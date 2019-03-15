package com.jk.jtms.service.Impl;

import com.jk.jtms.comm.PageUtil;
import com.jk.jtms.dao.CarDao;
import com.jk.jtms.dao.UserDao;
import com.jk.jtms.entity.Car;
import com.jk.jtms.entity.CarDTO;
import com.jk.jtms.entity.User;
import com.jk.jtms.service.CarService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Autowired
    private UserDao userDao;
    /**
     * 查询车辆信息
     * @param carDTO
     * @return
     */

    @Override
    public PageUtil<List<Car>> getCarInfo(CarDTO carDTO, int pageNo, int pageSize) {
        int start = (pageNo-1)*pageSize;
        Map<String,Object> map = new HashMap<>();
        map.put("start", start);
        map.put("pageSize", pageSize);
        final List<Car> carList = carDao.getCarInfo(carDTO,pageSize,pageNo);
        int cnt = carDao.getCountInfo();
        return new PageUtil<>(pageNo,pageSize,cnt,carList);
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

    @Override
    public Integer addCarInfo(CarDTO carDTO) {
        if(isExit(carDTO.getUserid())==0){
            User user = new User();
            user.setId(carDTO.getUserid());
            user.setName(carDTO.getUsername());
            user.setSfCode(carDTO.getUserid());
            String pwd = new Md5Hash("123456","1",3).toString();
            user.setPassword(pwd);
            user.setUsername(carDTO.getUsername());
            user.setRoleId("3cf9dd0d-6373-4458-8a72-7958113ae17b");
            userDao.addUser(user);
        }
        return carDao.addCar(carDTO);
    }

    @Override
    public Integer deleteCar(String xsCode) {
        return carDao.deleteCar(xsCode);
    }

    @Override
    public Integer updateCar(String carCode, String xsCode) {
        return carDao.updateCar(carCode, xsCode);
    }

    @Override
    public PageUtil<List<Map<String, Object>>> getCarList(Integer pageSize, Integer PageNo) {
        int start = (PageNo-1)*pageSize;
        Map<String,Object> map = new HashMap<>();
        map.put("start", start);
        map.put("pageSize", pageSize);
        final List<Map<String, Object>> carList = carDao.getCarList();
        int cnt = carList.size();
        final List<Map<String, Object>> carPage = carDao.getCarPage(start, pageSize);
        return new PageUtil<>(PageNo,pageSize,cnt,carPage);
    }

    @Override
    public Integer isExit(String useId) {
        return carDao.isExist(useId);
    }
}
