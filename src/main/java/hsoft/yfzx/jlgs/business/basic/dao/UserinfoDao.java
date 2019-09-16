package hsoft.yfzx.jlgs.business.basic.dao;

import hsoft.yfzx.jlgs.business.basic.model.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserinfoDao {
    /**
     * 根据用户名和密码查询用户信息表
     * @param userName 用户名
     * @param password 密码
     * @return 用户信息
     */
    @Select("select * from userInfo where userName = #{userName} and password = #{password}")
    Userinfo login(@Param("userName") String userName, @Param("password") String password);

}
