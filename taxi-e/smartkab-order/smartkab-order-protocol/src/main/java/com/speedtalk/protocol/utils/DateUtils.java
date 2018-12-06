package com.speedtalk.protocol.utils;

import java.text.SimpleDateFormat;

public class DateUtils {
    private static final SimpleDateFormat SMS_TIME_FORMAT = new SimpleDateFormat("yyMMdd HH:mm:ss");
    private static final SimpleDateFormat COMMON_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat GPS_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    public DateUtils() {
    }

    public static SimpleDateFormat getSmsTimeFormatter() {
        return SMS_TIME_FORMAT;
    }

    public static SimpleDateFormat getCommonTimeFormat() {
        return COMMON_TIME_FORMAT;
    }

    public static SimpleDateFormat getGpsTimeFormat() {
        return GPS_TIME_FORMAT;
    }
}
