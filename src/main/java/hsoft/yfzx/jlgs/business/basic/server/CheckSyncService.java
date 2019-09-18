package hsoft.yfzx.jlgs.business.basic.server;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.QCheckResult;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QCheckTokenRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QCheckTokenRst;
import hsoft.yfzx.jlgs.business.basic.mapper.LogininfoMapper;
import hsoft.yfzx.jlgs.business.basic.model.Logininfo;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.model.common.UserCacheData;
import hsoft.yfzx.jlgs.utils.tool.Generator;
import hsoft.yfzx.jlgs.utils.tool.XmppOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class CheckSyncService {

    @Autowired
    private LogininfoMapper loginInfoMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    // 设置失效时间
    private long failureTime = 180l;

    /**
     * 检测token是否有效
     *
     * @param userToken
     * @param qCheckTokenRec
     * @return
     * @throws UnsupportedEncodingException
     */
    public ResponseData<QCheckTokenRst> processCheckToken(String userToken, QCheckTokenRec qCheckTokenRec) throws UnsupportedEncodingException {

        //校验token
        ValueOperations<String, Object> tokenVo = redisTemplate.opsForValue();
        UserCacheData userTokenCacheData = (UserCacheData) tokenVo.get(userToken);

        if (userTokenCacheData == null) {
            //若token失效 则正常进行token校验处理
            System.out.println("&&&&&&&&&&&&&&&&&&&& token失效 " + userToken);
            return checkErrorToken(userToken, qCheckTokenRec);
        } else {
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%% token有效 " + userToken);
            //若token有效 则 根据kick值的设置进行下一步操作
            return checkRightToken(userTokenCacheData.getUserName(), qCheckTokenRec, userToken);
        }
    }

    /**
     * 当传入的token有效时调用次函数，根据kick不同的值对xmpp的连接执行是否断开操作
     *
     * @param userName       用户名 从token中获取
     * @param qCheckTokenRec 传入的数据
     * @return
     * @throws UnsupportedEncodingException
     */
    private ResponseData<QCheckTokenRst> checkRightToken(String userName, QCheckTokenRec qCheckTokenRec, String userToken) throws UnsupportedEncodingException {
        ResponseData<QCheckTokenRst> responseData = new ResponseData<>();
        QCheckTokenRst qCheckTokenRst = new QCheckTokenRst();

        //当token有效时，需要校验一下与loginInfo表中存储的token是否一致
        Logininfo loginInfo = loginInfoMapper.selectByPrimaryKey(qCheckTokenRec.getUserId());

        if (loginInfo == null) {
            //登录信息不存在（一般情况下不可能，出现则为严重错误）
            System.out.println("~~~~~~~~~ !!!!!!!!!!!! 账号不存在或已被删除");
            responseData.setStatus(ReturnStatus.ERR0010);
            responseData.setExtInfo("操作的数据不存在");
            QCheckResult qCheckResult = new QCheckResult();
            qCheckResult.setResultCode("-1");
            qCheckResult.setInfo("该账号不存在或已被删除");
            qCheckTokenRst.setXmppResult(qCheckResult);
            responseData.setResultSet(qCheckTokenRst);
            return responseData;
        }
        String token = loginInfo.getTOKEN();
        if (StringUtils.isBlank(token)) {
            //token为空（一般情况下不可能，出现则为严重错误）
            System.out.println("~~~~~~~~~~ !!!!!!!!!!!! 账号从未登录过");
            responseData.setStatus(ReturnStatus.ERR0010);
            responseData.setExtInfo("token不存在");
            QCheckResult qCheckResult = new QCheckResult();
            qCheckResult.setResultCode("-1");
            qCheckResult.setInfo("当前账号在其他设备上登录");
            qCheckTokenRst.setXmppResult(qCheckResult);
            responseData.setResultSet(qCheckTokenRst);
            return responseData;
        }

        if (token.equals(userToken)) {
            //登录信息中最后一次的token与传入值相同，可以继续处理
            System.out.println("~~~~~~~~ token 有效");
            responseData.setStatus(ReturnStatus.OK);
        } else {
            //登录信息中最后一次的token与传入值不同，此时虽然token在redis中有效，但是不可使用
            System.out.println("~~~~~~~~ token 与登录信息表不符");
            //token不一致,说明两次操作中间有人登录过
            responseData.setStatus(ReturnStatus.ERR0010);
            responseData.setExtInfo("账号重复登录");
            QCheckResult qCheckResult = new QCheckResult();
            qCheckResult.setResultCode("-1");
            qCheckResult.setInfo("当前账号在其他设备上登录");
            qCheckTokenRst.setXmppResult(qCheckResult);
            responseData.setResultSet(qCheckTokenRst);
            return responseData;
        }

        if ("1".equals(qCheckTokenRec.getKick())) {
            //若需要做踢人操作
            if ("M".equals(qCheckTokenRec.getDeviceType())) {
                //若为移动端登录
                String checkResult = XmppOperator.checkSession(userName, "mobile");
                System.out.println(qCheckTokenRec.getIMEI() + " " + userName + "****************" + checkResult + "1".equals(checkResult));
                if ("1".equals(checkResult)) {
                    //若存在连接

                    QCheckResult qCheckResult = new QCheckResult();

                    String closeResult = XmppOperator.closeSession(userName, "mobile");
                    if ("1".equals(closeResult)) {
                        //断开成功
                        qCheckResult.setResultCode("1");
                        qCheckResult.setInfo("当前账号在其他设备上登录");
                    } else if ("-100".equals(closeResult)) {
                        //连接为空
                        qCheckResult.setResultCode("1");
                        qCheckResult.setInfo("当前账号在其他设备上登录");
                    } else {
                        //断开连接失败
                        qCheckResult.setResultCode("-200");
                        qCheckResult.setInfo("当前账号在其他设备上登录");
                    }
                    qCheckTokenRst.setXmppResult(qCheckResult);
                } else if ("-100".equals(checkResult)) {
                    //不存在连接 暂不处理
                    QCheckResult qCheckR = new QCheckResult();
                    qCheckR.setResultCode("1");
                    qCheckR.setInfo("当前账号在其他设备上登录");
                    qCheckTokenRst.setXmppResult(qCheckR);
                } else {
                    QCheckResult qCheckR = new QCheckResult();
                    qCheckR.setResultCode("1");
                    qCheckR.setInfo("当前账号在其他设备上登录");
                    qCheckTokenRst.setXmppResult(qCheckR);
                }
            } else {
                //若为pc端 暂不处理
            }
        } else {
            //若不需要踢人操作 暂不处理
            QCheckResult qCheckR = new QCheckResult();
            qCheckR.setResultCode("1");
            qCheckR.setInfo("可以登录");
            qCheckTokenRst.setXmppResult(qCheckR);
        }
        responseData.setResultSet(qCheckTokenRst);
        return responseData;
    }

    /**
     * 当token失效时调用此函数，区分到底为何种失效
     * @param userToken 传入的token
     * @param qCheckTokenRec 请求体
     * @return
     */
    private ResponseData<QCheckTokenRst> checkErrorToken(String userToken, QCheckTokenRec qCheckTokenRec){
        ResponseData<QCheckTokenRst> responseData = new ResponseData<>();

        QCheckTokenRst qCheckTokenRst = new QCheckTokenRst();

        Logininfo loginInfo = loginInfoMapper.selectByPrimaryKey(qCheckTokenRec.getUserId());

        if(loginInfo == null){
            System.out.println("!!!!!!!!!!!! 账号不存在或已被删除");
            responseData.setStatus(ReturnStatus.ERR0010);
            responseData.setExtInfo("操作的数据不存在");
            QCheckResult qCheckResult = new QCheckResult();
            qCheckResult.setResultCode("-1");
            qCheckResult.setInfo("该账号不存在或已被删除");
            qCheckTokenRst.setXmppResult(qCheckResult);
            responseData.setResultSet(qCheckTokenRst);
            return responseData;
        }

        String token = loginInfo.getTOKEN();
        if(token == null || "".equals(token)){
            //如果token为空，说明此账号从未登录过
            System.out.println("!!!!!!!!!!!! 账号从未登录过");
            responseData.setStatus(ReturnStatus.ERR0010);
            responseData.setExtInfo("token不存在");
            QCheckResult qCheckResult = new QCheckResult();
            qCheckResult.setResultCode("-1");
            qCheckResult.setInfo("当前账号在其他设备上登录");
            qCheckTokenRst.setXmppResult(qCheckResult);
            responseData.setResultSet(qCheckTokenRst);
            return responseData;
        }

        if(token.equals(userToken)){
            //token一致，则说明token失效
            //需要生成一个有效的token给前端
            System.out.println("!!!!!!!!!!!! token超时失效");
            String newToken = Generator.getToken();

            String userName = loginInfo.getUSERNAME();

            //设置userName和token

            stringRedisTemplate.opsForValue().set(qCheckTokenRec.getDeviceType() + userName, newToken);

            List<String> serviceUrlList = new ArrayList<>();
            ValueOperations<String, Object> vo = redisTemplate.opsForValue();

            UserCacheData userCacheData = new UserCacheData();
            userCacheData.setUserId(loginInfo.getUSERID());
            userCacheData.setRealName(loginInfo.getREALNAME());
            userCacheData.setUserName(loginInfo.getUSERNAME());

            vo.set(newToken, userCacheData);
            redisTemplate.expire(newToken, failureTime, TimeUnit.MINUTES);

            //同时修改登录信息表数据
            System.out.println("IMEI = " + qCheckTokenRec.getIMEI());

            loginInfo.setIMEI(qCheckTokenRec.getIMEI());
            loginInfo.setTOKEN(newToken);
            loginInfo.setLASTLOGINTIME(Generator.getLongTimeStamp());
            loginInfo.setDEVICETYPE(qCheckTokenRec.getDeviceType());

            //更新登录信息表
            loginInfoMapper.updateByPrimaryKeySelective(loginInfo);

            qCheckTokenRst.setToken(newToken);

            responseData.setStatus(ReturnStatus.ERR0009);
            responseData.setExtInfo("token超时失效");
            QCheckResult qCheckResult = new QCheckResult();
            qCheckResult.setResultCode("1");
            qCheckTokenRst.setXmppResult(qCheckResult);
            responseData.setResultSet(qCheckTokenRst);

        }else{
            System.out.println("!!!!!!!!!!!! 账号重复登录");
            //token不一致,说明两次操作中间有人登录过
            responseData.setStatus(ReturnStatus.ERR0010);
            responseData.setExtInfo("账号重复登录");
            QCheckResult qCheckResult = new QCheckResult();
            qCheckResult.setResultCode("-1");
            qCheckResult.setInfo("当前账号在其他设备上登录");
            qCheckTokenRst.setXmppResult(qCheckResult);
            responseData.setResultSet(qCheckTokenRst);
        }
        return responseData;
    }
}
