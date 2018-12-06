package com.poctalk.protocols.gps;

import com.poctalk.protocols.utils.CalendarUtils;
import com.poctalk.utils.StringUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Position {
    private Calendar gpsDate;
    private double longitude;
    private String longSignal;
    private double latitude;
    private String latSignal;
    private String isAvailable;
    private float direction;

    public Position() {
        this.isAvailable = "V";
        this.longSignal = "E";
        this.latSignal = "N";
    }

    public Position(Calendar gpsDate, double longitude, String longSignal, double latitude, String latSignal, String isAvailable, float direction) {
        this.gpsDate = gpsDate;
        this.longitude = longitude;
        this.longSignal = longSignal;
        this.latitude = latitude;
        this.latSignal = latSignal;
        this.isAvailable = isAvailable;
        this.direction = direction;
    }

    public static double degree2DM(double position) {
        int integer = (int) position;
        if (position == (double) integer) {
            return (double) (integer * 100);
        } else {
            double decimal = position - (double) integer;
            return (double) (integer * 100) + decimal * 60.0D;
        }
    }

    public static double dm2Degree(double position) {
        int degree = (int) position / 100;
        double minute = position - (double) (degree * 100);
        return (double) degree + minute / 60.0D;
    }

    public static Position parseBytesToPosition(byte[] datas) throws ParseException {
        String[] positionArrays = (new String(datas)).split(",");
        Position position = new Position();
        String dateStr = StringUtils.formatDate(System.currentTimeMillis(), "ddMMyy");
        if (!positionArrays[9].equals(dateStr)) {
            positionArrays[9] = dateStr;
        }

        StringTokenizer timeToken = new StringTokenizer(positionArrays[1], ".");
        StringBuilder calBuffer = new StringBuilder(positionArrays[9]);
        calBuffer.append(timeToken.nextToken());

        try {
            int time = (int) Float.parseFloat(positionArrays[1]);
            if (time < 235959 && time / 100 < 2359 && time / 10000 < 235959) {
                try {
                    position.setGpsDate(CalendarUtils.strToCal(calBuffer.toString(), "ddMMyyHHmmss"));
                } catch (ParseException var8) {
                    var8.printStackTrace();
                    position.setGpsDate(Calendar.getInstance());
                }
            } else {
                position.setGpsDate(Calendar.getInstance());
            }
        } catch (NumberFormatException var9) {
            var9.printStackTrace();
            position.setGpsDate(Calendar.getInstance());
        }

        position.setIsAvailable(positionArrays[2]);
        position.setLatitude(dm2Degree(Double.parseDouble(positionArrays[3])));
        position.setLatSignal(positionArrays[4]);
        position.setLongitude(dm2Degree(Double.parseDouble(positionArrays[5])));
        position.setLongSignal(positionArrays[6]);
        position.setDirection(positionArrays[8].equals("") ? 0.0F : Float.parseFloat(positionArrays[8]));
        return position;
    }

    public byte[] parsePositionToBytes(float speed) throws Exception {
        double newLon = degree2DM(this.longitude);
        double newLat = degree2DM(this.latitude);
        this.setLongitude(newLon);
        this.setLatitude(newLat);
        return this.parseBKPositionToBytes(speed);
    }

    public byte[] parseBKPositionToBytes(float speed) throws Exception {
        StringBuilder tempBuffer = new StringBuilder("$GPRMC");
        tempBuffer.append(",");

        try {
            tempBuffer.append(this.getBKGpsTime());
        } catch (Exception var5) {
            throw var5;
        }

        tempBuffer.append(",");
        tempBuffer.append(this.isAvailable);
        tempBuffer.append(",");
        tempBuffer.append(this.checkLonLat(this.latitude));
        tempBuffer.append(",");
        tempBuffer.append(this.latSignal);
        tempBuffer.append(",");
        tempBuffer.append(this.checkLonLat(this.longitude));
        tempBuffer.append(",");
        tempBuffer.append(this.longSignal);
        tempBuffer.append(",");
        tempBuffer.append(String.valueOf(speed));
        tempBuffer.append(",");
        tempBuffer.append(String.valueOf(this.direction));
        tempBuffer.append(",");

        try {
            tempBuffer.append(this.getBKGpsDate());
        } catch (Exception var4) {
            throw var4;
        }

        tempBuffer.append(",");
        return tempBuffer.toString().getBytes();
    }

    public String checkLonLat(double lonlat) {
        String tempStr = String.valueOf(lonlat);
        int dotPosition = tempStr.indexOf(".");
        int length = tempStr.length();
        if (dotPosition > 0 && length - dotPosition > 5) {
            return tempStr;
        } else {
            DecimalFormat df = new DecimalFormat("#.0000");
            return String.valueOf(df.format(lonlat));
        }
    }

    public String getBKGpsDate() throws Exception {
        try {
            String year = String.valueOf(this.gpsDate.get(1)).substring(2);
            String month = String.valueOf(this.gpsDate.get(2) + 1);
            String day = String.valueOf(this.gpsDate.get(5));
            StringBuilder dateBuffer = new StringBuilder();
            dateBuffer.append(day.length() == 2 ? day : "0" + day);
            dateBuffer.append(month.length() == 2 ? month : "0" + month);
            dateBuffer.append(year);
            return dateBuffer.toString();
        } catch (NullPointerException var5) {
            return "000000";
        } catch (Exception var6) {
            throw var6;
        }
    }

    public String getBKGpsTime() throws Exception {
        try {
            String hour = String.valueOf(this.gpsDate.get(11));
            String minute = String.valueOf(this.gpsDate.get(12));
            String second = String.valueOf(this.gpsDate.get(13));
            StringBuilder timeBuffer = new StringBuilder();
            timeBuffer.append(hour.length() == 2 ? hour : "0" + hour);
            timeBuffer.append(minute.length() == 2 ? minute : "0" + minute);
            timeBuffer.append(second.length() == 2 ? second : "0" + second);
            timeBuffer.append(".00");
            return timeBuffer.toString();
        } catch (NullPointerException var5) {
            return "000000.00";
        } catch (Exception var6) {
            throw var6;
        }
    }

    public Calendar getGpsDate() {
        return this.gpsDate;
    }

    public void setGpsDate(Calendar gpsDate) {
        this.gpsDate = gpsDate;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLongSignal() {
        return this.longSignal;
    }

    public void setLongSignal(String longSignal) {
        this.longSignal = longSignal;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getLatSignal() {
        return this.latSignal;
    }

    public void setLatSignal(String latSignal) {
        this.latSignal = latSignal;
    }

    public String getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public float getDirection() {
        return this.direction;
    }

    public void setDirection(float direction) {
        this.direction = direction;
    }

    public String toString() {
        StringBuilder objBuffer = new StringBuilder(" 定位时间:");
        objBuffer.append(CalendarUtils.calToStr(this.getGpsDate(), "yyyy-MM-dd HH:mm:ss SS"));
        objBuffer.append(",经度：");
        objBuffer.append(this.getLongitude());
        objBuffer.append(",经度标志：");
        objBuffer.append(this.getLongSignal());
        objBuffer.append(",纬度：");
        objBuffer.append(this.getLatitude());
        objBuffer.append(",纬度标志：");
        objBuffer.append(this.getLatSignal());
        objBuffer.append(",有效标志：");
        objBuffer.append(this.getIsAvailable());
        objBuffer.append(",方向：");
        objBuffer.append(this.getDirection());
        return objBuffer.toString();
    }
}
