package hsoft.yfzx.jlgs.business.basic.controller;


import hsoft.yfzx.jlgs.business.basic.ctmmodel.*;
import hsoft.yfzx.jlgs.business.basic.server.UserMgrService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.validation.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/basic/user")
public class UserMgrController {

    @Autowired
    private UserMgrService userMgrService;

    /**
     * 登录接口
     * @param requestData 登录信息
     * @return token和个人信息
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData<QUserLoginRst> login(@RequestBody RequestData<QUserLoginRec> requestData) throws UnsupportedEncodingException {
        ResponseData<QUserLoginRst> responseData = new ResponseData<QUserLoginRst>();
        QUserLoginRec data = requestData.getData();
        if (!data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        return userMgrService.login(data);
    }

    /**
     * 修改密码
     * @param requestData 旧密码 新密码
     * @return 成功或失败
     */
    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    public ResponseData<String>  updatePwd(@RequestBody RequestData<UPwdRec> requestData){
        ResponseData<String> responseData = new ResponseData<String>();
        String token = requestData.getToken();
        String userId = requestData.getOwner().getUserId();
        UPwdRec data = requestData.getData();
        if (!data.validation() || data == null)
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        return userMgrService.updatePwd(data, userId);
    }

    /**
     * 查询用户详情接口
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseData<QUserDetailRst> detail(@RequestBody RequestData<QUserDetailRec> requestData){
        String userId = requestData.getOwner().getUserId();
        QUserDetailRec data = requestData.getData();
        return userMgrService.queryDetail(userId, data);
    }

    /**
     * 更新IMEI信息
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/updateMobileInfo", method = RequestMethod.POST)
    public ResponseData<String> updateMobileInfo(@RequestBody RequestData<UUserMobileInfoRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        UUserMobileInfoRec data = requestData.getData();
        if (data == null)
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("无数据需要修改");
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();
        return userMgrService.updateMobileInfo(userId, data);
    }

    /**
     * 创建用户
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseData<String> create(@RequestBody RequestData<String> requestData){
        return null;
    }

    /**
     * 删除用户
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseData<String> delete(@RequestBody RequestData<String> requestData){
        return null;
    }

    /**
     * 查询某部门下人员列表
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/listByDeptLimit", method = RequestMethod.POST)
    public ResponseData<List<QUserRst>> listByDeptLimit(@RequestBody RequestData<QUserRec> requestData){
        ResponseData<List<QUserRst>> responseData = new ResponseData<List<QUserRst>>();
        QUserRec data = requestData.getData();
        if (CheckUtil.hasSpecialChar(data.getSearchRule()))
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("传入数据带有非法字符");
            responseData.setResultSet(new ArrayList<>());
            // 返回
            return responseData;
        }
        return userMgrService.listByDeptLimit(data);
    }
}
