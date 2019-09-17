package hsoft.yfzx.jlgs.utils.model.push;

/**
 * 会话类型文本 20000
 * 文字 表情
 * @author MobileLy
 *
 */
public class XmppTextData  extends XmppInfoData{
	//文字类型消息内容
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
