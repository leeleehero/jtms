package com.jk.jtms.controller;

import com.jk.jtms.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("test")
    @ResponseBody
    public List<Map<String,Object>> test(){
        return testService.getAll();
    }
}
