package hsoft.yfzx.jlgs.business.basic.server;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.QSearchGroupAndUserRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QSearchGroupAndUserRst;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QSearchGroupRst;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QSearchUserRst;
import hsoft.yfzx.jlgs.business.basic.dao.CtmUserGroupMapper;
import hsoft.yfzx.jlgs.business.basic.dao.CtmUserInfoMapper;
import hsoft.yfzx.jlgs.business.basic.model.Groupinfo;
import hsoft.yfzx.jlgs.business.basic.model.Logininfo;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 搜索用户和群组
     *
     * @param qSearchGroupAndUserRec
     * @return
     */
    public ResponseData<QSearchGroupAndUserRst> searchGroupAndUser(QSearchGroupAndUserRec qSearchGroupAndUserRec) {
        ResponseData<QSearchGroupAndUserRst> responseData = new ResponseData<>();
        // 搜索群组
        List<Groupinfo> groupList = ctmUserGroupMapper.selectGroupByCondition(qSearchGroupAndUserRec.getUserId(),
                qSearchGroupAndUserRec.getCondition());
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
        List<Logininfo> userList = ctmUserInfoMapper.selectUserByCondition(qSearchGroupAndUserRec.getCondition());

        List<QSearchUserRst> searchUserList = new ArrayList<>();
        // 赋值
        for (Logininfo logininfo : userList){
            QSearchUserRst qSearchUserRst = new QSearchUserRst();
            qSearchUserRst.setUserId(logininfo.getUSERID());
            qSearchUserRst.setPicId(logininfo.getPICID());
            qSearchUserRst.setRealName(logininfo.getREALNAME());
            searchUserList.add(qSearchUserRst);
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
