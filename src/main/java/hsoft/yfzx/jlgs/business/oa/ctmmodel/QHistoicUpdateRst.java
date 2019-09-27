package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import java.util.Date;

public class QHistoicUpdateRst {

    private String id;

    private String isNewRecord;

    private String createDate;

    private String updateDate;

    private String name;

    private String objBefore;

    private String objAfter;

    private String procInsId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsNewRecord() {
        return isNewRecord;
    }

    public void setIsNewRecord(String isNewRecord) {
        this.isNewRecord = isNewRecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjBefore() {
        return objBefore;
    }

    public void setObjBefore(String objBefore) {
        this.objBefore = objBefore;
    }

    public String getObjAfter() {
        return objAfter;
    }

    public void setObjAfter(String objAfter) {
        this.objAfter = objAfter;
    }

    public String getProcInsId() {
        return procInsId;
    }

    public void setProcInsId(String procInsId) {
        this.procInsId = procInsId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
