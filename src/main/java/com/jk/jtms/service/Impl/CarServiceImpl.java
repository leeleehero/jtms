package com.jk.jtms.service.Impl;

import com.jk.jtms.dao.CarDao;
import com.jk.jtms.entity.Car;
import com.jk.jtms.entity.CarDTO;
import com.jk.jtms.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    /**
     * 查询车辆信息
     * @param carDTO
     * @return
     */
    @Override
    public List<Car> getCarInfo(CarDTO carDTO) {
        return carDao.getCarInfo(carDTO);
    }

    @Override
    public Integer addCarInfo(Car car) {
        return null;
    }

    @Override
    public String getUserId(String carcode) {
        return carDao.getUserId(carcode);
    }

    @Override
    public String getWzType(String type) {
        return carDao.getWzType(type);
    }

    @Override
    public Integer addTypeDetails(Map map) {
        return carDao.addTypeDetails(map);
    }
}
