package hsoft.yfzx.jlgs.utils.model.push;

/**
 * XMPP图片消息
 * @author MobileLy
 *
 */
public class XmppImgData extends XmppInfoData{
	//地址
	private String url;
	//大小 （单位 B）
	private String size;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}
