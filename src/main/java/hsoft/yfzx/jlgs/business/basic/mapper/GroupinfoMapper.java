package hsoft.yfzx.jlgs.business.basic.mapper;

import hsoft.yfzx.jlgs.business.basic.model.Groupinfo;
import hsoft.yfzx.jlgs.business.basic.model.GroupinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupinfoMapper {
    long countByExample(GroupinfoExample example);

    int deleteByExample(GroupinfoExample example);

    int deleteByPrimaryKey(String GROUPID);

    int insert(Groupinfo record);

    int insertSelective(Groupinfo record);

    List<Groupinfo> selectByExample(GroupinfoExample example);

    Groupinfo selectByPrimaryKey(String GROUPID);

    int updateByExampleSelective(@Param("record") Groupinfo record, @Param("example") GroupinfoExample example);

    int updateByExample(@Param("record") Groupinfo record, @Param("example") GroupinfoExample example);

    int updateByPrimaryKeySelective(Groupinfo record);

    int updateByPrimaryKey(Groupinfo record);
}