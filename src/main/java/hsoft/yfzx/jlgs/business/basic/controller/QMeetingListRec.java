package hsoft.yfzx.jlgs.business.basic.controller;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;

/**
 * 查询会议列表传入参数model
 */
public class QMeetingListRec extends AbstactBaseRec {

    private String flag;

    private String searchKey;

    private String userId;

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
