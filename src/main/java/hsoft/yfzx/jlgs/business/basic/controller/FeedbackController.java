package hsoft.yfzx.jlgs.business.basic.controller;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.CFeedbackRec;
import hsoft.yfzx.jlgs.business.basic.server.FeedbackService;
import hsoft.yfzx.jlgs.utils.model.common.Owner;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    /**
     * 发起反馈
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/launch", method = RequestMethod.POST)
    public ResponseData<String> launchFeedBack(@RequestBody RequestData<CFeedbackRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        CFeedbackRec data = requestData.getData();

        if(data == null){
            // 数据为空
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("传入数据为空");
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
        Owner owner = requestData.getOwner();
        data.setUserId(owner.getUserId());

        return feedbackService.launchFeedBack(data);
    }


}
