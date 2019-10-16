package hsoft.yfzx.jlgs.business.basic.dao;

import hsoft.yfzx.jlgs.business.im.model.SysUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CtmSysUserDao {

    @Select("select * from SYS_USER")
    List<SysUser> findList();

}
