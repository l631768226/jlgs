package hsoft.yfzx.jlgs.aop;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hsoft.yfzx.jlgs.utils.model.common.*;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class CheckPermissionAop {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private HttpServletRequest request;

    private Gson gson = new Gson();

    @Pointcut(value = "execution(* hsoft.yfzx.jlgs.business.*.controller..*.*(..))")
    public void CheckIMPermissionAop() {
    }

    @Around("CheckIMPermissionAop()")
    public Object checkSecurity(ProceedingJoinPoint pjp) throws Throwable {
        RequestData<Object> requestData = new RequestData<Object>();
        Object[] objects = pjp.getArgs();

        if ("/im/xmpp/send".equals(request.getServletPath())) {
            // 键值对的形式传入参数
            String value = request.getParameter("json");
//            System.out.println("传入的数据 " + value);
            try {
                requestData = gson.fromJson(value, new TypeToken<RequestData<Object>>() {
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
                ResponseData<String> responseData = new ResponseData<>();
                responseData.setStatus(ReturnStatus.ERR0016);
                responseData.setExtInfo("未按照约定的格式传递参数");
                return responseData;
            }
        } else if("/basic/user/login".equals(request.getServletPath())){
            //登录接口不需要校验token
            return pjp.proceed();
        }else if("/file/upload".equals(request.getServletPath()) ||
                "/file/download".equals(request.getServletPath())||
                "/file/pic".equals(request.getServletPath())){
            //文件上传下载接口不需要校验token
            return pjp.proceed();
        }else if("/im/push".equals(request.getServletPath()) ||
                //消息推送接口不需要校验token
                "/basic/user/create".equals(request.getServletPath())){
                //创建xmpp账号不需要校验token
            return pjp.proceed();
        }else {
//            System.out.println("请求的地址为 = " + request.getServletPath());
            // json形式传入
            requestData = (RequestData<Object>) objects[0];
        }

        // 如果请求参数不为空，则取参数，并将参数类型转为RequestData
        try {

            if (requestData == null) {
//                System.out.println("转换后的model为空");
                ResponseData<String> responseData = new ResponseData<>();
                responseData.setStatus(ReturnStatus.ERR0016);
                responseData.setExtInfo("未按照约定的方式传递参数");
                return responseData;
            }
            //获取传入的token
            String token = requestData.getToken();

            if (StringUtils.isBlank(token)) {
//                System.out.println("没有传token");
                ResponseData<String> responseData = new ResponseData<>();
                responseData.setStatus(ReturnStatus.ERR0005);
                responseData.setExtInfo("没有上传token");
                return responseData;
            }

            ValueOperations<String, Object> vo = redisTemplate.opsForValue();
            UserCacheData userCacheData = (UserCacheData) vo.get(token);
            if (userCacheData == null) {
//                System.out.println("token不存在");
                ResponseData<String> responseData = new ResponseData<>();
                responseData.setStatus(ReturnStatus.ERR0005);
                responseData.setExtInfo("token失效或 不存在");
                return responseData;
            }
            //获取token中存储的userName
            String userName = userCacheData.getUserName();
            if (StringUtils.isBlank(userName)) {
                //若userName为空，提示token失效
//                System.out.println("userName不存在");
                ResponseData<String> responseData = new ResponseData<>();
                responseData.setStatus(ReturnStatus.ERR0005);
                responseData.setExtInfo("token失效或userName不存在");
                return responseData;
            }

            //有效的token
            redisTemplate.expire(token, 180, TimeUnit.MINUTES);

            Owner owner = new Owner();
            // 将查询到的用户信息中的userId置入owner中
            owner.setUserId(userCacheData.getUserId());
            owner.setUserName(userCacheData.getUserName());
            owner.setRealName(userCacheData.getRealName());

            // 将用户信息置入请求参数中
            for (Object argItem : objects) {
                if (argItem instanceof RequestData) {
                    RequestData<String> newRequestData = (RequestData<String>) argItem;
                    newRequestData.setOwner(owner);
                }
            }
            return pjp.proceed();
        } catch (Exception e) {
            e.printStackTrace();
            // 校验失败，提示错误
            ResponseData<String> responseData = new ResponseData<>();
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务器错误");
            return responseData;
        }
    }
}
