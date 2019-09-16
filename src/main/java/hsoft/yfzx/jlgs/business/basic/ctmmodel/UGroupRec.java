package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 修改群组信息传入model
 */
public class UGroupRec extends AbstactBaseRec {

    @DataValidation(description = "群组Id", dataType = DataType.STRING, required = true, length = 36)
    private String groupId;
    @DataValidation(description = "群组名称", dataType = DataType.STRING, required = true, length = 50)
    private String groupName;
    @DataValidation(description = "群组通知", dataType = DataType.STRING, required = false, length = 255)
    private String notice;
    private String picId;
    @DataValidation(description = "群组简介", dataType = DataType.STRING, required = false, length = 255)
    private String introduce;

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

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
