package com.alipay.api.internal.util;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.parser.json.ObjectJsonParser;
import com.alipay.api.internal.util.json.JSONReader;
import com.alipay.api.internal.util.json.JSONValidatingReader;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public abstract class AlipayUtils {
    private static String localIp;


    public static String getFileSuffix(byte[] bytes) {
        /*  37 */
        if ((bytes == null) || (bytes.length < 10)) {
            /*  38 */
            return null;

        }

        /*  41 */
        if ((bytes[0] == 71) && (bytes[1] == 73) && (bytes[2] == 70))
            /*  42 */
            return "GIF";
        /*  43 */
        if ((bytes[1] == 80) && (bytes[2] == 78) && (bytes[3] == 71))
            /*  44 */
            return "PNG";
        /*  45 */
        if ((bytes[6] == 74) && (bytes[7] == 70) && (bytes[8] == 73) && (bytes[9] == 70))
            /*  46 */
            return "JPG";
        /*  47 */
        if ((bytes[0] == 66) && (bytes[1] == 77)) {
            /*  48 */
            return "BMP";

        }
        /*  50 */
        return null;

    }


    public static String getMimeType(byte[] bytes) {
        /*  61 */
        String suffix = getFileSuffix(bytes);

        String mimeType;

        String mimeType;
        /*  64 */
        if ("JPG".equals(suffix)) {
            /*  65 */
            mimeType = "image/jpeg";

        } else {

            String mimeType;
            /*  66 */
            if ("GIF".equals(suffix)) {
                /*  67 */
                mimeType = "image/gif";

            } else {

                String mimeType;
                /*  68 */
                if ("PNG".equals(suffix)) {
                    /*  69 */
                    mimeType = "image/png";

                } else {

                    String mimeType;
                    /*  70 */
                    if ("BMP".equals(suffix))
                        /*  71 */
                        mimeType = "image/bmp";

                    else
                        /*  73 */             mimeType = "application/octet-stream";

                }

            }

        }
        /*  76 */
        return mimeType;

    }


    public static <V> Map<String, V> cleanupMap(Map<String, V> map) {
        /*  87 */
        if ((map == null) || (map.isEmpty())) {
            /*  88 */
            return null;

        }

        /*  91 */
        Map result = new HashMap(map.size());
        /*  92 */
        Set entries = map.entrySet();

        /*  94 */
        for (Entry entry : entries) {
            /*  95 */
            if (entry.getValue() != null) {
                /*  96 */
                result.put(entry.getKey(), entry.getValue());

            }

        }

        /* 100 */
        return result;

    }


    public static Map<?, ?> parseJson(String body) {
        /* 110 */
        JSONReader jr = new JSONValidatingReader();
        /* 111 */
        Object obj = jr.read(body);
        /* 112 */
        if ((obj instanceof Map)) {
            /* 113 */
            return (Map) obj;

        }
        /* 115 */
        return null;

    }


    public static <T extends AlipayResponse> T parseResponse(String json, Class<T> clazz) throws AlipayApiException {
        /* 129 */
        ObjectJsonParser parser = new ObjectJsonParser(clazz);
        /* 130 */
        return parser.parse(json);

    }


    public static String getLocalNetWorkIp() {
        /* 137 */
        if (localIp != null)
            /* 138 */
            return localIp;

        try {
            /* 141 */
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
            /* 142 */
            InetAddress ip = null;
            /* 143 */
            while (netInterfaces.hasMoreElements()) {
                /* 144 */
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                /* 145 */
                if ((ni.isLoopback()) || (ni.isVirtual())) {

                    continue;

                }
                /* 148 */
                Enumeration addresss = ni.getInetAddresses();
                /* 149 */
                while (addresss.hasMoreElements()) {
                    /* 150 */
                    InetAddress address = (InetAddress) addresss.nextElement();
                    /* 151 */
                    if ((address instanceof Inet4Address)) {
                        /* 152 */
                        ip = address;
                        /* 153 */
                        break;

                    }

                }
                /* 156 */
                if (ip != null) {

                    break;

                }

            }
            /* 160 */
            if (ip != null)
                /* 161 */
                localIp = ip.getHostAddress();

            else
                /* 163 */         localIp = "127.0.0.1";

        } catch (Exception e) {
            /* 166 */
            localIp = "127.0.0.1";

        }
        /* 168 */
        return localIp;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.AlipayUtils
 * JD-Core Version:    0.6.0
 */