package hsoft.yfzx.jlgs;

import hsoft.yfzx.jlgs.business.basic.dao.CtmLogininfoMapper;
import hsoft.yfzx.jlgs.business.basic.model.Logininfo;
import hsoft.yfzx.xmpppush.XmppOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TescController {

    @Autowired
    private CtmLogininfoMapper ctmLogininfoMapper;

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        List<Logininfo> logininfos = ctmLogininfoMapper.findList();
        for(Logininfo logininfo : logininfos){
            String loginName = logininfo.getUSERNAME();
            String userId = logininfo.getUSERID();

            XmppOperator.register(loginName, userId);

        }
        return "OK";
    }

}
