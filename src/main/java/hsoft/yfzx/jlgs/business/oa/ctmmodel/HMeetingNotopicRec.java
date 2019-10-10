package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

public class HMeetingNotopicRec {

    private String type;
    private String flag;
    private String userId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
