package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

public class UUpdateTopicRec extends AbstactBaseRec {
    @DataValidation(description = "议题id", dataType = DataType.STRING, required = true, length = 36)
    private String topicId;
    @DataValidation(description = "议题", dataType = DataType.STRING, required = true, length = 36)
    private String title;
    @DataValidation(description = "汇报人", dataType = DataType.STRING, required = true, length = 36)
    private String reporter;
    @DataValidation(description = "汇报时长", dataType = DataType.STRING, required = true, length = 36)
    private String duration;
//    @DataValidation(description = "列席部门名称", dataType = DataType.STRING, required = true, length = 2000)
//    private String depName;
    @DataValidation(description = "列席部门id", dataType = DataType.STRING, required = true, length = 2000)
    private String depId;

    private String userId;
    @DataValidation(description = "会议id", dataType = DataType.STRING, required = true, length = 36)
    private String meetingId;

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }
}
