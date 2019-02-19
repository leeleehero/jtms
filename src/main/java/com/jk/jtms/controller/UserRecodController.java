package com.jk.jtms.controller;

import com.jk.jtms.comm.CommonResult;
import com.jk.jtms.service.UserRecodService;
import com.jk.jtms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class UserRecodController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRecodService userRecodService;

    @RequestMapping("/getUserJL")
    public CommonResult getUserJL(String id){
        try{
            List<Map<String,Object>> list = userService.getUserJL(id);
            return  CommonResult.ok(list);
        }catch (Exception e){
            return CommonResult.build(500, "没有信息");
        }
    }

    @RequestMapping("/getUserJLDetails")
    public  CommonResult getUserJLDetails(Integer pageNo, Integer pageSize, String carcode){

        try { pageNo = 1;
              pageSize = 2;
              carcode = "苏L12334";
            return CommonResult.ok(userRecodService.getUserDetails(pageNo, pageSize, carcode));
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.build(500, "查询失败");
        }
    }
}


    