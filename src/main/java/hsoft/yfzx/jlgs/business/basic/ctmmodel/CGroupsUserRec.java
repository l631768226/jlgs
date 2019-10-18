package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 创建群组时人员信息model
 */
public class CGroupsUserRec extends AbstactBaseRec {

//    @DataValidation(description = "用户id", dataType = DataType.STRING, required = true, length = 36)
    private String userId;
//    @DataValidation(description = "部门id", dataType = DataType.STRING, required = true, length = 36)
    private String deptId;
//    @DataValidation(description = "职务代码", dataType = DataType.STRING, required = true, length = 100)
    private String positionCodeList;
//    @DataValidation(description = "成员等级", dataType = DataType.STRING, required = true, length = 2)
    private String level;
    private String sort;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getPositionCodeList() {
        return positionCodeList;
    }

    public void setPositionCodeList(String positionCodeList) {
        this.positionCodeList = positionCodeList;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
