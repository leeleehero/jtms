package com.jk.jtms.listener;

/**
 * @author LITAO
 * @version V1.0
 * @Package com.jk.jtms.listener
 * @Title:
 * @Description:
 * @date 2019/2/20 16:23
 */

import javax.servlet.ServletContext;

import com.jk.jtms.upload.UpServerImage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;


@Service
public class WebContextListener implements InitializingBean, ServletContextAware{

    @Override
    public void setServletContext(ServletContext servletContext) {
        try {


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub

    }


}


    