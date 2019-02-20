package com.jk.jtms.controller;

import com.jk.jtms.comm.CommonResult;
import com.jk.jtms.entity.User;
import com.jk.jtms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author LITAO
 * @version V1.0
 * @Package com.jk.jtms.controller
 * @Title:
 * @Description:
 * @date 2019/2/19 14:25
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public CommonResult addUser(User user){
        try{
            user.setUsername("ll");
            user.setSfCode("111");
            user.setPhone("123");
            user.setSfCode("3218111");
            System.out.println(user.getSfCode());
            user.setName("litao");
            user.setEmail("110@qq.com");
            user.setPassword("123");
            return CommonResult.ok(userService.addUser(user));
        }catch (Exception e){
            return CommonResult.build(500, "注册失败");
        }
    }
}


    