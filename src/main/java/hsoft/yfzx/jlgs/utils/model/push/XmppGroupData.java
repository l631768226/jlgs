package hsoft.yfzx.jlgs.utils.model.push;

import java.util.List;

/**
 * XMPP群组增减人消息
 * @author MobileLy
 *
 */
public class XmppGroupData extends XmppInfoData{
	//操作id 1加人 2减人
	private String operateType;
	//被操作人员id列表
	private List<String> uuids;

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public List<String> getUuids() {
		return uuids;
	}

	public void setUuids(List<String> uuids) {
		this.uuids = uuids;
	}
	
}
