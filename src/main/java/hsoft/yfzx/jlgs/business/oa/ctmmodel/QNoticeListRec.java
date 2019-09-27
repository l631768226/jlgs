package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;

/**
 * 查询通知列表传入参数
 */
public class QNoticeListRec extends AbstactBaseRec {

    private String state;

    private String type;

    private String urgency;

    private String del;

    private String searchRule;

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public String getSearchRule() {
        return searchRule;
    }

    public void setSearchRule(String searchRule) {
        this.searchRule = searchRule;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
