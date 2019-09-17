package hsoft.yfzx.jlgs.business.im.server;

import hsoft.yfzx.jlgs.business.im.ctmmodel.CXmppRec;
import hsoft.yfzx.jlgs.business.im.ctmmodel.CXmppRst;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@Transactional
public class XmppService {


    public ResponseData<CXmppRst> sendXmpp(CXmppRec data, HttpServletRequest request){
        ResponseData<CXmppRst> responseData = new ResponseData<>();

        return responseData;
    }

}
