package hsoft.yfzx.jlgs.business.basic.server;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.CFeedbackRec;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.tool.Generator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FeedbackService {



    /**
     * 发起反馈
     *
     * @param cFeedBackRec
     * @return
     */
    public ResponseData<String> launchFeedBack(CFeedbackRec cFeedBackRec) {
        ResponseData<String> responseData = new ResponseData<>();
        // 插入数据

        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

}
