package hsoft.yfzx.jlgs.utils.model.common;

import java.io.Serializable;
import java.util.List;

public class UserCacheData implements Serializable {

    private static final long serialVersionUID = 6639626630406961620L;

    private String userId;

    private String userName;

    private String realName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
