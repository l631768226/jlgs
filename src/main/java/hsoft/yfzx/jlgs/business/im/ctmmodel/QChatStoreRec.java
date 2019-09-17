package hsoft.yfzx.jlgs.business.im.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

import java.util.List;

/**
 * 根据id查询聊天记录请求时 传入参数
 */
public class QChatStoreRec extends AbstactBaseRec {

    @DataValidation(description = "消息id列表", dataType = DataType.LIST, required = true, length = 1)
    private List<String> ids;

    @DataValidation(description = "聊天对象类型", dataType = DataType.STRING, required = true, length = 1)
    private String objectType;

    @DataValidation(description = "聊天对象id", dataType = DataType.STRING, required = true, length = 36)
    private String objectId;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
