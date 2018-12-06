package com.speedtalk.smartkab.pay.ws;

import com.speedtalk.utils.AutoLoadConfig;
import com.speedtalk.utils.LoadXmlConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

public class TaxiPayStartUpListener implements ServletContextListener {
    private static final Logger LOG = Logger.getLogger(TaxiPayStartUpListener.class.getName());

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        String dir = System.getProperty("user.dir");
        dir = dir.replace("bin", "conf");
        LoadXmlConfig.initConfigHash(dir + "/taxipay_config.xml");
        new Thread(new AutoLoadConfig(dir + "/taxipay_config.xml")).start();
        LOG.info("TaxiPayStartUpListener finished init...!");
    }
}
