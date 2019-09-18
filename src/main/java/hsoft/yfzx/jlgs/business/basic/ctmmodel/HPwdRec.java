package hsoft.yfzx.jlgs.business.basic.ctmmodel;

/**
 * 内网修改密码传入参数
 */
public class HPwdRec {

    private String userId;

    private String oldPwd;

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
