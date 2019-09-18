package hsoft.yfzx.jlgs.business.im.controller;

import hsoft.yfzx.jlgs.business.im.ctmmodel.CtmPushRec;
import hsoft.yfzx.jlgs.business.im.server.PushService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.exceptions.InvalidDeviceTokenFormatException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/im")
public class PushController {

    @Autowired
    private PushService pushService;

    /**
     * 推送接口
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public ResponseData<String> processPush(@RequestBody RequestData<CtmPushRec> requestData) throws CommunicationException, XMPPException, InvalidDeviceTokenFormatException, IOException, InterruptedException, SmackException, JSONException, KeystoreException {
        ResponseData<String> responseData = new ResponseData<>();

        CtmPushRec data = requestData.getData();

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

        return pushService.processPush(data);

    }

}
