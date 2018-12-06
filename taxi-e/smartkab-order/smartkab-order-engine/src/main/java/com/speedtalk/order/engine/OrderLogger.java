package com.speedtalk.order.engine;

import org.apache.log4j.Logger;

public class OrderLogger {
    public final static String VERSION = "1.7";
    private final static String SYS_NAME = "Order-Engine--";
    private final static Logger LOG = Logger.getLogger("cnsle");

    public static void log(String s) {
        LOG.debug(SYS_NAME + s);
    }

    public static Logger getLogger() {
        return LOG;
    }
}
