package hsoft.yfzx.jlgs.business.basic.ctmmodel;

/**
 * 内网请求会议详情传入参数model
 */
public class HMeetingDetailRec {

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
