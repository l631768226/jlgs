package hsoft.yfzx.jlgs;

import hsoft.yfzx.jlgs.business.basic.dao.CtmLogininfoMapper;
import hsoft.yfzx.jlgs.business.basic.dao.CtmSysUserDao;
import hsoft.yfzx.jlgs.business.basic.mapper.LogininfoMapper;
import hsoft.yfzx.jlgs.business.basic.model.Logininfo;
import hsoft.yfzx.jlgs.business.im.model.SysUser;
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

    @Autowired
    private LogininfoMapper logininfoMapper;

    @Autowired
    private CtmSysUserDao ctmSysUserDao;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        List<SysUser> sysUserList = ctmSysUserDao.findList();
        for(SysUser sysUser : sysUserList){
            Logininfo logininfo = new Logininfo();
            String userId = sysUser.getID();
            String username = sysUser.getLOGIN_NAME();
            logininfo.setUSERID(userId);
            logininfo.setUSERNAME(username);
            logininfo.setREALNAME(sysUser.getNAME());
            logininfoMapper.insertSelective(logininfo);
            XmppOperator.register(username, userId);
        }
        return "OK";
    }

}
