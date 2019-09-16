package hsoft.yfzx.jlgs.business.basic.server;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.CGroupRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.CGroupsUserRec;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.DGroupRec;
import hsoft.yfzx.jlgs.business.basic.mapper.CtmUserGroupMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.GroupinfoMapper;
import hsoft.yfzx.jlgs.business.basic.mapper.UsergroupMapper;
import hsoft.yfzx.jlgs.business.basic.model.Groupinfo;
import hsoft.yfzx.jlgs.business.basic.model.GroupinfoExample;
import hsoft.yfzx.jlgs.business.basic.model.Usergroup;
import hsoft.yfzx.jlgs.business.basic.model.UsergroupExample;
import hsoft.yfzx.jlgs.business.im.ctmmodel.CtmChatCfgMapper;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import hsoft.yfzx.jlgs.utils.tool.Generator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class GroupMgrService {

    @Autowired
    private GroupinfoMapper groupinfoMapper;

    @Autowired
    private UsergroupMapper usergroupMapper;

    @Autowired
    private CtmUserGroupMapper ctmUserGroupMapper;

    @Autowired
    private CtmChatCfgMapper ctmChatCfgMapper;

    /**
     * 创建群组
     * @param cGroupRec
     * @return
     */
    public ResponseData<String> createGroup(CGroupRec cGroupRec) {
        ResponseData<String> responseData = new ResponseData<>();

        // 判断群组人员与人员的组织机构是否关联并且存在
        List<CGroupsUserRec> userList = cGroupRec.getUsers();
        int ownerNum = 0;
        for (int i = 0; i < userList.size(); i++) {
            // 群组内只允许有一个群主
            if (userList.get(i).getLevel().equals("1")) {
                ownerNum++;
            }
            if (ownerNum > 1) {
                responseData.setStatus(ReturnStatus.ERR0002);
                responseData.setExtInfo("群组内只可以有一个群主");
                return responseData;
            }
        }
        if (ownerNum < 1) {
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo("群组内必须有一个群主");
            return responseData;
        }
        Long versionStamp = Generator.getLongTimeStamp();
        // 插入群组
        Groupinfo groupInfo = new Groupinfo();
        String newGroupId = Generator.getUUID();
        BeanUtils.copyProperties(cGroupRec, groupInfo);
        groupInfo.setGROUPID(newGroupId);
        groupInfo.setCREATETIME(versionStamp);
        groupInfo.setVERSIONSTAMP(versionStamp);
        groupinfoMapper.insert(groupInfo);

        // 循环插入群组人员
        Usergroup userGroup = new Usergroup();
        for (int i = 0; i < userList.size(); i++) {
            CGroupsUserRec cGroupsUserRec = userList.get(i);
            BeanUtils.copyProperties(cGroupsUserRec, userGroup);
            userGroup.setGROUPID(newGroupId);
            short sort = 0;
            userGroup.setSORT(sort);
            userGroup.setCREATETIME(Generator.getLongTimeStamp());
            userGroup.setVERSIONSTAMP(Generator.getLongTimeStamp());
            if (usergroupMapper.insert(userGroup) < 1) {
                responseData.setStatus(ReturnStatus.ERR0004);
                responseData.setExtInfo("添加群组成员失败");
                return responseData;
            }
        }

        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 删除群组
     * @param dGroupRec
     * @return
     */
    public ResponseData<String> deleteGroup(DGroupRec dGroupRec) {
        ResponseData<String> responseData = new ResponseData<>();

        //获取群组id
        String groupId = dGroupRec.getGroupId();
        // 判断删除的群组状态是否正常或者是否存在
        List<Groupinfo> list = checkGroup(groupId);
        if (list.isEmpty()) {
            responseData.setStatus(ReturnStatus.ERR0003);
            responseData.setExtInfo("删除的群组在数据库中不存在");
            return responseData;
        }
        //更新群组信息的删除标志
        Groupinfo groupInfo = list.get(0);
        groupInfo.setDELFLAG("1");
        groupinfoMapper.updateByPrimaryKeySelective(groupInfo);

        // 删除群组用户表中有关此群组的数据
        UsergroupExample userGroupExample = new UsergroupExample();
        userGroupExample.or().andGROUPIDEqualTo(dGroupRec.getGroupId());

        List<Usergroup> userGroupList = usergroupMapper.selectByExample(userGroupExample);
        //获取Long型时间戳
        Long versionStamp = Generator.getLongTimeStamp();
        for(Usergroup usergroup : userGroupList){
            usergroup.setDELFLAG("1");
            usergroup.setVERSIONSTAMP(versionStamp);
        }

        //批量更新用户群组的删除标识和时间戳
        int updateCount = ctmUserGroupMapper.updateDelFlag(userGroupList, groupId);

        if(updateCount < 0){
            responseData.setStatus(ReturnStatus.ERR0004);
            responseData.setExtInfo("数据库更新失败");
            return responseData;
        }

        //删除对此群组的会话设置
        int deleteCount = ctmChatCfgMapper.deleteByObjectId(groupId);

        responseData.setStatus(ReturnStatus.OK);
        return responseData;
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
