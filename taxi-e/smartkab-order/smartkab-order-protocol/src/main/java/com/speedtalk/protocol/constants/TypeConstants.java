package com.speedtalk.protocol.constants;

public class TypeConstants {
    public static final byte CREATE_TEMP_GRP_NOTICE = 0;
    public static final byte REMOVE_TEMP_GRP_NOTICE = 1;
    public static final byte START_SPEAK_NOTICE = 2;
    public static final byte END_SPEAK_NOTICE = 3;
    public static final byte EXIT_TEMP_GRP_NOTICE = 4;
    public static final byte ONLINE_NOTICE = 5;
    public static final byte OFFLINE_NOTICE = 6;
    public static final byte MSID_CONFLICT_NOTICE = 7;
    public static final byte CHANGE_GRP_NOTICE = 8;
    public static final byte CALL_SET_NOTICE = 9;
    public static final byte CURRENT_GRP_QUERY = 0;
    public static final byte ALL_GRP_QUERY = 1;
    public static final byte CURRENT_GRP_QUERY_EXT = 2;
    public static final byte ALL_GRP_QUERY_EXT = 3;
    public static final byte REMOVE_OPR_TEMP_GRP = 0;
    public static final byte EXIT_OPR_TEMP_GRP = 1;
    public static final byte ADD_TEMP_GRP_MEMBER = 0;
    public static final byte REMOVE_TEMP_GRP_MEMBER = 1;
    public static final byte RESET_TEMP_GRP_MEMBER = 2;
    public static final byte QUERY_MEMBER = 0;
    public static final byte QUERY_TEMP_MEMBER = 1;
    public static final byte QUERY_MEMBER_EXT = 2;
    public static final byte MS_ONLINE = 1;
    public static final byte MS_OFFLINE = 0;
    public static final byte T20 = 0;
    public static final byte ANDROID = 10;
    public static final byte PC = 20;
    public static final byte CALL_FORBIDDEN = 0;
    public static final byte CALL_LISTEN_ONLY = 1;
    public static final byte CALL_ADMIN_ONLY = 2;
    public static final byte CALL_NORMAL = 8;

    public TypeConstants() {
    }
}
