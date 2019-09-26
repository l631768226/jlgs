package hsoft.yfzx.jlgs.business.basic.controller;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.*;
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

    /**
     * 修改群组信息
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseData<String> updateGroup(@RequestBody RequestData<UGroupRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        UGroupRec data = requestData.getData();
        if (data == null || !data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        return groupMgrService.updateGroup(data);
    }

    /**
     * 查询群组详情信息
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseData<QGroupDetailRst> groupDetail(@RequestBody RequestData<QGroupDetailRec> requestData){
        ResponseData<QGroupDetailRst> responseData = new ResponseData<>();
        QGroupDetailRec qGroupDetailRec = requestData.getData();
        if (qGroupDetailRec == null || !qGroupDetailRec.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(qGroupDetailRec.getFailCauses());
            responseData.setResultSet(new QGroupDetailRst());
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();
        return groupMgrService.groupDetail(qGroupDetailRec,userId);
    }

    /**
     * 获取某用户群组列表
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/myList", method = RequestMethod.POST)
    public ResponseData<List<QGroupMyListRst>> groupMyList(@RequestBody RequestData<?> requestData){
        //获取用户id
        String userId = requestData.getOwner().getUserId();
        // String userId = null;
        return groupMgrService.groupMyList(userId);
    }

    /**
     * 群组修改
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public ResponseData<String> chagne(@RequestBody RequestData<UGroupChangeRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        UGroupChangeRec data = requestData.getData();

        if (data == null || !data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses() + "群组信息");
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

        return groupMgrService.change(data);
    }

}
