package hsoft.yfzx.jlgs.business.basic.controller;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.*;
import hsoft.yfzx.jlgs.business.basic.server.FreqService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic/freq")
public class FreqController {

    @Autowired
    private FreqService freqService;

    /**
     * 设置常用联系人
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/setContace", method = RequestMethod.POST)
    public ResponseData<String> setContact(@RequestBody RequestData<CFreqContactRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        CFreqContactRec data = requestData.getData();
        if (data == null || !data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();
        return freqService.setFreqContact(userId, data);
    }

    /**
     * 设置常用群组
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/setGroup", method = RequestMethod.POST)
    public ResponseData<String> setGroup(@RequestBody RequestData<CFreqGroupRec> requestData) {
        ResponseData<String> responseData = new ResponseData<>();
        CFreqGroupRec data = requestData.getData();
        if (data == null || !data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();
        return freqService.setFreqGroup(userId, data);
    }

    /**
     * 查询某人的常用联系人和常用群组
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseData<QFreqListRst> queryList(@RequestBody RequestData requestData){
        String userId = requestData.getOwner().getUserId();
        return freqService.queryFreqList(userId);
    }

    /**
     * 常用群组排序
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/groupSort", method = RequestMethod.POST)
    public ResponseData<String> groupSort(@RequestBody RequestData<UFreGroupRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        UFreGroupRec data = requestData.getData();
        if (data == null || !data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }

        String userId = requestData.getOwner().getUserId();
        return freqService.groupSort(userId, data);
    }

    /**
     * 常用联系人排序
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/groupSort", method = RequestMethod.POST)
    public ResponseData<String> contactSort(@RequestBody RequestData<UFreContactRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        UFreContactRec data = requestData.getData();
        if (data == null || !data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }

        String userId = requestData.getOwner().getUserId();
        return freqService.contactSort(userId, data);
    }

}
