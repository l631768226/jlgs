package hsoft.yfzx.jlgs.business.basic.dao;

import hsoft.yfzx.jlgs.business.basic.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserDao {
    /**
     * 根据用户名和密码查询用户信息表
     * @param userName 用户名
     * @param password 密码
     * @return 用户信息
     */
    @Select("select * from SYS_USER where LOGIN_NAME = #{userName} and PASSWORD = #{password}")
    SysUser login(@Param("userName") String userName, @Param("password") String password);

}
