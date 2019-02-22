package com.jk.jtms.service.Impl;

import com.jk.jtms.dao.UserDao;
import com.jk.jtms.entity.User;
import com.jk.jtms.service.UserService;
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
        user.setId(UUID.randomUUID().toString());
        Integer i = userDao.addUser(user);
        if(i==1){
            return "插入成功";
        }else{
            return "注册失败";
        }
    }
}
