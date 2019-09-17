package hsoft.yfzx.jlgs.utils.model.push;

/**
 * XMPP语音消息
 * @author MobileLy
 *
 */
public class XmppAudioData extends XmppInfoData{
	//地址
	private String url;
	//时长（单位 s）
	private String duration;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
}
