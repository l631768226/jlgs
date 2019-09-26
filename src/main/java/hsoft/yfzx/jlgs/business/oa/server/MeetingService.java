package hsoft.yfzx.jlgs.business.oa.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.HMeetingDetailRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.HMeetingListRec;
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
        //构造内网会议列表请求数据
        HsoftReqData<HMeetingListRec> hsoftReqData = new HsoftReqData<>();
        HMeetingListRec hMeetingListRec = new HMeetingListRec();
        hMeetingListRec.setUserId(userId);
        hsoftReqData.setChangeableData(hMeetingListRec);
        //请求内网地址
        String url = jsServerUrl + "";
        //传入数据
        String dataStr = gson.toJson(hsoftReqData);

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
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qMeetingListRstList);
        return responseData;
    }

    /**
     * 查询会议详情
     * @param userId
     * @param data
     * @return
     */
    public ResponseData<QMeetingDetailRst> detail(String userId, QMeetingDetailRec data){
        ResponseData<QMeetingDetailRst> responseData = new ResponseData<>();
        //获取会议id
        String meetingId = data.getMeetingId();
        //构造内网请求会议详情传入参数
        HsoftReqData<HMeetingDetailRec> hsoftReqData = new HsoftReqData<>();
        HMeetingDetailRec hMeetingDetailRec = new HMeetingDetailRec();
        hMeetingDetailRec.setUserId(userId);
        hMeetingDetailRec.setMeetingId(meetingId);
        hsoftReqData.setChangeableData(hMeetingDetailRec);
        //内网请求数据
        String dataStr = gson.toJson(hsoftReqData);
        //请求内网地址
        String url = jsServerUrl + "";

        QMeetingDetailRst qMeetingDetailRst = new QMeetingDetailRst();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<QMeetingDetailRst> hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData<QMeetingDetailRst>>() {
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
                        qMeetingDetailRst = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qMeetingDetailRst);
        return responseData;
    }

    /**
     * 确认参加会议
     * @param userId
     * @return
     */
    public ResponseData<String> confirm(String userId, CConfirmRec data){
        ResponseData<String> responseData = new ResponseData<>();
        //获取会议id
        String meetingId = data.getMeetingId();

        HsoftReqData<HConfirmRec> hsoftReqData = new HsoftReqData<>();
        HConfirmRec hConfirmRec = new HConfirmRec();
        hConfirmRec.setMeetingId(meetingId);
        hConfirmRec.setUserId(userId);
        hsoftReqData.setChangeableData(hConfirmRec);

        //内网请求数据
        String dataStr = gson.toJson(hsoftReqData);
        //请求内网地址
        String url = jsServerUrl + "";

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
     * 会议请假
     * @param ownerId
     * @param data
     * @return
     */
    public ResponseData<String> leave(String ownerId, CMeetingLeaveRec data){
        ResponseData<String>  responseData = new ResponseData<>();
        //获取代替参会人员id
        String userId = data.getUserId();
        //获取会议id
        String meetingId = data.getMeetingId();
        //获取部门id
        String deptId = data.getDeptId();

        HsoftReqData<HMeetingLeaveRec> hsoftReqData = new HsoftReqData<>();
        HMeetingLeaveRec hMeetingLeaveRec = new HMeetingLeaveRec();
        hMeetingLeaveRec.setUserId(userId);
        hMeetingLeaveRec.setOwnerId(ownerId);
        hMeetingLeaveRec.setMeetingId(meetingId);
        hMeetingLeaveRec.setDeptId(deptId);
        hsoftReqData.setChangeableData(hMeetingLeaveRec);

        //内网请求数据
        String dataStr = gson.toJson(hsoftReqData);
        //请求内网地址
        String url = jsServerUrl + "";

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
     * 获取会议审批列表
     * @param userId
     * @param data
     * @return
     */
    public ResponseData<QMeetingAproveListRst> approveList(String userId, QMeetingAproveListRec data){
        ResponseData<QMeetingAproveListRst> responseData = new ResponseData<>();
        //会议类型
        String type = data.getType();
        //状态（1待我办理 2经我办理 3我发起的）
        String status = data.getStatus();

        HsoftReqData<HMeetingApproveListRec> hsoftReqData = new HsoftReqData<>();
        HMeetingApproveListRec hMeetingApproveRec = new HMeetingApproveListRec();
        hMeetingApproveRec.setUserId(userId);
        hMeetingApproveRec.setStatus(status);
        hMeetingApproveRec.setType(type);
        hsoftReqData.setChangeableData(hMeetingApproveRec);

        //内网请求数据
        String dataStr = gson.toJson(hsoftReqData);
        //请求内网地址
        String url = jsServerUrl + "";

        QMeetingAproveListRst qMeetingAproveListRst = new QMeetingAproveListRst();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<QMeetingAproveListRst> hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData<QMeetingAproveListRst>>() {
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
                        qMeetingAproveListRst = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qMeetingAproveListRst);
        return responseData;
    }

    /**
     * 会议审批详情
     * @param userId
     * @param data
     * @return
     */
    public ResponseData<List<QMeetingApproveDetailRst>> approveDetail(
            String userId, QMeetingApproveDetailRec data){
        ResponseData<List<QMeetingApproveDetailRst>> responseData = new ResponseData<>();
        //获取会议id
        String meetingId = data.getMeetingId();

        List<QMeetingApproveDetailRst> qMeetingApproveDetailRstList = new ArrayList<>();

        HsoftReqData<HMeetingApproveDetailRec> hsoftReqData = new HsoftReqData<>();
        HMeetingApproveDetailRec hApproveDetailRec = new HMeetingApproveDetailRec();
        hApproveDetailRec.setMeetingId(meetingId);
        hApproveDetailRec.setUserId(userId);
        hsoftReqData.setChangeableData(hApproveDetailRec);

        //内网请求数据
        String dataStr = gson.toJson(hsoftReqData);
        //请求内网地址
        String url = jsServerUrl + "";

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<List<QMeetingApproveDetailRst>> hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData<List<QMeetingApproveDetailRst>>>() {
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
                        qMeetingApproveDetailRstList = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qMeetingApproveDetailRstList);
        return responseData;
    }

    /**
     * 会议办理
     * @param userId
     * @param data
     * @return
     */
    public ResponseData<String> approve(String userId, CMeetingApproveRec data){
        ResponseData<String> responseData = new ResponseData<>();
        //获取会议id
        String meetingId = data.getMeetingId();

        HsoftReqData<HMeetingApproveRec> hsoftReqData = new HsoftReqData<>();
        HMeetingApproveRec hApproveRec = new HMeetingApproveRec();
        hApproveRec.setMeetingId(meetingId);
        hApproveRec.setUserId(userId);
        hsoftReqData.setChangeableData(hApproveRec);

        //内网请求数据
        String dataStr = gson.toJson(hsoftReqData);
        //请求内网地址
        String url = jsServerUrl + "";

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
     * 会议驳回
     */
    public ResponseData<String> reject(String userId, CMeetingRejectRec data){
        ResponseData<String> responseData = new ResponseData<>();
        //会议id
        String meetingId = data.getMeetingId();

        HsoftReqData<HRejectRec> hsoftReqData = new HsoftReqData<>();
        HRejectRec hRejectRec = new HRejectRec();
        hRejectRec.setMeetingId(meetingId);
        hRejectRec.setUserId(userId);
        hsoftReqData.setChangeableData(hRejectRec);

        //内网请求数据
        String dataStr = gson.toJson(hsoftReqData);
        //请求内网地址
        String url = jsServerUrl + "";

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
