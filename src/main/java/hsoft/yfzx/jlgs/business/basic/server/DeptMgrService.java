package hsoft.yfzx.jlgs.business.basic.server;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.QDeptListRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QDeptListRst;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DeptMgrService {

    /**
     * 调用内网查询某组织机构下部门列表接口
     * @param data
     * @return
     */
    public ResponseData<List<QDeptListRst>> deptList(QDeptListRec data) {
        // 构建返回结果的数据对象
        ResponseData<List<QDeptListRst>> responseData = new ResponseData<List<QDeptListRst>>();

        //调用内网查询某组织机构下部门列表接口

        List<QDeptListRst> dtlist = new ArrayList<QDeptListRst>();
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(dtlist);
        return responseData;
    }

}
