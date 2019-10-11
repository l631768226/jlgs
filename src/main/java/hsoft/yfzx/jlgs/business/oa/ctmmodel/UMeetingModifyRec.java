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
    private String submasterNames;
//    @DataValidation(description = "汇报人姓名", dataType = DataType.STRING, required = true, length = 36)
//    private String reporterName;

    private List<String> topicList;

    private String userId;

    private String comment;
    @DataValidation(description = "议题id", dataType = DataType.STRING, required = true, length = 2000)
    private String ids;
    @DataValidation(description = "会议时长", dataType = DataType.STRING, required = true, length = 36)
    private String conferenceDuration;
    @DataValidation(description = "议题时长", dataType = DataType.STRING, required = true, length = 36)
    private String topicDuration;
    @DataValidation(description = "操作人id", dataType = DataType.STRING, required = true, length = 36)
    private String createBy;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getConferenceDuration() {
        return conferenceDuration;
    }

    public void setConferenceDuration(String conferenceDuration) {
        this.conferenceDuration = conferenceDuration;
    }

    public String getTopicDuration() {
        return topicDuration;
    }

    public void setTopicDuration(String topicDuration) {
        this.topicDuration = topicDuration;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

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

    public String getSubmasterNames() {
        return submasterNames;
    }

    public void setSubmasterNames(String submasterNames) {
        this.submasterNames = submasterNames;
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
