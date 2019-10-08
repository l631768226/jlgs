package hsoft.yfzx.jlgs.business.oa.ctmmodel;

/**
 * 内网调用会议驳回传入参数model
 */
public class HRejectRec {

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
