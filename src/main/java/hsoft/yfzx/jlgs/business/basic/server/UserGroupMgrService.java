package hsoft.yfzx.jlgs.business.basic.server;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.CGroupsUserRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.CUserGroupRec;
import hsoft.yfzx.jlgs.business.basic.mapper.GroupinfoMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.UsergroupMapper;
import hsoft.yfzx.jlgs.business.basic.model.Groupinfo;
import hsoft.yfzx.jlgs.business.basic.model.GroupinfoExample;
import hsoft.yfzx.jlgs.business.basic.model.Usergroup;
import hsoft.yfzx.jlgs.business.basic.model.UsergroupExample;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.tool.Generator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.security.acl.Group;
import java.util.List;

@Service
@Transactional
public class UserGroupMgrService {

    @Autowired
    private GroupinfoMapper groupinfoMapper;

    @Autowired
    private UsergroupMapper usergroupMapper;

    /**
     * 某个群组添加人员
     *
     * @param cUserGroupRec
     * @return
     */
    public ResponseData<String> createUserGroup(CUserGroupRec cUserGroupRec) {
        ResponseData<String> responseData = new ResponseData<>();

        // 判断群组是否存在
        GroupinfoExample groupInfoExample = new GroupinfoExample();
        groupInfoExample.or().andGROUPIDEqualTo(cUserGroupRec.getGroupId());
        List<Groupinfo> groupList = groupinfoMapper.selectByExample(groupInfoExample);
        if (groupList.isEmpty()) {
            responseData.setStatus(ReturnStatus.ERR0003);
            responseData.setExtInfo("添加人员的群组在数据库中不存在");
            return responseData;
        }

        UsergroupExample userGroupExample = new UsergroupExample();
        userGroupExample.or().andGROUPIDEqualTo(cUserGroupRec.getGroupId());
        List<Usergroup> list = usergroupMapper.selectByExample(userGroupExample);
        List<CGroupsUserRec> userIds = cUserGroupRec.getUsers();
        for (Usergroup userGroup : list) {
            for (int i = 0; i < cUserGroupRec.getUsers().size(); i++) {
                CGroupsUserRec cGroupsUserRec = cUserGroupRec.getUsers().get(i);
                if (cGroupsUserRec.getLevel().equals("1")) {
                    responseData.setStatus(ReturnStatus.ERR0002);
                    responseData.setExtInfo("群组内只能有一个群主");
                    return responseData;
                }
                if (userGroup.getUSERID().equals(cGroupsUserRec.getUserId())) {
                    userIds.remove(cGroupsUserRec);
                }
            }
        }

        Long createStamp = Generator.getLongTimeStamp();
        // 循环插入群组人员
        Usergroup userGroup = new Usergroup();
        for (CGroupsUserRec groupsUserRec : userIds) {
            CGroupsUserRec cGroupsUserRec = groupsUserRec;
            userGroup.setUSERID(cGroupsUserRec.getUserId());
            userGroup.setDEPTID(cGroupsUserRec.getDeptId());
            userGroup.setPOSITIONCODELIST(cGroupsUserRec.getPositionCodeList());
            userGroup.setGROUPID(cUserGroupRec.getGroupId());
            Short sort = 0;
            userGroup.setSORT(sort);
            userGroup.setCREATETIME(createStamp);
            userGroup.setVERSIONSTAMP(createStamp);
            usergroupMapper.insert(userGroup);
        }
        // 更新群组版本
        Groupinfo groupInfo = groupinfoMapper.selectByPrimaryKey(cUserGroupRec.getGroupId());
        groupInfo.setVERSIONSTAMP(createStamp);
        groupinfoMapper.updateByPrimaryKeySelective(groupInfo);

        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

}
