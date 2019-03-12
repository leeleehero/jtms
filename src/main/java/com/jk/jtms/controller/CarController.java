package com.jk.jtms.controller;

import com.jk.jtms.comm.CommonResult;
import com.jk.jtms.entity.Car;
import com.jk.jtms.entity.CarDTO;
import com.jk.jtms.service.CarService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@ResponseBody
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/getCarInfo")
    public List<Car> getCarInfo(CarDTO carDTO){
        return carService.getCarInfo(carDTO);
    }

    @GetMapping("/addCar")
    public CommonResult addCar(CarDTO carDTO){
        try{
            return CommonResult.ok(carService.addCarInfo(carDTO));
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.build(500, "插入错误");
        }
    }

    @PostMapping("/deleteCar")
    public CommonResult deleteCar(String xscode){
        try{
            return CommonResult.ok(carService.deleteCar(xscode));
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.build(500, "插入错误");
        }
    }

    @PostMapping("/updateCar")
    public CommonResult updateCar(String xsCode ,String xscode){
        try{
            return CommonResult.ok(carService.updateCar(xsCode, xscode));
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.build(500, "插入错误");
        }
    }

    @GetMapping("/getCarList")
    public CommonResult getCarList(int pageNo, int pageSize){
        try{
            return CommonResult.ok(carService.getCarList(pageSize,pageNo));
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.build(500, "查询错误");
        }
    }
}
