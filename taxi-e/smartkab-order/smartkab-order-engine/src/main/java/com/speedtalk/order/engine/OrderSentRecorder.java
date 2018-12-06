package com.speedtalk.order.engine;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class OrderSentRecorder {
    private static OrderSentRecorder instance = new OrderSentRecorder();
    private ConcurrentHashMap<String, List<String>> recordMap = new ConcurrentHashMap<String, List<String>>();

    private OrderSentRecorder() {
    }

    public static OrderSentRecorder getInstance() {
        if (null == instance)
            instance = new OrderSentRecorder();
        return instance;
    }

    public void addRecord(String orderId, List<String> driverList) throws NullPointerException {
        if (null == orderId || orderId.trim().equals("") || null == driverList || driverList.isEmpty())
            throw new NullPointerException();

        recordMap.put(orderId, driverList);
    }

    public int addRecord(String orderId, String driverStrs) {
        int count = 0;
        try {
            String[] drivers = driverStrs.split(",");
            List<String> driverList = Arrays.asList(drivers);
            addRecord(orderId, driverList);
            count = driverList.size();
        } catch (Exception e) {
            return count;
        }
        return count;
    }

    public List<String> getDriverList(String orderId) {
        return recordMap.get(orderId);
    }

    public List<String> removeRecord(String orderId) {
        return recordMap.remove(orderId);
    }
}
