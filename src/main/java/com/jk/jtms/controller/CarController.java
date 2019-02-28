package com.jk.jtms.controller;

import com.jk.jtms.entity.Car;
import com.jk.jtms.entity.CarDTO;
import com.jk.jtms.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
}
