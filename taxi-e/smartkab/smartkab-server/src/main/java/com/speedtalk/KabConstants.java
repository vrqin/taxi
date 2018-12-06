package com.speedtalk;

public class KabConstants {
    public static final String ORDER_SMS_PRIFIX = "ORDER";
    public static final String ORDER_SMS_SEP = "|";
    public static final String OLD_PROTOCOL = "o";
    public static final String PHOENIX_PROTOCOL = "p";
    private final static String PHOENIX_LOG = "phoenix#";
    private final static String OLD_LOG = "old#";
    private final static String TAXI_LOG = "taxix#";
    private final static String WS_LOG = "WS#";

    public static String getPhoenixLogPrefix() {
        return PHOENIX_LOG + "msId:" + ClientInfo.getInstance().getMsId() + "-->";
    }

    public static String getOldLogPrefix() {
        return OLD_LOG + "msId:" + ClientInfo.getInstance().getMsId() + "-->";
    }

    public static String getTaxiLogPrefix() {
        return TAXI_LOG + "msId:" + ClientInfo.getInstance().getMsId() + "-->";
    }

    public static String getWSLogPrefix() {
        return WS_LOG + "msId:" + ClientInfo.getInstance().getMsId() + "-->";
    }

    public static void main(String[] args) {
        System.out.println(KabConstants.getPhoenixLogPrefix());
    }
}
