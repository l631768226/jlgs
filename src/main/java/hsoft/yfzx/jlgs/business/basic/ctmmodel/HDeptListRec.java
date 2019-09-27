package hsoft.yfzx.jlgs.business.basic.ctmmodel;

/**
 * 调用内网根据id查询部门列表信息传入参数
 */
public class HDeptListRec {

    private String deptId;

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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
