package hsoft.yfzx.jlgs.business.oa.controller;

import hsoft.yfzx.jlgs.business.oa.ctmmodel.QUnconfirmRst;
import hsoft.yfzx.jlgs.business.oa.server.OAService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/oa")
public class OAController {

    @Autowired
    private OAService oaService;

    @RequestMapping(value = "/unconfirm", method = RequestMethod.POST)
    public ResponseData<QUnconfirmRst> unconfirm(@RequestBody RequestData requestData){
        String userId = requestData.getOwner().getUserId();
        return oaService.unconfirm(userId);
    }

}
