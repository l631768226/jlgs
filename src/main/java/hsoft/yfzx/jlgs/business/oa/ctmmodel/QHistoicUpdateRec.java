package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

public class QHistoicUpdateRec extends AbstactBaseRec {
    @DataValidation(description = "流程id", dataType = DataType.STRING, required = true, length = 36)
    private String procInsId;
    @DataValidation(description = "步骤id", dataType = DataType.STRING, required = true, length = 36)
    private String taskId;

    public String getProcInsId() {
        return procInsId;
    }

    public void setProcInsId(String procInsId) {
        this.procInsId = procInsId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
