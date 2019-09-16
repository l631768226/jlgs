package hsoft.yfzx.jlgs.business.basic.mapper;

import hsoft.yfzx.jlgs.business.basic.model.Usergroup;
import hsoft.yfzx.jlgs.business.basic.model.UsergroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsergroupMapper {
    long countByExample(UsergroupExample example);

    int deleteByExample(UsergroupExample example);

    int deleteByPrimaryKey(@Param("GROUPID") String GROUPID, @Param("USERID") String USERID);

    int insert(Usergroup record);

    int insertSelective(Usergroup record);

    List<Usergroup> selectByExample(UsergroupExample example);

    Usergroup selectByPrimaryKey(@Param("GROUPID") String GROUPID, @Param("USERID") String USERID);

    int updateByExampleSelective(@Param("record") Usergroup record, @Param("example") UsergroupExample example);

    int updateByExample(@Param("record") Usergroup record, @Param("example") UsergroupExample example);

    int updateByPrimaryKeySelective(Usergroup record);

    int updateByPrimaryKey(Usergroup record);
}