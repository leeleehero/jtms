package com.jk.jtms.service.Impl;

import com.jk.jtms.dao.UserDao;
import com.jk.jtms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServcieImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Map<String, Object> getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
