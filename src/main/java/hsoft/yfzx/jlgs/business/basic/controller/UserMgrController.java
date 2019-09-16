package hsoft.yfzx.jlgs.business.basic.controller;


import hsoft.yfzx.jlgs.business.basic.ctmmodel.QUserLoginRec;
import hsoft.yfzx.jlgs.business.basic.model.Userinfo;
import hsoft.yfzx.jlgs.business.basic.server.UserMgrService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic/user")
public class UserMgrController {

    @Autowired
    private UserMgrService userMgrService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData<Userinfo> login(@RequestBody RequestData<QUserLoginRec> requestData){
        ResponseData<Userinfo> responseData = new ResponseData<Userinfo>();
        QUserLoginRec data = requestData.getData();
        if (!data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        return userMgrService.login(data);
    }

}
