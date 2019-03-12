package com.jk.jtms.service;

import com.baidu.aip.ocr.AipOcr;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Map;

public interface BaiduApiService {

    /**
     * 车牌识别接口
     * @param client
     * @return
     */
    String getCp(AipOcr client,String fileUrl);
}
