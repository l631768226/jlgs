package hsoft.yfzx.jlgs.business.im.server;

import hsoft.yfzx.jlgs.business.im.ctmmodel.CtmPushRec;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.tool.FBase64;
import hsoft.yfzx.jlgs.utils.tool.XmppOperator;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.exceptions.InvalidDeviceTokenFormatException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class PushService {

    /**
     * 发送推送
     * @param data
     * @return
     * @throws CommunicationException
     * @throws XMPPException
     * @throws KeystoreException
     * @throws IOException
     * @throws InterruptedException
     * @throws InvalidDeviceTokenFormatException
     * @throws SmackException
     * @throws JSONException
     */
    public ResponseData<String> processPush(CtmPushRec data) throws CommunicationException, XMPPException, KeystoreException, IOException, InterruptedException, InvalidDeviceTokenFormatException, SmackException, JSONException {
        ResponseData<String> responseData = new ResponseData<>();
        //获取用户名列表
        List<String> userNameList = data.getUserNameList();
        //获取IMEI列表
        List<String> IMEIList = data.getIMEIList();
        //获取推送内容（明文）
        String content = data.getContent();
        //获取APNS推送标题
        String apnsTitle = data.getApnsTitle();
        //获取APNS推送对话框内容
        String apnsContent = data.getApnsContent();
        //FBase64加密
        content = FBase64.encode(content.getBytes("UTF-8"));

        XmppOperator.sendXMPP(userNameList, IMEIList, apnsContent, apnsTitle, content);

        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

}
