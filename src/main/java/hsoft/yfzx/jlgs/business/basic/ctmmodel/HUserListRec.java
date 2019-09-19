package hsoft.yfzx.jlgs.business.basic.ctmmodel;

/**
 * 内网查询用户列表传入参数model
 */
public class HUserListRec {

    private String deptId;

    private String searchRule;

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
