package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.business.basic.model.SysOffice;
import hsoft.yfzx.jlgs.business.basic.model.SysUser;

import java.util.List;

public class CtmInfoListRst {

    private List<SysOffice> deptList;

    private List<SysUser> userList;

    public List<SysOffice> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<SysOffice> deptList) {
        this.deptList = deptList;
    }

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }
}
