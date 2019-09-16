package hsoft.yfzx.jlgs.business.basic.model;

public class Logininfo {
    private String USERID;

    private String DEVICETYPE;

    private String IMEI;

    private String TOKEN;

    private Long LASTLOGINTIME;

    private String PICID;

    private String REALNAME;

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID == null ? null : USERID.trim();
    }

    public String getDEVICETYPE() {
        return DEVICETYPE;
    }

    public void setDEVICETYPE(String DEVICETYPE) {
        this.DEVICETYPE = DEVICETYPE == null ? null : DEVICETYPE.trim();
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI == null ? null : IMEI.trim();
    }

    public String getTOKEN() {
        return TOKEN;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN == null ? null : TOKEN.trim();
    }

    public Long getLASTLOGINTIME() {
        return LASTLOGINTIME;
    }

    public void setLASTLOGINTIME(Long LASTLOGINTIME) {
        this.LASTLOGINTIME = LASTLOGINTIME;
    }

    public String getPICID() {
        return PICID;
    }

    public void setPICID(String PICID) {
        this.PICID = PICID == null ? null : PICID.trim();
    }

    public String getREALNAME() {
        return REALNAME;
    }

    public void setREALNAME(String REALNAME) {
        this.REALNAME = REALNAME == null ? null : REALNAME.trim();
    }
}