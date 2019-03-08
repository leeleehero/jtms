package com.jk.jtms.service.Impl;

import com.jk.jtms.dao.UserDao;
import com.jk.jtms.entity.User;
import com.jk.jtms.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.jar.JarEntry;

@Service
public class UserServcieImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    @Transactional
    public String addUser(User user) {
//        user.setUsername("xiaoming1");
//        user.setSfCode("111");
//        user.setPhone("123");
//        user.setSfCode("321181199610203791117");
//        user.setName("leeeleee");
//        user.setEmail("110@qq.com");
//        user.setPassword("123456");
//        user.setId("321181199610203111712313197");
        String pwd = user.getPassword();
        String salt = user.getUsername();
        user.setId(user.getSfcode());
        //盐值加密三次 盐是用户名
        String str = new Md5Hash(pwd,salt,3).toString();
        Map<String,Object> map = new HashMap<>();
        map.put("userid", user.getId());
        map.put("creditnum", "12");
        map.put("id", UUID.randomUUID().toString());
        map.put("jz_code", "xsz"+UUID.randomUUID().toString());
        user.setPassword(str);
        user.setSalt(salt);
        user.setRoleId("3cf9dd0d-6373-4458-8a72-7958113ae17b");
        Integer i = userDao.addUser(user);
        userDao.addUserCried(map);
        if(i==1){
            return "插入成功";
        }else{
            return "注册失败";
        }
    }

    @Override
    public String queryPwd(String username,String password,String pwd) {
        String str = new Md5Hash(pwd,username,3).toString();
        Integer i = userDao.queryPwd(username,password);
        Integer j = userDao.updatePwd(username, str);
        if(i==1&&j==1){
            return "密码正确";
        }else{
            return "密码错误";
        }
    }

    @Override
    public String updatePwd(String username, String pwd) {
        String str = new Md5Hash(pwd,username,3).toString();
        Integer i = userDao.updatePwd(username, str);
        if(i==1){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    @Override
    public String getUserEmail(String username) {
        return userDao.getUserEmail(username);
    }
}
