package com.jk.jtms.service.Impl;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.ocr.AipOcr;
import com.jk.jtms.service.BaiduApiService;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class BaiduApiServiceImpl implements BaiduApiService {
    @Override
    public String getCp(AipOcr client,String fileUrl) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("multi_detect", "false");
        // 参数为本地路径
        JSONObject res = client.plateLicense(fileUrl, options);
        //System.out.println(res.toString(2));
        String str = res.toString(2);
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(str);
        String result = jsonObject.getString("words_result");
        jsonObject = JSON.parseObject(result);
        result = jsonObject.getString("number");
        // 参数为二进制数组
        //byte[] file = readFile(image);
        //res = client.plateLicense(file, options);
        return result;
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


//    public static void main(String[] args) {
//        BaiduApiServiceImpl baiduApiService = new BaiduApiServiceImpl();
//        final String APP_ID = "15368523";
//        final String API_KEY = "mFsINdPHfYaZdlKS5pY6K7Ti";
//        final String SECRET_KEY = "17ve46XqTHF3WtXZVSgHUrvcf0ITy4Zy";
//        AipOcr aipOcr = new AipOcr(APP_ID,API_KEY,SECRET_KEY);
//        String result = baiduApiService.getCp(aipOcr,"");
//        System.out.println(result);
//    }

}
