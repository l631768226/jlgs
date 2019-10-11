package hsoft.yfzx.jlgs.business.basic.server;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.CFeedbackRec;
import hsoft.yfzx.jlgs.business.basic.mapper.FeedbackMapper;
import hsoft.yfzx.jlgs.business.basic.model.Feedback;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.tool.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    /**
     * 发起反馈
     *
     * @param cFeedBackRec
     * @return
     */
    public ResponseData<String> launchFeedBack(CFeedbackRec cFeedBackRec) {
        ResponseData<String> responseData = new ResponseData<>();
        // 插入数据
        Feedback feedback = new Feedback();
        feedback.setFEEDBACKID(Generator.getUUID());
        feedback.setUSERID(cFeedBackRec.getUserId());
        feedback.setCONTENT(cFeedBackRec.getContent());
        feedback.setEMAIL(cFeedBackRec.getEmail());
        feedback.setPHONE(cFeedBackRec.getPhone());
        feedback.setISDEAL("0");
        feedback.setUSERTYPE(cFeedBackRec.getUserType());
        feedback.setCREATETIME(new Date());
        feedback.setTYPE(cFeedBackRec.getType());

        int resultCode = feedbackMapper.insertSelective(feedback);
        if(resultCode < 1){
            responseData.setStatus(ReturnStatus.ERR0004);
            responseData.setExtInfo("插入数据库失败");
            return responseData;
        }
        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

}
