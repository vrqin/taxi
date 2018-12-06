package com.spring.jersy.hibernate.servlet;

import com.spring.jersy.hibernate.publics.util.Constant;
import com.spring.jersy.hibernate.quartz.SpringQtz;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


public class StartupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(StartupServlet.class);
    @Override
    public void destroy() {

        LOGGER.warn("------------StartupServlet销毁------------");

    }

    @Override
    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException {
    }


    @Override
    public void init() {
        LOGGER.warn("------------StartupServlet开始启动------------");


        SpringQtz springQtz = new SpringQtz();
        try {
            springQtz.loadTimeoutOrder();
            LOGGER.warn("已成功加载发送给乘客短信信息,一共有" + Constant.allDriverList.size() + "个乘客,刷新时间是:" + new Date());
        } catch (Exception e) {
            LOGGER.error("StartupServlet初始化异常:", e);
        }


    }



}
