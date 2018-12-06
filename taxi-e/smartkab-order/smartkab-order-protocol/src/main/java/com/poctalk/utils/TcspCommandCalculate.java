package com.poctalk.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class TcspCommandCalculate {
    public static AtomicInteger tscAllReceive = new AtomicInteger();
    public static AtomicInteger tscAllSender = new AtomicInteger();
    public static AtomicInteger tscPttReceive = new AtomicInteger();
    public static AtomicInteger tscPttSender = new AtomicInteger();
    public static AtomicInteger tscGpsReceive = new AtomicInteger();
    public static AtomicInteger tscGpsSender = new AtomicInteger();

    public TcspCommandCalculate() {
    }

    public static int tscAllReceiveAdd() {
        return tscAllReceive.incrementAndGet();
    }

    public static int tscAllSenderAdd() {
        return tscAllSender.incrementAndGet();
    }

    public static int tscPttReceiveAdd() {
        return tscPttReceive.incrementAndGet();
    }

    public static int tscPttSenderAdd() {
        return tscPttSender.incrementAndGet();
    }

    public static int tscGpsReceiveAdd() {
        return tscGpsReceive.incrementAndGet();
    }

    public static int tscGpsSenderAdd() {
        return tscGpsSender.incrementAndGet();
    }
}
