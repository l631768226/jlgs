package hsoft.yfzx.jlgs.business.oa.controller;

import hsoft.yfzx.jlgs.business.oa.ctmmodel.QMeetingDetailRec;
import hsoft.yfzx.jlgs.business.oa.ctmmodel.QMeetingDetailRst;
import hsoft.yfzx.jlgs.business.oa.ctmmodel.QMeetingListRst;
import hsoft.yfzx.jlgs.business.oa.server.MeetingService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
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

//    @RequestMapping(value = "/detail", method = RequestMethod.POST)
//    public ResponseData<QMeetingDetailRst> detail(@RequestBody RequestData<QMeetingDetailRec> recRequestData){
//        ResponseData<QMeetingDetailRst>
//        QMeetingDetailRec data = new QMeetingDetailRec();
//        if (data == null)
//        {
//            // 数据校验不通过
//            responseData.setStatus(ReturnStatus.ERR0001);
//            responseData.setExtInfo("无数据需要修改");
//            // 返回
//            return responseData;
//        }
//    }
}
