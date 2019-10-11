package hsoft.yfzx.jlgs.business.oa.controller;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.UModifyRec;
import hsoft.yfzx.jlgs.business.oa.ctmmodel.*;
import hsoft.yfzx.jlgs.business.oa.server.TopicService;
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
@RequestMapping("/oa/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    /**
     * 查询会议议题审批列表
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseData<List<QTopicListRst>> list(@RequestBody RequestData<QTopicListRec> requestData){
        ResponseData<List<QTopicListRst>> responseData = new ResponseData<>();
        QTopicListRec data = requestData.getData();

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

        return topicService.list(data, userId);
    }

    /**
     * 会议议题审批审批
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public ResponseData<String> approve(@RequestBody RequestData<CTopicApproveRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();

        CTopicApproveRec data = requestData.getData();

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

        return topicService.approve(userId, data);
    }

    /**
     * 会议议题审批驳回
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public ResponseData<String> reject(@RequestBody RequestData<CTopicRejectRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();

        CTopicRejectRec data = requestData.getData();

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

        return topicService.reject(userId, data);
    }

    /**
     * 会议议题审批修改
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseData<String> modify(@RequestBody RequestData<UModifyRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();

        UModifyRec data = requestData.getData();

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

        return topicService.modify(userId, data);
    }

    /**
     * 会议议题详情
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseData<QTopicDetailRst> detail(@RequestBody RequestData<QTopicDetailRec> requestData){
        ResponseData<QTopicDetailRst> responseData = new ResponseData<>();

        QTopicDetailRec data = requestData.getData();

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

        return topicService.detail(userId, data);
    }



}
