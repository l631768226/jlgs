package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;

public class QTopicListRec extends AbstactBaseRec {

    private String userName;

    private String page;

    private String pageSize;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
