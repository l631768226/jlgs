package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 常用联系人排序model
 */
public class CtmFreqSortRec extends AbstactBaseRec {
    @DataValidation(description = "对方id", dataType = DataType.STRING, required = true, length = 64)
    private String objectId;
    @DataValidation(description = "排序字段", dataType = DataType.STRING, required = true, length = 3)
    private String sort;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
