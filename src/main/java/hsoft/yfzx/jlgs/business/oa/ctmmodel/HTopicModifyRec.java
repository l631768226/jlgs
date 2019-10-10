package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

public class HTopicModifyRec {

    private String topicId;
    private String type;
    private String topicName;
    private String reporterName;
    private String duration;
    private String countersign;
    private String countersignName;
    private String deputy;
    private String loginName;
    private String userId;
    private String comment;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCountersign() {
        return countersign;
    }

    public void setCountersign(String countersign) {
        this.countersign = countersign;
    }

    public String getCountersignName() {
        return countersignName;
    }

    public void setCountersignName(String countersignName) {
        this.countersignName = countersignName;
    }

    public String getDeputy() {
        return deputy;
    }

    public void setDeputy(String deputy) {
        this.deputy = deputy;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
