package com.speedtalk.protocol.constants;

public class ParamConstants {
    public static final byte WRITE = 0;
    public static final byte READ = 1;
    public static final byte VERSION = 0;
    public static final byte ISP = 1;
    public static final byte IP = 2;
    public static final byte PWD = 3;
    public static final byte GPS = 4;
    public static final byte SPEED = 5;
    public static final byte DANGER = 6;
    private static final byte BRIEF = 0;
    private static final byte DETAIL = 9;
    private static byte logOption = 0;

    public ParamConstants() {
    }

    public static void setLogOption(byte option) {
        logOption = option;
    }

    public static boolean isDetail() {
        return logOption == 9;
    }
}
