package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 查询请休假详情传入参数model
 */
public class QLeaveDetailRec extends AbstactBaseRec {

    @DataValidation(description = "请休假id", dataType = DataType.STRING, required = true, length = 36)
    private String leaveId;

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }
}
