package com.speedtalk.order.engine;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderNumUtils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
    private static final SimpleDateFormat logSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS - ");
    private static final SimpleDateFormat commonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static AtomicInteger orderSerialNum = new AtomicInteger(200);

    public static String getOrderSerialNum() {
        int num = orderSerialNum.getAndIncrement();
        if (num > 999) {
            orderSerialNum.set(200);
            num = 0;
        }
        String serialNum = String.format("%03d", num);
        return sdf.format(Calendar.getInstance().getTime()) + serialNum;
    }

    /**
     * 格式化数字
     *
     * @param source
     * @param decimal 保留小数位数
     * @return
     */
    public static String format(double source, int decimal) {
        return String.format("%." + decimal + "f", source);
    }

    /**
     * 格式化数字
     *
     * @param source
     * @param decimal 保留小数位数
     * @return
     */
    public static String format(float source, int decimal) {
        return String.format("%." + decimal + "f", source);
    }
}
