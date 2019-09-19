package hsoft.yfzx.jlgs.business.basic.model;

public class Freqgroup {
    private String OWNERID;

    private String GROUPID;

    private Short SORT;

    private String GROUPNAME;

    private String objectName;

    private String picId;

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getOWNERID() {
        return OWNERID;
    }

    public void setOWNERID(String OWNERID) {
        this.OWNERID = OWNERID == null ? null : OWNERID.trim();
    }

    public String getGROUPID() {
        return GROUPID;
    }

    public void setGROUPID(String GROUPID) {
        this.GROUPID = GROUPID == null ? null : GROUPID.trim();
    }

    public Short getSORT() {
        return SORT;
    }

    public void setSORT(Short SORT) {
        this.SORT = SORT;
    }

    public String getGROUPNAME() {
        return GROUPNAME;
    }

    public void setGROUPNAME(String GROUPNAME) {
        this.GROUPNAME = GROUPNAME == null ? null : GROUPNAME.trim();
    }
}