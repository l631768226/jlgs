package hsoft.yfzx.jlgs.business.im.ctmmodel;

/**
 * 查询会话的最新一条消息返回数据model
 */
public class QChatStoreListRst {

    private String chatStoreId;

    private String objectId;

    private String objectType;

    private String senderId;

    private String senderName;

    private String receId;

    private String msgType;

    private String sendTime;

    private String isReceipted;

    private String versionStamp;

    private String content;

    private String name;

    private String picId;

    private String objectName;

    private String objectPicId;

    public String getChatStoreId() {
        return chatStoreId;
    }

    public void setChatStoreId(String chatStoreId) {
        this.chatStoreId = chatStoreId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceId() {
        return receId;
    }

    public void setReceId(String receId) {
        this.receId = receId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getIsReceipted() {
        return isReceipted;
    }

    public void setIsReceipted(String isReceipted) {
        this.isReceipted = isReceipted;
    }

    public String getVersionStamp() {
        return versionStamp;
    }

    public void setVersionStamp(String versionStamp) {
        this.versionStamp = versionStamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectPicId() {
        return objectPicId;
    }

    public void setObjectPicId(String objectPicId) {
        this.objectPicId = objectPicId;
    }
}
