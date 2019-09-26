package hsoft.yfzx.jlgs.business.oa.ctmmodel;

/**
 * 内网确认参加会议传入model
 */
public class HConfirmRec {

    private String meetingId;

    private String userId;

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
