package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

public class HUpdateTopicRec {

    private String topicId;
    private String title;
    private String reporter;
    private String duration;
    private String depId;
    private String userId;
    private String meetingId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }
}
