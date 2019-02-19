package com.jk.jtms.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {

    /**
     * 根据用户名获取用户信息
     * @return
     */
    Map<String,Object> getUserByUsername(@Param("username") String username);
}
