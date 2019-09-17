package hsoft.yfzx.jlgs.business.im.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

import java.math.BigDecimal;

/**
 * 同步会话设置时使用的实体类
 */
public class QChatCfgSyncRec extends AbstactBaseRec {

    @DataValidation(description = "版本时间戳", dataType = DataType.DECIMAL, required = true, length = 17)
    private BigDecimal versionStamp;

    private String userId;

    public BigDecimal getVersionStamp() {
        return versionStamp;
    }

    public void setVersionStamp(BigDecimal versionStamp) {
        this.versionStamp = versionStamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
