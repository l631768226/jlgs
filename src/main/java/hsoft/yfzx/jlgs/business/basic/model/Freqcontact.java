package hsoft.yfzx.jlgs.business.basic.model;

public class Freqcontact {
    private String OWNERID;

    private String USERID;

    private Short SORT;

    private String REALNAME;

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

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID == null ? null : USERID.trim();
    }

    public Short getSORT() {
        return SORT;
    }

    public void setSORT(Short SORT) {
        this.SORT = SORT;
    }

    public String getREALNAME() {
        return REALNAME;
    }

    public void setREALNAME(String REALNAME) {
        this.REALNAME = REALNAME == null ? null : REALNAME.trim();
    }
}