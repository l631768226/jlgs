package hsoft.yfzx.jlgs.business.im.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

import java.math.BigDecimal;

/**
 * 消息同步时使用的实体类
 */
public class QChatStoreSyncRec extends AbstactBaseRec {

    @DataValidation(description = "发送时间", dataType = DataType.DECIMAL, required = true, length = 17)
    private BigDecimal sendTime;

    @DataValidation(description = "同步数量", dataType = DataType.INTEGER, required = true, length = 50)
    private int account;

    @DataValidation(description = "是否为群组消息标识", dataType = DataType.STRING, required = true, length = 3)
    private String objectType;

    @DataValidation(description = "接收方id", dataType = DataType.STRING, required = true, length = 36)
    private String receId;

    private String userId;

    public BigDecimal getSendTime() {
        return sendTime;
    }

    public void setSendTime(BigDecimal sendTime) {
        this.sendTime = sendTime;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getReceId() {
        return receId;
    }

    public void setReceId(String receId) {
        this.receId = receId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
