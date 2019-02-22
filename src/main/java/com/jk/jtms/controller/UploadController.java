package com.jk.jtms.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;

/**
 * @author LITAO
 * @version V1.0
 * @Package com.jk.jtms.controller
 * @Title:
 * @Description:
 * @date 2019/2/20 15:41
 */
@Controller
@RequestMapping("/")
@ResponseBody
public class UploadController {
    /**
     * 单个文件上传
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile partFile, HttpServletRequest request) {

        try {
            String path = request.getServletContext().getRealPath("/image");
            //log.info("其他的参数{}",name);
            //System.out.println("其他的参数{}"+name);
            //log.info("upload2---------------start---------------------");
            //log.info("这个临时文件的路径是[{}]", path);
            System.out.println("这个临时文件的路径是["+path+"]");
            String filename = partFile.getOriginalFilename();
            //log.info("文件的名字：{}",filename);
            System.out.println("文件的名字：{}"+filename);
            File file = new File(path+"/"+filename);
            InputStream inputStream = partFile.getInputStream();
            FileUtils.copyInputStreamToFile(inputStream, file);
            if(inputStream!=null){
                inputStream.close();
            }
            return "文件上传成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "文件上传失败！";
        }
    }

}


    