package hsoft.yfzx.jlgs.business.oa.controller;

import hsoft.yfzx.jlgs.business.oa.ctmmodel.QHistoicUpdateRec;
import hsoft.yfzx.jlgs.business.oa.ctmmodel.QHistoicUpdateRst;
import hsoft.yfzx.jlgs.business.oa.server.FollowService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oa/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    /**
     * 查看业务表修改记录
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/historicUpdate", method = RequestMethod.POST)
    public ResponseData<QHistoicUpdateRst> historicUpdate(@RequestBody RequestData<QHistoicUpdateRec> requestData){
        ResponseData<QHistoicUpdateRst> responseData = new ResponseData<>();

        QHistoicUpdateRec data = requestData.getData();

        if (data == null)
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("无数据需要修改");
            // 返回
            return responseData;
        }
        if(!data.validation()){
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }

        String userId = requestData.getOwner().getUserId();
        return followService.historicUpdate(userId, data);
    }

}
