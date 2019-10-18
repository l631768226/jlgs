package hsoft.yfzx.jlgs.business.oa.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hsoft.yfzx.jlgs.business.oa.ctmmodel.*;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.model.http.HsoftReqData;
import hsoft.yfzx.jlgs.utils.model.http.HsoftRstData;
import hsoft.yfzx.jlgs.utils.tool.HttpMethodTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FollowService {

    @Value("${custom.js.serverUrl}")
    String jsServerUrl;

    private Gson gson = new Gson();

    /**
     * 查看业务表修改记录
     * @param userId
     * @param data
     * @return
     */
    public ResponseData<QHistoicUpdateRst> historicUpdate(String userId, QHistoicUpdateRec data){
        ResponseData<QHistoicUpdateRst> responseData = new ResponseData<>();

        String procInsId = data.getProcInsId();
        String taskId = data.getTaskId();

        HsoftReqData<HHistoicUpdateRec> hsoftReqData = new HsoftReqData<>();
        HHistoicUpdateRec hHistoicUpdateRec = new HHistoicUpdateRec();
        hHistoicUpdateRec.setProcInsId(procInsId);
        hHistoicUpdateRec.setTaskId(taskId);
        hsoftReqData.setChangeableData(hHistoicUpdateRec);

        //内网请求数据
        String dataStr = gson.toJson(hsoftReqData);
        //请求内网地址
        String url = jsServerUrl + "/follow/histoicUpdate";
//        url = "http://192.168.4.206:8080/jeesite/a/mobile/follow/histoicUpdate";

        QHistoicUpdateRst qHistoicUpdateRst = new QHistoicUpdateRst();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
//        System.out.println(resultStr);
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<List<QHistoicUpdateRst>> hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData<List<QHistoicUpdateRst>>>() {
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
                        qHistoicUpdateRst = hsoftRstData.getData().get(0);
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qHistoicUpdateRst);
        return responseData;
    }

    public ResponseData<List<QHistoicFlowRst>> historicFlow(String userId, QHistoicFlowRec data){
        ResponseData<List<QHistoicFlowRst>> responseData = new ResponseData<>();

        String procInsId = data.getProcInsId();

        HsoftReqData<HHistoicUpdateRec> hsoftReqData = new HsoftReqData<>();
        HHistoicUpdateRec hHistoicUpdateRec = new HHistoicUpdateRec();
        hHistoicUpdateRec.setProcInsId(procInsId);
        hsoftReqData.setChangeableData(hHistoicUpdateRec);

        //内网请求数据
        String dataStr = gson.toJson(hsoftReqData);
        //请求内网地址
        String url = jsServerUrl + "/follow/histoicFlow";
//        url = "http://192.168.4.206:8080/jeesite/a/mobile/follow/histoicFlow";

        List<QHistoicFlowRst> qHistoicFlowRstList = new ArrayList<>();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
//        System.out.println("列表" + resultStr);
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<List<QHistoicFlowRst>> hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData<List<QHistoicFlowRst>>>() {
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
                        qHistoicFlowRstList = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qHistoicFlowRstList);
        return responseData;
    }
}
