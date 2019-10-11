package hsoft.yfzx.jlgs.business.basic.model;

import java.util.Date;

public class Feedback {
    private String FEEDBACKID;

    private String USERID;

    private String MANAGERID;

    private String EMAIL;

    private String PHONE;

    private String ISDEAL;

    private Date CREATETIME;

    private String USERTYPE;

    private String TYPE;

    private String CONTENT;

    private byte[] PHOTO;

    public String getFEEDBACKID() {
        return FEEDBACKID;
    }

    public void setFEEDBACKID(String FEEDBACKID) {
        this.FEEDBACKID = FEEDBACKID == null ? null : FEEDBACKID.trim();
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID == null ? null : USERID.trim();
    }

    public String getMANAGERID() {
        return MANAGERID;
    }

    public void setMANAGERID(String MANAGERID) {
        this.MANAGERID = MANAGERID == null ? null : MANAGERID.trim();
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL == null ? null : EMAIL.trim();
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE == null ? null : PHONE.trim();
    }

    public String getISDEAL() {
        return ISDEAL;
    }

    public void setISDEAL(String ISDEAL) {
        this.ISDEAL = ISDEAL == null ? null : ISDEAL.trim();
    }

    public Date getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getUSERTYPE() {
        return USERTYPE;
    }

    public void setUSERTYPE(String USERTYPE) {
        this.USERTYPE = USERTYPE == null ? null : USERTYPE.trim();
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE == null ? null : TYPE.trim();
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT == null ? null : CONTENT.trim();
    }

    public byte[] getPHOTO() {
        return PHOTO;
    }

    public void setPHOTO(byte[] PHOTO) {
        this.PHOTO = PHOTO;
    }
}