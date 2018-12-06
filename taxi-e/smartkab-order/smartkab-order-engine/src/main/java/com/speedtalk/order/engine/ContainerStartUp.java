package com.speedtalk.order.engine;

import com.speedtalk.order.engine.threads.OrderSender;
import com.speedtalk.protocol.order.OrderMessFilter;
import com.speedtalk.order.server.TcpAcceptor;
import com.speedtalk.utils.AutoLoadConfig;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.mina.core.filterchain.IoFilter;

import java.util.LinkedHashMap;

public class ContainerStartUp {

    public static void startUp() {
        OrderLogger.log("Starting...");
        try {
            String dir = System.getProperty("user.dir");
            dir = dir.replace("bin", "webapps");
            LoadXmlConfig.initConfigHash(dir + "/order_engine_config.xml");
            new Thread(new AutoLoadConfig(dir + "/order_engine_config.xml")).start();
            ExcepPrinter.init(LoadXmlConfig.getConfigHash().get("excep-log"));
            OrderLogger.log("Finished load config...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Load config error,check order_engine_config.xml and then restart!");
        }
        int port = 10090;
        try {
            port = Integer.parseInt(LoadXmlConfig.getConfigHash().get("service-port"));
        } catch (Exception e) {
            // TODO: handle exception
        }

        KabInfoLoader.loadKabInfos();
        OrderLoader.loadOrders();
        OrderLogger.log("Finished load data...");

        LinkedHashMap<String, IoFilter> filterMap = new LinkedHashMap<String, IoFilter>();
        filterMap.put("ORDER", new OrderMessFilter());
        TcpAcceptor.getInstance().setIoHandler(new OrderEngineHandler());
        TcpAcceptor.getInstance().setFilterMap(filterMap);
        try {
            TcpAcceptor.getInstance().startUp(port);
            OrderLogger.log("running...service port：" + port);

            try {
                Thread.sleep(180000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            new Thread(new OrderSender()).start();
            OrderLogger.log("Order sender is running...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Start server error!!!");
        }
    }

    public static void destroy() {
        TcpAcceptor.getInstance().closeAcceptor();
    }
}
