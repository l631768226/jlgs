package hsoft.yfzx.jlgs.business.oa.ctmmodel;

/**
 * 内网会议请假传入参数
 */
public class HMeetingLeaveRec {

    private String userId;

    private String ownerId;

    private String deptId;

    private String meetingId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }
}
