package com.jk.jtms.dao;

import com.jk.jtms.entity.Car;
import com.jk.jtms.entity.CarDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import javax.print.DocFlavor;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;
import java.util.Map;

public interface CarDao {
    /**
     * 获取车辆信息
     * @param carDTO
     * @return
     */
    List<Car> getCarInfo(@Param("carDTO") CarDTO carDTO,@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    Integer getCountInfo();
    /**
     * 添加车辆信息
     * @param car
     * @return
     */
    Integer addCarInfo(@Param("car") Car car);

    String getUserId(String carcode);

    String getWzType(String type);

    Integer addTypeDetails(Map map);

    Integer addCar(@Param("carDTO") CarDTO carDTO);

    Integer deleteCar(@Param("xsCode") String xsCode);

    Integer updateCar(@Param("carCode")String carCode,@Param("xsCode") String xsCode);

    List<Map<String,Object>> getCarList();

    List<Map<String,Object>> getCarPage(@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    Integer isExist(String useId);
}
