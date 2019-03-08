package com.jk.jtms.service;

import com.jk.jtms.comm.PageUtil;
import com.jk.jtms.entity.Wzss;

import java.util.List;
import java.util.Map;

public interface UserRecodService {

    /**
     * 查询违章记录
     * @param startPage
     * @param pageSize
     * @param carcode
     * @param status
     * @param username
     * @param xscode
     * @return
     */
    PageUtil<List<Map<String,Object>>> getUserDetails(int startPage,int pageSize,String carcode,String status,String username,String xscode,String sszz);
    int getCountNum(String xscode);

    /**
     * 获得车牌号
     * @param userid
     * @return
     */
    List<String> getCarCode(String userid);

    /**
     * 扣分总和
     * @param carcode
     * @param status
     * @return
     */
    int getScore(String carcode,String status);

    /**
     * 获取驾驶证信息
     * @param userid
     * @return
     */
    Map<String,Object> getUserCredit(String userid);

    /**
     * 查询车辆信息
     * @param id
     * @return
     */
    Map<String,Object> getCarDetails(String id);

    /**
     * 发送申诉请求
     * @param wzss
     * @return
     */
    Integer sendShengSu(Wzss wzss);

    /**
     * 查询违章细节
     * @param sfcode
     * @return
     */
    List<Wzss> getShenSu(String sfcode);


    /**
     * 查询违章细节
     * @param carcode
     * @param time
     * @return
     */
    List<Map<String,Object>> getWzDetails(String id);

    Integer updateStatus(String carcode,String time);
}
