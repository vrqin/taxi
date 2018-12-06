package com.speedtalk.protocol.constants;

public class RespConstants {
    public static final byte DATA_ERROR = -1;
    public static final byte SUCCESS = 0;
    public static final byte FAILURE = 1;
    public static final byte LOGIN_MSID_ERROR = 1;
    public static final byte LOGIN_PWD_ERROR = 2;
    public static final byte LOGIN_NO_CURRENT_GRP = 3;
    public static final byte SMS_UNKNOWN_TARGET = 1;
    public static final byte SMS_OFFLINE_TARGET = 2;
    public static final byte CHANGEGROUP_GRP_INEXISTENCE = 1;
    public static final byte CHANGEGROUP_GRP_ERROR = 2;
    public static final byte PTT_GRP_IN_CALLING = 0;
    public static final byte PTT_UNALLOWED_CALL = 1;
    public static final byte PTT_MEMBER_OFFLINE = 2;
    public static final byte PTT_UNKNOWN_GRP = 3;
    public static final byte QUERY_MEMBER_GRP_ERROR = 1;
    public static final byte QUERY_MEMBER_NO_PRIVILEGE = 2;
    public static final byte QUERY_MEMBER_EMPTY = 3;

    public RespConstants() {
    }
}
