package com.spring.jersy.hibernate.publics.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by sky on 15-8-17
 */
public class DateUtil {
    /**
     * 把CST格式时间转换成给定的字符串格式的时间
     *
     * @param rex  给定的字符串(如:yyyy-MM-dd HH:mm:ss)
     * @param date CST格式时间
     * @return 时间字符串
     */
    public static String dateFormatStr(String rex, Date date) {
        SimpleDateFormat sd = new SimpleDateFormat(rex);
        return sd.format(date);
    }

    /**
     * 把Date类型的时间转换成Timestamp类型的时间
     *
     * @param date Date类型的时间
     * @return Timestamp类型的时间
     */
    public static Timestamp toTimestamp(Date date) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return Timestamp.valueOf(sd.format(date));
    }

    /**
     * @param date  需要计算的日期
     * @param mouth 需要添加的月份数
     * @return 添加之后的日期, 以字符串形式返回
     */
    public static String datePlusMouth(Date date, Integer mouth) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, mouth);
        Date d = rightNow.getTime();
        return dateFormatStr("yyyy-MM-dd HH:mm:ss", d);
    }

    public static Date computeDate(String date, Integer mouth) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date1);
        rightNow.add(Calendar.MONTH, mouth);
        return rightNow.getTime();
    }

    public static Date stringToDate(String s, String farmat) throws Exception {
        SimpleDateFormat sd = new SimpleDateFormat(farmat);
        return sd.parse(s);
    }

    /**
     * 获取某个毫秒数之前或之后的CST格式时间
     *
     * @param type       类型,before:这个时间段之前,after:这个时间段之后,其他值:返回空;
     * @param millsecond 时间段,是一个毫秒数
     * @return {Date} CST格式时间
     */
    public static Date achieveTimeQuantum(String type, long millsecond) {
        long nowmillsecond = new Date().getTime();
        if ("before".equals(type)) {
            return new Date(nowmillsecond - millsecond);
        } else if ("after".equals(type)) {
            return new Date(millsecond - nowmillsecond);
        } else {
            return null;
        }
    }

    public static String formatDate(long timeMillis, String format) throws NullPointerException {
        if (null == format)
            throw new NullPointerException("Formatter is NULL!");
        return new SimpleDateFormat(format).format(timeMillis);
    }
}
