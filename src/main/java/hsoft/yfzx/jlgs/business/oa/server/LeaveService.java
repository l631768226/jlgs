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
public class LeaveService {

    @Value("${custom.js.serverUrl}")
    String jsServerUrl;

    private Gson gson = new Gson();

    /**
     * 查询请休假列表
     * @param userId
     * @param data
     * @return
     */
    public ResponseData<List<QLeaveListRst>> list(String userId, QLeaveListRec data){
        ResponseData<List<QLeaveListRst>> responseData = new ResponseData<>();

        String status = data.getStatus();
        String pageNo = data.getPage();
        String pageSize = data.getPageSize();
        String type = data.getType();

        HsoftReqData<HLeaveListRec> hsoftReqData = new HsoftReqData<>();
        HLeaveListRec hLeaveListRec = new HLeaveListRec();
        hLeaveListRec.setStatus(status);
        hLeaveListRec.setUserId(userId);
        hLeaveListRec.setPageNo(pageNo);
        hLeaveListRec.setPageSize(pageSize);
        hLeaveListRec.setType(type);
        hsoftReqData.setChangeableData(hLeaveListRec);

        //请求内网地址
        String url = jsServerUrl + "/oa/leave/page";
        //传入数据
        String dataStr = gson.toJson(hsoftReqData);

        List<QLeaveListRst> qLeaveListRstList = new ArrayList<>();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        System.out.println("请休假列表" + resultStr);
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<List<QLeaveListRst>> hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData<List<QLeaveListRst>>>() {
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
                        qLeaveListRstList = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qLeaveListRstList);
        return  responseData;
    }

    /**
     * 查询请休假详情
     * @param userId
     * @param data
     * @return
     */
    public ResponseData<QLeaveDetailRst> detail(String userId, QLeaveDetailRec data){
        ResponseData<QLeaveDetailRst> responseData = new ResponseData<>();

        String leaveId = data.getLeaveId();

        HsoftReqData<HLeaveDetailRec> hsoftReqData = new HsoftReqData<>();
        HLeaveDetailRec hLeaveDetailRec = new HLeaveDetailRec();
        hLeaveDetailRec.setLeaveId(leaveId);
        hLeaveDetailRec.setUserId(userId);
        hsoftReqData.setChangeableData(hLeaveDetailRec);

        //请求内网地址
        String url = jsServerUrl + "/oa/leave/detail";
        //传入数据
        String dataStr = gson.toJson(hsoftReqData);

        QLeaveDetailRst qLeaveDetailRst = new QLeaveDetailRst();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<QLeaveDetailRst> hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData<QLeaveDetailRst>>() {
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
                        qLeaveDetailRst = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qLeaveDetailRst);
        return responseData;
    }

    /**
     * 请休假审批通过
     */
    public ResponseData<String> approve(String userId, CLeaveApproveRec data){
        ResponseData<String> responseData = new ResponseData<>();

        String leaveId = data.getLeaveId();
        String comment = data.getComment();

        HsoftReqData<HLeaveApproveRec> hsoftReqData = new HsoftReqData<>();
        HLeaveApproveRec hLeaveApproveRec = new HLeaveApproveRec();
        hLeaveApproveRec.setLeaveId(leaveId);
        hLeaveApproveRec.setUserId(userId);
        hLeaveApproveRec.setComment(comment);
        hsoftReqData.setChangeableData(hLeaveApproveRec);

        //请求内网地址
        String url = jsServerUrl + "/oa/leave/approve";
        //传入数据
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
                        responseData.setStatus(ReturnStatus.ERR0004);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);

        return responseData;
    }

    /**
     * 请休假审批驳回
     */
    public ResponseData<String> reject(String userId, CLeaveRejectRec data){
        ResponseData<String> responseData = new ResponseData<>();

        String leaveId = data.getLeaveId();
        String comment = data.getComment();

        HsoftReqData<HLeaveRejectRec> hsoftReqData = new HsoftReqData<>();
        HLeaveRejectRec hLeaveRejectRec = new HLeaveRejectRec();
        hLeaveRejectRec.setLeaveId(leaveId);
        hLeaveRejectRec.setUserId(userId);
        hLeaveRejectRec.setComment(comment);
        hsoftReqData.setChangeableData(hLeaveRejectRec);

        //请求内网地址
        String url = jsServerUrl + "/oa/leave/reject";
        //传入数据
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
                        responseData.setStatus(ReturnStatus.ERR0004);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }
}
