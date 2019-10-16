package hsoft.yfzx.jlgs.business.basic.dao;

import hsoft.yfzx.jlgs.business.basic.model.Logininfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CtmLogininfoMapper {

    @Select("select * from LOGININFO")
    List<Logininfo> findList();
}
