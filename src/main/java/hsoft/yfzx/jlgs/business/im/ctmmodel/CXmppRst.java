package hsoft.yfzx.jlgs.business.im.ctmmodel;

/**
 * 发送xmpp消息返回model
 */
public class CXmppRst {

    //消息id
    private String chatStoreId;
    //发送时间
    private String sendTime;

    public String getChatStoreId() {
        return chatStoreId;
    }

    public void setChatStoreId(String chatStoreId) {
        this.chatStoreId = chatStoreId;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
