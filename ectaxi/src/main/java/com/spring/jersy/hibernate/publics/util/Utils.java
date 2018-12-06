package com.spring.jersy.hibernate.publics.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class Utils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss"), logSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS - "), commonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static AtomicInteger orderSerialNum = new AtomicInteger(0);

    public static String getOrderSerialNum() {
        int num = orderSerialNum.getAndIncrement();
        if (num > 999) {
            orderSerialNum.set(0);
            num = 0;
        }
        String serialNum = String.format("%03d", num);
        return sdf.format(Calendar.getInstance().getTime()) + serialNum;
    }

    public static String getLogFix() {
        return logSdf.format(Calendar.getInstance().getTime());
    }

    public static SimpleDateFormat getCommonsdf() {
        return commonSdf;
    }

    /**
     * 根据经纬度计算里程
     *
     * @param curr_lt 当前纬度
     * @param curr_lg 当前经度
     * @param last_lt 上一次纬度
     * @param last_lg 上一次经度
     * @return
     */
    public static double calDistance(double curr_lt, double curr_lg, double last_lt, double last_lg) {
        double x; //直解边长度
        double y; //直解边长度
        double nRet; //斜边长度
        double PI = 3.14159265;
        double R = 6.371229 * 1e6;
        x = (last_lg - curr_lg) * PI * R * Math.cos(((curr_lt + last_lt) / 2) * PI / 180) / 180;
        y = (last_lt - curr_lt) * PI * R / 180;

        nRet = Math.hypot(x, y); //计算一直角三角形的斜边长度
        return nRet;
    }

    /**
     * 类型转换，必须按照顺序排放
     *
     * @param typeNumber
     * @param typeArray
     * @return
     */
    public static String type(int typeNumber, String[] typeArray) {
        if (typeNumber > typeArray.length) {
            return null;
        }
        return typeArray[typeNumber];
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd\n HH:mm:ss");

        System.out.println(getOrderSerialNum());
        System.out.println(getOrderSerialNum());
        System.out.println(getOrderSerialNum());
        System.out.println(sdf.format(System.currentTimeMillis()));
    }
}
