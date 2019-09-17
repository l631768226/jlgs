package hsoft.yfzx.jlgs.business.im.controller;

import hsoft.yfzx.jlgs.business.im.ctmmodel.*;
import hsoft.yfzx.jlgs.business.im.server.ChatCfgService;
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
@RequestMapping("/im/chatCfg")
public class ChatCfgController {

    @Autowired
    private ChatCfgService chatCfgService;

    /**
     * 更新某人的会话设置
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseData<String> updateChatCfg(@RequestBody RequestData<UChatCfgRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        UChatCfgRec data = requestData.getData();
        //System.out.println(gson.toJson(requestData));

        if(data == null){
            //无数据
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("请提交相应数据");
            //返回
            return responseData;
        }

        if(!data.validation()){
            //数据校验没有通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            //返回
            return responseData;
        }
        //将userId置入到需要更新的数据中
        data.setUserId(requestData.getOwner().getUserId());
        return chatCfgService.updateChatCfg(data);
    }

    /**
     * 获取某人的会话设置
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseData<OfflineData<List<QChatCfgRst>>> chatCfgList(@RequestBody RequestData<?> requestData){
        return chatCfgService.chatCfgList(requestData.getOwner().getUserId());
    }

    /**
     * 同步某人的会话设置
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/syncInfo", method = RequestMethod.POST)
    public ResponseData<SyncData<List<QChatCfgSyncRst>, List<String>>> syncChatCfg(@RequestBody RequestData<QChatCfgSyncRec> requestData){
        ResponseData<SyncData<List<QChatCfgSyncRst>, List<String>>> responseData = new ResponseData<>();
        QChatCfgSyncRec data = requestData.getData();

        if(data == null || !data.validation()){
            //无数据
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("请提交相应数据");
            //返回
            return responseData;
        }

        data.setUserId(requestData.getOwner().getUserId());
        return chatCfgService.syncChatCfg(data);
    }

}
