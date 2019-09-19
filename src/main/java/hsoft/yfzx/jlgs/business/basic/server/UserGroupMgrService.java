package hsoft.yfzx.jlgs.business.basic.server;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.*;
import hsoft.yfzx.jlgs.business.basic.dao.CtmUserGroupMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.GroupinfoMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.UsergroupMapper;
import hsoft.yfzx.jlgs.business.basic.model.Groupinfo;
import hsoft.yfzx.jlgs.business.basic.model.GroupinfoExample;
import hsoft.yfzx.jlgs.business.basic.model.Usergroup;
import hsoft.yfzx.jlgs.business.basic.model.UsergroupExample;
import hsoft.yfzx.jlgs.business.im.dao.CtmChatCfgMapper;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.tool.Generator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserGroupMgrService {

    @Autowired
    private GroupinfoMapper groupinfoMapper;

    @Autowired
    private UsergroupMapper usergroupMapper;

    @Autowired
    private CtmChatCfgMapper ctmChatCfgMapper;

    @Autowired
    private CtmUserGroupMapper ctmUserGroupMapper;

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
            String sort = cUserGroupRec.getSort();
            if(sort == null || "".equals(sort)){
                sort = "0";
            }
            userGroup.setSORT(Short.valueOf(sort));
            userGroup.setCREATETIME(createStamp);
            userGroup.setVERSIONSTAMP(createStamp);
            userGroup.setDELFLAG("0");
            usergroupMapper.insert(userGroup);
        }
        // 更新群组版本
        Groupinfo groupInfo = groupinfoMapper.selectByPrimaryKey(cUserGroupRec.getGroupId());
        groupInfo.setVERSIONSTAMP(createStamp);
        groupinfoMapper.updateByPrimaryKeySelective(groupInfo);

        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 删除群组内成员
     * @param dUserGroupRec
     * @return
     */
    public ResponseData<String> deleteUserGroup(DUserGroupRec dUserGroupRec) {
        ResponseData<String> responseData = new ResponseData<>();
        UsergroupExample userGroupExample = new UsergroupExample();
        userGroupExample.or().andGROUPIDEqualTo(dUserGroupRec.getGroupId()).andUSERIDIn(dUserGroupRec.getUsers());
        // 判断删除的人员是否存在
        List<Usergroup> userGroupList = checkUserGroup(userGroupExample);
        if (userGroupList.size() != dUserGroupRec.getUsers().size()) {
            responseData.setStatus(ReturnStatus.ERR0003);
            responseData.setExtInfo("删除的人员或群组在数据库中不存在");
            return responseData;
        }

        // 删除人员
        UsergroupExample userGroupExample1 = new UsergroupExample();
        userGroupExample1.or().andGROUPIDEqualTo(dUserGroupRec.getGroupId());

        usergroupMapper.deleteByExample(userGroupExample);

        List<String> userIdList = dUserGroupRec.getUsers();
        //获取群组id
        String groupId = dUserGroupRec.getGroupId();
        for(String userId : userIdList){
            ctmChatCfgMapper.delChatCfg(userId, groupId);
        }
        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 查询群组内人员列表
     * @param qUserGroupListRec
     * @param userId
     * @return
     */
    public ResponseData<List<QUserGroupListRst>> userGroupList(QUserGroupListRec qUserGroupListRec, String userId) {
        ResponseData<List<QUserGroupListRst>> responseData = new ResponseData<>();
        List<QUserGroupListRst> userGroupList = new ArrayList<>();
        // 判断群组是否存在
        if (checkGroup(qUserGroupListRec.getGroupId()).size() < 1) {
            responseData.setStatus(ReturnStatus.ERR0003);
            responseData.setExtInfo("群组在数据库中不存在");
            responseData.setResultSet(userGroupList);
            return responseData;
        }
        //获取群组id
        String groupId = qUserGroupListRec.getGroupId();

        String content= "%" + qUserGroupListRec.getSearchRule() + "%";
        //根据条件查询群组内人员

        //此处的返回值需要测试
        userGroupList = ctmUserGroupMapper.selectGroupUser(groupId, content);

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(userGroupList);
        return responseData;
    }

    /**
     * 返回成员数据
     *
     * @param userGroupExample
     * @return
     */
    public List<Usergroup> checkUserGroup(UsergroupExample userGroupExample) {

        return usergroupMapper.selectByExample(userGroupExample);
    }

    /**
     * 查找群组
     *
     * @param groupId
     * @return
     */
    public List<Groupinfo> checkGroup(String groupId) {
        GroupinfoExample groupInfoExample = new GroupinfoExample();
        groupInfoExample.or().andGROUPIDEqualTo(groupId);

        List<Groupinfo> list = groupinfoMapper.selectByExample(groupInfoExample);

        return list;
    }
}
