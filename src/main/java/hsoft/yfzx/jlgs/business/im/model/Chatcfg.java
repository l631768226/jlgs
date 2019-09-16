package hsoft.yfzx.jlgs.business.im.model;

public class Chatcfg {
    private String CHATCFGID;

    private String USERID;

    private String OBJECTID;

    private String TOPSTATUS;

    private String OBJECTTYPE;

    private String UNDISTURBED;

    private Long VERSIONSTAMP;

    private Long CREATETIME;

    private String DELFLAG;

    private String OBJECTNAME;

    public String getCHATCFGID() {
        return CHATCFGID;
    }

    public void setCHATCFGID(String CHATCFGID) {
        this.CHATCFGID = CHATCFGID == null ? null : CHATCFGID.trim();
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID == null ? null : USERID.trim();
    }

    public String getOBJECTID() {
        return OBJECTID;
    }

    public void setOBJECTID(String OBJECTID) {
        this.OBJECTID = OBJECTID == null ? null : OBJECTID.trim();
    }

    public String getTOPSTATUS() {
        return TOPSTATUS;
    }

    public void setTOPSTATUS(String TOPSTATUS) {
        this.TOPSTATUS = TOPSTATUS == null ? null : TOPSTATUS.trim();
    }

    public String getOBJECTTYPE() {
        return OBJECTTYPE;
    }

    public void setOBJECTTYPE(String OBJECTTYPE) {
        this.OBJECTTYPE = OBJECTTYPE == null ? null : OBJECTTYPE.trim();
    }

    public String getUNDISTURBED() {
        return UNDISTURBED;
    }

    public void setUNDISTURBED(String UNDISTURBED) {
        this.UNDISTURBED = UNDISTURBED == null ? null : UNDISTURBED.trim();
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

    public String getOBJECTNAME() {
        return OBJECTNAME;
    }

    public void setOBJECTNAME(String OBJECTNAME) {
        this.OBJECTNAME = OBJECTNAME == null ? null : OBJECTNAME.trim();
    }
}