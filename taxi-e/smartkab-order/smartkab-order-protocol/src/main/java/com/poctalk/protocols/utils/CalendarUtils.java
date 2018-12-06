package com.poctalk.protocols.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtils {
    public CalendarUtils() {
    }

    public static Calendar utcToShangHai(Calendar cal) throws NullPointerException {
        try {
            cal.add(10, 8);
            return cal;
        } catch (NullPointerException var2) {
            throw var2;
        }
    }

    public static Calendar strToCal(String timeStr, String pattern) throws NullPointerException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(timeStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date strToDate(String timeStr, String pattern) throws NullPointerException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(timeStr);
    }

    public static String dateToStr(Date date, String pattern) throws NullPointerException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String calToStr(Calendar cal, String pattern) throws NullPointerException {
        return dateToStr(cal.getTime(), pattern);
    }

    public static long timeStrToLong(String time, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(time).getTime();
    }

    public static void main(String[] args) {
    }
}
