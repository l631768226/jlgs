package hsoft.yfzx.jlgs.business.basic.controller;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.CGroupsUserRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.CUserGroupRec;
import hsoft.yfzx.jlgs.business.basic.server.UserGroupMgrService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


}
