package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

import java.util.List;

/**
 * 群组删除人员传入参数
 */
public class DUserGroupRec extends AbstactBaseRec {

    @DataValidation(description = "群组id", dataType = DataType.STRING, required = true, length = 36)
    private String groupId;
    @DataValidation(description = "群组人员id", dataType = DataType.LIST, required = true, length = 1)
    private List<String> users;
    private String userId;
    private String realName;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
