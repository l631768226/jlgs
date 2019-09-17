package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import java.util.List;

/**
 * 搜索群组和人员返回参数
 */
public class QSearchGroupAndUserRst {

    private List<QSearchGroupRst> groupList;
    private List<QSearchUserRst> userList;

    public List<QSearchGroupRst> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<QSearchGroupRst> groupList) {
        this.groupList = groupList;
    }

    public List<QSearchUserRst> getUserList() {
        return userList;
    }

    public void setUserList(List<QSearchUserRst> userList) {
        this.userList = userList;
    }
}
