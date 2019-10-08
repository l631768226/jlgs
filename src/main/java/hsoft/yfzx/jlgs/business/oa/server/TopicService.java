package hsoft.yfzx.jlgs.business.oa.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.UModifyRec;
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
public class TopicService {

    @Value("${custom.js.serverUrl}")
    String jsServerUrl;

    private Gson gson = new Gson();

    /**
     * 查询会议议题审批列表
     * @param userId
     * @return
     */
    public ResponseData<List<QTopicListRst>> list(QTopicListRec data, String userId){
        ResponseData<List<QTopicListRst>> responseData = new ResponseData<>();

        String loginName = data.getUserName();
        String page = data.getPage();
        String pageSize = data.getPageSize();
        String topicName = data.getTopicName();
        String status = data.getStatus();
        String type = data.getType();
        String deptId = data.getDeptId();

        HsoftReqData<HTopicListRec> hsoftReqData = new HsoftReqData<>();
        HTopicListRec hTopicListRec = new HTopicListRec();
        hTopicListRec.setUserId(userId);
        hTopicListRec.setPageSize(pageSize);
        hTopicListRec.setPageNo(page);
        hTopicListRec.setLoginName(loginName);
        hTopicListRec.setStatus(status);
        hTopicListRec.setTopicName(topicName);
        hTopicListRec.setType(type);
        hTopicListRec.setUserDepId(deptId);
        hsoftReqData.setChangeableData(hTopicListRec);

//        System.out.println(gson.toJson(hsoftReqData));

        String url = jsServerUrl + "/topic/topicCheckList";
//        String url = "http://192.168.4.218:8088/jeesite/a/mobile/topic/topicCheckList";
        String dataStr = gson.toJson(hsoftReqData);

        List<QTopicListRst> qTopicListRstList = new ArrayList<>();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");

        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<List<QTopicListRst>> hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData<List<QTopicListRst>>>() {
                }.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0013);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }else{
                        qTopicListRstList = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qTopicListRstList);
        return responseData;
    }

    /**
     * 会议议题审批通过
     * @param userId
     * @param data
     * @return
     */
    public ResponseData<String> approve(String userId, CTopicApproveRec data){
        ResponseData<String> responseData = new ResponseData<>();
        String topicId = data.getTopicId();
        String comment = data.getComment();
        HsoftReqData<HTopicApproveRec> hsoftReqData = new HsoftReqData<>();
        HTopicApproveRec hTopicApproveRec = new HTopicApproveRec();
        hTopicApproveRec.setTopicId(topicId);
        hTopicApproveRec.setUserId(userId);
        hTopicApproveRec.setComment(comment);
        hsoftReqData.setChangeableData(hTopicApproveRec);

        String url = jsServerUrl + "/topic/topicApprove";

        String dataStr = gson.toJson(hsoftReqData);


        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData>() {
                        }.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0013);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 会议议题审批驳回
     * @param userId
     * @param data
     * @return
     */
    public ResponseData<String> reject(String userId, CTopicRejectRec data){
        ResponseData<String> responseData = new ResponseData<>();
        String topicId = data.getTopicId();
        String comment = data.getComment();

        HsoftReqData<HTopicRejectRec> hsoftReqData = new HsoftReqData<>();
        HTopicRejectRec hTopicRejectRec = new HTopicRejectRec();
        hTopicRejectRec.setTopicId(topicId);
        hTopicRejectRec.setUserId(userId);
        hTopicRejectRec.setComment(comment);
        hsoftReqData.setChangeableData(hTopicRejectRec);

        String url = jsServerUrl + "/topic/topicReject";

        String dataStr = gson.toJson(hsoftReqData);

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData>() {
                        }.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0013);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 查询会议议题详情
     * @param userId
     * @return
     */
    public ResponseData<QTopicDetailRst> detail(String userId, QTopicDetailRec data){
        ResponseData<QTopicDetailRst> responseData = new ResponseData<>();

        HsoftReqData<HTopicDetailRec> hsoftReqData = new HsoftReqData<>();
        HTopicDetailRec hTopicDetailRec = new HTopicDetailRec();
        hTopicDetailRec.setUserId(userId);
        hTopicDetailRec.setTopicId(data.getTopicId());
        hsoftReqData.setChangeableData(hTopicDetailRec);

        String url = jsServerUrl + "/topic/topicDetail";
//        String url = "http://192.168.4.218:8088/jeesite/a/mobile/topic/topicDetail";


        String dataStr = gson.toJson(hsoftReqData);

        QTopicDetailRst qTopicListRst = new QTopicDetailRst();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");

        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<QTopicDetailRst> hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData<QTopicDetailRst>>() {
                        }.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0013);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }else{
                        qTopicListRst = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qTopicListRst);
        return responseData;
    }

    public ResponseData<String> modify(String userId, UModifyRec data){
        ResponseData<String> responseData = new ResponseData<>();
        data.setUserId(userId);
        HsoftReqData<UModifyRec> hsoftReqData = new HsoftReqData<>();
        hsoftReqData.setChangeableData(data);

        String url = jsServerUrl + "/topic/topicModify";

        String dataStr = gson.toJson(hsoftReqData);

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData>() {
                        }.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0013);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }


}
