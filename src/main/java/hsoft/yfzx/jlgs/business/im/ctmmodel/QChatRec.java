package hsoft.yfzx.jlgs.business.im.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 根据聊天对象获取最新一条聊天记录 传入参数
 */
public class QChatRec extends AbstactBaseRec {

    @DataValidation(description = "对方id" , dataType = DataType.STRING, required = true, length = 36)
    private String objectId;

    private String userId;

    @DataValidation(description = "对方类型" , dataType = DataType.STRING, required = true, length = 3)
    private String objectType;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
