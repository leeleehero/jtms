package com.jk.jtms.controller;

import com.jk.jtms.comm.CommonResult;
import com.jk.jtms.entity.User;
import com.jk.jtms.service.UserService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.shiro.crypto.hash.Md5Hash;
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
@CrossOrigin
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public CommonResult addUser(User user){
        try{
            return CommonResult.ok(userService.addUser(user));
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.build(500, e.getMessage()+"注册失败");
        }
    }

    @PostMapping("/queryPwd")
    public CommonResult queryPwd(String username,String password,String pwd){
        try{
            return CommonResult.ok(userService.queryPwd(username,password,pwd));
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.build(500, "旧密码错误");
        }
    }

    @PostMapping("/updatePwd")
    public CommonResult updatePwd(String username,String pwd){
        try{
            return CommonResult.ok(userService.updatePwd(username, pwd));
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.build(500, "修改失败");
        }
    }
}


    