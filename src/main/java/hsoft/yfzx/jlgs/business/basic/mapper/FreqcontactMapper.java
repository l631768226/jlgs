package hsoft.yfzx.jlgs.business.basic.mapper;

import hsoft.yfzx.jlgs.business.basic.model.Freqcontact;
import hsoft.yfzx.jlgs.business.basic.model.FreqcontactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FreqcontactMapper {
    long countByExample(FreqcontactExample example);

    int deleteByExample(FreqcontactExample example);

    int deleteByPrimaryKey(@Param("OWNERID") String OWNERID, @Param("USERID") String USERID);

    int insert(Freqcontact record);

    int insertSelective(Freqcontact record);

    List<Freqcontact> selectByExample(FreqcontactExample example);

    Freqcontact selectByPrimaryKey(@Param("OWNERID") String OWNERID, @Param("USERID") String USERID);

    int updateByExampleSelective(@Param("record") Freqcontact record, @Param("example") FreqcontactExample example);

    int updateByExample(@Param("record") Freqcontact record, @Param("example") FreqcontactExample example);

    int updateByPrimaryKeySelective(Freqcontact record);

    int updateByPrimaryKey(Freqcontact record);
}