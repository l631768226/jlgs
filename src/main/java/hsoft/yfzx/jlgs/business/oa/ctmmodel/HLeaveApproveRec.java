package hsoft.yfzx.jlgs.business.oa.ctmmodel;

/**
 * 内网请休假审批通过传入model
 */
public class HLeaveApproveRec {

    private String userId;

    private String leaveId;

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
