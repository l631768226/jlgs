package hsoft.yfzx.jlgs.business.basic.controller;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.QDeptListRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QDeptListRst;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QInfoListRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QInfoListRst;
import hsoft.yfzx.jlgs.business.basic.server.DeptMgrService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/basic/dept")
public class DeptMgrController {

    @Autowired
    private DeptMgrService deptMgrService;


    /**
     * 调用内网查询某组织机构下部门列表接口
     * @param requestData 部门id
     * @return
     */
    @RequestMapping(value = "/deptList", method = RequestMethod.POST)
    public ResponseData<List<QDeptListRst>> deptList(@RequestBody RequestData<QDeptListRec> requestData)
    {
        ResponseData<List<QDeptListRst>> responseData = new ResponseData<List<QDeptListRst>>();
        QDeptListRec data = requestData.getData();
        if (!data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }

        return deptMgrService.deptList(data);
    }

    /**
     * 获取某组织机构下人员列表和组织机构列表信息
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/infoList", method = RequestMethod.POST)
    public ResponseData<QInfoListRst> infoList(@RequestBody RequestData<QInfoListRec> requestData){
        ResponseData<QInfoListRst> responseData = new ResponseData<>();
        QInfoListRec data = requestData.getData();
        if (!data.validation())
        {
            // 数据校验不通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }

        return deptMgrService.infoList(data);
    }

    /**
     * 获取全部人员列表和组织机构列表信息
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/allInfoList", method = RequestMethod.POST)
    public ResponseData<QInfoListRst> allInfoList(@RequestBody RequestData requestData){
        ResponseData<QInfoListRst> responseData = new ResponseData<>();

        return deptMgrService.allInfoList();
    }

}
