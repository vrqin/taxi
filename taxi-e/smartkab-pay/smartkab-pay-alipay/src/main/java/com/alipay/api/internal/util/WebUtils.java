package com.alipay.api.internal.util;


import com.alipay.api.FileItem;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public abstract class WebUtils {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_GET = "GET";
    /*  45 */   private static SSLContext ctx = null;

    /*  47 */   private static HostnameVerifier verifier = null;

    /*  49 */   private static SSLSocketFactory socketFactory = null;


    static {

        try {
            /*  68 */
            ctx = SSLContext.getInstance("TLS");
            /*  69 */
            ctx.init(new KeyManager[0], new TrustManager[]{new DefaultTrustManager(null)}, new SecureRandom());

            /*  72 */
            ctx.getClientSessionContext().setSessionTimeout(15);
            /*  73 */
            ctx.getClientSessionContext().setSessionCacheSize(1000);

            /*  75 */
            socketFactory = ctx.getSocketFactory();

        } catch (Exception e) {

        }
        /*  80 */
        verifier = new HostnameVerifier() {

            public boolean verify(String hostname, SSLSession session) {
                /*  82 */
                return false;

            }

        };

    }


    public static String doPost(String url, Map<String, String> params, int connectTimeout, int readTimeout)
            throws IOException {
        /* 101 */
        return doPost(url, params, "UTF-8", connectTimeout, readTimeout);

    }


    public static String doPost(String url, Map<String, String> params, String charset, int connectTimeout, int readTimeout)
            throws IOException {
        /* 115 */
        String ctype = "application/x-www-form-urlencoded;charset=" + charset;
        /* 116 */
        String query = buildQuery(params, charset);
        /* 117 */
        byte[] content = new byte[0];
        /* 118 */
        if (query != null) {
            /* 119 */
            content = query.getBytes(charset);

        }
        /* 121 */
        return doPost(url, ctype, content, connectTimeout, readTimeout);

    }


    public static String doPost(String url, String ctype, byte[] content, int connectTimeout, int readTimeout)
            throws IOException {
        /* 135 */
        HttpURLConnection conn = null;
        /* 136 */
        OutputStream out = null;
        /* 137 */
        String rsp = null;

        try {

            try {
                /* 140 */
                conn = getConnection(new URL(url), "POST", ctype);
                /* 141 */
                conn.setConnectTimeout(connectTimeout);
                /* 142 */
                conn.setReadTimeout(readTimeout);

            } catch (IOException e) {
                /* 144 */
                Map map = getParamsFromUrl(url);
                /* 145 */
                AlipayLogger.logCommError(e, url, (String) map.get("app_key"), (String) map.get("method"), content);
                /* 146 */
                throw e;

            }

            try {
                /* 149 */
                out = conn.getOutputStream();
                /* 150 */
                out.write(content);
                /* 151 */
                rsp = getResponseAsString(conn);

            } catch (IOException e) {
                /* 153 */
                Map map = getParamsFromUrl(url);
                /* 154 */
                AlipayLogger.logCommError(e, conn, (String) map.get("app_key"), (String) map.get("method"), content);
                /* 155 */
                throw e;

            }

        } finally {
            /* 159 */
            if (out != null) {
                /* 160 */
                out.close();

            }
            /* 162 */
            if (conn != null) {
                /* 163 */
                conn.disconnect();

            }


        }

        /* 168 */
        return rsp;

    }


    public static String doPost(String url, Map<String, String> params, Map<String, FileItem> fileParams, int connectTimeout, int readTimeout)
            throws IOException {
        /* 183 */
        if ((fileParams == null) || (fileParams.isEmpty())) {
            /* 184 */
            return doPost(url, params, "UTF-8", connectTimeout, readTimeout);

        }
        /* 186 */
        return doPost(url, params, fileParams, "UTF-8", connectTimeout, readTimeout);

    }


    public static String doPost(String url, Map<String, String> params, Map<String, FileItem> fileParams, String charset, int connectTimeout, int readTimeout)
            throws IOException {
        /* 203 */
        if ((fileParams == null) || (fileParams.isEmpty())) {
            /* 204 */
            return doPost(url, params, charset, connectTimeout, readTimeout);

        }

        /* 207 */
        String boundary = System.currentTimeMillis() + "";
        /* 208 */
        HttpURLConnection conn = null;
        /* 209 */
        OutputStream out = null;
        /* 210 */
        String rsp = null;

        try {

            try {
                /* 213 */
                String ctype = "multipart/form-data;boundary=" + boundary + ";charset=" + charset;
                /* 214 */
                conn = getConnection(new URL(url), "POST", ctype);
                /* 215 */
                conn.setConnectTimeout(connectTimeout);
                /* 216 */
                conn.setReadTimeout(readTimeout);

            } catch (IOException e) {
                /* 218 */
                Map map = getParamsFromUrl(url);
                /* 219 */
                AlipayLogger.logCommError(e, url, (String) map.get("app_key"), (String) map.get("method"), params);
                /* 220 */
                throw e;

            }

            try {
                /* 224 */
                out = conn.getOutputStream();

                /* 226 */
                byte[] entryBoundaryBytes = ("\r\n--" + boundary + "\r\n").getBytes(charset);

                /* 229 */
                Set textEntrySet = params.entrySet();
                /* 230 */
                for (Entry textEntry : textEntrySet) {
                    /* 231 */
                    byte[] textBytes = getTextEntry((String) textEntry.getKey(), (String) textEntry.getValue(), charset);

                    /* 233 */
                    out.write(entryBoundaryBytes);
                    /* 234 */
                    out.write(textBytes);

                }

                /* 238 */
                Set fileEntrySet = fileParams.entrySet();
                /* 239 */
                for (Entry fileEntry : fileEntrySet) {
                    /* 240 */
                    FileItem fileItem = (FileItem) fileEntry.getValue();
                    /* 241 */
                    byte[] fileBytes = getFileEntry((String) fileEntry.getKey(), fileItem.getFileName(), fileItem.getMimeType(), charset);

                    /* 243 */
                    out.write(entryBoundaryBytes);
                    /* 244 */
                    out.write(fileBytes);
                    /* 245 */
                    out.write(fileItem.getContent());

                }

                /* 249 */
                byte[] endBoundaryBytes = ("\r\n--" + boundary + "--\r\n").getBytes(charset);
                /* 250 */
                out.write(endBoundaryBytes);
                /* 251 */
                rsp = getResponseAsString(conn);

            } catch (IOException e) {
                /* 253 */
                Map map = getParamsFromUrl(url);
                /* 254 */
                AlipayLogger.logCommError(e, conn, (String) map.get("app_key"), (String) map.get("method"), params);
                /* 255 */
                throw e;

            }

        } finally {
            /* 259 */
            if (out != null) {
                /* 260 */
                out.close();

            }
            /* 262 */
            if (conn != null) {
                /* 263 */
                conn.disconnect();

            }

        }

        /* 267 */
        return rsp;

    }


    private static byte[] getTextEntry(String fieldName, String fieldValue, String charset) throws IOException {
        /* 272 */
        StringBuilder entry = new StringBuilder();
        /* 273 */
        entry.append("Content-Disposition:form-data;name=\"");
        /* 274 */
        entry.append(fieldName);
        /* 275 */
        entry.append("\"\r\nContent-Type:text/plain\r\n\r\n");
        /* 276 */
        entry.append(fieldValue);
        /* 277 */
        return entry.toString().getBytes(charset);

    }


    private static byte[] getFileEntry(String fieldName, String fileName, String mimeType, String charset)
            throws IOException {
        /* 282 */
        StringBuilder entry = new StringBuilder();
        /* 283 */
        entry.append("Content-Disposition:form-data;name=\"");
        /* 284 */
        entry.append(fieldName);
        /* 285 */
        entry.append("\";filename=\"");
        /* 286 */
        entry.append(fileName);
        /* 287 */
        entry.append("\"\r\nContent-Type:");
        /* 288 */
        entry.append(mimeType);
        /* 289 */
        entry.append("\r\n\r\n");
        /* 290 */
        return entry.toString().getBytes(charset);

    }


    public static String doGet(String url, Map<String, String> params) throws IOException {
        /* 302 */
        return doGet(url, params, "UTF-8");

    }


    public static String doGet(String url, Map<String, String> params, String charset) throws IOException {
        /* 316 */
        HttpURLConnection conn = null;
        /* 317 */
        String rsp = null;

        try {
            /* 320 */
            String ctype = "application/x-www-form-urlencoded;charset=" + charset;
            /* 321 */
            String query = buildQuery(params, charset);

            try {
                /* 323 */
                conn = getConnection(buildGetUrl(url, query), "GET", ctype);

            } catch (IOException e) {
                /* 325 */
                Map map = getParamsFromUrl(url);
                /* 326 */
                AlipayLogger.logCommError(e, url, (String) map.get("app_key"), (String) map.get("method"), params);
                /* 327 */
                throw e;

            }

            try {
                /* 331 */
                rsp = getResponseAsString(conn);

            } catch (IOException e) {
                /* 333 */
                Map map = getParamsFromUrl(url);
                /* 334 */
                AlipayLogger.logCommError(e, conn, (String) map.get("app_key"), (String) map.get("method"), params);
                /* 335 */
                throw e;

            }

        } finally {
            /* 339 */
            if (conn != null) {
                /* 340 */
                conn.disconnect();

            }

        }

        /* 344 */
        return rsp;

    }


    private static HttpURLConnection getConnection(URL url, String method, String ctype) throws IOException {
        /* 349 */
        HttpURLConnection conn = null;
        /* 350 */
        if ("https".equals(url.getProtocol())) {
            /* 351 */
            HttpsURLConnection connHttps = (HttpsURLConnection) url.openConnection();
            /* 352 */
            connHttps.setSSLSocketFactory(socketFactory);
            /* 353 */
            connHttps.setHostnameVerifier(verifier);
            /* 354 */
            conn = connHttps;

        } else {
            /* 356 */
            conn = (HttpURLConnection) url.openConnection();

        }

        /* 359 */
        conn.setRequestMethod(method);
        /* 360 */
        conn.setDoInput(true);
        /* 361 */
        conn.setDoOutput(true);
        /* 362 */
        conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
        /* 363 */
        conn.setRequestProperty("User-Agent", "aop-sdk-java");
        /* 364 */
        conn.setRequestProperty("Content-Type", ctype);
        /* 365 */
        return conn;

    }


    private static URL buildGetUrl(String strUrl, String query) throws IOException {
        /* 369 */
        URL url = new URL(strUrl);
        /* 370 */
        if (StringUtils.isEmpty(query)) {
            /* 371 */
            return url;

        }

        /* 374 */
        if (StringUtils.isEmpty(url.getQuery())) {
            /* 375 */
            if (strUrl.endsWith("?"))
                /* 376 */
                strUrl = strUrl + query;

            else {
                /* 378 */
                strUrl = strUrl + "?" + query;

            }

        }
        /* 381 */
        else if (strUrl.endsWith("&"))
            /* 382 */
            strUrl = strUrl + query;

        else {
            /* 384 */
            strUrl = strUrl + "&" + query;

        }

        /* 388 */
        return new URL(strUrl);

    }


    public static String buildQuery(Map<String, String> params, String charset) throws IOException {
        /* 392 */
        if ((params == null) || (params.isEmpty())) {
            /* 393 */
            return null;

        }

        /* 396 */
        StringBuilder query = new StringBuilder();
        /* 397 */
        Set entries = params.entrySet();
        /* 398 */
        boolean hasParam = false;

        /* 400 */
        for (Entry entry : entries) {
            /* 401 */
            String name = (String) entry.getKey();
            /* 402 */
            String value = (String) entry.getValue();

            /* 404 */
            if (StringUtils.areNotEmpty(new String[]{name, value})) {
                /* 405 */
                if (hasParam)
                    /* 406 */
                    query.append("&");

                else {
                    /* 408 */
                    hasParam = true;

                }

                /* 411 */
                query.append(name).append("=").append(URLEncoder.encode(value, charset));

            }

        }

        /* 415 */
        return query.toString();

    }


    protected static String getResponseAsString(HttpURLConnection conn) throws IOException {
        /* 419 */
        String charset = getResponseCharset(conn.getContentType());
        /* 420 */
        InputStream es = conn.getErrorStream();
        /* 421 */
        if (es == null) {
            /* 422 */
            return getStreamAsString(conn.getInputStream(), charset);

        }
        /* 424 */
        String msg = getStreamAsString(es, charset);
        /* 425 */
        if (StringUtils.isEmpty(msg)) {
            /* 426 */
            throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());

        }
        /* 428 */
        throw new IOException(msg);

    }


    private static String getStreamAsString(InputStream stream, String charset) throws IOException {

        try {
            /* 435 */
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset));
            /* 436 */
            StringWriter writer = new StringWriter();

            /* 438 */
            char[] chars = new char[256];
            /* 439 */
            int count = 0;
            /* 440 */
            while ((count = reader.read(chars)) > 0) {
                /* 441 */
                writer.write(chars, 0, count);

            }

            /* 444 */
            String str = writer.toString();

            return str;

        } finally {
            /* 446 */
            if (stream != null)
                /* 447 */
                stream.close();
            /* 447 */
        }
        throw localObject;

    }


    private static String getResponseCharset(String ctype) {
        /* 453 */
        String charset = "UTF-8";

        /* 455 */
        if (!StringUtils.isEmpty(ctype)) {
            /* 456 */
            String[] params = ctype.split(";");
            /* 457 */
            for (String param : params) {
                /* 458 */
                param = param.trim();
                /* 459 */
                if (param.startsWith("charset")) {
                    /* 460 */
                    String[] pair = param.split("=", 2);
                    /* 461 */
                    if ((pair.length != 2) ||
                            /* 462 */             (StringUtils.isEmpty(pair[1])))
                        break;
                    /* 463 */
                    charset = pair[1].trim();
                    break;

                }


            }


        }

        /* 471 */
        return charset;

    }


    public static String decode(String value) {
        /* 481 */
        return decode(value, "UTF-8");

    }


    public static String encode(String value) {
        /* 491 */
        return encode(value, "UTF-8");

    }


    public static String decode(String value, String charset) {
        /* 502 */
        String result = null;
        /* 503 */
        if (!StringUtils.isEmpty(value)) {

            try {
                /* 505 */
                result = URLDecoder.decode(value, charset);

            } catch (IOException e) {
                /* 507 */
                throw new RuntimeException(e);

            }

        }
        /* 510 */
        return result;

    }


    public static String encode(String value, String charset) {
        /* 521 */
        String result = null;
        /* 522 */
        if (!StringUtils.isEmpty(value)) {

            try {
                /* 524 */
                result = URLEncoder.encode(value, charset);

            } catch (IOException e) {
                /* 526 */
                throw new RuntimeException(e);

            }

        }
        /* 529 */
        return result;

    }


    private static Map<String, String> getParamsFromUrl(String url) {
        /* 533 */
        Map map = null;
        /* 534 */
        if ((url != null) && (url.indexOf('?') != -1)) {
            /* 535 */
            map = splitUrlQuery(url.substring(url.indexOf('?') + 1));

        }
        /* 537 */
        if (map == null) {
            /* 538 */
            map = new HashMap();

        }
        /* 540 */
        return map;

    }


    public static Map<String, String> splitUrlQuery(String query) {
        /* 550 */
        Map result = new HashMap();

        /* 552 */
        String[] pairs = query.split("&");
        /* 553 */
        if ((pairs != null) && (pairs.length > 0)) {
            /* 554 */
            for (String pair : pairs) {
                /* 555 */
                String[] param = pair.split("=", 2);
                /* 556 */
                if ((param != null) && (param.length == 2)) {
                    /* 557 */
                    result.put(param[0], param[1]);

                }

            }

        }

        /* 562 */
        return result;

    }


    public static String buildForm(String baseUrl, Map<String, String> parameters) {
        /* 570 */
        StringBuilder sb = new StringBuilder();
        /* 571 */
        sb.append("<form name=\"punchout_form\" method=\"post\" action=\"");
        /* 572 */
        sb.append(baseUrl);
        /* 573 */
        sb.append("\">\n");
        /* 574 */
        sb.append(buildHiddenFields(parameters));

        /* 576 */
        sb.append("<input type=\"submit\" value=\"立即支付\" style=\"display:none\" >\n");
        /* 577 */
        sb.append("</form>\n");
        /* 578 */
        sb.append("<script>document.forms[0].submit();</script>");
        /* 579 */
        String form = sb.toString();
        /* 580 */
        return form;

    }


    private static String buildHiddenFields(Map<String, String> parameters) {
        /* 584 */
        if ((parameters == null) || (parameters.isEmpty())) {
            /* 585 */
            return "";

        }
        /* 587 */
        StringBuilder sb = new StringBuilder();
        /* 588 */
        Set keys = parameters.keySet();
        /* 589 */
        for (String key : keys) {
            /* 590 */
            String value = (String) parameters.get(key);

            /* 592 */
            if ((key == null) || (value == null)) {

                continue;

            }
            /* 595 */
            sb.append(buildHiddenField(key, value));

        }
        /* 597 */
        String result = sb.toString();
        /* 598 */
        return result;

    }


    private static String buildHiddenField(String key, String value) {
        /* 602 */
        StringBuilder sb = new StringBuilder();
        /* 603 */
        sb.append("<input type=\"hidden\" name=\"");
        /* 604 */
        sb.append(key);

        /* 606 */
        sb.append("\" value=\"");

        /* 608 */
        String a = value.replace("\"", "&quot;");
        /* 609 */
        sb.append(a).append("\">\n");
        /* 610 */
        return sb.toString();

    }


    public String buildForm(String baseUrl, RequestParametersHolder requestHolder) {
        /* 566 */
        return null;

    }


    private static class DefaultTrustManager implements X509TrustManager {

        public X509Certificate[] getAcceptedIssuers() {
            /*  53 */
            return null;

        }


        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }


        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.WebUtils
 * JD-Core Version:    0.6.0
 */