package hsoft.yfzx.jlgs.utils.model.common;

import java.io.Serializable;

public class Owner implements Serializable {

    private String userId;

    private String userName;

    private String realName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
