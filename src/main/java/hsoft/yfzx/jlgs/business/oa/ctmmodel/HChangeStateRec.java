package hsoft.yfzx.jlgs.business.oa.ctmmodel;

/**
 * 内网修改通知阅读状态传入model
 */
public class HChangeStateRec {

    private String noticeId;

    private String userId;

    private String state;

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
