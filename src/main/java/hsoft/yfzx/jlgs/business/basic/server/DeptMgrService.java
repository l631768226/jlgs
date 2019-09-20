package hsoft.yfzx.jlgs.business.basic.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.*;
import hsoft.yfzx.jlgs.business.basic.model.SysOffice;
import hsoft.yfzx.jlgs.business.basic.model.SysUser;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.model.http.HsoftReqData;
import hsoft.yfzx.jlgs.utils.model.http.HsoftRstData;
import hsoft.yfzx.jlgs.utils.tool.HttpMethodTool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DeptMgrService {

    //内网基础地址
    @Value("${custom.serverUrl}")
    private String serverUrl;

    private Gson gson = new Gson();

    /**
     * 调用内网查询某组织机构下部门列表接口
     * @param data
     * @return
     */
    public ResponseData<List<QDeptListRst>> deptList(QDeptListRec data) {
        // 构建返回结果的数据对象
        ResponseData<List<QDeptListRst>> responseData = new ResponseData<List<QDeptListRst>>();

        //调用内网查询某组织机构下部门列表接口

        HDeptListRec hDeptListRec = new HDeptListRec();
        hDeptListRec.setDeptId(data.getDeptId());
        HsoftReqData<HDeptListRec> hsoftReqData = new HsoftReqData<>();
        hsoftReqData.setChangeableData(hDeptListRec);
        //转换成请求数据json字符串
        String dataStr = gson.toJson(hsoftReqData);
        //拼接请求地址
        String url = serverUrl + "/dept/deptList";

        List<SysOffice> officeList = new ArrayList<>();

        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<List<SysOffice>> hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData
                        <List<SysOffice>>>() {}.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0004);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }else{
                        //获取部门信息列表
                        officeList = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        List<QDeptListRst> dtlist = new ArrayList<QDeptListRst>();

        //将数据查询结果拷贝到返回信息中
        if(officeList != null && officeList.size() > 0){
            for(SysOffice sysOffice : officeList){
                QDeptListRst qOfficeListRst = new QDeptListRst();
                qOfficeListRst.setDeptId(sysOffice.getId());
                qOfficeListRst.setDeptName(sysOffice.getName());
                qOfficeListRst.setParentId(sysOffice.getParent_ID());
                //获取部门排序信息
                Double sort = sysOffice.getSort();
                if(sort != null){
                    qOfficeListRst.setSort(String.valueOf(sort));
                }else{
                    qOfficeListRst.setSort("");
                }
                qOfficeListRst.setGrade(sysOffice.getGrade());
                dtlist.add(qOfficeListRst);
            }
        }

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(dtlist);
        return responseData;
    }

    /**
     * 获取某组织机构下人员列表信息和部门列表信息
     * @param data
     * @return
     */
    public ResponseData<QInfoListRst> infoList(QInfoListRec data){
        ResponseData<QInfoListRst> responseData = new ResponseData<>();
        QInfoListRst qInfoListRst = new QInfoListRst();
        //获取部门id
        String deptId = data.getDeptId();
        //设置参数
        HInfoListRec hInfoListRec = new HInfoListRec();
        hInfoListRec.setDeptId(deptId);
        HsoftReqData<HInfoListRec> hsoftReqData = new HsoftReqData<>();
        hsoftReqData.setChangeableData(hInfoListRec);
        //请求参数
        String dataStr = gson.toJson(hsoftReqData);
        //请求地址
        String url = serverUrl + "/user/infoList";

        List<SysOffice> officeList = new ArrayList<>();
        List<SysUser> sysUserList = new ArrayList<>();
        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<CtmInfoListRst> hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData
                        <CtmInfoListRst>>() {}.getType());

                if(hsoftRstData == null){
                    responseData.setStatus(ReturnStatus.ERR0017);
                    responseData.setExtInfo("服务请求失败,返回为空");
                    return responseData;
                }else{
                    int code = hsoftRstData.getCode();
                    if(code < 1){
                        responseData.setStatus(ReturnStatus.ERR0004);
                        responseData.setExtInfo(hsoftRstData.getMessage());
                        return responseData;
                    }else{
                        //获取部门信息列表
                        officeList = hsoftRstData.getData().getDeptList();
                        sysUserList = hsoftRstData.getData().getUserList();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        List<QDeptListRst> dtlist = new ArrayList<QDeptListRst>();
        //将数据查询结果拷贝到返回信息中
        if(officeList != null && officeList.size() > 0){
            for(SysOffice sysOffice : officeList){
                QDeptListRst qOfficeListRst = new QDeptListRst();
                qOfficeListRst.setDeptId(sysOffice.getId());
                qOfficeListRst.setDeptName(sysOffice.getName());
                qOfficeListRst.setParentId(sysOffice.getParent_ID());
                //获取部门排序信息
                Double sort = sysOffice.getSort();
                if(sort != null){
                    qOfficeListRst.setSort(String.valueOf(sort));
                }else{
                    qOfficeListRst.setSort("");
                }
                qOfficeListRst.setGrade(sysOffice.getGrade());
                dtlist.add(qOfficeListRst);
            }
        }
        qInfoListRst.setDeptList(dtlist);

        List<QUserRst> userList = new ArrayList<>();
        if(sysUserList != null && sysUserList.size() > 0){
            for(SysUser sysUser : sysUserList){
                QUserRst qUserRst = new QUserRst();
                qUserRst.setUserId(sysUser.getId());
                qUserRst.setRealName(sysUser.getName());
                qUserRst.setGender(sysUser.getGender());
                qUserRst.setPhone(sysUser.getPhone());
                qUserRst.setMobile(sysUser.getMobile());
                qUserRst.setEmail(sysUser.getEmail());
                qUserRst.setPhoto(sysUser.getPhoto());
                qUserRst.setPosition(sysUser.getPosition());
                qUserRst.setPositionRemark(sysUser.getPosition_REMARK());
                if(sysUser.getBirthday() == null){
                    qUserRst.setBirthday("");
                }else{
                    qUserRst.setBirthday(sysUser.getBirthday().toString());
                }

                if(sysUser.getWork_YEARS() == null){
                    qUserRst.setWorkYears("");
                }else{
                    qUserRst.setWorkYears(sysUser.getWork_YEARS().toString());
                }
                qUserRst.setWorkState(sysUser.getWork_STATE());
                qUserRst.setDuty(sysUser.getDuty());
                qUserRst.setDeptName(sysUser.getOfficeName());
                qUserRst.setDeptId(sysUser.getOffice_ID());

                userList.add(qUserRst);
            }
        }
        qInfoListRst.setUserList(userList);
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qInfoListRst);
        return responseData;
    }

}
