package hsoft.yfzx.jlgs.business.basic.controller;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.CGroupRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.CGroupsUserRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.DGroupRec;
import hsoft.yfzx.jlgs.business.basic.mapper.GroupinfoMapper;
import hsoft.yfzx.jlgs.business.basic.model.Groupinfo;
import hsoft.yfzx.jlgs.business.basic.model.GroupinfoExample;
import hsoft.yfzx.jlgs.business.basic.server.GroupMgrService;
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
@RequestMapping("/basic/group")
public class GroupMgrController {

    @Autowired
    private GroupMgrService groupMgrService;



    /**
     * 创建群组
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseData<String> createGroup(@RequestBody RequestData<CGroupRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        CGroupRec data = requestData.getData();
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
        return groupMgrService.createGroup(data);
    }

    /**
     * 删除群组
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseData<String> deleteGroup(@RequestBody RequestData<DGroupRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        DGroupRec data = requestData.getData();
        if (data == null || !data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        return groupMgrService.deleteGroup(data);
    }



}
