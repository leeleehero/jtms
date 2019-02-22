package com.jk.jtms.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class loginController {

    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response,Model model) {
        Subject subject = SecurityUtils.getSubject();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            if (UnknownAccountException.class.getName().equals(e.getClass().getName())) {
                //最终会抛给异常处理器
                model.addAttribute("msg", "账号不存在");
                System.out.println("账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(e.getClass().getName())) {
                model.addAttribute("msg", "用户名/密码错误");
                System.out.println("用户名/密码错误");
            } else {
                //最终在异常处理器生成未知错误.
                e.printStackTrace();
                model.addAttribute("msg", "其他异常信息");
                System.out.println("其他异常信息");
            }
            return "index";
        }
        return "main";
    }
}
