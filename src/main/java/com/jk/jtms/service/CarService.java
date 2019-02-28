package com.jk.jtms.service;

import com.jk.jtms.entity.Car;
import com.jk.jtms.entity.CarDTO;

import java.util.List;

public interface CarService {
    /**
     * 查询车辆信息
     * @param carDTO
     * @return
     */
    List<Car> getCarInfo(CarDTO carDTO);

    /**
     * 新增车辆信息
     * @param car
     * @return
     */
    Integer addCarInfo(Car car);
}
