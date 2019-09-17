package hsoft.yfzx.jlgs.business.im.model;

public class Chatstore {
    private String CHATSTOREID;

    private String OBJECTTYPE;

    private String SENDERID;

    private String SENDERNAME;

    private String RECEID;

    private String RECENAME;

    private String MSGTYPE;

    private Long SENDTIME;

    private String SENDSTATUS;

    private Long VERSIONSTAMP;

    private String PICID;

    private String CONTENT;

    public String getCHATSTOREID() {
        return CHATSTOREID;
    }

    public void setCHATSTOREID(String CHATSTOREID) {
        this.CHATSTOREID = CHATSTOREID == null ? null : CHATSTOREID.trim();
    }

    public String getOBJECTTYPE() {
        return OBJECTTYPE;
    }

    public void setOBJECTTYPE(String OBJECTTYPE) {
        this.OBJECTTYPE = OBJECTTYPE == null ? null : OBJECTTYPE.trim();
    }

    public String getSENDERID() {
        return SENDERID;
    }

    public void setSENDERID(String SENDERID) {
        this.SENDERID = SENDERID == null ? null : SENDERID.trim();
    }

    public String getSENDERNAME() {
        return SENDERNAME;
    }

    public void setSENDERNAME(String SENDERNAME) {
        this.SENDERNAME = SENDERNAME == null ? null : SENDERNAME.trim();
    }

    public String getRECEID() {
        return RECEID;
    }

    public void setRECEID(String RECEID) {
        this.RECEID = RECEID == null ? null : RECEID.trim();
    }

    public String getRECENAME() {
        return RECENAME;
    }

    public void setRECENAME(String RECENAME) {
        this.RECENAME = RECENAME == null ? null : RECENAME.trim();
    }

    public String getMSGTYPE() {
        return MSGTYPE;
    }

    public void setMSGTYPE(String MSGTYPE) {
        this.MSGTYPE = MSGTYPE == null ? null : MSGTYPE.trim();
    }

    public Long getSENDTIME() {
        return SENDTIME;
    }

    public void setSENDTIME(Long SENDTIME) {
        this.SENDTIME = SENDTIME;
    }

    public String getSENDSTATUS() {
        return SENDSTATUS;
    }

    public void setSENDSTATUS(String SENDSTATUS) {
        this.SENDSTATUS = SENDSTATUS == null ? null : SENDSTATUS.trim();
    }

    public Long getVERSIONSTAMP() {
        return VERSIONSTAMP;
    }

    public void setVERSIONSTAMP(Long VERSIONSTAMP) {
        this.VERSIONSTAMP = VERSIONSTAMP;
    }

    public String getPICID() {
        return PICID;
    }

    public void setPICID(String PICID) {
        this.PICID = PICID == null ? null : PICID.trim();
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT == null ? null : CONTENT.trim();
    }
}