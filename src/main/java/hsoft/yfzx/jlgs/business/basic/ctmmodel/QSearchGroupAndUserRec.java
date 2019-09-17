package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 搜索群组和人员
 */
public class QSearchGroupAndUserRec extends AbstactBaseRec {

    @DataValidation(description = "搜索条件", dataType = DataType.STRING, required = true, length = 100)
    private String condition;
    private String userId;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
