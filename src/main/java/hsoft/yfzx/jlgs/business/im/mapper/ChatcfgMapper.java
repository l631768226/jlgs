package hsoft.yfzx.jlgs.business.im.mapper;

import hsoft.yfzx.jlgs.business.im.model.Chatcfg;
import hsoft.yfzx.jlgs.business.im.model.ChatcfgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatcfgMapper {
    long countByExample(ChatcfgExample example);

    int deleteByExample(ChatcfgExample example);

    int deleteByPrimaryKey(String CHATCFGID);

    int insert(Chatcfg record);

    int insertSelective(Chatcfg record);

    List<Chatcfg> selectByExample(ChatcfgExample example);

    Chatcfg selectByPrimaryKey(String CHATCFGID);

    int updateByExampleSelective(@Param("record") Chatcfg record, @Param("example") ChatcfgExample example);

    int updateByExample(@Param("record") Chatcfg record, @Param("example") ChatcfgExample example);

    int updateByPrimaryKeySelective(Chatcfg record);

    int updateByPrimaryKey(Chatcfg record);
}