package hsoft.yfzx.jlgs.business.basic.server;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.QUserLoginRec;
import hsoft.yfzx.jlgs.business.basic.dao.UserinfoDao;
import hsoft.yfzx.jlgs.business.basic.model.Userinfo;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMgrService {

    @Autowired
    private UserinfoDao userinfoDao;

    public ResponseData<Userinfo> login(QUserLoginRec data){

        ResponseData<Userinfo> responseData = new ResponseData<Userinfo>();
        //传入的密码进行MD5加密
        String password = DigestUtils.md5Hex(data.getPassword());
        //获取用户名
        String userName = data.getUserName();

        //根据用户名和密码查询用户信息
        Userinfo userinfo = userinfoDao.login(userName, password);



        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(userinfo);
        return responseData;
    }
}
