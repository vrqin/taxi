package com.speedtalk.protocol.constants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class MessIdDesc {
    public static Map<Integer, String> messIDDescMap = new ConcurrentHashMap<Integer, String>() {
        private static final long serialVersionUID = 1L;

        {
            this.put(1, "REGISTER");
            this.put(2, "REGISTER_RESP");
            this.put(3, "LOGIN");
            this.put(4, "LOGIN_RESP");
            this.put(5, "APPLY_JOIN_GRP");
            this.put(6, "APPLY_JOIN_GRP_RESP");
            this.put(7, "CREATE_GRP");
            this.put(8, "CREATE_GRP_RESP");
            this.put(9, "ALLOW_JOIN_GRP");
            this.put(16, "ALLOW_JOIN_GRP_RESP");
            this.put(17, "GPS");
            this.put(21, "SETTING");
            this.put(22, "SETTING_RESP");
            this.put(23, "SMS");
            this.put(24, "SMS_RESP");
            this.put(25, "PICTURE");
            this.put(32, "PICTURE_RESP");
            this.put(33, "TRANSFER");
            this.put(34, "TRANSFER_RESP");
            this.put(35, "PTT");
            this.put(36, "PTT_RESP");
            this.put(37, "CREATE_TEMP_GRP");
            this.put(38, "CREATE_TEMP_GRP_RESP");
            this.put(39, "REMOVE_TEMP_GRP");
            this.put(40, "REMOVE_TEMP_GRP_RESP");
            this.put(41, "NOTICE");
            this.put(49, "HUP");
            this.put(50, "HUP_RESP");
            this.put(51, "VOICE");
            this.put(52, "VOICE_RESP");
            this.put(53, "CHANGE_GRP");
            this.put(54, "CHANGE_GRP_RESP");
            this.put(55, "QUERY_GRP");
            this.put(56, "QUERY_GRP_RESP");
            this.put(57, "EDIT_TEMP_GRP");
            this.put(64, "EDIT_TEMP_GRP_RESP");
            this.put(65, "HB");
            this.put(66, "HB_RESP");
            this.put(67, "START_MONITOR");
            this.put(68, "START_MONITOR_RESP");
            this.put(69, "END_MONITOR");
            this.put(70, "END_MONITOR_RESP");
            this.put(73, "UPDATE_ADDR");
            this.put(80, "UPDATE_ADDR_RESP");
            this.put(81, "UPGRADE");
            this.put(83, "QUERY_MEMBER");
            this.put(84, "QUERY_MEMBER_RESP");
            this.put(85, "CALL_SET");
            this.put(86, "CALL_SET_RESP");
            this.put(87, "DETECTION");
        }
    };

    public MessIdDesc() {
    }
}
