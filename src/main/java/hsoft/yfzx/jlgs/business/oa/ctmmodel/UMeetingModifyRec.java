package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

import java.util.List;

/**
 * 会议审批修改并通过
 */
public class UMeetingModifyRec extends AbstactBaseRec {

    @DataValidation(description = "会议id", dataType = DataType.STRING, required = true, length = 36)
    private String meetingId;
    @DataValidation(description = "会议类型", dataType = DataType.STRING, required = true, length = 36)
    private String type;
    @DataValidation(description = "会议名称", dataType = DataType.STRING, required = true, length = 36)
    private String name;
    @DataValidation(description = "主持人姓名", dataType = DataType.STRING, required = true, length = 36)
    private String hostName;
    @DataValidation(description = "主持人id", dataType = DataType.STRING, required = true, length = 36)
    private String host;
    @DataValidation(description = "会议开始时间", dataType = DataType.STRING, required = true, length = 36)
    private String startTime;
    @DataValidation(description = "会议结束时间", dataType = DataType.STRING, required = true, length = 36)
    private String finishTime;
    @DataValidation(description = "分管领导id", dataType = DataType.STRING, required = true, length = 2000)
    private String deputy;
    @DataValidation(description = "分管领导姓名", dataType = DataType.STRING, required = true, length = 2000)
    private String submasterName;
    @DataValidation(description = "分管局领导id", dataType = DataType.STRING, required = true, length = 36)
    private String duty;
    @DataValidation(description = "汇报人姓名", dataType = DataType.STRING, required = true, length = 36)
    private String reporterName;

    private List<String> topicList;

    private String userId;

    private String comment;

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getDeputy() {
        return deputy;
    }

    public void setDeputy(String deputy) {
        this.deputy = deputy;
    }

    public String getSubmasterName() {
        return submasterName;
    }

    public void setSubmasterName(String submasterName) {
        this.submasterName = submasterName;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public List<String> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<String> topicList) {
        this.topicList = topicList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
