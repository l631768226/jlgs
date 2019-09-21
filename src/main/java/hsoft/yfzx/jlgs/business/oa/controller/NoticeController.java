package hsoft.yfzx.jlgs.business.oa.controller;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.UUserMobileInfoRec;
import hsoft.yfzx.jlgs.business.oa.ctmmodel.*;
import hsoft.yfzx.jlgs.business.oa.server.NoticeService;
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
@RequestMapping("/oa/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 查询通知详情
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseData<QNoticeDetailRst> detail(@RequestBody RequestData<QNoticeDetailRec> requestData){
        ResponseData<QNoticeDetailRst> responseData = new ResponseData<>();
        QNoticeDetailRec data = requestData.getData();
        if (data == null)
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("无数据需要修改");
            // 返回
            return responseData;
        }
        return noticeService.detail(data);
    }

    /**
     * 修改通知阅读状态
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/changeState", method = RequestMethod.POST)
    public ResponseData<String> changeState(@RequestBody RequestData<UChangeStateRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        UChangeStateRec data = requestData.getData();
        if (data == null)
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("无数据需要修改");
            // 返回
            return responseData;
        }
        //获取用户id
        String userId = requestData.getOwner().getUserId();

        return noticeService.changeState(userId, data);
    }

    /**
     * 查询通知列表
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseData<List<QNoticeListRst>> queryList(@RequestBody RequestData<QNoticeListRec> requestData){
        ResponseData<List<QNoticeListRst>> responseData = new ResponseData<>();
        QNoticeListRec data = requestData.getData();
        if (data == null)
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("无数据需要修改");
            // 返回
            return responseData;
        }
        //获取用户id
        String userId = requestData.getOwner().getUserId();
        return noticeService.queryList(userId, data);
    }

    /**
     * 查询未读通知数量
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/unreadCount", method = RequestMethod.POST)
    public ResponseData<QNoticeCountRst> unreadCount(@RequestBody RequestData requestData){
        String userId = requestData.getOwner().getUserId();
        return noticeService.unreadCount(userId);
    }

}
