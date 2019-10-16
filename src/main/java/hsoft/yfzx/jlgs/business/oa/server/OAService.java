package hsoft.yfzx.jlgs.business.oa.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hsoft.yfzx.jlgs.business.oa.ctmmodel.HUnconfirmRec;
import hsoft.yfzx.jlgs.business.oa.ctmmodel.QMeetingListRst;
import hsoft.yfzx.jlgs.business.oa.ctmmodel.QUnconfirmRst;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.model.http.HsoftReqData;
import hsoft.yfzx.jlgs.utils.model.http.HsoftRstData;
import hsoft.yfzx.jlgs.utils.tool.HttpMethodTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OAService {

    @Value("${custom.js.serverUrl}")
    String jsServerUrl;

//    private String jsServerUrl = "http://192.168.4.213:8088/jeesite/a/mobile";

    private Gson gson = new Gson();

    public ResponseData<QUnconfirmRst> unconfirm(String userId){
        ResponseData<QUnconfirmRst> responseData = new ResponseData<>();

        HUnconfirmRec hUnconfirmRec = new HUnconfirmRec();
        hUnconfirmRec.setUserId(userId);
        HsoftReqData<HUnconfirmRec> hsoftReqData = new HsoftReqData<>();
        hsoftReqData.setChangeableData(hUnconfirmRec);

        //请求内网地址
        String url = jsServerUrl + "/oa/unconfirm";
        //传入数据
        String dataStr = gson.toJson(hsoftReqData);

        QUnconfirmRst qUnconfirmRst = new QUnconfirmRst();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
//        System.out.println("the result = " + resultStr);
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<QUnconfirmRst> hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData<QUnconfirmRst>>() {
                        }.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0004);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }else{
                        qUnconfirmRst = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qUnconfirmRst);
        return responseData;
    }

}
