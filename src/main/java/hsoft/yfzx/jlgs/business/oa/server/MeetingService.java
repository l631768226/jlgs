package hsoft.yfzx.jlgs.business.oa.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hsoft.yfzx.jlgs.business.oa.ctmmodel.QMeetingListRst;
import hsoft.yfzx.jlgs.business.oa.model.OaNotify;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.model.http.HsoftRstData;
import hsoft.yfzx.jlgs.utils.tool.HttpMethodTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingService {

    @Value("${custom.js.serverUrl}")
    String jsServerUrl;

    private Gson gson = new Gson();

    /**
     * 查询会议列表
     * @param userId
     * @return
     */
    public ResponseData<List<QMeetingListRst>> list(String userId){
        ResponseData<List<QMeetingListRst>> responseData = new ResponseData<>();

        List<QMeetingListRst> qMeetingListRstList = new ArrayList<>();

        String url = jsServerUrl + "";

        String dataStr = "";

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<List<QMeetingListRst>> hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData<List<QMeetingListRst>>>() {
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
                        qMeetingListRstList = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        responseData.setResultSet(qMeetingListRstList);
        return responseData;
    }



}
