package com.speedtalk.smartkab.ws;

import com.speedtalk.smartkab.ws.kabs.GpsUpdater;
import com.speedtalk.utils.AutoLoadConfig;
import com.speedtalk.utils.LoadXmlConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PhoenixClientStartUp implements ServletContextListener {
    //	GpsUpdater gpsUpdater = new GpsUpdater("tcp://192.168.1.251:61616","engine_to_ws");
    //	GpsUpdater gpsUpdater = new GpsUpdater("tcp://127.0.0.1:61616","engine_to_ws");
    GpsUpdater gpsUpdater = null;

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // System.out.println("=========== Loading Order =========");
        // Orders.getInstance().loadOrder();
        // System.out.println("=========== Start Client =========");
        // ContainerStartUp.startUp();
        // System.out.println("=========== Start Order Engine =========");
        // ContainerStartUp.startUp();
        // new Thread(new DbConnKeeper()).start();
        String dir = System.getProperty("user.dir");
        dir = dir.replace("bin", "webapps");
        LoadXmlConfig.initConfigHash(dir + "/kab_config.xml");
        new Thread(new AutoLoadConfig(dir + "/kab_config.xml")).start();
        System.out.println(Utils.getLogFix() + "PhoenixClientStartUp finished init...!");

        gpsUpdater = new GpsUpdater(LoadXmlConfig.getConfigHash().get("queue_addr"), "engine_to_ws");
        new Thread(gpsUpdater).start();

        new Thread(UdpServer.getInstance()).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("=========== Destroy Client =========");
        try {
            gpsUpdater.setRun(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(1);
    }


}
