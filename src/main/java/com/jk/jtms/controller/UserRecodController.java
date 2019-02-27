package com.jk.jtms.controller;


import com.jk.jtms.comm.CommonResult;
import com.jk.jtms.service.UserRecodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yh")
public class UserRecodController {
    @Autowired
    private UserRecodService userRecodService;

    //用户查询车辆违规细节
    @GetMapping("/getUserDetails")
    public CommonResult getUserDetails(int pageNo, int pageSize, String carcode,String status){
        try {
            return CommonResult.ok(userRecodService.getUserDetails(pageNo, pageSize, carcode,status));
        }catch (Exception e){
            return CommonResult.build(200, "查询错误");
        }
    }

    //用户查询违规次数单独车辆违规次数
    @GetMapping("/getCount")
    public CommonResult getCount(String xscode){
        try{
            return CommonResult.ok(userRecodService.getCount(xscode));
        }catch (Exception e){
            return CommonResult.build(200, "查询错误");
        }
    }

    //查询车牌
    @GetMapping("/getCarCode")
    public CommonResult getCarCode(String userid){
        try{
            return CommonResult.ok(userRecodService.getCarCode(userid));
        }catch (Exception e){
            return CommonResult.build(200, "车辆查询错误");
        }
    }

    //总分更具选中的状态车辆
    @GetMapping("/getScore")
    public CommonResult getScore(String status,String carcode){
        try{
            return CommonResult.ok(userRecodService.getScore(status, carcode));
        }catch (Exception e){
            return CommonResult.build(200, "车辆查询错误");
        }
    }


}


    