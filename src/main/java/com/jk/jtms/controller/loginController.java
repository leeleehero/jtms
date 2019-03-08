package com.jk.jtms.controller;

import com.jk.jtms.comm.CharacterUtil;
import com.jk.jtms.comm.CommonResult;
import com.jk.jtms.comm.EmailUtil;
import com.jk.jtms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
@CrossOrigin
@ResponseBody
@RequestMapping("/")
public class loginController {

    @Autowired
    private UserService userService;

    String authCode = null;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param rememberme
     * @param code
     * @return
     */
    @PostMapping(value = "/login")
    public CommonResult login(String username, String password, String rememberme,String code) {
        if(!code.equals(authCode)){
            return CommonResult.build(500,"验证码错误");
        }
        Subject subject = SecurityUtils.getSubject();
        boolean isRemember = "rememberme".equals(rememberme);
        String msg = null;
        System.out.println(isRemember+"************************");
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(isRemember);
            try {
                subject.login(token);
            } catch (AuthenticationException e) {
                if (UnknownAccountException.class.getName().equals(e.getClass().getName())) {
                    //最终会抛给异常处理器
                    msg = "账号不存在";
                    System.out.println("账号不存在");
                } else if (IncorrectCredentialsException.class.getName().equals(e.getClass().getName())) {
                    msg = "用户名/密码错误";
                    System.out.println("用户名/密码错误");
                } else {
                    //最终在异常处理器生成未知错误.
                    e.printStackTrace();
                    msg = "其他错误";
                    System.out.println("其他异常信息");
                }
                return CommonResult.build(500, msg);
        }
        }
        return CommonResult.ok(200);
    }

    /**
     * 获取登录验证码
     * @param username
     * @return
     */
    @GetMapping("/getAuthCode")
    public CommonResult loginAuth(String username){
        String email = userService.getUserEmail(username);
        authCode = CharacterUtil.getCode();
        System.out.println(email+"--------------");
        try {
            EmailUtil.send_mail(email,authCode,username);
            return CommonResult.build(200,"验证码发送成功");
        } catch (MessagingException e) {
            e.printStackTrace();
            return CommonResult.build(500,"验证码发送失败");
        }
    }
}
