package hsoft.yfzx.jlgs.business.oa.ctmmodel;

/**
 * 内网查询通知列表传入参数
 */
public class HNoticeListRec {

    private String userId;

    private String state;

    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
