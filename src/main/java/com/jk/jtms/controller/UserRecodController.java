package com.jk.jtms.controller;


import com.jk.jtms.comm.CommonResult;
import com.jk.jtms.entity.Wzss;
import com.jk.jtms.service.UserRecodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("yh")
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

    //违章总分更具选中的状态车辆
    @GetMapping("/getScore")
    public CommonResult getScore(String status,String carcode){
        try{
            return CommonResult.ok(userRecodService.getScore(status, carcode));
        }catch (Exception e){
            return CommonResult.build(200, "车辆查询错误");
        }
    }

    //查询自己的驾驶证信息
    @GetMapping("/getUserCredit")
    public CommonResult getUserCredit(String userid){
        try{
            return CommonResult.ok(userRecodService.getUserCredit(userid));
        }catch (Exception e){
            return CommonResult.build(200, "车辆查询错误");
        }
    }

    //单次违章信息
    @GetMapping("/getCarDetails")
    public CommonResult getCarDetails(String id){
        try{
            return CommonResult.ok(userRecodService.getCarDetails(id));
        }catch (Exception e){
            return CommonResult.build(200, "车辆查询错误");
        }
    }

    //发送申诉
    @GetMapping("/SendShengSu")
    public CommonResult SendShengSu(Wzss wzss){
        try{
            Integer i = userRecodService.sendShengSu(wzss);
            if (i==1){
                return CommonResult.ok("申请提交");
            }else{
                return CommonResult.ok("申请提交失败");
            }
        }catch (Exception e){
            return CommonResult.build(200, "申请提交失败");
        }
    }

    //查看自己的申诉
    @GetMapping("/getShengSu")
    public CommonResult getShengSu(String sfcode){
        try{
            return CommonResult.ok(userRecodService.getShenSu(sfcode));
        }catch (Exception e){
            return CommonResult.build(200, "申请提交失败");
        }
    }

}


    