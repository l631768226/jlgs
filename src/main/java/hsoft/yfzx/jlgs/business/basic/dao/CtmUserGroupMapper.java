package hsoft.yfzx.jlgs.business.basic.dao;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.CtmGroupUser;
import hsoft.yfzx.jlgs.business.basic.ctmmodel.QUserGroupListRst;
import hsoft.yfzx.jlgs.business.basic.model.Groupinfo;
import hsoft.yfzx.jlgs.business.basic.model.Usergroup;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CtmUserGroupMapper {

    /**
     * 批量更新 群组用户表 的删除标识和时间戳
     * @param versionStamp 版本时间戳
     * @param groupId 群组id
     * @return
     */
//    @Update({
//            "<script>",
//            "update USERGROUP ",
//            "<foreach collection = 'userGroupList' item = 'userGroup' index = 'index' separator = ','>",
//            "set DELFLAG = #{userGroup.DELFLAG}, VERSIONSTAMP = #{userGroup.VERSIONSTAMP} ",
//            "</foreach>",
//            " where GROUPID = #{groupId} ",
//            "</script>"
//    })
    @Update("update USERGROUP set DELFLAG = 1, VERSIONSTAMP = #{versionStamp} where GROUPID = #{groupId}")
    int updateDelFlag(@Param("groupId") String groupId, @Param("versionStamp")Long versionStamp);

    /**
     * 根据用户id查询属于他的群组信息
     * @param userId 用户id
     * @return
     */
    @Select("select B.* from USERGROUP A, GROUPINFO B where A.GROUPID = B.GROUPID and A.USERID = #{userId} " +
            "ORDER BY B.SORT ASC")
    List<Groupinfo> findMyGroupList(@Param("userId") String userId);

    /**
     * 根据群组id和搜索条件模糊查询群组内成员信息
     * @param groupId
     * @param searchRule
     * @return
     */
    @Select("SELECT A.*, B.REALNAME realName, A.USER_LEVEL \"level\", B.PICID picId " +
            "FROM \"USERGROUP\" A ,LOGININFO B " +
            "WHERE A.GROUPID = #{groupId} and A.USERID = B.USERID " +
            "and B.REALNAME like '%${searchRule}%' order by A.CREATETIME ASC ")
    List<QUserGroupListRst> selectGroupUser(@Param("groupId") String groupId, @Param("searchRule") String searchRule);



    @Select("select * from "

            + "(select AA.*, ROWNUM AS rowno from "

            + "(SELECT A.*, B.REALNAME realName, A.USER_LEVEL \"level\", B.PICID picId " +
            " FROM \"USERGROUP\" A ,LOGININFO B " +
            " WHERE A.GROUPID = #{groupId} and A.USERID = B.USERID " +
            " and B.REALNAME like '%${searchRule}%' order by A.CREATETIME ASC ) AA "

            + "where ROWNUM <= ${end}) AAA "

            + "where AAA.rowno > ${start}")
    List<QUserGroupListRst> selectGroupUserPage(@Param("groupId") String groupId, @Param("searchRule") String searchRule,
                                                @Param("start")int start, @Param("end")int end);


    /**
     * 根据条件查询某人的群组
     * @param userId 用户id
     * @param condition 查询条件
     * @return
     */
    @Select("select * from GROUPINFO where GROUPID in (select GROUPID from \"USERGROUP\" where USERID =  #{userId}) and GROUPNAME like '%${condition}%'")
    List<Groupinfo> selectGroupByCondition(@Param("userId") String userId, @Param("condition") String condition);

    /**
     * 根据用户id和群组id查询群组人员关系表
     * @param userId 用户id
     * @param groupId 群组id
     * @return
     */
    @Select("select * from \"USERGROUP\" where USERID = #{userId} and GROUPID = #{groupId}")
    Usergroup findByUserIdGroupId(@Param("userId") String userId, @Param("groupId") String groupId);

    /**
     * 根据群组id获取用户id列表
     *
     * @param groupId
     *        群组id
     * @return
     */
    @Select("select USERID from \"USERGROUP\" where GROUPID = #{groupId}")
    List<String> queryUserId(@Param("groupId") String groupId);


    @Delete("delete from \"USERGROUP\" where GROUPID = #{groupId}")
    int deleteByGroupId(@Param("groupId") String groupId);
}
