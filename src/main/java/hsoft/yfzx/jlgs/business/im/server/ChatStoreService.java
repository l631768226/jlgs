package hsoft.yfzx.jlgs.business.im.server;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import hsoft.yfzx.jlgs.business.basic.dao.CtmUserGroupMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.LogininfoMapper;
import hsoft.yfzx.jlgs.business.basic.model.Logininfo;
import hsoft.yfzx.jlgs.business.basic.model.Usergroup;
import hsoft.yfzx.jlgs.business.im.ctmmodel.*;
import hsoft.yfzx.jlgs.business.im.dao.CtmChatStoreMapper;
import hsoft.yfzx.jlgs.business.im.model.Chatstore;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.tool.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ChatStoreService {

    @Autowired
    private CtmUserGroupMapper ctmUserGroupMapper;

    @Autowired
    private CtmChatStoreMapper ctmChatStoreMapper;

    @Autowired
    private LogininfoMapper logininfoMapper;

    /**
     * 同步消息记录
     *
     * @param data
     * @return 消息记录的id
     */
    public ResponseData<List<QChatStoreSyncRst>> queryIdList(QChatStoreSyncRec data) {
        ResponseData<List<QChatStoreSyncRst>> responseData = new ResponseData<List<QChatStoreSyncRst>>();
        // 声明查询条件
        String userId = data.getUserId();
        List<QChatStoreSyncRst> sChatStoreList = new ArrayList<>();
        // 获取是否为群组消息
        String objectType = data.getObjectType();
        List<Chatstore> chatStoreList;
        if ("1".equals(objectType)) {
            // 若为群组消息 则设置查询条件为 为群组消息，接收方id为群组id，发送时间小于传入的时间
            // criteria.andObjectTypeEqualTo(objectType).andReceIdEqualTo(data.getReceId())
            // .andSendTimeLessThan(data.getSendTime());

            BigDecimal versionStamp = null;
            // 判断此用户是否还在当前群组中
            Usergroup userGroup = ctmUserGroupMapper.findByUserIdGroupId(userId, data.getReceId());
            if (userGroup != null) {
                // 若存在，传入的时间即为接收的时间。
                versionStamp = data.getSendTime();
            } else {
                ;
            }

            // 开始查询
            // 设置分页
//            PageHelper.startPage(1, data.getAccount());
            // 消息列表
            chatStoreList = ctmChatStoreMapper.queryGroupChatStoreInfo(objectType, data.getReceId(),
                    versionStamp, userGroup.getCREATETIME(), data.getAccount());
        } else {
            // 若为单人消息，则设置查询条件为

            // 设置分页
//            PageHelper.startPage(1, data.getAccount());
            chatStoreList = ctmChatStoreMapper.queryChatStore(userId, data.getReceId(),
                    data.getSendTime(), data.getAccount());
        }

        // 将数据组拼成返回的格式
        for (Chatstore chatStore : chatStoreList) {
            QChatStoreSyncRst qChatStoreRst = new QChatStoreSyncRst();
            qChatStoreRst.setChatStoreId(chatStore.getCHATSTOREID());
            sChatStoreList.add(qChatStoreRst);
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(sChatStoreList);
        return responseData;
    }


    /**
     * 获取会话的最新一条消息
     *
     * @param data
     * @return
     */
    public ResponseData<List<QChatStoreListRst>> lastChatStore(QChatStoreListRec data) {
        ResponseData<List<QChatStoreListRst>> responseData = new ResponseData<>();

        // 获取用户id
        String userId = data.getUserId();
        // 获取用户id的列表
        List<String> userIds = data.getUserIds();

        // 获取群组id的列表
        List<String> groupIds = data.getGroupIds();

        if (userIds == null || groupIds == null) {
            // userIds 或 groupIds 为空
            // System.out.println("userid groupis is null");
            responseData.setStatus(ReturnStatus.ERR0018);
            responseData.setExtInfo("传入的数据为空");
            return responseData;
        }

        if (userIds.isEmpty() && groupIds.isEmpty()) {
            // System.out.println("userid groupid is empty");
            responseData.setStatus(ReturnStatus.ERR0018);
            responseData.setExtInfo("未按照约定的方式传入数据");
            return responseData;
        }

        List<QChatStoreListRst> list = new ArrayList<QChatStoreListRst>();
        if (userIds != null && !userIds.isEmpty()) {
            if (userIds.size() > 0) {
                for (String id : userIds) {
                    //根据用户id查询用户信息
                    Logininfo logininfo = logininfoMapper.selectByPrimaryKey(id);
                    if(logininfo == null){
                        //若用户信息不存在，则继续
                        continue;
                    }else{
                        // 根据己方id和对方的用户id查询双方会话的最后一条消息
                        List<CtmLastChatStore> chatStoreList = ctmChatStoreMapper.queryNewestChat(userId, id);
                        if (chatStoreList.size() > 0) {
                            QChatStoreListRst qChatStoreListRst = new QChatStoreListRst();
                            qChatStoreListRst.setChatStoreId(chatStoreList.get(0).getCHATSTOREID());
                            qChatStoreListRst.setContent(chatStoreList.get(0).getCONTENT());
                            qChatStoreListRst.setObjectType(chatStoreList.get(0).getOBJECTTYPE());
                            qChatStoreListRst.setIsReceipted(chatStoreList.get(0).getISRECEIPTED());
                            qChatStoreListRst.setMsgType(chatStoreList.get(0).getMSGTYPE());
                            qChatStoreListRst.setReceId(chatStoreList.get(0).getRECEID());
                            qChatStoreListRst.setSenderId(chatStoreList.get(0).getSENDERID());
                            qChatStoreListRst.setSenderName(chatStoreList.get(0).getSENDERNAME());
                            qChatStoreListRst.setSendTime(chatStoreList.get(0).getSENDTIME());
                            qChatStoreListRst.setVersionStamp(chatStoreList.get(0).getVERSIONSTAMP());
                            qChatStoreListRst.setName(chatStoreList.get(0).getNAME());
                            qChatStoreListRst.setPicId(chatStoreList.get(0).getPICID());
                            qChatStoreListRst.setObjectId(id);
                            qChatStoreListRst.setObjectName(chatStoreList.get(0).getOBJECTNAME());
                            qChatStoreListRst.setObjectPicId(chatStoreList.get(0).getOBJECTPICID());
                            list.add(qChatStoreListRst);
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        if (groupIds != null && !groupIds.isEmpty()) {
            if (groupIds.size() > 0) {
                for (String groupId : groupIds) {
                    // 根据用户id和群组id确认用户是否还是该群组成员
                    Usergroup userGroup = ctmUserGroupMapper.findByUserIdGroupId(userId, groupId);
                    List<CtmLastChatStore> chatStoreList = new ArrayList<>();
                    BigDecimal versionStamp = null;
                    if (userGroup != null) {
                        // 若是，则设置同步时间戳（小于此值的同步）为当前时间
                        versionStamp = Generator.getDecimalTimeStamp();
                    } else {
                        //当前用户已不在此群组中
                        continue;
                    }
                    chatStoreList = ctmChatStoreMapper.queryNewestGroupChat(groupId, versionStamp, userGroup.getCREATETIME());

                    // 若不是，则查询历史表获取离开群组的时间

                    // 根据时间获取离开群组前的最后一条消息
                    if (chatStoreList.size() > 0) {
                        QChatStoreListRst qChatStoreListRst = new QChatStoreListRst();
                        qChatStoreListRst.setChatStoreId(chatStoreList.get(0).getCHATSTOREID());
                        qChatStoreListRst.setContent(chatStoreList.get(0).getCONTENT());
                        qChatStoreListRst.setObjectType(chatStoreList.get(0).getOBJECTTYPE());
                        qChatStoreListRst.setIsReceipted(chatStoreList.get(0).getISRECEIPTED());
                        qChatStoreListRst.setMsgType(chatStoreList.get(0).getMSGTYPE());
                        qChatStoreListRst.setReceId(chatStoreList.get(0).getRECEID());
                        qChatStoreListRst.setSenderId(chatStoreList.get(0).getSENDERID());
                        qChatStoreListRst.setSenderName(chatStoreList.get(0).getSENDERNAME());
                        qChatStoreListRst.setSendTime(chatStoreList.get(0).getSENDTIME());
                        qChatStoreListRst.setVersionStamp(chatStoreList.get(0).getVERSIONSTAMP());
                        qChatStoreListRst.setName(chatStoreList.get(0).getNAME());
                        qChatStoreListRst.setPicId(chatStoreList.get(0).getPICID());
                        qChatStoreListRst.setObjectId(groupId);
                        qChatStoreListRst.setObjectName(chatStoreList.get(0).getOBJECTNAME());
                        qChatStoreListRst.setObjectPicId(chatStoreList.get(0).getOBJECTPICID());
                        list.add(qChatStoreListRst);
                    } else {
                        continue;
                    }
                }
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(list);

        return responseData;
    }

    /**
     * 根据消息id的list获取消息内容list
     *
     * @param data
     * @return
     */
    public ResponseData<List<QChatStoreRst>> queryList(QChatStoreRec data) {
        ResponseData<List<QChatStoreRst>> responseData = new ResponseData<>();
        // 获取消息id的列表
        List<String> ids = data.getIds();
//        System.out.println(new Gson().toJson(ids));

        String objectType = data.getObjectType();
        // 声明查询条件
        // 返回结果容器
        List<QChatStoreRst> qChatStoreRstList = new ArrayList<QChatStoreRst>();
        if ("0".equals(objectType)) {
            // 获取单人会话详情
            for (String id : ids) {
                // 根据id查询数据库获取聊天记录
                CtmChatStore chatStore = ctmChatStoreMapper.queryDetailByUserId(id);
                // 根据需要组拼返回结果
                if (chatStore != null) {
                    QChatStoreRst qChatStoreRst = new QChatStoreRst();

                    qChatStoreRst.setChatStoreId(chatStore.getCHATSTOREID());
                    qChatStoreRst.setContent(chatStore.getCONTENT());
                    qChatStoreRst.setObjectType(chatStore.getOBJECTTYPE());
                    qChatStoreRst.setSenderId(chatStore.getSENDERID());
                    qChatStoreRst.setSenderName(chatStore.getSENDERNAME());
                    qChatStoreRst.setReceId(chatStore.getRECEID());
                    qChatStoreRst.setMsgType(chatStore.getMSGTYPE());
                    qChatStoreRst.setSendTime(chatStore.getSENDTIME());
                    qChatStoreRst.setIsReceipted(chatStore.getISRECEIPTED());
                    qChatStoreRst.setVersionStamp(chatStore.getVERSIONSTAMP());
                    qChatStoreRst.setPicId(chatStore.getPICID());

                    qChatStoreRstList.add(qChatStoreRst);
                } else {
                    continue;
                }
            }
        } else {
            // 获取群组会话详情
            for (String id : ids) {
                // 根据id查询数据库获取聊天记录
                CtmChatStore chatStore = ctmChatStoreMapper.queryDetailByGroupId(id);
//                System.out.println(id + " " + new Gson().toJson(chatStore));
                // 根据需要组拼返回结果
                if (chatStore != null) {
                    QChatStoreRst qChatStoreRst = new QChatStoreRst();

                    qChatStoreRst.setChatStoreId(chatStore.getCHATSTOREID());
                    qChatStoreRst.setContent(chatStore.getCONTENT());
                    qChatStoreRst.setObjectType(chatStore.getOBJECTTYPE());
                    qChatStoreRst.setSenderId(chatStore.getSENDERID());
                    qChatStoreRst.setSenderName(chatStore.getSENDERNAME());
                    qChatStoreRst.setReceId(chatStore.getRECEID());
                    qChatStoreRst.setMsgType(chatStore.getMSGTYPE());
                    qChatStoreRst.setSendTime(chatStore.getSENDTIME());
                    qChatStoreRst.setIsReceipted(chatStore.getISRECEIPTED());
                    qChatStoreRst.setVersionStamp(chatStore.getVERSIONSTAMP());
                    qChatStoreRst.setPicId(chatStore.getPICID());

                    qChatStoreRstList.add(qChatStoreRst);
                } else {
                    continue;
                }
            }
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qChatStoreRstList);
        return responseData;
    }

    public ResponseData<List<QChatStoreRst>> queryLastChatStore(QChatRec qChatRec) {
        ResponseData<List<QChatStoreRst>> responseData = new ResponseData<List<QChatStoreRst>>();

        String objectType = qChatRec.getObjectType();

        String objectId = qChatRec.getObjectId();

        String userId = qChatRec.getUserId();
        // 声明查询条件
        // 返回结果容器
        List<QChatStoreRst> qChatStoreRstList = new ArrayList<QChatStoreRst>();
        if ("0".equals(objectType)) {
            // 获取单人会话详情
            //根据用户id查询用户信息
            Logininfo logininfo = logininfoMapper.selectByPrimaryKey(objectId);
            if(logininfo == null){
                //若用户信息不存在，则继续
                ;
            }else{
                // 根据id查询数据库获取聊天记录
                List<CtmChatStore> chatStoreList = ctmChatStoreMapper.queryLastByUserId(userId, objectId);
//                System.out.println(objectId + " " + new Gson().toJson(chatStoreList));
                // 根据需要组拼返回结果
                if (chatStoreList.size() > 0) {
                    QChatStoreRst qChatStoreRst = new QChatStoreRst();

                    qChatStoreRst.setChatStoreId(chatStoreList.get(0).getCHATSTOREID());
                    qChatStoreRst.setContent(chatStoreList.get(0).getCONTENT());
                    qChatStoreRst.setObjectType(chatStoreList.get(0).getOBJECTTYPE());
                    qChatStoreRst.setSenderId(chatStoreList.get(0).getSENDERID());
                    qChatStoreRst.setSenderName(chatStoreList.get(0).getSENDERNAME());
                    qChatStoreRst.setReceId(chatStoreList.get(0).getRECEID());
                    qChatStoreRst.setMsgType(chatStoreList.get(0).getMSGTYPE());
                    qChatStoreRst.setSendTime(chatStoreList.get(0).getSENDTIME());
                    qChatStoreRst.setIsReceipted(chatStoreList.get(0).getISRECEIPTED());
                    qChatStoreRst.setVersionStamp(chatStoreList.get(0).getVERSIONSTAMP());
                    qChatStoreRst.setPicId(chatStoreList.get(0).getPICID());

                    qChatStoreRstList.add(qChatStoreRst);
                } else {
                    ;
                }
            }

        } else {
            // 获取群组会话详情
            BigDecimal versionStamp = null;
            // 判断此用户是否还在当前群组中
            Usergroup userGroup = ctmUserGroupMapper.findByUserIdGroupId(userId, objectId);
            if (userGroup != null) {
                // 若存在，传入的时间即为接收的时间。
                versionStamp = Generator.getDecimalTimeStamp();
            } else {
                //若不在群组中，不做处理
                ;
            }

            // 根据id查询数据库获取聊天记录
            CtmChatStore chatStore = ctmChatStoreMapper.queryLastByGroupId(userId, objectId, versionStamp, userGroup.getCREATETIME());
//            System.out.println(objectId + " " + new Gson().toJson(chatStore));
            // 根据需要组拼返回结果
            if (chatStore != null) {
                QChatStoreRst qChatStoreRst = new QChatStoreRst();

                qChatStoreRst.setChatStoreId(chatStore.getCHATSTOREID());
                qChatStoreRst.setContent(chatStore.getCONTENT());
                qChatStoreRst.setObjectType(chatStore.getOBJECTTYPE());
                qChatStoreRst.setSenderId(chatStore.getSENDERID());
                qChatStoreRst.setSenderName(chatStore.getSENDERNAME());
                qChatStoreRst.setReceId(chatStore.getRECEID());
                qChatStoreRst.setMsgType(chatStore.getMSGTYPE());
                qChatStoreRst.setSendTime(chatStore.getSENDTIME());
                qChatStoreRst.setIsReceipted(chatStore.getISRECEIPTED());
                qChatStoreRst.setVersionStamp(chatStore.getVERSIONSTAMP());
                qChatStoreRst.setPicId(chatStore.getPICID());

                qChatStoreRstList.add(qChatStoreRst);
            } else {
                ;
            }
        }

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qChatStoreRstList);

        if (qChatStoreRstList == null || qChatStoreRstList.size() == 0) {
            responseData.setResultSet(new ArrayList<QChatStoreRst>());
        }
        return responseData;
    }

}
