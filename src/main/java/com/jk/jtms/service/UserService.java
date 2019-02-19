package com.jk.jtms.service;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    Map<String,Object> getUserByUsername(String username);
}
