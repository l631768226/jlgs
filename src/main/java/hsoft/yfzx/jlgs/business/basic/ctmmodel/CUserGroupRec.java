package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

import java.util.List;

/**
 * 群组添加人员传入参数
 */
public class CUserGroupRec extends AbstactBaseRec {

    @DataValidation(description = "群组id", dataType = DataType.STRING, required = true, length = 36)
    private String groupId;
    @DataValidation(description = "群组名人员", dataType = DataType.LIST, required = true, length = 1)
    private List<CGroupsUserRec> users;
    private String realName;
    private String userId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<CGroupsUserRec> getUsers() {
        return users;
    }

    public void setUsers(List<CGroupsUserRec> users) {
        this.users = users;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
