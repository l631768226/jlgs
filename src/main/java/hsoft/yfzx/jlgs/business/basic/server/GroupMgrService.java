package hsoft.yfzx.jlgs.business.basic.server;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.*;
import hsoft.yfzx.jlgs.business.basic.dao.CtmUserGroupMapper;
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

import java.util.ArrayList;
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

    /**
     * 修改群组信息
     * @param uGroupRec
     * @return
     */
    public ResponseData<String> updateGroup(UGroupRec uGroupRec) {
        ResponseData<String> responseData = new ResponseData<>();
        // 判断要修改的群组是否存在并且状态正常
        List<Groupinfo> list = checkGroup(uGroupRec.getGroupId());
        if (list.isEmpty()) {
            responseData.setStatus(ReturnStatus.ERR0003);
            responseData.setExtInfo("修改的群组在数据库中不存在");
            return responseData;
        }
        // 添加修改历史
        Groupinfo oldGroupInfo = list.get(0);

        // 修改
        oldGroupInfo.setGROUPNAME(uGroupRec.getGroupName());
        oldGroupInfo.setINTRODUCE(uGroupRec.getIntroduce());
        oldGroupInfo.setNOTICE(uGroupRec.getNotice());
        oldGroupInfo.setPICID(uGroupRec.getPicId());
        oldGroupInfo.setVERSIONSTAMP(Generator.getLongTimeStamp());
        int updateCount = groupinfoMapper.updateByPrimaryKey(oldGroupInfo);
        if(updateCount < 0){
            responseData.setStatus(ReturnStatus.ERR0004);
            responseData.setExtInfo("数据库更新失败");
            return responseData;
        }
        responseData.setStatus(ReturnStatus.OK);
        return responseData;
    }

    /**
     * 根据群组id查询群组信息
     * @param qGroupDetailRec
     * @param userId
     * @return
     */
    public ResponseData<QGroupDetailRst> groupDetail(QGroupDetailRec qGroupDetailRec, String userId) {
        ResponseData<QGroupDetailRst> responseData = new ResponseData<>();
        //根据群组id查询群组信息
        List<Groupinfo> list = checkGroup(qGroupDetailRec.getGroupId());
        QGroupDetailRst qGroupDetailRst = new QGroupDetailRst();
        if (list.isEmpty()) {
            responseData.setStatus(ReturnStatus.ERR0003);
            responseData.setExtInfo("该群组在数据库中不存在");
            responseData.setResultSet(qGroupDetailRst);
            return responseData;
        }
        Groupinfo groupInfo = list.get(0);

        //设置返回参数
        qGroupDetailRst.setGroupId(groupInfo.getGROUPID());
        qGroupDetailRst.setGroupName(groupInfo.getGROUPNAME());
        qGroupDetailRst.setIntroduce(groupInfo.getINTRODUCE());
        qGroupDetailRst.setNotice(groupInfo.getNOTICE());
        qGroupDetailRst.setPicId(groupInfo.getPICID());
        qGroupDetailRst.setCreateTime(String.valueOf(groupInfo.getCREATETIME()));
        qGroupDetailRst.setVersionStamp(groupInfo.getVERSIONSTAMP().toString());

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qGroupDetailRst);
        return responseData;
    }

    /**
     * 查询某用户的群组列表
     * @param userId 用户id
     * @return
     */
    public ResponseData<List<QGroupMyListRst>> groupMyList(String userId) {
        ResponseData<List<QGroupMyListRst>> responseData = new ResponseData<>();
        // 根据用户id查询属于他的群组列表
        List<Groupinfo> userGroupList = ctmUserGroupMapper.findMyGroupList(userId);
        List<QGroupMyListRst> list = new ArrayList<>();
        // 复制数据返回
        for (Groupinfo groupinfo : userGroupList) {
            QGroupMyListRst qGroupMyListRst = new QGroupMyListRst();
            qGroupMyListRst.setGroupId(groupinfo.getGROUPID());
            qGroupMyListRst.setGroupName(groupinfo.getGROUPNAME());
            qGroupMyListRst.setPicId(groupinfo.getPICID());
            Long createTime = groupinfo.getCREATETIME();
            qGroupMyListRst.setCreateTime(createTime != null ?
                    String.valueOf(groupinfo.getCREATETIME()) : "");
            Long versionStamp = groupinfo.getVERSIONSTAMP();
            qGroupMyListRst.setVersionStamp(versionStamp != null ?
                    groupinfo.getVERSIONSTAMP().toString() : "");
            list.add(qGroupMyListRst);
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(list);
        return responseData;
    }
}
