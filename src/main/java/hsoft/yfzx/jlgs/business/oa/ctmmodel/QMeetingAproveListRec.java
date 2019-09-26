package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;

/**
 * 会议审批列表传入参数
 */
public class QMeetingAproveListRec extends AbstactBaseRec {

    private String type;

    private String status;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
