package com.jk.jtms.service.Impl;

import com.jk.jtms.dao.TestDao;
import com.jk.jtms.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public List<Map<String, Object>> getAll() {
        return testDao.getAll();
    }
}
