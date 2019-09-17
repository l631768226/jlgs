package hsoft.yfzx.jlgs.business.im.controller;

import hsoft.yfzx.jlgs.business.im.ctmmodel.*;
import hsoft.yfzx.jlgs.business.im.server.ChatCfgService;
import hsoft.yfzx.jlgs.business.im.server.ChatStoreService;
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
@RequestMapping("/im/chatStore")
public class ChatStoreController {

    @Autowired
    private ChatStoreService chatStoreService;


    /**
     * 同步聊天信息（根据对方id，最后一条消息发送时间，同步消息数量和是否为群组消息 获取消息id的列表）
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/syncInfo", method = RequestMethod.POST)
    public ResponseData<List<QChatStoreSyncRst>> syncChatStore(@RequestBody RequestData<QChatStoreSyncRec> requestData){
        ResponseData<List<QChatStoreSyncRst>> responseData = new ResponseData<>();

        QChatStoreSyncRec data = requestData.getData();

        if(data == null || !data.validation()){
            //无数据
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("请提交相应数据");
            //返回
            return responseData;
        }

        data.setUserId(requestData.getOwner().getUserId());

        return chatStoreService.queryIdList(data);
    }

    /**
     * 查询会话的最新一条消息
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/lastInfo", method = RequestMethod.POST)
    public ResponseData<List<QChatStoreListRst>> lastChatStore(@RequestBody RequestData<QChatStoreListRec> requestData){
        ResponseData<List<QChatStoreListRst>> responseData = new ResponseData<>();
        QChatStoreListRec data = requestData.getData();

        if(data == null || !data.validation()){
            //无数据
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("请提交相应数据");
            //返回
            return responseData;
        }

        data.setUserId(requestData.getOwner().getUserId());

        return chatStoreService.lastChatStore(data);
    }

    /**
     * 根据id列表获取聊天记录列表
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseData<List<QChatStoreRst>> chatStoreListDetial(@RequestBody RequestData<QChatStoreRec> requestData){
        ResponseData<List<QChatStoreRst>> responseData = new ResponseData<>();

        QChatStoreRec data = requestData.getData();

        if(data == null || !data.validation()){
            //无数据
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("请提交相应数据");
            //返回
            return responseData;
        }

        return chatStoreService.queryList(data);
    }

    /**
     * 根据聊天对象获取最新一条聊天记录
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/chatStore/last", method = RequestMethod.POST)
    public ResponseData<List<QChatStoreRst>> queryLastChatStore(@RequestBody RequestData<QChatRec> requestData){
        ResponseData<List<QChatStoreRst>> responseData = new ResponseData<>();

        QChatRec data = requestData.getData();
        //数据校验
        if(data == null || !data.validation()){
            //无数据
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("请提交相应数据");
            //返回
            return responseData;
        }
        //设置发起请求人的id
        data.setUserId(requestData.getOwner().getUserId());

        return chatStoreService.queryLastChatStore(data);
    }

}
