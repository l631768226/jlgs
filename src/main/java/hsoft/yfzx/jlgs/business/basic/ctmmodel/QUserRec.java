package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 查询某部门下人员列表传入参数
 */
public class QUserRec extends AbstactBaseRec {

    @DataValidation(description = "部门Id", dataType = DataType.STRING, length = 36)
    private String deptId;

    @DataValidation(description = "搜索条件", dataType = DataType.STRING)
    private String searchRule;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getSearchRule() {
        return searchRule;
    }

    public void setSearchRule(String searchRule) {
        this.searchRule = searchRule;
    }
}
