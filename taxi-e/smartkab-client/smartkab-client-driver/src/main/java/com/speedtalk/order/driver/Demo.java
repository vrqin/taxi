package com.speedtalk.order.driver;

import com.speedtalk.client.ClientConnector;
import com.speedtalk.client.ClientInfo;
import com.speedtalk.protocol.order.OrderMessFilter;
import org.apache.mina.core.filterchain.IoFilter;

import java.util.LinkedHashMap;

public class Demo {
    public static void main(String[] args) {
        ClientInfo.getInstance().setClientInfo("5544", "", "123456");
        // ClientInfo.getInstance().setServerInfo("221.5.72.213", 10090);
        ClientInfo.getInstance().setServerInfo("192.168.1.251", 10091);

        ClientConnector.getInstance().setClientIoHandler(new OrderClientHandler());

        LinkedHashMap<String, IoFilter> filterMap = new LinkedHashMap<>();
        filterMap.put("order", new OrderMessFilter());
        ClientConnector.getInstance().setFilterMap(filterMap);

        System.out.println("timeout millis:" + ClientConnector.getInstance().getTimeoutMillis());
        ClientConnector.getInstance().setTimeoutMillis(2000);
        System.out.println("timeout millis:" + ClientConnector.getInstance().getTimeoutMillis());

        long start = System.currentTimeMillis();
        ClientConnector.getInstance().connect();
        long end = System.currentTimeMillis();
        System.out.println("finish connect..." + (end - start));
    }
}
