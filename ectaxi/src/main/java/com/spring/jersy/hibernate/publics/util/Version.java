package com.spring.jersy.hibernate.publics.util;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by sky on 15-8-17
 */

public class Version {

    private final static String VERSION = "第1.0.0版本";
    private final static String RELEASE_DATE = "20151015";
    private final static String VERSION_100 = "1.0.0";
    private final static String RELEASE_DATE_20151015 = "20151015";
    private final static Map<String, String> SYSTEMNAME = new HashMap<String, String>() {
        {
            put(getVersion(), "电召管理系统");
        }
    };

    public Version() {
    }

    public static String getVersion() {
        return VERSION;
    }

    public static String getReleaseDate() {
        return RELEASE_DATE;
    }

    public static Map<String, String> getSystemname() {
        return SYSTEMNAME;
    }
}
