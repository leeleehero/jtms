package com.jk.jtms.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wz")
public class MainController {

    @PostMapping("/main")
    public String main(){
        return "main";
    }

    @RequiresPermissions("wz:add")
    @GetMapping("add")
    public String addWz(){
        return "add";
    }


    @RequiresPermissions("wz:delete")
    @GetMapping("delete")
    public String delWz(){
        return "del";
    }


}
