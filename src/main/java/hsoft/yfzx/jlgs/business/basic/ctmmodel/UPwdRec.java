package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 修改密码传入参数
 */
public class UPwdRec extends AbstactBaseRec {
    @DataValidation(description = "用户标识", dataType = DataType.STRING, length = 36)
    private String userId;

    @DataValidation(description = "旧密码", dataType = DataType.STRING, length = 30)
    private String oldPwd;

    @DataValidation(description = "新密码", dataType = DataType.STRING, required = true, length = 30)
    private String newPwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
