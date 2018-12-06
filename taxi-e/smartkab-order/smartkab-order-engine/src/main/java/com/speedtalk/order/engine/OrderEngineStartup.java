package com.speedtalk.order.engine;

import com.speedtalk.order.engine.threads.*;
import com.speedtalk.order.engine.threads.OrderSender;
import com.speedtalk.protocol.order.OrderMessFilter;
import com.speedtalk.order.server.TcpAcceptor;
import com.speedtalk.utils.AutoLoadConfig;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.mina.core.filterchain.IoFilter;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

public class OrderEngineStartup {
    public static int idle_time_second = 90;

    public static void main(String[] args) throws Exception {
        OrderLogger.log("Starting...");
        LoadXmlConfig.initConfigHash("order_engine_config.xml");
        new Thread(new AutoLoadConfig("order_engine_config.xml")).start();
        ExcepPrinter.init(LoadXmlConfig.getConfigHash().get("excep-log"));
        OrderLogger.log("Finished load config...");
        int port = 10090;
        try {
            port = Integer.parseInt(LoadXmlConfig.getConfigHash().get("service-port"));
        } catch (Exception e) {
            // TODO: handle exception
        }

        try {
            idle_time_second = Integer.parseInt(LoadXmlConfig.getConfigHash().get("session-timeout"));
        } catch (Exception e) {
            // TODO: handle exception
        }

        KabInfoLoader.loadKabInfos();
        OrderLoader.loadOrders();
        CompanySettingLoader.loadCompanySetting();
        OrderLogger.log("Finished load data...");

        LinkedHashMap<String, IoFilter> filterMap = new LinkedHashMap<String, IoFilter>();
        filterMap.put("ORDER", new OrderMessFilter());
        TcpAcceptor.getInstance().setIoHandler(new OrderEngineHandler());
        TcpAcceptor.getInstance().setFilterMap(filterMap);
        TcpAcceptor.getInstance().setReadIdle(idle_time_second);
        TcpAcceptor.getInstance().startUp(port);
        OrderLogger.log("Working...service port：" + port);

        //		new Thread(new GetMyInfo()).start();//验证
        new Thread(new OrderMqReceiver(LoadXmlConfig.getConfigHash().get("mq-addr"), LoadXmlConfig.getConfigHash()
                .get("wstoe-queue"))).start();
        new Thread(new TaxiPayMqReceiver(LoadXmlConfig.getConfigHash().get("mq-addr"), LoadXmlConfig.getConfigHash()
                .get("paytoe-queue"))).start();
        new Thread(WaitingOrderManager.getInstance()).start();
        new Thread(new DataReloader()).start();
        new Thread(new OrderRemainingChecker()).start();
        new Thread(new NoticeSender()).start();
        new Thread(new DropOrderChecker()).start();

        //		new Thread(AliQueryer.getInstance()).start();	//支付宝轮询支付结果线程

        int delay = 1;
        try {
            delay = Integer.parseInt(LoadXmlConfig.getConfigHash().get("order-sender-startup-delay"));
        } catch (Exception e) {
        }
        try {
            TimeUnit.MINUTES.sleep(delay);
        } catch (Exception e) {
        }
        new Thread(new OrderSender()).start();
        OrderLogger.log("派单线程启动...");
    }
}
