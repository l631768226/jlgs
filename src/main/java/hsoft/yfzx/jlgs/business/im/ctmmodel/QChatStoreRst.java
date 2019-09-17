package hsoft.yfzx.jlgs.business.im.ctmmodel;

/**
 * 根据id查询聊天记录时 返回参数
 */
public class QChatStoreRst {

    private String chatStoreId = "";

    private String objectType = "";

    private String senderId = "";

    private String senderName = "";

    private String receId = "";

    private String msgType = "";

    private String sendTime = "";

    private String isReceipted = "";

    private String versionStamp = "";

    private String content = "";

    private String picId = "";

    public String getChatStoreId() {
        return chatStoreId;
    }

    public void setChatStoreId(String chatStoreId) {
        this.chatStoreId = chatStoreId;
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

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }
}
