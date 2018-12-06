package com.alipay.api.internal.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class AlipayHashMap extends HashMap<String, String> {
    private static final long serialVersionUID = -1277791390393392630L;

    public AlipayHashMap() {
    }

    public AlipayHashMap(Map<? extends String, ? extends String> m) {
        /* 27 */
        super(m);
    }

    public String put(String key, Object value) {
        String strValue;
        String strValue;
        /* 33 */
        if (value == null) {
            /* 34 */
            strValue = null;
        } else {
            String strValue;
            /* 35 */
            if ((value instanceof String)) {
                /* 36 */
                strValue = (String) value;
            } else {
                String strValue;
                /* 37 */
                if ((value instanceof Integer)) {
                    /* 38 */
                    strValue = ((Integer) value).toString();
                } else {
                    String strValue;
                    /* 39 */
                    if ((value instanceof Long)) {
                        /* 40 */
                        strValue = ((Long) value).toString();
                    } else {
                        String strValue;
                        /* 41 */
                        if ((value instanceof Float)) {
                            /* 42 */
                            strValue = ((Float) value).toString();
                        } else {
                            String strValue;
                            /* 43 */
                            if ((value instanceof Double)) {
                                /* 44 */
                                strValue = ((Double) value).toString();
                            } else {
                                String strValue;
                                /* 45 */
                                if ((value instanceof Boolean)) {
                                    /* 46 */
                                    strValue = ((Boolean) value).toString();
                                } else {
                                    String strValue;
                                    /* 47 */
                                    if ((value instanceof Date)) {
                                        /* 48 */
                                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        /* 49 */
                                        format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                                        /* 50 */
                                        strValue = format.format((Date) value);
                                    } else {
                                        /* 52 */
                                        strValue = value.toString();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        /* 55 */
        return put(key, strValue);
    }

    public String put(String key, String value) {
        /* 59 */
        if (StringUtils.areNotEmpty(new String[]{key, value})) {
            /* 60 */
            return (String) super.put(key, value);
        }
        /* 62 */
        return null;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.AlipayHashMap
 * JD-Core Version:    0.6.0
 */