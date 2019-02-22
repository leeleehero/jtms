package com.jk.jtms.service;

import com.jk.jtms.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);


    String addUser(User user);
}
