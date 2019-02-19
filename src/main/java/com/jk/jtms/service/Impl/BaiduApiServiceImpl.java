package com.jk.jtms.service.Impl;

import com.baidu.aip.ocr.AipOcr;
import com.jk.jtms.service.BaiduApiService;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class BaiduApiServiceImpl implements BaiduApiService {
    @Override
    public String getCp(AipOcr client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("multi_detect", "false");


        // 参数为本地路径
        String image = Thread.currentThread().getContextClassLoader().getResource("images/2.jpg").getPath();
        JSONObject res = client.plateLicense(image, options);
        System.out.println(res.toString(2));

        // 参数为二进制数组
        //byte[] file = readFile(image);
        //res = client.plateLicense(file, options);
        return res.toString(2);
    }


    public static byte[] readFile(String url) {
        byte[] data = null;
        InputStream is = null;
        try {
            is = new FileInputStream(url);
            data = new byte[is.available()];
            is.read(data);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
