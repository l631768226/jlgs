package hsoft.yfzx.jlgs.business.basic.controller;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.QCheckTokenRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QCheckTokenRst;
import hsoft.yfzx.jlgs.business.basic.server.CheckSyncService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/basic/check")
public class CheckController {

    @Autowired
    private CheckSyncService checkSyncService;

    /**
     * 检查token是否可用
     * @param requestData
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseData<QCheckTokenRst> checkToken(@RequestBody RequestData<QCheckTokenRec> requestData) throws UnsupportedEncodingException{
        //当token失效时进入下面处理
        ResponseData<QCheckTokenRst> responseData = new ResponseData<>();
        QCheckTokenRec data = requestData.getData();
        if (!data.validation()) {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }

        return checkSyncService.processCheckToken(requestData.getToken(), requestData.getData());
    }

}
