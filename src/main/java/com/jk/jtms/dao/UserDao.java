package com.jk.jtms.dao;

import com.jk.jtms.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {

    /**
     * 根据用户名获取用户信息
     * @return
     */
    User getUserByUsername(@Param("username") String username);

    Integer addUser(User user);

    Integer queryPwd(@Param("username")String username,@Param("password")String password);

    Integer updatePwd(@Param("username") String username,@Param("pwd") String pwd);

    Integer addUserCried(Map map);

    String getUserEmail(@Param("username") String username);
}
