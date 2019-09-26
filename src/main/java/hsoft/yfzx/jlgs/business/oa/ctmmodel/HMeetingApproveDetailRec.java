package hsoft.yfzx.jlgs.business.oa.ctmmodel;

/**
 * 内网查询会议审批详情传入参数model
 */
public class HMeetingApproveDetailRec {

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
