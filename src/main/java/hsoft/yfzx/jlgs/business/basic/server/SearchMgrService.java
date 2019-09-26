package hsoft.yfzx.jlgs.business.basic.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QSearchGroupAndUserRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QSearchGroupAndUserRst;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QSearchGroupRst;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QSearchUserRst;
import hsoft.yfzx.jlgs.business.basic.dao.CtmUserGroupMapper;
import hsoft.yfzx.jlgs.business.basic.dao.CtmUserInfoMapper;
import hsoft.yfzx.jlgs.business.basic.model.Groupinfo;
import hsoft.yfzx.jlgs.business.basic.model.Logininfo;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.HSearchUserRec;
import hsoft.yfzx.jlgs.business.basic.model.SysUser;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.model.http.HsoftReqData;
import hsoft.yfzx.jlgs.utils.model.http.HsoftRstData;
import hsoft.yfzx.jlgs.utils.tool.HttpMethodTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SearchMgrService {

    @Autowired
    private CtmUserGroupMapper ctmUserGroupMapper;

    @Autowired
    private CtmUserInfoMapper ctmUserInfoMapper;

    @Autowired
    private Gson gson = new Gson();

    @Value("${custom.js.serverUrl}")
    String jsServerUrl;

    /**
     * 搜索用户和群组
     *
     * @param qSearchGroupAndUserRec
     * @return
     */
    public ResponseData<QSearchGroupAndUserRst> searchGroupAndUser(QSearchGroupAndUserRec qSearchGroupAndUserRec) {
        ResponseData<QSearchGroupAndUserRst> responseData = new ResponseData<>();

        String condition = qSearchGroupAndUserRec.getCondition();
        if(condition == null){
            condition = "";
        }
        // 搜索群组
        List<Groupinfo> groupList = ctmUserGroupMapper.selectGroupByCondition(qSearchGroupAndUserRec.getUserId(),
                condition);
        List<QSearchGroupRst> searchGroupList = new ArrayList<>();
        // 赋值
        for (Groupinfo groupInfo : groupList) {
            QSearchGroupRst qSearchGroupRst = new QSearchGroupRst();
            qSearchGroupRst.setGroupId(groupInfo.getGROUPID());
            qSearchGroupRst.setGroupName(groupInfo.getGROUPNAME());
            qSearchGroupRst.setPicId(groupInfo.getPICID());
            searchGroupList.add(qSearchGroupRst);
        }

        //根据条件查询用户信息（姓名模糊查询）
//        List<Logininfo> userList = ctmUserInfoMapper.selectUserByCondition(condition);

        List<QSearchUserRst> searchUserList = new ArrayList<>();
        // 赋值
//        for (Logininfo logininfo : userList){
//            QSearchUserRst qSearchUserRst = new QSearchUserRst();
//            qSearchUserRst.setUserId(logininfo.getUSERID());
//            qSearchUserRst.setPicId(logininfo.getPICID());
//            qSearchUserRst.setRealName(logininfo.getREALNAME());
//            searchUserList.add(qSearchUserRst);
//        }

        //根据条件查询内网用户信息
        HsoftReqData<HSearchUserRec> hsoftReqData = new HsoftReqData<>();
        HSearchUserRec hSearchUserRec = new HSearchUserRec();
        hSearchUserRec.setCodition(condition);
        hsoftReqData.setChangeableData(hSearchUserRec);
        //请求数据
        String dataStr = gson.toJson(hsoftReqData);

        String url = jsServerUrl + "/user/search";

        List<SysUser> sysUserList = new ArrayList<>();
        //调用内网查询某组织下人员列表接口
        String resultStr = HttpMethodTool.getJson(url, dataStr, "POST");
        if(resultStr.equals("fail") || resultStr.equals("error")){
            responseData.setStatus(ReturnStatus.ERR0017);
            responseData.setExtInfo("服务请求失败");
            return responseData;
        }else {
            try {
                HsoftRstData<List<SysUser>> hsoftRstData = gson.fromJson(resultStr, new TypeToken<HsoftRstData<List<SysUser>>>() {
                }.getType());

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
                        sysUserList = hsoftRstData.getData();
                    }
                }
            }catch (Exception e){
                responseData.setStatus(ReturnStatus.ERR0017);
                responseData.setExtInfo("服务请求失败,返回值解析失败");
                return responseData;
            }
        }

        if(sysUserList != null && sysUserList.size() > 0){
            for(SysUser sysUser : sysUserList){
                QSearchUserRst qSearchUserRst = new QSearchUserRst();
                qSearchUserRst.setRealName(sysUser.getName());
                qSearchUserRst.setPicId(sysUser.getPhoto());
                qSearchUserRst.setUserId(sysUser.getId());
                qSearchUserRst.setMobile(sysUser.getMobile());
                qSearchUserRst.setPosition(sysUser.getPosition());
                searchUserList.add(qSearchUserRst);
            }
        }

        //设置返回参数
        QSearchGroupAndUserRst qSearchGroupAndUserRst = new QSearchGroupAndUserRst();
        qSearchGroupAndUserRst.setGroupList(searchGroupList);
        qSearchGroupAndUserRst.setUserList(searchUserList);
        // 返回
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qSearchGroupAndUserRst);
        return responseData;
    }


}
