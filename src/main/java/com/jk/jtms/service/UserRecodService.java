package com.jk.jtms.service;

import com.jk.jtms.comm.PageUtil;

import java.util.List;
import java.util.Map;

public interface UserRecodService {
    PageUtil<List<Map<String,Object>>> getUserDetails(int startPage,int pageSize,String xscode);

    int getCount(String xscode);
}
