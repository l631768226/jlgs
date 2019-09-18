package hsoft.yfzx.jlgs.business.im.server;

import com.google.gson.Gson;
import hsoft.yfzx.jlgs.business.basic.dao.CtmUserGroupMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.GroupinfoMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.LogininfoMapper;
import hsoft.yfzx.jlgs.business.basic.model.Groupinfo;
import hsoft.yfzx.jlgs.business.basic.model.Logininfo;
import hsoft.yfzx.jlgs.business.file.server.FileService;
import hsoft.yfzx.jlgs.business.im.ctmmodel.CXmppRec;
import hsoft.yfzx.jlgs.business.im.ctmmodel.CXmppRst;
import hsoft.yfzx.jlgs.business.im.mapper.ChatstoreMapper;
import hsoft.yfzx.jlgs.business.im.model.Chatstore;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.model.push.*;
import hsoft.yfzx.jlgs.utils.tool.FBase64;
import hsoft.yfzx.jlgs.utils.tool.Generator;
import hsoft.yfzx.jlgs.utils.tool.XmppOperator;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.exceptions.InvalidDeviceTokenFormatException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class XmppService {

    private Gson gson = new Gson();

    private FileService fileService;

    @Autowired
    private LogininfoMapper logininfoMapper;

    @Autowired
    private ChatstoreMapper chatstoreMapper;

    @Autowired
    private GroupinfoMapper groupinfoMapper;

    @Autowired
    private CtmUserGroupMapper ctmUserGroupMapper;

    //使用mongodb
    @Value("${custom.fileUrl}")
    private String fileUrl;

    public ResponseData<CXmppRst> sendXmpp(CXmppRec data, HttpServletRequest request) throws IOException, ServletException {
        ResponseData<CXmppRst> responseData = new ResponseData<>();

        // 发送的XMPP消息中<body>标签中的内容
        String msgInfo = "";
        // 前端传入的消息类型
        String msgType = data.getMsgType();
        // APNS推送的消息内容
        String apnsContent = "";
        // 存储到数据库中的数据
        String content = "";

        XmppBodyData xmppBodyData = new XmppBodyData();
        XmppHeadData<XmppBodyData> xmppHeadData = new XmppHeadData<>();
        //文件名称
        String fileName = "";
        //文件id
        String fileId = "";
        switch (msgType) {
            // 文本类型
            case "20000":
            case "20001":
                XmppTextData xmppTextData = new XmppTextData();
                xmppTextData.setContent(data.getContent());
                content = gson.toJson(xmppTextData);
                xmppBodyData.setContent(content);
                apnsContent = data.getContent();
                break;

            // 图片
            case "20002":
                // 图片文件处理

                String imgResult = "";

                //如果使用mongodb
                //获取文件id
                fileId = fileService.uploadDBFile(request.getPart("file"));
                imgResult = fileUrl + fileId;

                System.out.println("img = " + imgResult);
                XmppImgData xmppImgData = new XmppImgData();
                xmppImgData.setUrl(imgResult);
                xmppImgData.setSize(data.getFileSize());

                content = gson.toJson(xmppImgData);

                xmppBodyData.setContent(content);

                apnsContent = "[图片]";
                break;

            // 语音
            case "20003":
                // 语音处理
                String audioUrl = "";

                //获取文件id
                fileId = fileService.uploadDBFile(request.getPart("file"));
                audioUrl = fileUrl + fileId;

                System.out.println("audio = " + audioUrl);
                XmppAudioData xmppAudioData = new XmppAudioData();
                xmppAudioData.setUrl(audioUrl);
                xmppAudioData.setDuration(data.getDuration());

                content = gson.toJson(xmppAudioData);

                xmppBodyData.setContent(content);
                apnsContent = "[语音]";
                break;

            // 视频
            case "20004":
                // 视频及图片文件处理
                String videoUrl = "";
                String firstFrameImageUrl = "";

                //使用mongodb
                String videoFilePath = fileService.uploadDBFile(request.getPart("file"));
                videoUrl = fileUrl + videoFilePath;

                firstFrameImageUrl = fileUrl + fileService.uploadDBFile(request.getPart("imgFile"));

                XmppVideoData xmppVideoData = new XmppVideoData();
                xmppVideoData.setUrl(videoUrl);
                xmppVideoData.setFirstFrameImageUrl(firstFrameImageUrl);
                xmppVideoData.setSize(data.getFileSize());
                xmppVideoData.setDuration(data.getDuration());

                content = gson.toJson(xmppVideoData);

                xmppBodyData.setContent(content);
                apnsContent = "[视频]";
                break;

            // 文件
            case "20005":
                // 文件处理
                String filesUrl = "";

                //mongodb
                fileId = fileService.uploadDBFile(request.getPart("file"));
                filesUrl = fileUrl + fileId;

                XmppFileData xmppFileData = new XmppFileData();
                xmppFileData.setFileType(data.getFileType());
                xmppFileData.setName(data.getFileName());
                xmppFileData.setSize(data.getFileSize());
                xmppFileData.setUrl(filesUrl);

                content = gson.toJson(xmppFileData);

                xmppBodyData.setContent(content);
                apnsContent = "[文件]";
                break;

            // 位置
            case "20006":
                XmppLocationData xmppLocationData = new XmppLocationData();

                xmppLocationData.setAddress(data.getAddress());
                xmppLocationData.setCoordinateSystem(data.getCoordinateSystem());
                xmppLocationData.setLat(data.getLat());
                xmppLocationData.setLon(data.getLon());
                xmppLocationData.setBuildingName(data.getBuildingName());

                content = gson.toJson(xmppLocationData);

                xmppBodyData.setContent(content);
                apnsContent = "[位置]";
                break;

            // 群组加减人
            case "20007":
                XmppGroupData xmppGroupData = new XmppGroupData();

                xmppGroupData.setOperateType(data.getOperateType());
                xmppGroupData.setUuids(data.getOperationIds());

                content = gson.toJson(xmppGroupData);

                xmppBodyData.setContent(content);
                break;

            default:
                break;
        }

        Chatstore chatStore = new Chatstore();
        Long sendTime = Generator.getLongTimeStamp();
        //聊天id
        String chatStoreId = Generator.getUUID();
        try {
            // 获取发送消息人员的信息
            Logininfo logininfo = logininfoMapper.selectByPrimaryKey(data.getSenderId());
            if (logininfo == null) {
                // 若发送人信息不存在
                responseData.setStatus(ReturnStatus.ERR0019);
                responseData.setExtInfo("发送人员信息不存在");
                return responseData;
            }


            // 组织插入数据库的数据

            chatStore.setCHATSTOREID(chatStoreId);
            chatStore.setOBJECTTYPE(data.getObjectType());
            chatStore.setSENDERID(data.getSenderId());
            chatStore.setSENDERNAME(data.getSenderName());
            chatStore.setRECEID(data.getReceId());
            chatStore.setMSGTYPE(data.getMsgType());
            chatStore.setVERSIONSTAMP(sendTime);
            chatStore.setSENDTIME(sendTime);
            // 初始设置发送状态为 失败
            chatStore.setSENDSTATUS("0");
            chatStore.setCONTENT(content);

            xmppBodyData.setReceId(data.getReceId());
            xmppBodyData.setIsReceipted(data.getIsReceipted());
            xmppBodyData.setObjectType(data.getObjectType());
            xmppBodyData.setSenderId(data.getSenderId());
            xmppBodyData.setSenderName(data.getSenderName());
            xmppBodyData.setUserPic(logininfo.getPICID());
            xmppBodyData.setMsgType(msgType);
            xmppBodyData.setSendTime(String.valueOf(sendTime));
            xmppBodyData.setChatStoreId(chatStoreId);
            // 消息组拼完毕，根据 isGroup（是否群组消息）决定是单发消息是群发
            if ("0".equals(data.getObjectType())) {
                // 若为单人消息
                xmppHeadData.setMessageType("2");

                xmppHeadData.setContent(xmppBodyData);
                msgInfo = gson.toJson(xmppHeadData);
                System.out.println("2****" + msgInfo);
                // 获取接收人的信息
                Logininfo receUser = logininfoMapper.selectByPrimaryKey(data.getReceId());
                if (receUser == null) {
                    // 若接收人员信息不存在
                    responseData.setStatus(ReturnStatus.ERR0020);
                    responseData.setExtInfo("接收人员信息不存在");
                    return responseData;
                }

                // 插入数据库
                chatstoreMapper.insertSelective(chatStore);

                System.out.println("0***************" + gson.toJson(chatStore));
                List<String> userList = new ArrayList<>();
                userList.add(receUser.getUSERID());
                apnsContent = logininfo.getREALNAME() + ":" + apnsContent;

                //FBase64加密
                msgInfo = FBase64.encode(msgInfo.getBytes("UTF-8"));


                sendXMPP(userList, msgInfo, apnsContent, msgType, "");
                // XmppOperator.xmppSend(receUser.getUserName(), msgInfo);
            } else {
                // 若为群组消息
                xmppHeadData.setMessageType("2");

                // 群组信息相关内容设置
                Groupinfo groupInfo = groupinfoMapper.selectByPrimaryKey(data.getReceId());
                if (groupInfo == null) {
                    // 若群组信息不存在
                    responseData.setStatus(ReturnStatus.ERR0020);
                    responseData.setExtInfo("该群已被解散");
                    return responseData;
                }

                xmppBodyData.setGroupName(groupInfo.getGROUPNAME());
                xmppBodyData.setGroupPic(groupInfo.getPICID());
                // 组装成消息体内容
                xmppHeadData.setContent(xmppBodyData);

                msgInfo = gson.toJson(xmppHeadData);
                //查询群组人员id列表
                List<String> userIdList = ctmUserGroupMapper.queryUserId(data.getReceId());
                if (!userIdList.contains(data.getSenderId())) {
                    //若群组人员id列表中不包含自己，则说明已被移出群组
                    responseData.setStatus(ReturnStatus.ERR0026);
                    responseData.setExtInfo("你已被移出该群组");
                    return responseData;
                }

                //利用迭代器从群组人员id列表中删除自己的id
                Iterator<String> it = userIdList.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(data.getSenderId())) {
                        it.remove();
                        break;
                    }
                }

                // 插入数据库
                chatstoreMapper.insertSelective(chatStore);

                apnsContent = data.getSenderName() + ":" + apnsContent;
                System.out.println("1***************" + gson.toJson(chatStore));
                // 群发消息
                if (!userIdList.isEmpty()) {
                    // 若群组信息不存在
                    //FBase64加密
                    msgInfo = FBase64.encode(msgInfo.getBytes("UTF-8"));

                    sendXMPP(userIdList, msgInfo, apnsContent, msgType, groupInfo.getGROUPNAME());
                }

                // sendMultiXmpp(userNameList, msgInfo);
            }

            // 设置消息发送状态为 成功
            chatStore.setSENDSTATUS("1");
            chatstoreMapper.updateByPrimaryKeySelective(chatStore);
            System.out.println("==================" + gson.toJson(chatStore));
            CXmppRst cXmppRst = new CXmppRst();
            cXmppRst.setChatStoreId(chatStoreId);
            cXmppRst.setSendTime(String.valueOf(sendTime));
            responseData.setStatus(ReturnStatus.OK);
            responseData.setResultSet(cXmppRst);
            return responseData;
        } catch (SmackException | IOException | XMPPException | InterruptedException e) {
            e.printStackTrace();
            responseData.setStatus(ReturnStatus.ERR0006);
            responseData.setExtInfo("xmpp服务错误");
            return responseData;
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setStatus(ReturnStatus.ERR0021);
            responseData.setExtInfo("未知错误");
            return responseData;
        }
    }

    /**
     * 发送XMPP消息，包含APNS推送
     *
     * @param userIdList
     *            用户id列表
     * @param content
     *            XMPP发送的内容
     * @param apnsContent
     *            APNS推送的内容
     * @param msgType
     *            消息类型
     * @param title
     *            APNS推送的标题
     * @throws SmackException
     * @throws IOException
     * @throws XMPPException
     * @throws InterruptedException
     * @throws JSONException
     * @throws CommunicationException
     * @throws KeystoreException
     * @throws InvalidDeviceTokenFormatException
     */
    private void sendXMPP(List<String> userIdList, String content, String apnsContent,
                          String msgType, String title)
            throws SmackException, IOException, XMPPException, InterruptedException{
        List<String> userNameList = new ArrayList<>();
        List<String> IMEIList = new ArrayList<>();
        // 根据传入的用户id的列表，获取用户名的列表和IMEI的列表，为推送做准备
        for (String userId : userIdList) {
            Logininfo logininfo = logininfoMapper.selectByPrimaryKey(userId);
            if (logininfo != null) {
                // 获取用户名
                userNameList.add(logininfo.getUSERNAME());
                if (logininfo.getDEVICETYPE() != null && "iOS".equals(logininfo.getDEVICETYPE())) {
                    // 若为iOS设备，则获取IMEI
                    IMEIList.add(logininfo.getIMEI());
                }
            }
        }

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                // 发送XMPP消息
                try
                {
                    if (!"20007".equals(msgType) && !"20008".equals(msgType)) {
                        // 若不为群组加减人消息或撤回消息，发送APNS推送

                        // 发送APNS推送

                        XmppOperator.sendXMPP(userNameList, IMEIList, apnsContent, title, content);
                    }
                }
                catch (SmackException | IOException | XMPPException | InterruptedException | JSONException | CommunicationException | KeystoreException | InvalidDeviceTokenFormatException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
