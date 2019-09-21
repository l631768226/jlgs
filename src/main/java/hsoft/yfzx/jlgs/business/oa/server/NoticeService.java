package hsoft.yfzx.jlgs.business.oa.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hsoft.yfzx.jlgs.business.oa.ctmmodel.*;
import hsoft.yfzx.jlgs.business.oa.model.OaNotify;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.model.http.HsoftReqData;
import hsoft.yfzx.jlgs.utils.model.http.HsoftRstData;
import hsoft.yfzx.jlgs.utils.tool.HttpMethodTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.ServerError;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NoticeService {

    private Gson gson = new Gson();

    @Value("${custom.serverUrl}")
    private String serverUrl;

    /**
     * 查询通知详情
     * @param data
     * @return
     */
    public ResponseData<QNoticeDetailRst> detail(QNoticeDetailRec data){
        ResponseData<QNoticeDetailRst> responseData = new ResponseData<>();
        //获取通知id
        String noticeId = data.getNoticeId();
        //组织内网请求数据
        HNoticeDetailRec hNoticeDetailRec = new HNoticeDetailRec();
        hNoticeDetailRec.setNoticeId(noticeId);
        HsoftReqData<HNoticeDetailRec> hsoftReqData = new HsoftReqData();
        hsoftReqData.setChangeableData(hNoticeDetailRec);
        //内网请求数据
        String dataStr = gson.toJson(hsoftReqData);

        String url = serverUrl + "/notice/detail";

        OaNotify notice = new OaNotify();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<OaNotify> hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData<OaNotify>>() {
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
                        notice = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        QNoticeDetailRst qNoticeDetailRst = new QNoticeDetailRst();
        qNoticeDetailRst.setNoticeId(notice.getId());
        qNoticeDetailRst.setContent(notice.getContent());
//        qNoticeDetailRst.setRelationId(notice.get);
        qNoticeDetailRst.setTitle(notice.getTitle());
        qNoticeDetailRst.setType(notice.getType());

        qNoticeDetailRst.setCreateTime(notice.getCreate_DATE());

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qNoticeDetailRst);
        return responseData;
    }

    /**
     * 修改通知阅读状态
     * @param userId
     * @param data
     * @return
     */
    public ResponseData<String> changeState(String userId, UChangeStateRec data){
        ResponseData<String> responseData = new ResponseData<>();
        //获取通知id
        String noticeId = data.getNoticeId();

        HChangeStateRec hChangeStateRec = new HChangeStateRec();
        hChangeStateRec.setNoticeId(noticeId);
        hChangeStateRec.setUserId(userId);
        hChangeStateRec.setState("1");
        HsoftReqData<HChangeStateRec> hsoftReqData = new HsoftReqData<>();
        hsoftReqData.setChangeableData(hChangeStateRec);
        //请求数据
        String dataStr = gson.toJson(hsoftReqData);
        //请求地址
        String url = serverUrl + "/notice/changeState";

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData>() {
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


    public ResponseData<List<QNoticeListRst>> queryList(String userId, QNoticeListRec data){
        ResponseData<List<QNoticeListRst>> responseData = new ResponseData<>();

        String state = data.getState();
        String type = data.getType();

        HNoticeListRec hNoticeListRec = new HNoticeListRec();
        hNoticeListRec.setState(state);
        hNoticeListRec.setType(type);
        hNoticeListRec.setUserId(userId);
        HsoftReqData<HNoticeListRec> hsoftReqData = new HsoftReqData<>();
        hsoftReqData.setChangeableData(hNoticeListRec);
        //传入参数
        String dataStr = gson.toJson(hsoftReqData);
        //请求地址
        String url = serverUrl + "/notice/list";

        List<OaNotify> oaNotifyList = new ArrayList<>();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<List<OaNotify>> hsoftRstData = gson.fromJson(resultStr,
                        new TypeToken<HsoftRstData<List<OaNotify>>>() {
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
                    }else {
                        oaNotifyList = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }
        List<QNoticeListRst> qNoticeListRsts = new ArrayList<>();
        if(oaNotifyList != null && oaNotifyList.size() > 0){
            for(OaNotify oaNotify : oaNotifyList){
                QNoticeListRst qNoticeListRst = new QNoticeListRst();
                qNoticeListRst.setId(oaNotify.getId());
                qNoticeListRst.setCreateTime(oaNotify.getCreate_DATE());
                qNoticeListRst.setState(oaNotify.getStatus());
                qNoticeListRst.setType(oaNotify.getType());
                qNoticeListRsts.add(qNoticeListRst);
            }
        }

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qNoticeListRsts);
        return responseData;
    }

}
