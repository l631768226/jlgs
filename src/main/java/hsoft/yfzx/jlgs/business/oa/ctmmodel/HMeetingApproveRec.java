package hsoft.yfzx.jlgs.business.oa.ctmmodel;

/**
 * 内网会议办理传入参数model
 */
public class HMeetingApproveRec {

    private String userId;

    private String meetingId;

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

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }
}
