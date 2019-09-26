package hsoft.yfzx.jlgs.business.im.dao;

import hsoft.yfzx.jlgs.business.im.ctmmodel.CtmChatCfg;
import hsoft.yfzx.jlgs.business.im.model.Chatcfg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CtmChatCfgMapper {

    /**
     * 根据用户id和对象id删除会话设置
     * @param userId 用户id
     * @param objectId 对象id
     * @return
     */
    @Delete("delete from CHATCFG where USERID = #{userId} and OBJECTID = #{objectId}")
    int delChatCfg(@Param("userId") String userId, @Param("objectId") String objectId);

    /**
     * 根据聊天对象id删除会话设置
     * @param objectId
     * @return
     */
    @Delete("delete from CHATCFG where OBJECTID = #{objectId}")
    int deleteByObjectId(@Param("objectId") String objectId);

    /**
     * 根据主人id和对象id查询会话设置
     * @param objectId 对象id
     * @param userId 主人id
     * @return
     */
    @Select("select * from CHATCFG where OBJECTID = #{objectId} and USERID = #{userId}")
    List<Chatcfg> findByObjectId(@Param("objectId") String objectId, @Param("userId") String userId);

    /**
     * 更新会话设置
     * @param topStatus 置顶
     * @param undisturbed 免打扰
     * @param userId 用户id
     * @param objectId 对象id
     * @return
     */
    @Update("update CHATCFG set TOPSTATUS = #{topStatus}, UNDISTURBED = #{undisturbed} "
            + "where USERID = #{userId} and OBJECTID = #{objectId}")
    int updateById(@Param("topStatus") String topStatus, @Param("undisturbed") String undisturbed,
                   @Param("userId") String userId, @Param("objectId") String objectId);


    /**
     * 根据条件关联人员表或群组表获取某人的会话设置
     * @param userId 用户id
     * @return
     */
    @Select("select * from ("
            + "select A.*, "
            + "\"DECODE\"(A.OBJECTTYPE, 0, B.PICID, C.PICID) as PICID, "
            + "\"DECODE\"(A.OBJECTTYPE, 0, B.REALNAME, C.GROUPNAME) as NAME "
            + "from CHATCFG A "
            + "LEFT JOIN LOGININFO B on (A.OBJECTTYPE = 0 and A.OBJECTID = B.USERID) "
            + "LEFT JOIN GROUPINFO C on (A.OBJECTTYPE = 1 and A.OBJECTID = C.GROUPID) ) D"
            + " where D.USERID = #{userId}")
    List<CtmChatCfg> queryByUserId(@Param("userId")String userId);


    /**
     * 根据条件关联人员表或群组表，获取某人在某时间戳之后的会话设置
     * @param uesrId
     * @param versionStamp
     * @return
     */
    @Select("select * from ("
            + "select A.*,"
            + "\"DECODE\"(A.OBJECTTYPE, 0, B.PICID, C.PICID) as PICID,"
            + "\"DECODE\"(A.OBJECTTYPE, 0, B.REALNAME, C.GROUPNAME) as NAME "
            + "from CHATCFG A "
            + "LEFT JOIN LOGININFO B on (A.OBJECTTYPE = 0 and A.OBJECTID = B.USERID) "
            + "LEFT JOIN GROUPINFO C on (A.OBJECTTYPE = 1 and A.OBJECTID = C.GROUPID) ) D "
            + "where D.USERID = #{userId} and D.VERSIONSTAMP > #{versionStamp} "
            + "order by D.VERSIONSTAMP desc")
    List<CtmChatCfg> queryListByIdAndVersion(@Param("userId") String uesrId,
                                             @Param("versionStamp") String versionStamp);

}
