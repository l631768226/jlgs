package hsoft.yfzx.jlgs.utils.model.push;

/**
 * XMPP视频消息
 * @author MobileLy
 *
 */
public class XmppVideoData extends XmppInfoData{
	//地址
	private String url;
	//第一帧图片路径
	private String firstFrameImageUrl;
	//时长（单位 s）
	private String duration;
	//文件大小（单位 B）
	private String size;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFirstFrameImageUrl() {
		return firstFrameImageUrl;
	}
	public void setFirstFrameImageUrl(String firstFrameImageUrl) {
		this.firstFrameImageUrl = firstFrameImageUrl;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
}
