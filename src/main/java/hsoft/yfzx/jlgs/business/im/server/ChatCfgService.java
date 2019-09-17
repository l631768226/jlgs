package hsoft.yfzx.jlgs.business.im.server;

import hsoft.yfzx.jlgs.business.basic.dao.CtmUserGroupMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.LogininfoMapper;
import hsoft.yfzx.jlgs.business.basic.model.Logininfo;
import hsoft.yfzx.jlgs.business.basic.model.Usergroup;
import hsoft.yfzx.jlgs.business.im.ctmmodel.*;
import hsoft.yfzx.jlgs.business.im.dao.CtmChatCfgMapper;
import hsoft.yfzx.jlgs.business.im.mapper.ChatcfgMapper;
import hsoft.yfzx.jlgs.business.im.model.Chatcfg;
import hsoft.yfzx.jlgs.utils.model.common.OfflineData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.model.common.SyncData;
import hsoft.yfzx.jlgs.utils.tool.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ChatCfgService {

    @Autowired
    private LogininfoMapper logininfoMapper;

    @Autowired
    private CtmUserGroupMapper ctmUserGroupMapper;

    @Autowired
    private CtmChatCfgMapper ctmChatCfgMapper;

    @Autowired
    private ChatcfgMapper chatcfgMapper;

    /**
     * 更新用户的会话设置
     * @param data
     * @return
     */
    public ResponseData<String> updateChatCfg(UChatCfgRec data) {
        ResponseData<String> responseData = new ResponseData<>();

        //根据objectType判断是单人设置还是群聊设置
        if(data.getObjectType().equals("0")){
            //如果是单人设置，判断对方是否存在
            Logininfo logininfo = logininfoMapper.selectByPrimaryKey(data.getObjectId());
            if(logininfo == null){
                //如果不存在
                responseData.setStatus(ReturnStatus.ERR0003);
                responseData.setExtInfo("对方不存在，该用户已被删除");
                return responseData;
            }else{
                ;
            }
        }else{
            //如果是群组设置，判断本人是否在这个群组中
            Usergroup userGroup = ctmUserGroupMapper.findByUserIdGroupId(data.getUserId(), data.getObjectId());
            if(userGroup == null){
                //如果该用户不在此群组中
                responseData.setStatus(ReturnStatus.ERR0003);
                responseData.setExtInfo("该用户不在此群组中");
                return responseData;
            }else{
                ;
            }
        }

        //查询此人对此聊天对象的会话设置
        List<Chatcfg> list = ctmChatCfgMapper.findByObjectId(data.getObjectId(), data.getUserId());
        if (list.isEmpty()) {
            // 若查询结果为空，则说明此条数据不存在, 说明这是一条新的会话设置
            //新增会话设置
            Chatcfg chatCfg = new Chatcfg();
            chatCfg.setOBJECTID(data.getObjectId());
            chatCfg.setTOPSTATUS(data.getTopStatus());
            chatCfg.setOBJECTTYPE(data.getObjectType());
            chatCfg.setUNDISTURBED(data.getUndisturbed());
            chatCfg.setCHATCFGID(Generator.getUUID());
            chatCfg.setCREATETIME(Generator.getLongTimeStamp());
            chatCfg.setVERSIONSTAMP(Generator.getLongTimeStamp());

            chatcfgMapper.insertSelective(chatCfg);
            responseData.setStatus(ReturnStatus.OK);
        } else {
            // 若数据存在，则将传入的设置更新到数据库中
            ctmChatCfgMapper.updateById(data.getTopStatus(), data.getUndisturbed(), data.getUserId()  ,data.getObjectId());
            responseData.setStatus(ReturnStatus.OK);
        }
        return responseData;
    }

    /**
     * 获取某位用户的会话设置
     *
     * @param userId
     * @return
     */
    public ResponseData<OfflineData<List<QChatCfgRst>>> chatCfgList(String userId) {
        ResponseData<OfflineData<List<QChatCfgRst>>> responseData = new ResponseData<>();
        // 查询拥有者id与操作用户id相同的数据
        List<CtmChatCfg> list = ctmChatCfgMapper.queryByUserId(userId);
        //最大版本号
        String maxVersion = "";
        if(list.size() > 0){
            maxVersion = list.get(0).getVERSIONSTAMP();
        }else{
            maxVersion = Generator.getLongTimeStamp().toString();
        }

        // 返回值的容器
        List<QChatCfgRst> chatCfgList = new ArrayList<QChatCfgRst>();
        // 从查询的信息中过滤出需要的字段
        for (CtmChatCfg chatCfg : list) {
            QChatCfgRst qChatCfgRst = new QChatCfgRst();
            qChatCfgRst.setChatCfgId(chatCfg.getCHATCFGID());
            qChatCfgRst.setName(chatCfg.getNAME());
            qChatCfgRst.setObjectId(chatCfg.getOBJECTID());
            qChatCfgRst.setObjectType(chatCfg.getOBJECTTYPE());
            qChatCfgRst.setPicId(chatCfg.getPICID());
            qChatCfgRst.setTopStatus(chatCfg.getTOPSTATUS());
            qChatCfgRst.setUndisturbed(chatCfg.getUNDISTURBED());
            qChatCfgRst.setUserId(chatCfg.getUSERID());
            qChatCfgRst.setVersionStamp(chatCfg.getVERSIONSTAMP());
            chatCfgList.add(qChatCfgRst);
        }
        //获取下载时间
        BigDecimal downloadTime = Generator.getDecimalTimeStamp();
        //设置返回参数
        OfflineData<List<QChatCfgRst>> offlineData = new OfflineData<>();
        offlineData.setData(chatCfgList);
        offlineData.setVersionStamp(maxVersion);
        offlineData.setDownloadTime(String.valueOf(downloadTime));

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(offlineData);
        return responseData;
    }

    /**
     * 同步某位用户的会话设置
     *
     * @param data
     * @return
     */
    public ResponseData<SyncData<List<QChatCfgSyncRst>, List<String>>> syncChatCfg(QChatCfgSyncRec data) {
        ResponseData<SyncData<List<QChatCfgSyncRst>, List<String>>> responseData = new ResponseData<>();

        SyncData<List<QChatCfgSyncRst>, List<String>> syncData = new SyncData<>();

        List<CtmChatCfg> list = ctmChatCfgMapper.queryListByIdAndVersion(data.getUserId(), String.valueOf(data.getVersionStamp()));

        // 返回值的容器
        List<QChatCfgSyncRst> chatCfgList = new ArrayList<QChatCfgSyncRst>();

        if(list.size() > 0){
            // 从查询的信息中过滤出需要的字段
            for (CtmChatCfg chatCfg : list) {
                QChatCfgSyncRst qChatCfgRst = new QChatCfgSyncRst();
                qChatCfgRst.setChatCfgId(chatCfg.getCHATCFGID());
                qChatCfgRst.setName(chatCfg.getNAME());
                qChatCfgRst.setObjectId(chatCfg.getOBJECTID());
                qChatCfgRst.setObjectType(chatCfg.getOBJECTTYPE());
                qChatCfgRst.setPicId(chatCfg.getPICID());
                qChatCfgRst.setTopStatus(chatCfg.getTOPSTATUS());
                qChatCfgRst.setUndisturbed(chatCfg.getUNDISTURBED());
                qChatCfgRst.setUserId(chatCfg.getUSERID());
                qChatCfgRst.setVersionStamp(chatCfg.getVERSIONSTAMP());
                chatCfgList.add(qChatCfgRst);
            }

            syncData.setVersionStamp(String.valueOf(chatCfgList.get(0).getVersionStamp()));

        }else{
            syncData.setVersionStamp(String.valueOf(Generator.getCurrentTime()));

        }
        syncData.setData(chatCfgList);
        syncData.setSyncTime(String.valueOf(Generator.getCurrentTime()));
        responseData.setStatus(ReturnStatus.OK);
        syncData.setRemoveData(new ArrayList<String>());
        responseData.setResultSet(syncData);
        return responseData;

    }

}
