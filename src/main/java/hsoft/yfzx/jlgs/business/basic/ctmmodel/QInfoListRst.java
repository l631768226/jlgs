package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import java.util.List;

/**
 * 查询某组织机构下人员列表和部门列表信息返回参数
 */
public class QInfoListRst {

    private List<QUserRst> userList;

    private List<QDeptListRst> deptList;

    public List<QUserRst> getUserList() {
        return userList;
    }

    public void setUserList(List<QUserRst> userList) {
        this.userList = userList;
    }

    public List<QDeptListRst> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<QDeptListRst> deptList) {
        this.deptList = deptList;
    }
}
