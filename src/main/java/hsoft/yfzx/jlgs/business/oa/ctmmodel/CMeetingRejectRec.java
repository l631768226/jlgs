package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 会议驳回传入参数model
 */
public class CMeetingRejectRec extends AbstactBaseRec {

    @DataValidation(description = "会议id", dataType = DataType.STRING, required = true, length = 36)
    private String meetingId;

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

}
