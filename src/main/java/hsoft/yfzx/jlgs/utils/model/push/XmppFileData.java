package hsoft.yfzx.jlgs.utils.model.push;

/**
 * XMPP文件消息
 * @author MobileLy
 *
 */
public class XmppFileData extends XmppInfoData{
	//地址
	private String url;
	//文件大小
	private String size;
	//文件名称
	private String name;
	//文件类型
	private String fileType;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
}
