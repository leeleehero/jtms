package com.jk.jtms.service.Impl;


import com.jk.jtms.dao.UserDao;
import com.jk.jtms.entity.User;
import com.jk.jtms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public int addUserService(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int isExit(String name) {
        return userDao.isExit(name);
    }

    @Override
    public List<Map<String, Object>> getUserJL(String id) {
        Map<String,Object> map =new HashMap<>(8);
        map.put("id", id);
        return userDao.getUserJL(map);
    }
}


    