package hsoft.yfzx.jlgs.business.basic.dao;

import hsoft.yfzx.jlgs.business.basic.model.Groupinfo;
import hsoft.yfzx.jlgs.business.basic.model.Usergroup;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CtmUserGroupMapper {

    /**
     * 批量更新 群组用户表 的删除标识和时间戳
     * @param usergroupList 群组用户表
     * @param groupId 群组id
     * @return
     */
    @Update({
            "<script>",
            "update USERGROUP ",
            "<foreach collection = 'userGroupList' item = 'userGroup' index = 'index' separator = ','>",
            "set DELFLAG = #{userGroup.DELFLAG}, VERSIONSTAMP = #{userGroup.VERSIONSTAMP} ",
            "</foreach>",
            " where GROUPID = #{groupId} ",
            "</script>"
    })
    int updateDelFlag(@Param(value = "userGroupList") List<Usergroup> usergroupList, @Param("groupId") String groupId);

    /**
     * 根据用户id查询属于他的群组信息
     * @param userId 用户id
     * @return
     */
    @Select("select B.* from USERGROUP A, GROUPINFO B where A.GROUPID = B.GROUPID and A.USERID = #{userId}")
    List<Groupinfo> findMyGroupList(@Param("userId") String userId);

}
