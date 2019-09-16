package hsoft.yfzx.jlgs.business.basic.model;

public class Groupinfo {
    private String GROUPID;

    private String GROUPNAME;

    private String PICID;

    private String NOTICE;

    private String INTRODUCE;

    private Long VERSIONSTAMP;

    private Long CREATETIME;

    private String DELFLAG;

    private Short SORT;

    public String getGROUPID() {
        return GROUPID;
    }

    public void setGROUPID(String GROUPID) {
        this.GROUPID = GROUPID == null ? null : GROUPID.trim();
    }

    public String getGROUPNAME() {
        return GROUPNAME;
    }

    public void setGROUPNAME(String GROUPNAME) {
        this.GROUPNAME = GROUPNAME == null ? null : GROUPNAME.trim();
    }

    public String getPICID() {
        return PICID;
    }

    public void setPICID(String PICID) {
        this.PICID = PICID == null ? null : PICID.trim();
    }

    public String getNOTICE() {
        return NOTICE;
    }

    public void setNOTICE(String NOTICE) {
        this.NOTICE = NOTICE == null ? null : NOTICE.trim();
    }

    public String getINTRODUCE() {
        return INTRODUCE;
    }

    public void setINTRODUCE(String INTRODUCE) {
        this.INTRODUCE = INTRODUCE == null ? null : INTRODUCE.trim();
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

    public Short getSORT() {
        return SORT;
    }

    public void setSORT(Short SORT) {
        this.SORT = SORT;
    }
}