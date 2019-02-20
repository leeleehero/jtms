package com.jk.jtms.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;//阻塞式IO流jar包
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class UpServerImage {
    private static String path = "D:\\image";
    public static void getFile() throws FileNotFoundException, IOException{
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                WatchKey key;
                try {
                    WatchService watchService = FileSystems.getDefault().newWatchService();
                    Paths.get(path).register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
                    while (true) {
                        File file = new File(path);
                        //path为监听文件夹
                        File[] files = file.listFiles();
                        System.out.println("等待图片加载！");
                        key = watchService.take();
                        //没有文件增加时，阻塞在这里
                        for (WatchEvent<?> event : key.pollEvents()) {
                            String fileName = path+"\\"+event.context();
                            System.out.println("增加文件的文件夹路径"+fileName);
                            File file1 = files[files.length-1];
                            //获取最新文件
                            System.out.println(file1.getName());
                            //根据后缀判断
                            String url = uploadFile(file1,uploadAddres);
                            //上传服务器
                        }if (!key.reset()) {
                            break; //中断循环
                        }
                    }
                }catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, 2000 , 3000);
        //第一个数字2000表示，2000ms以后开启定时器,第二个数字3000，表示3000ms后运行一次run
    }

    /**
     * 将file文件上传到指定dir文件夹中
     * @param file：待上传文件
     * @param dir：指定路径
     * @throws FileNotFoundException
     * @throws IOException
     */

    final static String uploadAddres ="D:\\web";
    public static String uploadFile(File file , String dir) throws FileNotFoundException, IOException {
        String imgURL = null;
        try {
            InputStream in = new FileInputStream(file);
            System.out.println("服务器路径：" + dir);
            // 获取文件名称
            String fileName = file.getName();
            // 路径和文件名丢进file对象里
            File uploadFile = new File(dir, fileName);
            // 输出流
            OutputStream out = new FileOutputStream(uploadFile);
            // 设置文件大小1MB
            byte[] buffer = new byte[1024 * 1024];
            int length;
            // 用循环从流中读取文件的大小
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            // 设置图片标题和全路径
            imgURL = "uploadFile/" + fileName;

            System.out.println("绝对路径为"+imgURL);
            // 关闭输入流输出流，释放内存
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgURL;
    }
}


    