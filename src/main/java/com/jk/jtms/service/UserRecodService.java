package com.jk.jtms.service;

import com.jk.jtms.comm.PageUtil;
import com.jk.jtms.entity.Wzss;

import java.util.List;
import java.util.Map;

public interface UserRecodService {
    PageUtil<List<Map<String,Object>>> getUserDetails(int startPage,int pageSize,String xscode,String status);
    int getCount(String xscode);
    List<String> getCarCode(String userid);
    int getScore(String carcode,String status);
    Map<String,Object> getUserCredit(String userid);
    Map<String,Object> getCarDetails(String id);
    Integer sendShengSu(Wzss wzss);
    List<Wzss> getShenSu(String sfcode);
}
