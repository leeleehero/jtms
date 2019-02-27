package com.jk.jtms.service.Impl;

import com.jk.jtms.dao.UserDao;
import com.jk.jtms.entity.User;
import com.jk.jtms.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class UserServcieImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public String addUser(User user) {
        String pwd = user.getPassword();
        String salt = user.getUsername();
        //盐值加密三次 盐是用户名
        String str = new Md5Hash(pwd,salt,3).toString();
        user.setPassword(str);
        user.setSalt(salt);
        user.setRoleId("3cf9dd0d-6373-4458-8a72-7958113ae17b");
        Integer i = userDao.addUser(user);
        if(i==1){
            return "插入成功";
        }else{
            return "注册失败";
        }
    }

    @Override
    public String queryPwd(String username) {
        Integer i = userDao.queryPwd(username);
        if(i==1){
            return "密码正确";
        }else{
            return "密码错误";
        }
    }

    @Override
    public String updatePwd(String username, String pwd) {
        Integer i = userDao.updatePwd(username, pwd);
        if(i==1){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }
}
