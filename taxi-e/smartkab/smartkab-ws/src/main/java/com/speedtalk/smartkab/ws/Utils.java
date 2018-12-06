package com.speedtalk.smartkab.ws;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
    private static final SimpleDateFormat logSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS - ");
    private static final SimpleDateFormat commonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static AtomicInteger orderSerialNum = new AtomicInteger(0);

    public static String getOrderSerialNum() {
        int num = orderSerialNum.getAndIncrement();
        if (num > 999) {
            orderSerialNum.set(0);
            num = 0;
        }
        String serialNum = String.format("%03d", num);
        return sdf.format(System.currentTimeMillis()) + serialNum;
    }

    public static String getLogFix() {
        StringBuilder buf = new StringBuilder(logSdf.format(System.currentTimeMillis()));
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        buf.append("(")
                .append(element[2].getFileName())
                .append(":")
                .append(element[2].getLineNumber())
                .append(")")
                .append("--");
        return buf.toString();
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

    public static boolean isPhone(String mobile) {
        try {
            Pattern p = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0,6-8])|(18[0-9]))\\d{8}$");
            Matcher m = p.matcher(mobile);
            return m.matches();
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd\n HH:mm:ss");

        System.out.println(getOrderSerialNum());

        System.out.println(sdf.format(System.currentTimeMillis()));
    }
}
