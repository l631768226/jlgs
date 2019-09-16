package hsoft.yfzx.jlgs.business.basic.model;

import java.util.Date;

public class SysUser {
    private String ID;

    private String COMPANY_ID;

    private String OFFICE_ID;

    private String LOGIN_NAME;

    private String PASSWORD;

    private String NO;

    private String NAME;

    private String EMAIL;

    private String PHONE;

    private String MOBILE;

    private String PHOTO;

    private String LOGIN_IP;

    private Date LOGIN_DATE;

    private String LOGIN_FLAG;

    private String CREATE_BY;

    private Date CREATE_DATE;

    private String UPDATE_BY;

    private Date UPDATE_DATE;

    private String REMARKS;

    private String DEL_FLAG;

    private String QRCODE;

    private String SIGN;

    private String GENDER;

    private String POSITION;

    private String POSITION_REMARK;

    private Date BIRTHDAY;

    private Short WORK_YEARS;

    private String WORK_STATE;

    private String DUTY;

    private String POLITICS;

    private Long VERSIONSTAMP;

    private String DEVICETYPE;

    private String IMEI;

    private Short SORT;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID == null ? null : ID.trim();
    }

    public String getCOMPANY_ID() {
        return COMPANY_ID;
    }

    public void setCOMPANY_ID(String COMPANY_ID) {
        this.COMPANY_ID = COMPANY_ID == null ? null : COMPANY_ID.trim();
    }

    public String getOFFICE_ID() {
        return OFFICE_ID;
    }

    public void setOFFICE_ID(String OFFICE_ID) {
        this.OFFICE_ID = OFFICE_ID == null ? null : OFFICE_ID.trim();
    }

    public String getLOGIN_NAME() {
        return LOGIN_NAME;
    }

    public void setLOGIN_NAME(String LOGIN_NAME) {
        this.LOGIN_NAME = LOGIN_NAME == null ? null : LOGIN_NAME.trim();
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD == null ? null : PASSWORD.trim();
    }

    public String getNO() {
        return NO;
    }

    public void setNO(String NO) {
        this.NO = NO == null ? null : NO.trim();
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME == null ? null : NAME.trim();
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

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE == null ? null : MOBILE.trim();
    }

    public String getPHOTO() {
        return PHOTO;
    }

    public void setPHOTO(String PHOTO) {
        this.PHOTO = PHOTO == null ? null : PHOTO.trim();
    }

    public String getLOGIN_IP() {
        return LOGIN_IP;
    }

    public void setLOGIN_IP(String LOGIN_IP) {
        this.LOGIN_IP = LOGIN_IP == null ? null : LOGIN_IP.trim();
    }

    public Date getLOGIN_DATE() {
        return LOGIN_DATE;
    }

    public void setLOGIN_DATE(Date LOGIN_DATE) {
        this.LOGIN_DATE = LOGIN_DATE;
    }

    public String getLOGIN_FLAG() {
        return LOGIN_FLAG;
    }

    public void setLOGIN_FLAG(String LOGIN_FLAG) {
        this.LOGIN_FLAG = LOGIN_FLAG == null ? null : LOGIN_FLAG.trim();
    }

    public String getCREATE_BY() {
        return CREATE_BY;
    }

    public void setCREATE_BY(String CREATE_BY) {
        this.CREATE_BY = CREATE_BY == null ? null : CREATE_BY.trim();
    }

    public Date getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(Date CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public String getUPDATE_BY() {
        return UPDATE_BY;
    }

    public void setUPDATE_BY(String UPDATE_BY) {
        this.UPDATE_BY = UPDATE_BY == null ? null : UPDATE_BY.trim();
    }

    public Date getUPDATE_DATE() {
        return UPDATE_DATE;
    }

    public void setUPDATE_DATE(Date UPDATE_DATE) {
        this.UPDATE_DATE = UPDATE_DATE;
    }

    public String getREMARKS() {
        return REMARKS;
    }

    public void setREMARKS(String REMARKS) {
        this.REMARKS = REMARKS == null ? null : REMARKS.trim();
    }

    public String getDEL_FLAG() {
        return DEL_FLAG;
    }

    public void setDEL_FLAG(String DEL_FLAG) {
        this.DEL_FLAG = DEL_FLAG == null ? null : DEL_FLAG.trim();
    }

    public String getQRCODE() {
        return QRCODE;
    }

    public void setQRCODE(String QRCODE) {
        this.QRCODE = QRCODE == null ? null : QRCODE.trim();
    }

    public String getSIGN() {
        return SIGN;
    }

    public void setSIGN(String SIGN) {
        this.SIGN = SIGN == null ? null : SIGN.trim();
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER == null ? null : GENDER.trim();
    }

    public String getPOSITION() {
        return POSITION;
    }

    public void setPOSITION(String POSITION) {
        this.POSITION = POSITION == null ? null : POSITION.trim();
    }

    public String getPOSITION_REMARK() {
        return POSITION_REMARK;
    }

    public void setPOSITION_REMARK(String POSITION_REMARK) {
        this.POSITION_REMARK = POSITION_REMARK == null ? null : POSITION_REMARK.trim();
    }

    public Date getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(Date BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public Short getWORK_YEARS() {
        return WORK_YEARS;
    }

    public void setWORK_YEARS(Short WORK_YEARS) {
        this.WORK_YEARS = WORK_YEARS;
    }

    public String getWORK_STATE() {
        return WORK_STATE;
    }

    public void setWORK_STATE(String WORK_STATE) {
        this.WORK_STATE = WORK_STATE == null ? null : WORK_STATE.trim();
    }

    public String getDUTY() {
        return DUTY;
    }

    public void setDUTY(String DUTY) {
        this.DUTY = DUTY == null ? null : DUTY.trim();
    }

    public String getPOLITICS() {
        return POLITICS;
    }

    public void setPOLITICS(String POLITICS) {
        this.POLITICS = POLITICS == null ? null : POLITICS.trim();
    }

    public Long getVERSIONSTAMP() {
        return VERSIONSTAMP;
    }

    public void setVERSIONSTAMP(Long VERSIONSTAMP) {
        this.VERSIONSTAMP = VERSIONSTAMP;
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

    public Short getSORT() {
        return SORT;
    }

    public void setSORT(Short SORT) {
        this.SORT = SORT;
    }
}