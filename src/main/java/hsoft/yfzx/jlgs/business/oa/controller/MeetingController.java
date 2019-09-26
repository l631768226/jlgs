package hsoft.yfzx.jlgs.business.oa.controller;

import hsoft.yfzx.jlgs.business.oa.ctmmodel.*;
import hsoft.yfzx.jlgs.business.oa.server.MeetingService;
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
@RequestMapping("/oa/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseData<List<QMeetingListRst>> list(@RequestBody RequestData requestData){

        String userId = requestData.getOwner().getUserId();

        return meetingService.list(userId);
    }

    /**
     * 查询会议详情
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseData<QMeetingDetailRst> detail(@RequestBody RequestData<QMeetingDetailRec> requestData){
        ResponseData<QMeetingDetailRst> responseData = new ResponseData<>();
        QMeetingDetailRec data = requestData.getData();
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
        return meetingService.detail(userId, data);
    }

    /**
     * 确认参加会议
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public ResponseData<String> confirm(@RequestBody RequestData<CConfirmRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        CConfirmRec data = requestData.getData();

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
        return meetingService.confirm(userId, data);
    }

    /**
     * 会议请假
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/leave", method = RequestMethod.POST)
    public ResponseData<String> leave(@RequestBody RequestData<CMeetingLeaveRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        CMeetingLeaveRec data = requestData.getData();

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

        return meetingService.leave(userId, data);
    }

    /**
     * 会议审批列表
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/approveList", method = RequestMethod.POST)
    public ResponseData<QMeetingAproveListRst> approveList(@RequestBody RequestData<QMeetingAproveListRec> requestData){
        ResponseData<QMeetingAproveListRst> responseData = new ResponseData<>();
        QMeetingAproveListRec data = requestData.getData();

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

        return meetingService.approveList(userId, data);
    }

    /**
     * 会议审批详情
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/approveDetail", method = RequestMethod.POST)
    public ResponseData<List<QMeetingApproveDetailRst>> approveDetail(
            @RequestBody RequestData<QMeetingApproveDetailRec> requestData ){
        ResponseData<List<QMeetingApproveDetailRst>> responseData = new ResponseData<>();
        QMeetingApproveDetailRec data = requestData.getData();

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

        return meetingService.approveDetail(userId, data);
    }

    /**
     * 会议办理
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public ResponseData<String> approve(@RequestBody RequestData<CMeetingApproveRec> requestData ) {
        ResponseData<String> responseData = new ResponseData<>();
        CMeetingApproveRec data = requestData.getData();

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

        return meetingService.approve(userId, data);
    }

    /**
     * 会议驳回
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public ResponseData<String> reject(@RequestBody RequestData<CMeetingRejectRec> requestData ) {
        ResponseData<String> responseData = new ResponseData<>();
        CMeetingRejectRec data = requestData.getData();

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

        return meetingService.reject(userId, data);
    }

}
