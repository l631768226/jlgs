package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

public class CUserRec extends AbstactBaseRec {
    @DataValidation(description = "用户id", dataType = DataType.STRING, required = true, length = 36)
    private String userId;
    @DataValidation(description = "用户名", dataType = DataType.STRING, required = true, length = 36)
    private String loginName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
