package hsoft.yfzx.jlgs.business.basic.ctmmodel;

/**
 * 获取会议列表传入model
 */
public class HMeetingListRec {

    private String userId;

    private String flag;

    private String searchKey;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
