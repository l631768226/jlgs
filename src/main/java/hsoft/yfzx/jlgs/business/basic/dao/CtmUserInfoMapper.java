package hsoft.yfzx.jlgs.business.basic.dao;

import hsoft.yfzx.jlgs.business.basic.model.Logininfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CtmUserInfoMapper {

    /**
     * 根据姓名模糊查询用户信息
     * @param condition
     * @return
     */
    @Select("select * from LOGININFO where REALNAME like '%${condition}%'")
    List<Logininfo> selectUserByCondition(@Param("condition") String condition);

}
