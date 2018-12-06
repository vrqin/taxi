package com.speedtalk.oldprotol;

public class OptionConstants {
    public static final byte[] HEAD = {(byte) 0xAA, (byte) 0x55, (byte) 0xAA, (byte) 0x55};
    public static final byte[] TAIL = {(byte) 0x3B};
    public static final byte GPS = (byte) 0x8A;

    public static final short SUCCESS_RESULT = 0;

    public static final int HEAD_LEN = 12;
    public static final int ID_LEN = 21;
    public static final int RESERVE_LEN = 21;
    //	public static final byte[] RESERVE = new byte[8];

    public static final byte SMS_NOTIFY = 2;
    public static final byte MS_STATUS_NOTIFY = 3;

    public static final byte MYSELF_QUERY = 0;
    public static final byte GRPS_OF_MS_QUERY = 1;
    public static final byte MS_STATUS_QUERY = 6;
    public static final byte MS_OF_GRP_QUERY = 7;

}
