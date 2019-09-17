package hsoft.yfzx.jlgs.business.im.mapper;

import hsoft.yfzx.jlgs.business.im.model.Chatstore;
import hsoft.yfzx.jlgs.business.im.model.ChatstoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatstoreMapper {
    long countByExample(ChatstoreExample example);

    int deleteByExample(ChatstoreExample example);

    int deleteByPrimaryKey(String CHATSTOREID);

    int insert(Chatstore record);

    int insertSelective(Chatstore record);

    List<Chatstore> selectByExampleWithBLOBs(ChatstoreExample example);

    List<Chatstore> selectByExample(ChatstoreExample example);

    Chatstore selectByPrimaryKey(String CHATSTOREID);

    int updateByExampleSelective(@Param("record") Chatstore record, @Param("example") ChatstoreExample example);

    int updateByExampleWithBLOBs(@Param("record") Chatstore record, @Param("example") ChatstoreExample example);

    int updateByExample(@Param("record") Chatstore record, @Param("example") ChatstoreExample example);

    int updateByPrimaryKeySelective(Chatstore record);

    int updateByPrimaryKeyWithBLOBs(Chatstore record);

    int updateByPrimaryKey(Chatstore record);
}