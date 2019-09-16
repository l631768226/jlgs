package hsoft.yfzx.jlgs.business.basic.mapper;

import hsoft.yfzx.jlgs.business.basic.model.Logininfo;
import hsoft.yfzx.jlgs.business.basic.model.LogininfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogininfoMapper {
    long countByExample(LogininfoExample example);

    int deleteByExample(LogininfoExample example);

    int deleteByPrimaryKey(String USERID);

    int insert(Logininfo record);

    int insertSelective(Logininfo record);

    List<Logininfo> selectByExample(LogininfoExample example);

    Logininfo selectByPrimaryKey(String USERID);

    int updateByExampleSelective(@Param("record") Logininfo record, @Param("example") LogininfoExample example);

    int updateByExample(@Param("record") Logininfo record, @Param("example") LogininfoExample example);

    int updateByPrimaryKeySelective(Logininfo record);

    int updateByPrimaryKey(Logininfo record);
}