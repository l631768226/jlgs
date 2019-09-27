package hsoft.yfzx.jlgs.business.basic.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.*;
import hsoft.yfzx.jlgs.business.basic.dao.CtmFreqMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.FreqcontactMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.FreqgroupMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.GroupinfoMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.LogininfoMapper;
import hsoft.yfzx.jlgs.business.basic.model.*;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.model.http.HsoftReqData;
import hsoft.yfzx.jlgs.utils.model.http.HsoftRstData;
import hsoft.yfzx.jlgs.utils.tool.HttpMethodTool;
import io.netty.channel.FileRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FreqService {

    @Autowired
    private FreqcontactMapper freqcontactMapper;

    @Autowired
    private FreqgroupMapper freqgroupMapper;

    @Autowired
    private CtmFreqMapper ctmFreqMapper;

    @Autowired
    private LogininfoMapper logininfoMapper;

    @Autowired
    private GroupinfoMapper groupinfoMapper;

    private Gson gson = new Gson();


    @Value("${custom.js.serverUrl}")
    String jsServerUrl;

    /**
     * 设置常用联系人
     * @param userId 主人id
     * @param cFreqContactRec
     * @return
     */
    public ResponseData<String> setFreqContact(String userId, CFreqContactRec cFreqContactRec){
        ResponseData<String> responseData = new ResponseData<>();
        if(userId.equals(cFreqContactRec.getUserId())){
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("传入人员信息有误");
            return responseData;
        }

        //查询登录信息表
        Logininfo logininfo = logininfoMapper.selectByPrimaryKey(cFreqContactRec.getUserId());

        if(logininfo == null){
            responseData.setStatus(ReturnStatus.ERR0003);
            responseData.setExtInfo("该人员不存在");
            return responseData;
        }

        //确认常用联系人表中无此数据
        Freqcontact freqcontact = ctmFreqMapper.findById(userId, cFreqContactRec.getUserId());
        if(freqcontact != null){
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("传入常用联系人信息有误");
            return responseData;
        }

        //设置常用联系人数据
        freqcontact = new Freqcontact();
        freqcontact.setOWNERID(userId);
        freqcontact.setUSERID(cFreqContactRec.getUserId());
        freqcontact.setREALNAME(logininfo.getREALNAME());
        Short sort = 0;
        freqcontact.setSORT(sort);
        //数据库插入操作
        int insertCount = freqcontactMapper.insertSelective(freqcontact);
        if(insertCount < 1){
            //插入失败
            responseData.setStatus(ReturnStatus.ERR0004);
            responseData.setExtInfo("数据插入失败");
            return responseData;
        }

        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 设置常用联系人
     * @param ownerId 主人id
     * @param dFreqContactRec
     * @return
     */
    public ResponseData<String> delFreqContact(String ownerId, DFreqContactRec dFreqContactRec) {
        ResponseData<String> responseData = new ResponseData<>();
        //被删除人员id
        String userId = dFreqContactRec.getUserId();

        //删除对某人的常用联系人设置
        int delCount = ctmFreqMapper.delFreqContact(ownerId, userId);
        if(delCount < 1){
            responseData.setStatus(ReturnStatus.ERR0004);
            responseData.setExtInfo("数据库删除失败");
            return responseData;
        }
        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 设置常用群组
     * @param userId 主人id
     * @param cFreqGroupRec
     * @return
     */
    public ResponseData<String> setFreqGroup(String userId, CFreqGroupRec cFreqGroupRec) {
        ResponseData<String> responseData = new ResponseData<>();

        //获取群组id
        String groupId = cFreqGroupRec.getGroupId();
        //获取群组信息
        Groupinfo groupinfo = groupinfoMapper.selectByPrimaryKey(groupId);

        if(groupinfo == null){
            responseData.setStatus(ReturnStatus.ERR0003);
            responseData.setExtInfo("该群组不存在");
            return responseData;
        }
        //检测常用群组中是否有此信息
        Freqgroup freqgroup = ctmFreqMapper.findGroupById(userId, groupId);
        if(freqgroup != null){
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("传入常用群组信息有误");
            return responseData;
        }

        freqgroup = new Freqgroup();
        freqgroup.setGROUPID(groupId);
        freqgroup.setOWNERID(userId);
        freqgroup.setGROUPNAME(groupinfo.getGROUPNAME());
        Short sort = 0;
        freqgroup.setSORT(sort);

        //常用群组插入操作
        int insertCount = freqgroupMapper.insertSelective(freqgroup);
        if(insertCount < 1){
            //插入常用群组失败
            responseData.setStatus(ReturnStatus.ERR0004);
            responseData.setExtInfo("数据插入失败");
            return responseData;
        }

        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 删除常用群组
     * @param ownerId 主人id
     * @param dFreqGroupRec
     * @return
     */
    public ResponseData<String> delFreqGroup(String ownerId, DFreqGroupRec dFreqGroupRec) {
        ResponseData<String> responseData = new ResponseData<>();
        //被删除群组id
        String groupId = dFreqGroupRec.getGroupId();

        //删除对某人的常用群组设置
        int delCount = ctmFreqMapper.delFreqGroup(ownerId, groupId);
        if(delCount < 1){
            responseData.setStatus(ReturnStatus.ERR0004);
            responseData.setExtInfo("数据库删除失败");
            return responseData;
        }
        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 查询某人的常用联系人和常用群组
     * @param userId  用户id
     * @return
     */
    public ResponseData<QFreqListRst> queryFreqList(String userId){
        ResponseData<QFreqListRst> responseData = new ResponseData<>();
        //常用联系人列表
        List<QFreqRst> freqContactList = new ArrayList<>();
        //常用群组列表
        List<QFreqRst> freqGroupList = new ArrayList<>();
        //根据用户id查询常用联系人
        List<Freqcontact> freqcontactList = ctmFreqMapper.findContactByOwnerId(userId);
        List<String> userIdList = new ArrayList<>();
        if(freqcontactList != null && freqcontactList.size() > 0){
            for(Freqcontact freqcontact : freqcontactList){
                QFreqRst qFreqRst = new QFreqRst();
                qFreqRst.setObjectId(freqcontact.getUSERID());
                qFreqRst.setObjectName(freqcontact.getObjectName());
                qFreqRst.setOwnerId(freqcontact.getOWNERID());
                qFreqRst.setPicId(freqcontact.getPicId());
                qFreqRst.setSort(freqcontact.getSORT().toString());
                freqContactList.add(qFreqRst);
                userIdList.add(freqcontact.getUSERID());
            }
        }

        //根据用户id列表查询内网用户信息
        HQueryByIdsRec hQueryByIdsRec = new HQueryByIdsRec();
        hQueryByIdsRec.setUserIdList(userIdList);
        HsoftReqData<HQueryByIdsRec> hsoftReqData = new HsoftReqData<>();
        hsoftReqData.setChangeableData(hQueryByIdsRec);

        String dataStr = gson.toJson(hsoftReqData);
        String url = jsServerUrl + "/user/queryByIds";

        List<SysUser> sysUserList = new ArrayList<>();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<List<SysUser>> hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData<List<SysUser>>>() {
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
                        sysUserList = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        if(sysUserList != null && sysUserList.size() > 0){
            for(SysUser sysUser : sysUserList){
                for(QFreqRst qFreqRst : freqContactList){
                    if(sysUser.getId().equals(qFreqRst.getObjectId())){
                        qFreqRst.setMobile(sysUser.getMobile());
                        qFreqRst.setPosition(sysUser.getPosition());
                        break;
                    }else{
                        continue;
                    }
                }
            }
        }

        //根据用户id查询常用群组
        List<Freqgroup> freqgroupList = ctmFreqMapper.findGroupByOwnerId(userId);
        if(freqcontactList != null && freqcontactList.size() > 0){
            for(Freqgroup freqgroup : freqgroupList){
                QFreqRst qFreqRst = new QFreqRst();
                qFreqRst.setObjectId(freqgroup.getGROUPID());
                qFreqRst.setObjectName(freqgroup.getObjectName());
                qFreqRst.setOwnerId(freqgroup.getOWNERID());
                qFreqRst.setPicId(freqgroup.getPicId());
                qFreqRst.setSort(freqgroup.getSORT().toString());
                freqGroupList.add(qFreqRst);
            }
        }

        //设置返回数据
        QFreqListRst qFreqListRst = new QFreqListRst();
        qFreqListRst.setContactList(freqContactList);
        qFreqListRst.setGroupList(freqGroupList);

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qFreqListRst);
        return responseData;
    }

    /**
     * 常用群组排序
     * @param userId 主人id
     * @param data
     * @return
     */
    public ResponseData<String> groupSort(String userId, UFreGroupRec data){
        ResponseData<String> responseData = new ResponseData<>();
        //获取排序信息
        List<CtmFreqSortRec> sortRecList = data.getSorts();

        if(sortRecList != null && sortRecList.size() > 0){
            for(CtmFreqSortRec ctmFreqSortRec : sortRecList){
                ctmFreqMapper.updateGroupSort(ctmFreqSortRec.getSort(), ctmFreqSortRec.getObjectId(), userId);
            }
        }else{
            responseData.setStatus(ReturnStatus.ERR0003);
            responseData.setExtInfo("传入数据有误");
            return responseData;
        }

        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 常用联系人排序
     * @param userId 主人id
     * @param data
     * @return
     */
    public ResponseData<String> contactSort(String userId, UFreContactRec data){
        ResponseData<String> responseData = new ResponseData<>();
        //获取排序信息
        List<CtmFreqSortRec> sortRecList = data.getSorts();

        if(sortRecList != null && sortRecList.size() > 0){
            for(CtmFreqSortRec ctmFreqSortRec : sortRecList){
                ctmFreqMapper.updateContactSort(ctmFreqSortRec.getSort(), ctmFreqSortRec.getObjectId(), userId);
            }
        }else{
            responseData.setStatus(ReturnStatus.ERR0003);
            responseData.setExtInfo("传入数据有误");
            return responseData;
        }

        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 根据条件查询常用联系人
     * @param userId 主人id
     * @param data 查询条件
     * @return
     */
    public ResponseData<List<QFreqRst>> searchContact(String userId, QFreqSearchRec data){
        ResponseData<List<QFreqRst>> responseData = new ResponseData<>();

        String searchRule = data.getSearchRule();
        if(searchRule == null){
            searchRule = "";
        }

        List<Freqcontact> freqcontactList = ctmFreqMapper.searchContact(userId, searchRule);
        List<QFreqRst> qFreqRstList = new ArrayList<>();
        List<String> userIdList = new ArrayList<>();
        if(freqcontactList != null && freqcontactList.size() > 0){
            for(Freqcontact freqcontact : freqcontactList){
                QFreqRst qFreqRst = new QFreqRst();
                qFreqRst.setOwnerId(userId);
                qFreqRst.setPicId(freqcontact.getPicId());
                qFreqRst.setObjectName(freqcontact.getObjectName());
                qFreqRst.setObjectId(freqcontact.getUSERID());
                qFreqRst.setSort(freqcontact.getSORT().toString());
                qFreqRstList.add(qFreqRst);
                userIdList.add(freqcontact.getUSERID());
            }
        }

        //根据用户id列表查询内网用户信息
        HQueryByIdsRec hQueryByIdsRec = new HQueryByIdsRec();
        hQueryByIdsRec.setUserIdList(userIdList);
        HsoftReqData<HQueryByIdsRec> hsoftReqData = new HsoftReqData<>();
        hsoftReqData.setChangeableData(hQueryByIdsRec);

        String dataStr = gson.toJson(hsoftReqData);
        String url = jsServerUrl + "/user/queryByIds";

        List<SysUser> sysUserList = new ArrayList<>();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<List<SysUser>> hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData<List<SysUser>>>() {
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
                        sysUserList = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        if(sysUserList != null && sysUserList.size() > 0){
            for(SysUser sysUser : sysUserList){
                for(QFreqRst qFreqRst : qFreqRstList){
                    if(sysUser.getId().equals(qFreqRst.getObjectId())){
                        qFreqRst.setMobile(sysUser.getMobile());
                        qFreqRst.setPosition(sysUser.getPosition());
                        break;
                    }else{
                        continue;
                    }
                }
            }
        }

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qFreqRstList);
        return responseData;
    }

    /**
     * 根据条件查询常用群组
     * @param userId 主人id
     * @param data 查询条件
     * @return
     */
    public ResponseData<List<QFreqRst>> searchGroup(String userId, QFreqSearchRec data){
        ResponseData<List<QFreqRst>> responseData = new ResponseData<>();

        String searchRule = data.getSearchRule();
        if(searchRule == null){
            searchRule = "";
        }

        List<Freqgroup> freqcontactList = ctmFreqMapper.searchGroup(userId, searchRule);
        List<QFreqRst> qFreqRstList = new ArrayList<>();
        if(freqcontactList != null && freqcontactList.size() > 0){
            for(Freqgroup freqgroup : freqcontactList){
                QFreqRst qFreqRst = new QFreqRst();
                qFreqRst.setOwnerId(userId);
                qFreqRst.setPicId(freqgroup.getPicId());
                qFreqRst.setObjectName(freqgroup.getObjectName());
                qFreqRst.setObjectId(freqgroup.getGROUPID());
                qFreqRst.setSort(freqgroup.getSORT().toString());
                qFreqRstList.add(qFreqRst);
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qFreqRstList);
        return responseData;
    }

    /**
     * 查询我的常用联系人列表
     * @param ownerId
     * @return
     */
    public ResponseData<List<QFreqRst>> contactList(String ownerId) {

        ResponseData<List<QFreqRst>> responseData = new ResponseData<>();

        //常用联系人列表
        List<QFreqRst> freqContactList = new ArrayList<>();

        //根据用户id查询常用联系人
        List<Freqcontact> freqcontactList = ctmFreqMapper.findContactList(ownerId);
        List<String> userIdList = new ArrayList<>();
        if (freqcontactList != null && freqcontactList.size() > 0) {
            for (Freqcontact freqcontact : freqcontactList) {
                QFreqRst qFreqRst = new QFreqRst();
                qFreqRst.setObjectId(freqcontact.getUSERID());
                qFreqRst.setObjectName(freqcontact.getObjectName());
                qFreqRst.setOwnerId(freqcontact.getOWNERID());
                qFreqRst.setPicId(freqcontact.getPicId());
                qFreqRst.setSort(freqcontact.getSORT().toString());
                freqContactList.add(qFreqRst);
                userIdList.add(freqcontact.getUSERID());
            }
        }

        //根据用户id列表查询内网用户信息
        HQueryByIdsRec hQueryByIdsRec = new HQueryByIdsRec();
        hQueryByIdsRec.setUserIdList(userIdList);
        HsoftReqData<HQueryByIdsRec> hsoftReqData = new HsoftReqData<>();
        hsoftReqData.setChangeableData(hQueryByIdsRec);

        String dataStr = gson.toJson(hsoftReqData);
        String url = jsServerUrl + "/user/queryByIds";

        List<SysUser> sysUserList = new ArrayList<>();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if (resultStr.equals("fail") || resultStr.equals("error")) {
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        } else {
            try {
                HsoftRstData<List<SysUser>> hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData<List<SysUser>>>() {
                }.getType());

                if (hsoftRstData == null) {
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                } else {
                    int code = hsoftRstData.getCode();
                    if (code < 1) {
                        responseData.setStatus(ReturnStatus.ERR0004);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    } else {
                        sysUserList = hsoftRstData.getData();
                    }
                }
            } catch (Exception e) {
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        if (sysUserList != null && sysUserList.size() > 0) {
            for (SysUser sysUser : sysUserList) {
                for (QFreqRst qFreqRst : freqContactList) {
                    if (sysUser.getId().equals(qFreqRst.getObjectId())) {
                        qFreqRst.setMobile(sysUser.getMobile());
                        qFreqRst.setPosition(sysUser.getPosition());
                        break;
                    } else {
                        continue;
                    }
                }
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(freqContactList);
        return responseData;
    }

}
