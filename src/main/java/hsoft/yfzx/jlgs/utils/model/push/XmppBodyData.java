package hsoft.yfzx.jlgs.utils.model.push;


/**
 * XMPP消息第二层 消息体
 * @author MobileLy
 */
public class XmppBodyData {
	//会话类型
	private String msgType;
	//会话消息id
	private String chatStoreId;
	//是否群组消息 0单人 1群组
	private String objectType;
	//群组名称
	private String groupName;
	//发送人id
	private String senderId;
	//发送人姓名
	private String senderName;
	//接收方id
	private String receId;
	//发送时间
	private String sendTime;
	//是否有阅读回执 0否 1是
	private String isReceipted;
	//消息免打扰状态 0提醒 1免打扰
	private String undisturbed;
	//消息内容
	private String content;
	//人员头像地址
	private String userPic;
	//群组头像地址
	private String groupPic;

	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getGroupPic() {
		return groupPic;
	}

	public void setGroupPic(String groupPic) {
		this.groupPic = groupPic;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getReceId() {
		return receId;
	}

	public void setReceId(String receId) {
		this.receId = receId;
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

	public String getUndisturbed() {
		return undisturbed;
	}

	public void setUndisturbed(String undisturbed) {
		this.undisturbed = undisturbed;
	}

	
}
