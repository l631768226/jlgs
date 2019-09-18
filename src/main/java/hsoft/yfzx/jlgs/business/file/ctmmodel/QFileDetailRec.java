package hsoft.yfzx.jlgs.business.file.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

public class QFileDetailRec extends AbstactBaseRec {

    //文件存储的id
    @DataValidation(description = "文件id", dataType = DataType.STRING, required = true, length = 100)
    private String fileId;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
