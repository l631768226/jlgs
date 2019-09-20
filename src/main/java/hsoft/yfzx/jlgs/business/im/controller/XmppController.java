package hsoft.yfzx.jlgs.business.im.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hsoft.yfzx.jlgs.business.im.ctmmodel.CXmppRec;
import hsoft.yfzx.jlgs.business.im.ctmmodel.CXmppRst;
import hsoft.yfzx.jlgs.business.im.server.XmppService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/im/xmpp")
public class XmppController {

    private Gson gson = new Gson();

    @Autowired
    private XmppService xmppService;

    /**
     * 发送xmpp消息
     * @param request
     * @return
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseData<CXmppRst> sendXmppInfo(HttpServletRequest request) throws IOException, ServletException {
        //获取参数
        String value = request.getParameter("json");
        //从请求中获取请求数据
        RequestData<CXmppRec> requestData = gson.fromJson(value, new TypeToken<RequestData<CXmppRec>>(){}.getType());

        ResponseData<CXmppRst> responseData = new ResponseData<>();
        //从请求体中获取信息项
        CXmppRec data = requestData.getData();

        if(data == null){
            //无数据
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("请提交相应数据");
            //返回
            return responseData;
        }

        //数据校验
        if(!data.validation()){
            //数据校验没有通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            //返回
            return responseData;
        }
        return xmppService.sendXmpp(data, request);
    }

}
