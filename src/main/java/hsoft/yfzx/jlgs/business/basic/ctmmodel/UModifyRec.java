package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

public class UModifyRec extends AbstactBaseRec {
    @DataValidation(description = "议题id", dataType = DataType.STRING, required = true, length = 36)
    private String topicId;
    @DataValidation(description = "议题类型", dataType = DataType.STRING, required = true, length = 36)
    private String type;
    @DataValidation(description = "议题名称", dataType = DataType.STRING, required = true, length = 36)
    private String topicName;
    @DataValidation(description = "议题汇报人姓名", dataType = DataType.STRING, required = true, length = 36)
    private String reporterName;
    @DataValidation(description = "议题时长", dataType = DataType.STRING, required = true, length = 36)
    private String duration;
    @DataValidation(description = "议题会签部门id", dataType = DataType.STRING, required = true, length = 2000)
    private String countersign;
    @DataValidation(description = "议题会签部门名称", dataType = DataType.STRING, required = true, length = 2000)
    private String countersignName;
    @DataValidation(description = "分管局领导id", dataType = DataType.STRING, required = true, length = 36)
    private String duty;

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

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
