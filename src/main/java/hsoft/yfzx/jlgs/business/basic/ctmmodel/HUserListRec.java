package hsoft.yfzx.jlgs.business.basic.ctmmodel;

/**
 * 内网查询用户列表传入参数model
 */
public class HUserListRec {

    private String deptId;

    private String searchRule;

    private String page;

    private String pageSize;

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

    public String getSearchRule() {
        return searchRule;
    }

    public void setSearchRule(String searchRule) {
        this.searchRule = searchRule;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
