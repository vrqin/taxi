package com.poctalk.protocols.gps;

public class GpsConstants {
    public static final int MAX_TIME = 235959;
    public static final int MAX_HOUR_MINUTE = 2359;
    public static final int MAX_HOUR = 23;
    public static final int COMMAND = 20;
    public static final int PROTOCOL_LENGTH = 23;
    public static final byte[] HEAD = new byte[]{-86, 85, -86, 85};
    public static final byte TAIL = 59;
    public static final byte[] GPS_HEAD = "$GPRMC".getBytes();
    public static final String GPS_HEAD_STR = "$GPRMC";
    public static final byte[] GPS_DELIMITER = ",".getBytes();
    public static final String GPS_DELIMITER_STR = ",";
    public static final byte GPS_READ = 0;
    public static final byte GPS_WRITE = -1;
    public static final byte GPS = -118;
    public static final byte HB = 8;
    public static final byte ALARM_RESP = 15;
    public static final byte SMS = 32;
    public static final byte PICTURE = 9;
    public static final byte PICTURE_RESP = -119;
    public static final byte SMS_RESP = -96;
    public static final byte[] RESERVE = new byte[8];
    public static final String A_GPS = "A";
    public static final String V_GPS = "V";
    public static final String N_LATI = "N";
    public static final String S_LATI = "S";
    public static final String E_LONGI = "E";
    public static final String W_LONGI = "W";
    public static final int MO_GPS_LEN = 42;
    public static final byte PIC_REAL_TIME = 0;
    public static final byte PIC_OLD_TIME = -1;

    public GpsConstants() {
    }
}
