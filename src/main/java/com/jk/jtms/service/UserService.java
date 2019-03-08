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


    /**
     * 添加用户
     * @param user
     * @return
     */
    String addUser(User user);

    /**
     * 查询密码
     * @param username
     * @return
     */
    String queryPwd(String username,String password,String pwd);

    /**
     * 更新密码
     * @param username
     * @param pwd
     * @return
     */
    String updatePwd(String username,String pwd);

    /**
     * 查询用户邮箱信息
     * @param username
     * @return
     */
    String getUserEmail(String username);
}
