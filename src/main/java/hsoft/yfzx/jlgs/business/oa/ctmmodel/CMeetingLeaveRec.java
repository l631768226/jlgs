package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

public class CMeetingLeaveRec extends AbstactBaseRec {
    @DataValidation(description = "会议id", dataType = DataType.STRING, required = true, length = 36)
    private String meetingId;
    @DataValidation(description = "部门id", dataType = DataType.STRING, required = true, length = 36)
    private String deptId;
    @DataValidation(description = "人员id", dataType = DataType.STRING, required = true, length = 36)
    private String userId;

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
