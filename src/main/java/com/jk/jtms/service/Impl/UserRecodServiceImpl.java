package com.jk.jtms.service.Impl;

import com.jk.jtms.comm.PageUtil;
import com.jk.jtms.dao.UserRecordDao;
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
    public PageUtil<List<Map<String, Object>>> getUserDetails(int pageNo, int pageSize, String carcode,String status) {
        Map<String,Object> map = new HashMap<>();
        int start = (pageNo-1)*pageSize;
        map.put("startPage", start);
        map.put("pageSize", pageSize);
        map.put("xscode", carcode);
        map.put("status", status);
        int cnt = getCount(carcode);
        List<Map<String,Object>> list = userRecordDao.getUserJLDetail(map);
        return new PageUtil<>(pageSize,pageNo,cnt,list);
    }

    @Override
    public int getCount(String xscode) {
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
}


    