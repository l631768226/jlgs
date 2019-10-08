package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

public class QMeetingNoTopicRec extends AbstactBaseRec {
    @DataValidation(description = "会议类型", dataType = DataType.STRING, required = true, length = 36)
    private String type;
    @DataValidation(description = "议题是否上会", dataType = DataType.STRING, required = true, length = 36)
    private String flag;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
