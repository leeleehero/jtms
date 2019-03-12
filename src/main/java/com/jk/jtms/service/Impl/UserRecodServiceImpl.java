package com.jk.jtms.service.Impl;

import com.jk.jtms.comm.PageUtil;
import com.jk.jtms.dao.UserRecordDao;
import com.jk.jtms.entity.Wzss;
import com.jk.jtms.service.UserRecodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserRecodServiceImpl implements UserRecodService {

    @Autowired
    private UserRecordDao userRecordDao;
    @Override
    public PageUtil<List<Map<String, Object>>> getUserDetails(int pageNo, int pageSize, String carcode,String status,String username,String xscode,String sszt) {
        Map<String,Object> map = new HashMap<>();
        int start = (pageNo-1)*pageSize;
        map.put("startPage", start);
        map.put("pageSize", pageSize);
        map.put("carcode", carcode);
        map.put("status", status);
        map.put("username", username);
        map.put("xscode", xscode);
        map.put("sszt", sszt);
        System.out.println("+++++++++++++++++++++++++++++++++");
        int cnt = getCountNum(carcode);

        List<Map<String,Object>> list = null;
        try {
            list = userRecordDao.getUserJLDetail(map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return new PageUtil<>(pageSize,pageNo,cnt,list);
    }

    @Override
    public int getCountNum(String xscode) {
        return userRecordDao.getCount(xscode);
    }

    @Override
    public List<String> getCarCode(String userid) {
        return userRecordDao.getCarCode(userid);
    }

    @Override
    public int getScore(String carcode, String status) {
        Map<String,Object> map = new HashMap<>();
        map.put("status", status);
        map.put("carcode", carcode);
        return userRecordDao.getScore(map);
    }

    @Override
    public Map<String, Object> getUserCredit(String userid) {
        Map<String,Object> map = new HashMap<>();
        map.put("userid", userid);
        return userRecordDao.getUserCredit(map);
    }

    @Override
    public Map<String, Object> getCarDetails(String id) {
        return userRecordDao.getCarDetails(id);
    }

    @Override
    public Integer sendShengSu(Wzss wzss) {
        return userRecordDao.sendSuSong(wzss);
    }

    @Override
    public List<Wzss> getShenSu(String sfcode) {
        return userRecordDao.queyrShenSu(sfcode);
    }

    @Override
    public List<Map<String, Object>> getWzDetails(String id) {
        Map<String,Object> map =new HashMap<>();
        map.put("id", id);
        return userRecordDao.getWZDetails(map);
    }

    @Override
    public Integer updateStatus(String carcode, String id) {
        return userRecordDao.updateStatus(carcode, id);
    }
}


    