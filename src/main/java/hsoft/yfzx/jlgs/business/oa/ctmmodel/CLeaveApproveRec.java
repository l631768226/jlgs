package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 请休假审批通过传入参数
 */
public class CLeaveApproveRec extends AbstactBaseRec {
    @DataValidation(description = "用户id", dataType = DataType.STRING, required = false, length = 36)
    private String userId;
    @DataValidation(description = "请休假id", dataType = DataType.STRING, required = true, length = 36)
    private String leaveId;

    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }
}
