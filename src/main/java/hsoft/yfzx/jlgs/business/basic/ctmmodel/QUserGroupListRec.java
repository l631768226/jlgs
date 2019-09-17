package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 查询群组内人员列表传入参数
 */
public class QUserGroupListRec extends AbstactBaseRec {
    @DataValidation(description = "群组id", dataType = DataType.STRING, required = true, length = 36)
    private String groupId;
    private String searchRule;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getSearchRule() {
        return searchRule;
    }

    public void setSearchRule(String searchRule) {
        this.searchRule = searchRule;
    }
}
