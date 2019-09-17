package hsoft.yfzx.jlgs.business.im.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

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
}
