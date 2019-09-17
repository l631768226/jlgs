package hsoft.yfzx.jlgs.business.im.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 更新会话设置时使用的实体类
 */
public class UChatCfgRec extends AbstactBaseRec {

    @DataValidation(description = "会话对象Id", dataType = DataType.STRING, required = true, length = 36)
    private String objectId;
    @DataValidation(description = "会话对象类别", dataType = DataType.STRING, required = true, length = 3)
    private String objectType;
    @DataValidation(description = "置顶状态", dataType = DataType.STRING, required = true, length = 3)
    private String topStatus;
    @DataValidation(description = "免打扰状态", dataType = DataType.STRING, required = true, length = 3)
    private String undisturbed;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getTopStatus() {
        return topStatus;
    }

    public void setTopStatus(String topStatus) {
        this.topStatus = topStatus;
    }

    public String getUndisturbed() {
        return undisturbed;
    }

    public void setUndisturbed(String undisturbed) {
        this.undisturbed = undisturbed;
    }
}
