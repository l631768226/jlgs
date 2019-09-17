package hsoft.yfzx.jlgs.business.basic.controller;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.QSearchGroupAndUserRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QSearchGroupAndUserRst;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.validation.CheckUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic/search")
public class SearchMgrController {


    /**
     * 搜索群组和人员
     *
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/search/groupAndUser", method = RequestMethod.POST)
    public ResponseData<QSearchGroupAndUserRst> searchGroupAndUser(
            @RequestBody RequestData<QSearchGroupAndUserRec> requestData){
        ResponseData<QSearchGroupAndUserRst> responseData = new ResponseData<>();
        QSearchGroupAndUserRec qSearchGroupAndUserRec = requestData.getData();
        if (qSearchGroupAndUserRec == null || !qSearchGroupAndUserRec.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(qSearchGroupAndUserRec.getFailCauses());
            responseData.setResultSet(new QSearchGroupAndUserRst());
            // 返回
            return responseData;
        }
        if (CheckUtil.hasSpecialChar(qSearchGroupAndUserRec.getCondition()))
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("传入数据带有非法字符");
            responseData.setResultSet(new QSearchGroupAndUserRst());
            // 返回
            return responseData;
        }
        qSearchGroupAndUserRec.setUserId(requestData.getOwner().getUserId());
        return searchMgrService.searchGroupAndUser(qSearchGroupAndUserRec);
    }

}
