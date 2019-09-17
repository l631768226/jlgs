package hsoft.yfzx.jlgs.utils.model.push;

/**
 * XMPP位置消息
 * @author MobileLy
 *
 */
public class XmppLocationData extends XmppInfoData{
	//经度
	private String lon;
	//纬度
	private String lat;
	//地址
	private String address;
	//建筑名称
	private String buildingName;
	//坐标系 1百度 2高德
	private String coordinateSystem;
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCoordinateSystem() {
		return coordinateSystem;
	}
	public void setCoordinateSystem(String coordinateSystem) {
		this.coordinateSystem = coordinateSystem;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	
}
