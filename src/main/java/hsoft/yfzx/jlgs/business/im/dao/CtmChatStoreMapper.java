package hsoft.yfzx.jlgs.business.im.dao;

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
    @Select("select * from CHATSTORE where OBJECTTYPE = #{objectType} and RECEID = #{receId} and SENDTIME < #{sendTime}"
            + " and SENDTIME > #{createTime} order by SENDTIME desc ")
    List<Chatstore> queryGroupChatStoreInfo(@Param("objectType") String objectType, @Param("receId") String receId,
                                            @Param("sendTime") BigDecimal sendTime, @Param("createTime") Long createTime);


    /**
     * 根据聊天对象id获取某时间之前的聊天记录
     * @param senderId 自己的用户id
     * @param receId
     * @param sendTime
     * @return
     */
    @Select("select * from CHATSTORE where (SENDERID = #{senderId} and RECEID = #{receId}" + "or SENDERID = #{receId} and RECEID = #{senderId})"
            + "and SENDTIME < #{sendTime} order by SENDTIME desc ")
    List<Chatstore> queryChatStore(@Param("senderId") String senderId, @Param("receId") String receId, @Param("sendTime") BigDecimal sendTime);


    /**
     * 根据发送人和接收人id查询最新的聊天记录
     * @param senderId
     * @param receId
     * @return
     */
    @Select("SELECT " +
            "	A.*, C.REALNAME `NAME`,  C.PICID, B.REALNAME `OBJECTNAME`, B.PICID `OBJECTPICID` " +
            "FROM " +
            "	CHATSTORE A, LOGININFO B, LOGININFO C WHERE B.USERID = #{receId} " +
            "AND ( " +
            "	SENDERID = #{senderId} " +
            "	AND RECEID = #{receId} " +
            "	OR RECEID = #{senderId} " +
            "	AND SENDERID = #{receId} " +
            ") " +
            "AND SENDTIME = ( " +
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
            "AND SENDTIME = ( " +
            "	SELECT " +
            "		MAX(SENDTIME) " +
            "	FROM " +
            "		CHATSTORE " +
            "	WHERE " +
            "		RECEID = #{receId} and SENDTIME < #{versionStamp} and SENDTIME > #{createTime}" +
            ") AND C.USERID = A.SENDERID " )
    List<CtmLastChatStore> queryNewestGroupChat(@Param("receId") String receId,
                                                @Param("versionStamp")BigDecimal versionStamp, @Param("createTime") Long createTime);

}
