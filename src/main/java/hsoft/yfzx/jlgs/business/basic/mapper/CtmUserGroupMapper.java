package hsoft.yfzx.jlgs.business.basic.mapper;

import hsoft.yfzx.jlgs.business.basic.model.Usergroup;
import org.apache.ibatis.annotations.Param;
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
}
