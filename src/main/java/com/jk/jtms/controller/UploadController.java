package com.jk.jtms.controller;

import com.baidu.aip.ocr.AipOcr;
import com.jk.jtms.comm.CommonResult;
import com.jk.jtms.comm.CommonResultT;
import com.jk.jtms.dao.CarDao;
import com.jk.jtms.entity.WzInfo;
import com.jk.jtms.service.BaiduApiService;
import com.jk.jtms.service.Impl.BaiduApiServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @Package com.jk.jtms.controller
 * @Title:
 * @Description:
 * @date 2019/2/20 15:41
 */
@Controller
@RequestMapping("/")
@ResponseBody
public class UploadController {


    public static final String APP_ID = "15368523";
    public static final String API_KEY = "mFsINdPHfYaZdlKS5pY6K7Ti";
    public static final String SECRET_KEY = "17ve46XqTHF3WtXZVSgHUrvcf0ITy4Zy";

    @Autowired
    private CarDao carDao;

    /**
     * 单个文件上传
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public CommonResultT<WzInfo> upload(@RequestParam("file") MultipartFile partFile, HttpServletRequest request) {
        try {
            String path = request.getServletContext().getRealPath("/image");
            //log.info("其他的参数{}",name);
            //System.out.println("其他的参数{}"+name);
            //log.info("upload2---------------start---------------------");
            //log.info("这个临时文件的路径是[{}]", path);
            //System.out.println("这个临时文件的路径是["+path+"]");
            String area = request.getParameter("location");
            String type = request.getParameter("wzType");
            String filename = partFile.getOriginalFilename();
            String[] arrayFile = filename.split("\\.");
            arrayFile[0]+=Calendar.getInstance().getTimeInMillis();
            filename = arrayFile[0]+"."+arrayFile[1];
            //log.info("文件的名字：{}",filename);
            //System.out.println("文件的名字：{}"+filename);
            File file = new File(path+"/"+filename);
            InputStream inputStream = partFile.getInputStream();
            FileUtils.copyInputStreamToFile(inputStream, file);
            if(inputStream!=null){
                inputStream.close();
            }
            AipOcr aipOcr = new AipOcr(APP_ID,API_KEY,SECRET_KEY);
            BaiduApiServiceImpl baiduApiService = new BaiduApiServiceImpl() ;
            String result = baiduApiService.getCp(aipOcr,path+"/"+filename);
            WzInfo wzInfo = new WzInfo();
            wzInfo.setArea(area);
            wzInfo.setCarCode(result);
            wzInfo.setType(type);
            String fsCode = carDao.getUserId(result);
            String wzType = carDao.getWzType(type);
            System.out.println(wzType+"++++++++++++++++++++++++");
            Map<String,Object> map = new HashMap<>();
            map.put("sfcode", fsCode);
            map.put("wzType", wzType);
            map.put("area", area);
            map.put("url", path+"/"+filename);
            map.put("id", UUID.randomUUID().toString());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            map.put("time", df.format(new Date()));
            map.put("carcode", result);
            carDao.addTypeDetails(map);
            wzInfo.setFileUrl(path+"/"+filename);
            return CommonResultT.ok(wzInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResultT.build(500,"违章图片识别失败");
        }
    }


}


    