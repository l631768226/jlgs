package hsoft.yfzx.jlgs.business.im.ctmmodel;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface CtmChatCfgMapper {

    /**
     * 根据聊天对象id删除会话设置
     * @param objectId
     * @return
     */
    @Delete("delete from CHATCFG where OBJECTID = #{objectId}")
    int deleteByObjectId(@Param("objectId") String objectId);

}
