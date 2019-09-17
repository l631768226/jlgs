package hsoft.yfzx.jlgs.business.basic.controller;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.*;
import hsoft.yfzx.jlgs.business.basic.server.UserGroupMgrService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.validation.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/basic/member")
public class UserGroupController {

    @Autowired
    private UserGroupMgrService userGroupMgrService;

    /**
     * 群组添加人员
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseData<String> createUserGroup(@RequestBody RequestData<CUserGroupRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        CUserGroupRec data = requestData.getData();
        if (data == null || !data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        List<CGroupsUserRec> list = data.getUsers();
        for (int i = 0; i < list.size(); i++)
        {
            if (!list.get(i).validation())
            {
                // 数据校验不通过
                responseData.setStatus(ReturnStatus.ERR0001);
                responseData.setExtInfo(data.getFailCauses());
                // 返回
                return responseData;
            }
        }
        data.setUserId(requestData.getOwner().getUserId());
        data.setRealName(requestData.getOwner().getRealName());
        return userGroupMgrService.createUserGroup(data);
    }

    /**
     * 删除群组人员
     *
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseData<String> deleteUserGroup(@RequestBody RequestData<DUserGroupRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        DUserGroupRec dUserGroupRec = requestData.getData();
        if (dUserGroupRec == null || !dUserGroupRec.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(dUserGroupRec.getFailCauses());
            // 返回
            return responseData;
        }
        dUserGroupRec.setUserId(requestData.getOwner().getUserId());
        dUserGroupRec.setRealName(requestData.getOwner().getRealName());
        return userGroupMgrService.deleteUserGroup(dUserGroupRec);
    }

    /**
     * 获取群组人员
     *
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseData<List<QUserGroupListRst>> userGroupList(@RequestBody RequestData<QUserGroupListRec> requestData){
        ResponseData<List<QUserGroupListRst>> responseData = new ResponseData<>();
        QUserGroupListRec qUserGroupListRec = requestData.getData();
        if (qUserGroupListRec == null || !qUserGroupListRec.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(qUserGroupListRec.getFailCauses());
            responseData.setResultSet(new ArrayList<QUserGroupListRst>());
            // 返回
            return responseData;
        }
        if (CheckUtil.hasSpecialChar(qUserGroupListRec.getSearchRule()))
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("传入数据带有非法字符");
            responseData.setResultSet(new ArrayList<QUserGroupListRst>());
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();
        return userGroupMgrService.userGroupList(qUserGroupListRec,userId);
    }


}
