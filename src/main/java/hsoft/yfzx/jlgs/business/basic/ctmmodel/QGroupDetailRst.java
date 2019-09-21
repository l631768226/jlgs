package hsoft.yfzx.jlgs.business.basic.ctmmodel;

public class QGroupDetailRst {
    private String groupId;
    private String groupName;
    private String notice;
    private String introduce;
    private String picId;
    private String createTime;
    private String versionStamp;
    private String freqFlag = "0";

    public String getFreqFlag() {
        return freqFlag;
    }

    public void setFreqFlag(String freqFlag) {
        this.freqFlag = freqFlag;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getVersionStamp() {
        return versionStamp;
    }

    public void setVersionStamp(String versionStamp) {
        this.versionStamp = versionStamp;
    }
}
