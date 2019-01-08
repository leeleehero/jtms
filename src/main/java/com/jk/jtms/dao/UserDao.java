package com.jk.jtms.dao;


import com.jk.jtms.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    /**
     * 用户注册
     * @param user
     * @return
     */
    int addUser(User user);

    int isExit(String name);

    List<Map<String,Object>> getUserJL(Map map);
}
