package com.jk.jtms.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wz")
public class MainController {
    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequiresPermissions("wz:add")
    @RequestMapping("add")
    public String addWz(){
        return "add";
    }

    @RequiresPermissions("wz:delete")
    @RequestMapping("delete")
    public String delWz(){
        return "del";
    }


}
