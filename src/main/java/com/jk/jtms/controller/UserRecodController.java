package com.jk.jtms.controller;


import com.jk.jtms.comm.CommonResult;
import com.jk.jtms.service.UserRecodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yh")
public class UserRecodController {
    @Autowired
    private UserRecodService userRecodService;

    //用户查询车辆违规细节
    @PostMapping("/getUserDetails")
    public CommonResult getUserDetails(int pageNo, int pageSize, String carcode){
        try {
            return CommonResult.ok(userRecodService.getUserDetails(pageNo, pageSize, carcode));
        }catch (Exception e){
            return CommonResult.build(200, "查询错误");
        }
    }

    //用户查询违规次数
    @PostMapping("/getCount")
    public CommonResult getCount(String xscode){
        try{
            return CommonResult.ok(userRecodService.getCount(xscode));
        }catch (Exception e){
            return CommonResult.build(200, "查询错误");
        }

    }
}


    