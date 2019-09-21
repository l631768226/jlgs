package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 修改通知阅读状态传入参数
 */
public class UChangeStateRec extends AbstactBaseRec {
    @DataValidation(description = "通知id", dataType = DataType.STRING, required = true, length = 36)
    private String noticeId;

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }
}
