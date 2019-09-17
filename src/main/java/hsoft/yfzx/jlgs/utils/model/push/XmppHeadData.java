package hsoft.yfzx.jlgs.utils.model.push;

/**
 * XMPP消息体 第一层
 * @param <T>
 */
public class XmppHeadData<T> {

    //消息类型
    private String messageType;
    //消息体
    private T content;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
