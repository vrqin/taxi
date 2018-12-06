package com.speedtalk.protocol.constants;

public class LengthConstants {
    public static final int HEAD_LENGTH = 28;
    public static final int MESSAGE_LEAST = 34;
    public static final int MAX_CONTENT = 478;
    public static final int MAX_SMS_CONTENT = 400;
    public static final int NAME_LENGTH = 20;
    public static final int ID_LENGTH = 11;
    public static final int PWD_LENGTH = 6;
    public static final short NOT_CONTNET = 0;
    public static final int LOGIN = 40;
    public static final int LOGIN_RESP = 106;
    public static final short LOGIN_CONTENT = 6;
    public static final short LOGIN_RESP_CONTENT = 72;
    public static final int HB = 34;
    public static final int HB_RESP = 35;
    public static final short HB_CONTENT = 0;
    public static final short HB_RESP_CONTENT = 1;
    public static final int GPS = 76;
    public static final short GPS_CONTENT = 42;
    public static final int QUERY_GRP = 35;
    public static final short QUERY_GRP_CONTENT = 1;
    public static final int WITH_OUT_BODY_MESS = 34;
    public static final short WITH_OUT_BODY_MESS_CONTENT = 0;
    public static final int COMMON_RESP = 35;
    public static final short COMMON_RESP_CONTENT = 1;
    public static final int NOTICE = 66;
    public static final short NOTICE_CONTENT = 32;
    public static final int CHANGE_GRP = 45;
    public static final short CHANGE_GRP_CONTENT = 11;
    public static final int REGISTER = 71;
    public static final short REGISTER_CONSTENT = 37;
    public static final int CREATE_GRP = 54;
    public static final short CREATE_GRP_CONSTENT = 20;
    public static final int CREATE_GRP_RESP = 66;
    public static final short CREATE_GRP_RESP_CONSTENT = 32;
    public static final int UPDATE_ADDR = 38;
    public static final short UPDATE_ADDR_CONSTENT = 4;
    public static final short VOICE_CONSTENT = 20;
    public static final int VOICE_RESP = 55;
    public static final short VOICE_RESP_CONSTENT = 21;
    public static final int READ_SET_PARAM = 38;
    public static final short SET_PARAM_CONSTENT = 4;
    public static final short SET_PARAM_RESP_CONSTENT = 5;
    public static final int QUERY_MEMBER = 46;
    public static final short QUERY_MEMBER_CONSTENT = 12;
    public static final short QUERY_MEMBER_CONSTENT_RESP = 14;
    public static final int CALL_SET = 48;
    public static final short CALL_SET_CONTENT = 14;

    public LengthConstants() {
    }
}
