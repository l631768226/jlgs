package hsoft.yfzx.jlgs.business.im.dao;

import hsoft.yfzx.jlgs.business.im.ctmmodel.CtmChatStore;
import hsoft.yfzx.jlgs.business.im.ctmmodel.CtmLastChatStore;
import hsoft.yfzx.jlgs.business.im.model.Chatstore;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

public interface CtmChatStoreMapper {

    /**
     * 根据群組id获取某时间之前的聊天记录
     *
     * @param objectType
     * @param receId
     * @param sendTime
     * @param createTime
     * @return
     */
    @Select("select * from (select * from CHATSTORE where OBJECTTYPE = #{objectType} and RECEID = #{receId} and SENDTIME < #{sendTime}"
            + " and SENDTIME > #{createTime} order by SENDTIME desc) where ROWNUM <= ${account} ")
    List<Chatstore> queryGroupChatStoreInfo(@Param("objectType") String objectType, @Param("receId") String receId,
                                            @Param("sendTime") BigDecimal sendTime,
                                            @Param("createTime") Long createTime, @Param("account") int account);


    /**
     * 根据聊天对象id获取某时间之前的聊天记录
     * @param senderId 自己的用户id
     * @param receId
     * @param sendTime
     * @return
     */
    @Select("select * from (select * from CHATSTORE where (SENDERID = #{senderId} and RECEID = #{receId}" + "or SENDERID = #{receId} and RECEID = #{senderId})"
            + "and SENDTIME < #{sendTime} order by SENDTIME desc) where ROWNUM <= ${account} ")
    List<Chatstore> queryChatStore(@Param("senderId") String senderId, @Param("receId") String receId,
                                   @Param("sendTime") BigDecimal sendTime, @Param("account") int account);


    /**
     * 根据发送人和接收人id查询最新的聊天记录
     * @param senderId
     * @param receId
     * @return
     */
    @Select("SELECT " +
            "	A.*, C.REALNAME \"NAME\",  C.PICID, B.REALNAME \"OBJECTNAME\", B.PICID \"OBJECTPICID\" " +
            "FROM " +
            "	CHATSTORE A, LOGININFO B, LOGININFO C WHERE B.USERID = #{receId} " +
            "AND ( " +
            "	A.SENDERID = #{senderId} " +
            "	AND A.RECEID = #{receId} " +
            "	OR A.RECEID = #{senderId} " +
            "	AND A.SENDERID = #{receId} " +
            ") " +
            "AND A.SENDTIME = ( " +
            "	SELECT " +
            "		max(SENDTIME) " +
            "	FROM " +
            "		CHATSTORE " +
            "	WHERE " +
            "		SENDERID = #{senderId} " +
            "	AND RECEID = #{receId} " +
            "	OR RECEID = #{senderId} " +
            "	AND SENDERID = #{receId} " +
            ")" +
            "AND C.USERID = A.SENDERID")
    List<CtmLastChatStore> queryNewestChat(@Param("senderId") String senderId, @Param("receId") String receId);


    /**
     * 查询某群组的最新一条会话消息
     * @param receId 群组id
     * @return
     */
    @Select("SELECT " +
            "	A.*, C.REALNAME `NAME`, C.PICID, B.GROUPNAME `OBJECTNAME`, B.PICID `OBJECTPICID` " +
            "FROM " +
            "	CHATSTORE A, GROUPINFO B, LOGININFO C where A.RECEID = #{receId} " +
            "AND A.RECEID = B.GROUPID " +
            "AND A.SENDTIME = ( " +
            "	SELECT " +
            "		MAX(SENDTIME) " +
            "	FROM " +
            "		CHATSTORE " +
            "	WHERE " +
            "		RECEID = #{receId} and SENDTIME < #{versionStamp} and SENDTIME > #{createTime}" +
            ") AND C.USERID = A.SENDERID " )
    List<CtmLastChatStore> queryNewestGroupChat(@Param("receId") String receId,
                                                @Param("versionStamp")BigDecimal versionStamp, @Param("createTime") Long createTime);


    /**
     * 根据聊天记录id查询单人会话详情
     * @param chatStoreId
     * @return
     */
    @Select("select A.*, B.PICID as PICID from CHATSTORE A " + "INNER JOIN LOGININFO B on A.OBJECTTYPE = 0 " +
            "and A.CHATSTOREID = #{chatStoreId} "
            + "and B.USERID = A.SENDERID order by A.SENDTIME desc")
    CtmChatStore queryDetailByUserId(@Param("chatStoreId") String chatStoreId);

    /**
     * 根据聊天记录id查询群组会话详情
     * @param chatStoreId
     * @return
     */
    @Select("select A.*, B.PICID as PICID from CHATSTORE A " + "INNER JOIN LOGININFO B on A.OBJECTTYPE = 1 and A.CHATSTOREID = #{chatStoreId} "
            + "and A.SENDERID = B.USERID order by A.SENDTIME desc")
    CtmChatStore queryDetailByGroupId(@Param("chatStoreId") String chatStoreId);

    /**
     * 根据userId和对方id获取最新一条聊天记录
     * @param userId
     * @param objectId
     * @return
     */
    @Select("select A.*, B.PICID from chatStore A INNER JOIN LOGININFO B on A.senderId = B.userId and "
            + "A.sendTime = (select max(sendTime) from chatStore " + "where senderId = #{userId} and receId = #{objectId} "
            + "or receId = #{userId} and senderId = #{objectId} )")
    List<CtmChatStore> queryLastByUserId(@Param("userId") String userId, @Param("objectId") String objectId);


    /**
     * 根据userId和群组id获取最后一条聊天记录
     * @param userId 用户id
     * @param objectId 群组id
     * @param versionStamp 时间戳(当前时间或被移出群组的时间)
     * @return
     */
    @Select("select A.*, B.PICID from CHATSTORE A INNER JOIN LOGININFO B on A.SENDERID = B.USERID "
            + "and A.SENDTIME = (select max(SENDTIME) from CHATSTORE where RECEID = #{objectId} and SENDTIME < #{versionStamp}"
            + " and SENDTIME > #{createTime})")
    CtmChatStore queryLastByGroupId(@Param("userId") String userId, @Param("objectId") String objectId,
                                    @Param("versionStamp") BigDecimal versionStamp, @Param("createTime") Long createTime);

}
