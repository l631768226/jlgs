package hsoft.yfzx.jlgs.business.basic.mapper;

import hsoft.yfzx.jlgs.business.basic.model.Freqgroup;
import hsoft.yfzx.jlgs.business.basic.model.FreqgroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FreqgroupMapper {
    long countByExample(FreqgroupExample example);

    int deleteByExample(FreqgroupExample example);

    int deleteByPrimaryKey(@Param("OWNERID") String OWNERID, @Param("GROUPID") String GROUPID);

    int insert(Freqgroup record);

    int insertSelective(Freqgroup record);

    List<Freqgroup> selectByExample(FreqgroupExample example);

    Freqgroup selectByPrimaryKey(@Param("OWNERID") String OWNERID, @Param("GROUPID") String GROUPID);

    int updateByExampleSelective(@Param("record") Freqgroup record, @Param("example") FreqgroupExample example);

    int updateByExample(@Param("record") Freqgroup record, @Param("example") FreqgroupExample example);

    int updateByPrimaryKeySelective(Freqgroup record);

    int updateByPrimaryKey(Freqgroup record);
}