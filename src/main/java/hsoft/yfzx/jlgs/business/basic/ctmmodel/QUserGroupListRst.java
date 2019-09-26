package hsoft.yfzx.jlgs.business.basic.ctmmodel;

/**
 * 查询群组人员返回model
 */
public class QUserGroupListRst {
    private String userId;
    private String realName;
    private String level;
    private String card;
    private String picId;
    private String versionStamp;
    private String deptId;
    private String positionCodeList;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getPositionCodeList() {
        return positionCodeList;
    }

    public void setPositionCodeList(String positionCodeList) {
        this.positionCodeList = positionCodeList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getVersionStamp() {
        return versionStamp;
    }

    public void setVersionStamp(String versionStamp) {
        this.versionStamp = versionStamp;
    }
}
