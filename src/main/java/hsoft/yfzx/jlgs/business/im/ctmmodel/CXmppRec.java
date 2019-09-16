package hsoft.yfzx.jlgs.business.im.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

import java.util.List;

/**
 * 发送xmpp消息传入参数
 */
public class CXmppRec extends AbstactBaseRec {

    // 会话类型
    @DataValidation(description = "会话类型", dataType = DataType.STRING, required = true, length = 5)
    private String msgType;

    // 是否群组消息 0单人 1群组
    @DataValidation(description = "是否群组消息", dataType = DataType.STRING, required = true, length = 3)
    private String objectType;

    // 发送人id
    @DataValidation(description = "发送人id", dataType = DataType.STRING, required = true, length = 36)
    private String senderId;

    // 发送人姓名
    @DataValidation(description = "发送人姓名", dataType = DataType.STRING, required = true, length = 100)
    private String senderName;

    // 接收方id
    @DataValidation(description = "接收方id", dataType = DataType.STRING, required = true, length = 36)
    private String receId;

    private String receName;

    // 是否有阅读回执 0否 1是
    @DataValidation(description = "是否有阅读回执", dataType = DataType.STRING, required = true, length = 3)
    private String isReceipted;

    // 文字类型消息内容
    private String content;

    // 语音时长（单位 s）
    private String duration;

    // 文件大小
    private String fileSize;

    // 文件名称
    private String fileName;

    // 文件类型
    private String fileType;

    // 经度
    private String lon;

    // 纬度
    private String lat;

    // 地址
    private String address;

    //建筑名称
    private String buildingName;

    // 坐标系 1百度 2高德
    private String coordinateSystem;

    // 操作id 1加人 2减人
    private String operateType;

    // 被操作人员id列表
    private List<String> operationIds;

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
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

    public String getReceId() {
        return receId;
    }

    public void setReceId(String receId) {
        this.receId = receId;
    }

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getIsReceipted() {
        return isReceipted;
    }

    public void setIsReceipted(String isReceipted) {
        this.isReceipted = isReceipted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

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

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getCoordinateSystem() {
        return coordinateSystem;
    }

    public void setCoordinateSystem(String coordinateSystem) {
        this.coordinateSystem = coordinateSystem;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public List<String> getOperationIds() {
        return operationIds;
    }

    public void setOperationIds(List<String> operationIds) {
        this.operationIds = operationIds;
    }
}
