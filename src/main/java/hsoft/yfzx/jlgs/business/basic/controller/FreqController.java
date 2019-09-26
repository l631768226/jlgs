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

import java.util.List;

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
    @RequestMapping(value = "/setContact", method = RequestMethod.POST)
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
     * 删除常用联系人
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/delContact", method = RequestMethod.POST)
    public ResponseData<String> delContact(@RequestBody RequestData<DFreqContactRec> requestData){
        ResponseData<String> responseData = new ResponseData<>();
        DFreqContactRec data = requestData.getData();
        if (data == null || !data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();
        return freqService.delFreqContact(userId, data);
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
     * 删除常用群组
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/delGroup", method = RequestMethod.POST)
    public ResponseData<String> delGroup(@RequestBody RequestData<DFreqGroupRec> requestData) {
        ResponseData<String> responseData = new ResponseData<>();
        DFreqGroupRec data = requestData.getData();
        if (data == null || !data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();
        return freqService.delFreqGroup(userId, data);
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
    @RequestMapping(value = "/contactSort", method = RequestMethod.POST)
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

    @RequestMapping(value = "/searchContact", method = RequestMethod.POST)
    public ResponseData<List<QFreqRst>> searchContact(@RequestBody RequestData<QFreqSearchRec> requestData){
        ResponseData<List<QFreqRst>> responseData = new ResponseData<>();
        QFreqSearchRec data = requestData.getData();
        if (data == null || !data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();
        return freqService.searchContact(userId, data);
    }


    @RequestMapping(value = "/searchGroup", method = RequestMethod.POST)
    public ResponseData<List<QFreqRst>> searchGroup(@RequestBody RequestData<QFreqSearchRec> requestData){
        ResponseData<List<QFreqRst>> responseData = new ResponseData<>();
        QFreqSearchRec data = requestData.getData();
        if (data == null || !data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }
        String userId = requestData.getOwner().getUserId();
        return freqService.searchGroup(userId, data);
    }

}
