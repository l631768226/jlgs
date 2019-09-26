package hsoft.yfzx.jlgs.business.oa.controller;

import hsoft.yfzx.jlgs.business.oa.ctmmodel.*;
import hsoft.yfzx.jlgs.business.oa.server.LeaveService;
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
@RequestMapping("/oa/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    /**
     * 查询请休假列表
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseData<List<QLeaveListRst>> list(@RequestBody RequestData<QLeaveListRec> requestData ) {
        ResponseData<List<QLeaveListRst>> responseData = new ResponseData<>();
        QLeaveListRec data = requestData.getData();

        if (data == null)
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("无数据需要修改");
            // 返回
            return responseData;
        }
        if (!data.validation()) {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();

        return leaveService.list(userId, data);
    }

    /**
     * 查询请休假详情
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseData<QLeaveDetailRst> detail(@RequestBody RequestData<QLeaveDetailRec> requestData ) {
        ResponseData<QLeaveDetailRst> responseData = new ResponseData<>();
        QLeaveDetailRec data = requestData.getData();

        if (data == null)
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("无数据需要修改");
            // 返回
            return responseData;
        }
        if (!data.validation()) {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();

        return leaveService.detail(userId, data);
    }

    /**
     * 请休假审批通过
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public ResponseData<String> approve(@RequestBody RequestData<CLeaveApproveRec> requestData ) {
        ResponseData<String> responseData = new ResponseData<>();
        CLeaveApproveRec data = requestData.getData();

        if (data == null)
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("无数据需要修改");
            // 返回
            return responseData;
        }
        if (!data.validation()) {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();

        return leaveService.approve(userId, data);
    }

    /**
     * 请休假审批驳回
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public ResponseData<String> reject(@RequestBody RequestData<CLeaveRejectRec> requestData ) {
        ResponseData<String> responseData = new ResponseData<>();
        CLeaveRejectRec data = requestData.getData();

        if (data == null)
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("无数据需要修改");
            // 返回
            return responseData;
        }
        if (!data.validation()) {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();

        return leaveService.reject(userId, data);
    }

}
