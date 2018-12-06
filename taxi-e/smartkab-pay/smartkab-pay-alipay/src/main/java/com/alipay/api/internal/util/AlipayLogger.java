package com.alipay.api.internal.util;


import com.alipay.api.AlipayResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Jdk14Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;


public class AlipayLogger {
    /*  32 */   private static final Log clog = LogFactory.getLog("sdk.comm.err");
    /*  33 */   private static final Log blog = LogFactory.getLog("sdk.biz.err");

    /*  35 */   private static String osName = System.getProperties().getProperty("os.name");
    /*  36 */   private static String ip = null;
    /*  37 */   private static boolean needEnableLogger = true;


    public static void setNeedEnableLogger(boolean needEnableLogger) {
        /*  40 */
        needEnableLogger = needEnableLogger;

    }


    public static String getIp() {
        /*  44 */
        if (ip == null) {

            try {
                /*  46 */
                ip = InetAddress.getLocalHost().getHostAddress();

            } catch (Exception e) {
                /*  48 */
                e.printStackTrace();

            }

        }
        /*  51 */
        return ip;

    }


    public static void setIp(String ip) {
        /*  55 */
        ip = ip;

    }


    public static void logCommError(Exception e, HttpURLConnection conn, String appKey, String method, byte[] content) {
        /*  63 */
        if (!needEnableLogger) {
            /*  64 */
            return;

        }
        /*  66 */
        String contentString = null;

        try {
            /*  68 */
            contentString = new String(content, "UTF-8");
            /*  69 */
            logCommError(e, conn, appKey, method, contentString);

        } catch (Exception e1) {
            /*  71 */
            e1.printStackTrace();

        }

    }


    public static void logCommError(Exception e, String url, String appKey, String method, byte[] content) {
        /*  80 */
        if (!needEnableLogger) {
            /*  81 */
            return;

        }
        /*  83 */
        String contentString = null;

        try {
            /*  85 */
            contentString = new String(content, "UTF-8");
            /*  86 */
            logCommError(e, url, appKey, method, contentString);

        } catch (UnsupportedEncodingException e1) {
            /*  88 */
            e1.printStackTrace();

        }

    }


    public static void logCommError(Exception e, HttpURLConnection conn, String appKey, String method, Map<String, String> params) {
        /*  97 */
        if (!needEnableLogger) {
            /*  98 */
            return;

        }
        /* 100 */
        _logCommError(e, conn, null, appKey, method, params);

    }


    public static void logCommError(Exception e, String url, String appKey, String method, Map<String, String> params) {
        /* 105 */
        if (!needEnableLogger) {
            /* 106 */
            return;

        }
        /* 108 */
        _logCommError(e, null, url, appKey, method, params);

    }


    private static void logCommError(Exception e, HttpURLConnection conn, String appKey, String method, String content) {
        /* 116 */
        Map params = parseParam(content);
        /* 117 */
        _logCommError(e, conn, null, appKey, method, params);

    }


    private static void logCommError(Exception e, String url, String appKey, String method, String content) {
        /* 125 */
        Map params = parseParam(content);
        /* 126 */
        _logCommError(e, null, url, appKey, method, params);

    }


    private static void _logCommError(Exception e, HttpURLConnection conn, String url, String appKey, String method, Map<String, String> params) {
        /* 134 */
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /* 135 */
        df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        /* 136 */
        String sdkName = "alipay-sdk-java-dynamicVersionNo";
        /* 137 */
        String urlStr = null;
        /* 138 */
        String rspCode = "";
        /* 139 */
        if (conn != null) {

            try {
                /* 141 */
                urlStr = conn.getURL().toString();
                /* 142 */
                rspCode = "HTTP_ERROR_" + conn.getResponseCode();

            } catch (IOException ioe) {

            }

        } else {
            /* 146 */
            urlStr = url;
            /* 147 */
            rspCode = "";

        }
        /* 149 */
        StringBuilder sb = new StringBuilder();
        /* 150 */
        sb.append(df.format(new Date()));
        /* 151 */
        sb.append("^_^");
        /* 152 */
        sb.append(method);
        /* 153 */
        sb.append("^_^");
        /* 154 */
        sb.append(appKey);
        /* 155 */
        sb.append("^_^");
        /* 156 */
        sb.append(getIp());
        /* 157 */
        sb.append("^_^");
        /* 158 */
        sb.append(osName);
        /* 159 */
        sb.append("^_^");
        /* 160 */
        sb.append(sdkName);
        /* 161 */
        sb.append("^_^");
        /* 162 */
        sb.append(urlStr);
        /* 163 */
        sb.append("^_^");
        /* 164 */
        sb.append(rspCode);
        /* 165 */
        sb.append("^_^");
        /* 166 */
        sb.append((e.getMessage() + "").replaceAll("\r\n", " "));
        /* 167 */
        clog.error(sb.toString());

    }


    private static Map<String, String> parseParam(String contentString) {
        /* 171 */
        Map params = new HashMap();
        /* 172 */
        if ((contentString == null) || (contentString.trim().equals(""))) {
            /* 173 */
            return params;

        }
        /* 175 */
        String[] paramsArray = contentString.split("\\&");
        /* 176 */
        if (paramsArray != null) {
            /* 177 */
            for (String param : paramsArray) {
                /* 178 */
                String[] keyValue = param.split("=");
                /* 179 */
                if ((keyValue != null) && (keyValue.length == 2)) {
                    /* 180 */
                    params.put(keyValue[0], keyValue[1]);

                }

            }

        }
        /* 184 */
        return params;

    }


    public static void logBizDebug(String rsp) {
        /* 191 */
        if (!needEnableLogger) {
            /* 192 */
            return;

        }
        /* 194 */
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /* 195 */
        df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        /* 196 */
        StringBuilder sb = new StringBuilder();
        /* 197 */
        sb.append(df.format(new Date()));
        /* 198 */
        sb.append("^_^");
        /* 199 */
        sb.append(rsp);

        /* 201 */
        if (blog.isDebugEnabled())
            /* 202 */
            blog.debug(sb.toString());

    }


    public static void logBizError(String rsp) {
        /* 210 */
        if (!needEnableLogger) {
            /* 211 */
            return;

        }
        /* 213 */
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /* 214 */
        df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        /* 215 */
        StringBuilder sb = new StringBuilder();
        /* 216 */
        sb.append(df.format(new Date()));
        /* 217 */
        sb.append("^_^");
        /* 218 */
        sb.append(rsp);
        /* 219 */
        blog.error(sb.toString());

    }


    public static void logBizError(Throwable t) {
        /* 226 */
        if (!needEnableLogger) {
            /* 227 */
            return;

        }
        /* 229 */
        blog.error(t);

    }


    public static void logErrorScene(Map<String, Object> rt, AlipayResponse tRsp, String appSecret) {
        /* 237 */
        if (!needEnableLogger) {
            /* 238 */
            return;

        }
        /* 240 */
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /* 241 */
        df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        /* 242 */
        StringBuilder sb = new StringBuilder();
        /* 243 */
        sb.append("ErrorScene");
        /* 244 */
        sb.append("^_^");
        /* 245 */
        sb.append(tRsp.getErrorCode());
        /* 246 */
        sb.append("^_^");
        /* 247 */
        sb.append(tRsp.getSubCode());
        /* 248 */
        sb.append("^_^");
        /* 249 */
        sb.append(ip);
        /* 250 */
        sb.append("^_^");
        /* 251 */
        sb.append(osName);
        /* 252 */
        sb.append("^_^");
        /* 253 */
        sb.append(df.format(new Date()));
        /* 254 */
        sb.append("^_^");
        /* 255 */
        sb.append("ProtocalMustParams:");
        /* 256 */
        appendLog((AlipayHashMap) rt.get("protocalMustParams"), sb);
        /* 257 */
        sb.append("^_^");
        /* 258 */
        sb.append("ProtocalOptParams:");
        /* 259 */
        appendLog((AlipayHashMap) rt.get("protocalOptParams"), sb);
        /* 260 */
        sb.append("^_^");
        /* 261 */
        sb.append("ApplicationParams:");
        /* 262 */
        appendLog((AlipayHashMap) rt.get("textParams"), sb);
        /* 263 */
        sb.append("^_^");
        /* 264 */
        sb.append("Body:");
        /* 265 */
        sb.append((String) rt.get("rsp"));
        /* 266 */
        blog.error(sb.toString());

    }


    private static void appendLog(AlipayHashMap map, StringBuilder sb) {
        /* 270 */
        boolean first = true;
        /* 271 */
        Set set = map.entrySet();
        /* 272 */
        for (Entry entry : set) {
            /* 273 */
            if (!first)
                /* 274 */
                sb.append("&");

            else {
                /* 276 */
                first = false;

            }
            /* 278 */
            sb.append((String) entry.getKey()).append("=").append((String) entry.getValue());

        }

    }


    public static Boolean isBizDebugEnabled() {
        /* 283 */
        return Boolean.valueOf(blog.isDebugEnabled());

    }


    public static void setJDKDebugEnabled(Boolean isEnabled) {
        /* 293 */
        if ((blog instanceof Jdk14Logger)) {
            /* 294 */
            Jdk14Logger logger = (Jdk14Logger) blog;
            /* 295 */
            if (isEnabled.booleanValue()) {
                /* 296 */
                logger.getLogger().setLevel(Level.FINE);
                /* 297 */
                Handler consoleHandler = new ConsoleHandler();
                /* 298 */
                consoleHandler.setLevel(Level.FINE);
                /* 299 */
                logger.getLogger().addHandler(consoleHandler);

            } else {
                /* 301 */
                logger.getLogger().setLevel(Level.INFO);

            }

        }

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.AlipayLogger
 * JD-Core Version:    0.6.0
 */