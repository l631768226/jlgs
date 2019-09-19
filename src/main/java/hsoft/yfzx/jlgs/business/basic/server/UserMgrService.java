package hsoft.yfzx.jlgs.business.basic.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.*;
import hsoft.yfzx.jlgs.business.basic.mapper.LogininfoMapper;
import hsoft.yfzx.jlgs.business.basic.model.Logininfo;
import hsoft.yfzx.jlgs.business.basic.model.SysUser;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.model.common.UserCacheData;
import hsoft.yfzx.jlgs.utils.model.http.HsoftReqData;
import hsoft.yfzx.jlgs.utils.model.http.HsoftRstData;
import hsoft.yfzx.jlgs.utils.tool.Generator;
import hsoft.yfzx.jlgs.utils.tool.HttpMethodTool;
import hsoft.yfzx.jlgs.utils.tool.XmppOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class UserMgrService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private LogininfoMapper loginInfoMapper;

    private Gson gson = new Gson();

    // 设置失效时间
    private long failureTime = 180l;

    @Value("${custom.serverUrl}")
    String serverUrl;

    /**
     * 登录接口
     * @param data
     * @return
     * @throws UnsupportedEncodingException
     */
    public ResponseData<QUserLoginRst> login(QUserLoginRec data) throws UnsupportedEncodingException {

        ResponseData<QUserLoginRst> responseData = new ResponseData<QUserLoginRst>();
        //传入的密码进行MD5加密
        String password = data.getPassword();
        //获取用户名
        String userName = data.getUserName();

        //调用内网登录接口
        HsoftReqData<HLoginRec> hsoftReqData = new HsoftReqData<>();

        HLoginRec hLoginRec = new HLoginRec();
        hLoginRec.setUserName(userName);
        hLoginRec.setPassword(password);
        hLoginRec.setDeviceType(data.getDeviceType());
        hLoginRec.setIMEI(data.getIMEI());

        hsoftReqData.setChangeableData(hLoginRec);

        String url = serverUrl + "/user/login";

        String dataStr = gson.toJson(hsoftReqData);

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        SysUser sysUser = new SysUser();
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<SysUser> hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData<SysUser>>() {
                }.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0013);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }else{
                        sysUser = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        if(sysUser == null){
            //若用户信息为空 则登录失败
            responseData.setStatus(ReturnStatus.ERR0013);
            responseData.setExtInfo("用户名或密码错误");
            return responseData;
        }
        QUserLoginRst qUserLoginRst = new QUserLoginRst();

        //获取用户id
        String userId = sysUser.getId();
        //获取新的token
        String token = Generator.getToken();
        //获取真实姓名
        String realName = sysUser.getName();
        //获取设备类型
        String deviceType = data.getDeviceType();
        //获取IMEI
        String IMEI = data.getIMEI();

        //设置登录信息
        Logininfo oldLogininfo = loginInfoMapper.selectByPrimaryKey(userId);

        Logininfo logininfo = new Logininfo();
        logininfo.setUSERID(userId);
        logininfo.setDEVICETYPE(deviceType);
        logininfo.setIMEI(IMEI);
        logininfo.setTOKEN(token);
        logininfo.setREALNAME(realName);
        logininfo.setPICID(sysUser.getPhoto());
        logininfo.setUSERNAME(sysUser.getLogin_NAME());
        long lastLoginTime = Generator.getLongTimeStamp();
        logininfo.setLASTLOGINTIME(lastLoginTime);

        if(oldLogininfo == null){
            loginInfoMapper.insertSelective(logininfo);
        }else{
            loginInfoMapper.updateByPrimaryKeySelective(logininfo);
        }

        // 调用检测连接方法
        String checkResult = XmppOperator.checkSession(data.getUserName(), "mobile");
        if ("1".equals(checkResult)) {
            // 连接存在 则需要发送断开连接消息 并断开连接
            String closeResult = XmppOperator.closeSession(data.getUserName(), "mobile");
            System.out.println("*************** " + closeResult + "1".equals(closeResult));
            if ("1".equals(closeResult) || "-100".equals(closeResult)) {
                // 断开连接成功 或 连接不存在
                System.out.println("**************连接************连接断开");
            } else {
                // 断开连接失败, 则返回消息服务器连接失败
                System.out.println("**************连接************断开连接失败");
                responseData.setStatus(ReturnStatus.ERR0014);
                responseData.setExtInfo("XMPP消息服务器连接失败");
                return responseData;
            }
        } else {
            // 若连接不存在，不必处理
            System.out.println("**************连接************连接不存在");
        }

        // 从redis里获取当前username对应的token值
        String rUserName = stringRedisTemplate.opsForValue().get("M" + data.getUserName());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        // 如果redis里存在当前username的则删除
        if (!"".equals(rUserName) && rUserName != null) {
            // 如果旧的token存在，则删除此token对应的数据
            System.out.println("^^^^^^^^^^^^^^^ token存在 删除");
            redisTemplate.delete("M" + data.getUserName());
        } else {
            // 如果旧的token不存在
            System.out.println("^^^^^^^^^^^^^^^ token不存在 暂时不操作");
        }
        // 把当前key为username value为token的放入redis
        stringRedisTemplate.opsForValue().set("M" + data.getUserName(), token);
        UserCacheData ucData = new UserCacheData();
        ucData.setUserId(userId);
        ucData.setUserName(data.getUserName());
        ucData.setRealName(realName);

        // token放到redis里 key是token，value里包含用户id，用户名称，真实姓名和角色id列表

        String tokenStr = stringRedisTemplate.opsForValue().get("M" + data.getUserName());

        if (StringUtils.isBlank(tokenStr)) {
            // 为空
            System.out.println("@@@@@@@@@@@@@@@@@@ 没有取到token");
            tokenStr = token;
        } else {
            // 不为空
            System.out.println("@@@@@@@@@@@@@@@@@@ 取到了token:" + tokenStr);
        }

        vo.set(tokenStr, ucData);

        // 设置token失效时间
        redisTemplate.expire(token, failureTime, TimeUnit.MINUTES);

        //获取部门信息

        //将数据set到返回model中
        qUserLoginRst.setToken(token);
        qUserLoginRst.setUserId(userId);
        qUserLoginRst.setRealName(sysUser.getName());
        qUserLoginRst.setUserName(sysUser.getLogin_NAME());
        qUserLoginRst.setGender(sysUser.getGender());
        qUserLoginRst.setPhone(sysUser.getPhone());
        qUserLoginRst.setMobile(sysUser.getMobile());
        qUserLoginRst.setEmail(sysUser.getEmail());
        qUserLoginRst.setPhoto(sysUser.getPhoto());
        qUserLoginRst.setPosition(sysUser.getPosition());
        qUserLoginRst.setPositionRemark(sysUser.getPosition_REMARK());
        qUserLoginRst.setOfficeName(sysUser.getOfficeName());

        if(sysUser.getWork_YEARS() != null){
            qUserLoginRst.setWorkYears(String.valueOf(sysUser.getWork_YEARS()));
        }else{
            qUserLoginRst.setWorkYears("");
        }
        qUserLoginRst.setWorkState(sysUser.getWork_STATE());
        qUserLoginRst.setDuty(sysUser.getDuty());
        qUserLoginRst.setPolitics(sysUser.getPolitics());

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qUserLoginRst);
        return responseData;
    }

    /**
     * 修改密码
     * @param data
     * @param userId
     * @return
     */
    public ResponseData<String> updatePwd(UPwdRec data, String userId) {
        // 构建返回结果的数据对象
        ResponseData<String> responseData = new ResponseData<String>();
        //获取旧密码
        String oldPwd = data.getOldPwd();

        //获取新密码
        String newPwd = data.getNewPwd();

        //调用内网修改密码接口，传入用户id、新密码和旧密码，获取返回值

        String url = serverUrl + "/user/updatePwd";

        HsoftReqData hsoftReqData = new HsoftReqData();
        HPwdRec hPwdRec = new HPwdRec();
        hPwdRec.setUserId(userId);
        hPwdRec.setOldPwd(oldPwd);
        hPwdRec.setNewPwd(newPwd);
        hsoftReqData.setChangeableData(hPwdRec);
        String dataStr = gson.toJson(hsoftReqData);

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData>() {
                }.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0004);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        //设置返回值
        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 查询用户详情信息
     * @param userId 用户id
     * @param data 查询用户详情传入参数
     * @return
     */
    public ResponseData<QUserDetailRst> queryDetail(String userId, QUserDetailRec data) {
        // 构建返回结果的数据对象
        ResponseData<QUserDetailRst> responseData = new ResponseData<QUserDetailRst>();
        // 如果传入的用户id不为空则userId取传入的值否则userid取登录者的
        if (!"".equals(data.getUserId()) && data.getUserId() != null) {
            userId = data.getUserId();
        }

        //调用内网查询用户详情接口
        HsoftReqData<HUserDetailRec> hsoftReqData = new HsoftReqData<>();
        HUserDetailRec hUserDetailRec = new HUserDetailRec();
        hUserDetailRec.setUserId(userId);
        hsoftReqData.setChangeableData(hUserDetailRec);

        String dataStr = gson.toJson(hsoftReqData);
        String url = serverUrl + "/user/detail";

        SysUser sysUser = new SysUser();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<SysUser> hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData<SysUser>>() {
                }.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0004);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }else{
                        sysUser = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        //将数据set到返回model中
        QUserDetailRst qUserDetailRst = new QUserDetailRst();
        qUserDetailRst.setUserId(userId);
        qUserDetailRst.setRealName(sysUser.getName());
        qUserDetailRst.setGender(sysUser.getGender());
        qUserDetailRst.setPhone(sysUser.getPhone());
        qUserDetailRst.setMobile(sysUser.getMobile());
        qUserDetailRst.setEmail(sysUser.getEmail());
        qUserDetailRst.setPhoto(sysUser.getPhoto());
        qUserDetailRst.setPosition(sysUser.getPosition());
        qUserDetailRst.setPositionRemark(sysUser.getPosition_REMARK());
        qUserDetailRst.setOfficeName(sysUser.getOfficeName());

        if(sysUser.getWork_YEARS() != null){
            qUserDetailRst.setWorkYears(String.valueOf(sysUser.getWork_YEARS()));
        }else{
            qUserDetailRst.setWorkYears("");
        }
        qUserDetailRst.setWorkState(sysUser.getWork_STATE());
        qUserDetailRst.setDuty(sysUser.getDuty());
        qUserDetailRst.setPolitics(sysUser.getPolitics());

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qUserDetailRst);
        return responseData;
    }

    /**
     * 更新手机IMEI信息
     * @param userId 用户id
     * @param data IMEI信息
     * @return
     */
    public ResponseData<String> updateMobileInfo(String userId, UUserMobileInfoRec data){
        ResponseData<String> responseData = new ResponseData<>();
        //获取设备类型
        String deviceType = data.getDeviceType();
        //获取IMEI
        String IMEI = data.getIMEI();

        HMobileRec hMobileRec = new HMobileRec();
        hMobileRec.setUserId(userId);
        hMobileRec.setIMEI(IMEI);
        hMobileRec.setDeviceType(deviceType);

        HsoftReqData<HMobileRec> hsoftReqData = new HsoftReqData<>();
        hsoftReqData.setChangeableData(hMobileRec);

        //调用内网接口更新IMEI信息

        String dataStr = gson.toJson(hsoftReqData);
        String url = serverUrl + "/user/updateMobileInfo";
        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData>() {
                }.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0004);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 查询某部门下人员列表信息
     * @param data
     * @return
     */
    public ResponseData<List<QUserRst>> listByDeptLimit(QUserRec data) {
        // 构建返回结果的数据对象
        ResponseData<List<QUserRst>> responseData = new ResponseData<List<QUserRst>>();

        List<QUserRst> qUserRstList = new ArrayList<>();

        String deptId = data.getDeptId();

        //设置调用内网查询用户列表参数
        HsoftReqData<HUserListRec> hsoftReqData = new HsoftReqData<>();
        HUserListRec hUserListRec = new HUserListRec();
        hUserListRec.setDeptId(deptId);
        hUserListRec.setSearchRule(data.getSearchRule());
        hsoftReqData.setChangeableData(hUserListRec);

        //设置调用内网查询人员列表接口参数
        String dataStr = gson.toJson(hsoftReqData);

        String url = serverUrl + "/user/listByDeptLimit";

        List<SysUser> sysUserList = new ArrayList<>();
        //调用内网查询某组织下人员列表接口
        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<List<SysUser>> hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData<List<SysUser>>>() {
                }.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0004);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }else{
                        sysUserList = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        if(sysUserList != null && sysUserList.size() > 0){
            for(SysUser sysUser : sysUserList){
                QUserRst qUserRst = new QUserRst();
                qUserRst.setUserId(sysUser.getId());
                qUserRst.setRealName(sysUser.getName());
                qUserRst.setGender(sysUser.getGender());
                qUserRst.setPhone(sysUser.getPhone());
                qUserRst.setMobile(sysUser.getMobile());
                qUserRst.setEmail(sysUser.getEmail());
                qUserRst.setPhoto(sysUser.getPhoto());
                qUserRst.setPosition(sysUser.getPosition());
                qUserRst.setPositionRemark(sysUser.getPosition_REMARK());
                if(sysUser.getBirthday() == null){
                    qUserRst.setBirthday("");
                }else{
                    qUserRst.setBirthday(sysUser.getBirthday().toString());
                }

                if(sysUser.getWork_YEARS() == null){
                    qUserRst.setWorkYears("");
                }else{
                    qUserRst.setWorkYears(sysUser.getWork_YEARS().toString());
                }
                qUserRst.setWorkState(sysUser.getWork_STATE());
                qUserRst.setDuty(sysUser.getDuty());
                qUserRst.setOfficeName(sysUser.getOfficeName());

                qUserRstList.add(qUserRst);
            }
        }
        //设置返回参数
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qUserRstList);
        return responseData;
    }



}
