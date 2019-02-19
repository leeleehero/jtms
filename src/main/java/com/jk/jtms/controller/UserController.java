package com.jk.jtms.controller;


import com.jk.jtms.comm.CommonResult;
import com.jk.jtms.entity.User;
import com.jk.jtms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public CommonResult addUser(){
        User user = new User();
        user.setId("3");
        user.setEmail("@qq.com");
        user.setName("litao");
        user.setPassword("123456");
        user.setPhone("110");
        user.setSfCode("321181199610203797");
        user.setUsername("lt3");
        if (userService.isExit(user.getUsername()) < 1){
            if (userService.addUserService(user) == 1){
                return CommonResult.ok("注册成功");
            }else{
                return CommonResult.build(500, "注册失败");
            }
        }else {
            return CommonResult.build(500, "用户名已存在");
        }
    }

}


    