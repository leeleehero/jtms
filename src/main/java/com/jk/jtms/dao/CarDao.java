package com.jk.jtms.dao;

import com.jk.jtms.entity.Car;
import com.jk.jtms.entity.CarDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarDao {
    /**
     * 获取车辆信息
     * @param carDTO
     * @return
     */
    List<Car> getCarInfo(@Param("carDTO") CarDTO carDTO);

    /**
     * 添加车辆信息
     * @param car
     * @return
     */
    Integer addCarInfo(@Param("car") Car car);
}
