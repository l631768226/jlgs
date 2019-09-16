package hsoft.yfzx.jlgs.business.basic.model;

public class Usergroup {
    private String GROUPID;

    private String USERID;

    private String DEPTID;

    private String USER_LEVEL;

    private String CARD;

    private String POSITIONCODELIST;

    private Short SORT;

    private Long VERSIONSTAMP;

    private Long CREATETIME;

    private String DELFLAG;

    public String getGROUPID() {
        return GROUPID;
    }

    public void setGROUPID(String GROUPID) {
        this.GROUPID = GROUPID == null ? null : GROUPID.trim();
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID == null ? null : USERID.trim();
    }

    public String getDEPTID() {
        return DEPTID;
    }

    public void setDEPTID(String DEPTID) {
        this.DEPTID = DEPTID == null ? null : DEPTID.trim();
    }

    public String getUSER_LEVEL() {
        return USER_LEVEL;
    }

    public void setUSER_LEVEL(String USER_LEVEL) {
        this.USER_LEVEL = USER_LEVEL == null ? null : USER_LEVEL.trim();
    }

    public String getCARD() {
        return CARD;
    }

    public void setCARD(String CARD) {
        this.CARD = CARD == null ? null : CARD.trim();
    }

    public String getPOSITIONCODELIST() {
        return POSITIONCODELIST;
    }

    public void setPOSITIONCODELIST(String POSITIONCODELIST) {
        this.POSITIONCODELIST = POSITIONCODELIST == null ? null : POSITIONCODELIST.trim();
    }

    public Short getSORT() {
        return SORT;
    }

    public void setSORT(Short SORT) {
        this.SORT = SORT;
    }

    public Long getVERSIONSTAMP() {
        return VERSIONSTAMP;
    }

    public void setVERSIONSTAMP(Long VERSIONSTAMP) {
        this.VERSIONSTAMP = VERSIONSTAMP;
    }

    public Long getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Long CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getDELFLAG() {
        return DELFLAG;
    }

    public void setDELFLAG(String DELFLAG) {
        this.DELFLAG = DELFLAG == null ? null : DELFLAG.trim();
    }
}