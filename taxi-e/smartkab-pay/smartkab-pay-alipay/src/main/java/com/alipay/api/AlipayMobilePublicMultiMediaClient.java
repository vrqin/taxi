package com.alipay.api;


import com.alipay.api.internal.parser.json.ObjectJsonParser;
import com.alipay.api.internal.util.*;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;


public class AlipayMobilePublicMultiMediaClient implements AlipayClient {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_GET = "GET";


    static {
        /*  80 */
        Security.setProperty("jdk.certpath.disabledAlgorithms", "");

    }

    private String serverUrl;
    private String appId;
    private String privateKey;
    private String prodCode;
    /*  57 */   private String format = "json";
    /*  58 */   private String sign_type = "RSA";
    private String charset;
    /*  62 */   private int connectTimeout = 3000;
    /*  63 */   private int readTimeout = 15000;


    public AlipayMobilePublicMultiMediaClient(String serverUrl, String appId, String privateKey) {
        /*  84 */
        this.serverUrl = serverUrl;
        /*  85 */
        this.appId = appId;
        /*  86 */
        this.privateKey = privateKey;

    }


    public AlipayMobilePublicMultiMediaClient(String serverUrl, String appId, String privateKey, String format) {
        /*  91 */
        this(serverUrl, appId, privateKey);
        /*  92 */
        this.format = format;

    }


    public AlipayMobilePublicMultiMediaClient(String serverUrl, String appId, String privateKey, String format, String charset) {
        /*  97 */
        this(serverUrl, appId, privateKey);
        /*  98 */
        this.format = format;
        /*  99 */
        this.charset = charset;

    }


    public AlipayMobilePublicMultiMediaClient(String serverUrl, String appId, String privateKey, String format, String charset, String signType) {
        /* 104 */
        this(serverUrl, appId, privateKey, format, charset);

        /* 106 */
        this.sign_type = signType;

    }


    public static AlipayMobilePublicMultiMediaDownloadResponse doGet(String url, RequestParametersHolder requestHolder, String charset, int connectTimeout, int readTimeout, OutputStream output)
            throws AlipayApiException, IOException {
        /* 222 */
        HttpURLConnection conn = null;
        /* 223 */
        AlipayMobilePublicMultiMediaDownloadResponse response = null;

        try {
            /* 227 */
            Map params = new TreeMap();
            /* 228 */
            AlipayHashMap appParams = requestHolder.getApplicationParams();
            /* 229 */
            if ((appParams != null) && (appParams.size() > 0)) {
                /* 230 */
                params.putAll(appParams);

            }
            /* 232 */
            AlipayHashMap protocalMustParams = requestHolder.getProtocalMustParams();
            /* 233 */
            if ((protocalMustParams != null) && (protocalMustParams.size() > 0)) {
                /* 234 */
                params.putAll(protocalMustParams);

            }
            /* 236 */
            AlipayHashMap protocalOptParams = requestHolder.getProtocalOptParams();
            /* 237 */
            if ((protocalOptParams != null) && (protocalOptParams.size() > 0)) {
                /* 238 */
                params.putAll(protocalOptParams);

            }

            /* 241 */
            String ctype = "application/x-www-form-urlencoded;charset=" + charset;
            /* 242 */
            String query = buildQuery(params, charset);

            try {
                /* 244 */
                conn = getConnection(buildGetUrl(url, query), "GET", ctype);
                /* 245 */
                conn.setConnectTimeout(connectTimeout);
                /* 246 */
                conn.setReadTimeout(readTimeout);

            } catch (IOException e) {
                /* 248 */
                Map map = getParamsFromUrl(url);
                /* 249 */
                AlipayLogger.logCommError(e, url, (String) map.get("app_key"), (String) map.get("method"), params);
                /* 250 */
                throw e;

            }

            try {
                /* 254 */
                if (conn.getResponseCode() == 200) {
                    /* 255 */
                    if ((conn.getContentType() != null) && (conn.getContentType()
                            .toLowerCase()
                            .contains("text/plain"))) {
                        /* 257 */
                        String rsp = getResponseAsString(conn);
                        /* 258 */
                        ObjectJsonParser parser = new ObjectJsonParser(AlipayMobilePublicMultiMediaDownloadResponse.class);

                        /* 260 */
                        response = (AlipayMobilePublicMultiMediaDownloadResponse) parser.parse(rsp);
                        /* 261 */
                        response.setBody(rsp);
                        /* 262 */
                        response.setParams(appParams);
                        /* 263 */
                        AlipayMobilePublicMultiMediaDownloadResponse localAlipayMobilePublicMultiMediaDownloadResponse1 = response;

                        /* 286 */
                        if (conn != null) {
                            /* 287 */
                            conn.disconnect();

                        }
                        /* 289 */
                        if (output != null)
                            /* 290 */
                            output.close();
                        return localAlipayMobilePublicMultiMediaDownloadResponse1;

                    }
                    /* 266 */
                    StreamUtil.io(conn.getInputStream(), output);
                    /* 267 */
                    response = new AlipayMobilePublicMultiMediaDownloadResponse();
                    /* 268 */
                    response.setCode("200");
                    /* 269 */
                    response.setMsg("成功");
                    /* 270 */
                    response.setBody("{\"alipay_mobile_public_multimedia_download_response\":{\"code\":200,\"msg\":\"成功\"}}");

                    /* 272 */
                    response.setParams(appParams);

                } else {
                    /* 274 */
                    response = new AlipayMobilePublicMultiMediaDownloadResponse();
                    /* 275 */
                    response.setCode(String.valueOf(conn.getResponseCode()));
                    /* 276 */
                    response.setMsg(conn.getResponseMessage());
                    /* 277 */
                    response.setParams(appParams);

                }

            } catch (IOException e) {
                /* 280 */
                Map map = getParamsFromUrl(url);
                /* 281 */
                AlipayLogger.logCommError(e, conn, (String) map.get("app_key"), (String) map.get("method"), params);
                /* 282 */
                throw e;

            }

        } finally {
            /* 286 */
            if (conn != null) {
                /* 287 */
                conn.disconnect();

            }
            /* 289 */
            if (output != null) {
                /* 290 */
                output.close();

            }

        }
        /* 293 */
        return response;

    }


    private static HttpURLConnection getConnection(URL url, String method, String ctype) throws IOException {
        /* 299 */
        HttpURLConnection conn = null;
        /* 300 */
        if ("https".equals(url.getProtocol())) {
            /* 301 */
            SSLContext ctx = null;

            try {
                /* 303 */
                ctx = SSLContext.getInstance("TLS");
                /* 304 */
                ctx.init(new KeyManager[0], new TrustManager[]{new DefaultTrustManager(null)}, new SecureRandom());

            } catch (Exception e) {
                /* 307 */
                throw new IOException(e);

            }
            /* 309 */
            HttpsURLConnection connHttps = (HttpsURLConnection) url.openConnection();
            /* 310 */
            connHttps.setSSLSocketFactory(ctx.getSocketFactory());
            /* 311 */
            connHttps.setHostnameVerifier(new HostnameVerifier() {

                public boolean verify(String hostname, SSLSession session) {
                    /* 313 */
                    return false;

                }

            });
            /* 316 */
            conn = connHttps;

        } else {
            /* 318 */
            conn = (HttpURLConnection) url.openConnection();

        }

        /* 321 */
        conn.setRequestMethod(method);
        /* 322 */
        conn.setDoInput(true);
        /* 323 */
        conn.setDoOutput(true);
        /* 324 */
        conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
        /* 325 */
        conn.setRequestProperty("User-Agent", "aop-sdk-java");
        /* 326 */
        conn.setRequestProperty("Content-Type", ctype);
        /* 327 */
        return conn;

    }


    protected static String getResponseAsString(HttpURLConnection conn) throws IOException {
        /* 331 */
        String charset = getResponseCharset(conn.getContentType());
        /* 332 */
        InputStream es = conn.getErrorStream();
        /* 333 */
        if (es == null) {
            /* 334 */
            return getStreamAsString(conn.getInputStream(), charset);

        }
        /* 336 */
        String msg = getStreamAsString(es, charset);
        /* 337 */
        if (StringUtils.isEmpty(msg)) {
            /* 338 */
            throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());

        }
        /* 340 */
        throw new IOException(msg);

    }


    private static String getStreamAsString(InputStream stream, String charset) throws IOException {

        try {
            /* 347 */
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset));
            /* 348 */
            StringWriter writer = new StringWriter();

            /* 350 */
            char[] chars = new char[256];
            /* 351 */
            int count = 0;
            /* 352 */
            while ((count = reader.read(chars)) > 0) {
                /* 353 */
                writer.write(chars, 0, count);

            }

            /* 356 */
            String str = writer.toString();

            return str;

        } finally {
            /* 358 */
            if (stream != null)
                /* 359 */
                stream.close();
            /* 359 */
        }
        throw localObject;

    }


    private static String getResponseCharset(String ctype) {
        /* 365 */
        String charset = "UTF-8";

        /* 367 */
        if (!StringUtils.isEmpty(ctype)) {
            /* 368 */
            String[] params = ctype.split(";");
            /* 369 */
            for (String param : params) {
                /* 370 */
                param = param.trim();
                /* 371 */
                if (param.startsWith("charset")) {
                    /* 372 */
                    String[] pair = param.split("=", 2);
                    /* 373 */
                    if ((pair.length != 2) ||
                            /* 374 */             (StringUtils.isEmpty(pair[1])))
                        break;
                    /* 375 */
                    charset = pair[1].trim();
                    break;

                }


            }


        }

        /* 383 */
        return charset;

    }


    private static Map<String, String> getParamsFromUrl(String url) {
        /* 387 */
        Map map = null;
        /* 388 */
        if ((url != null) && (url.indexOf('?') != -1)) {
            /* 389 */
            map = splitUrlQuery(url.substring(url.indexOf('?') + 1));

        }
        /* 391 */
        if (map == null) {
            /* 392 */
            map = new HashMap();

        }
        /* 394 */
        return map;

    }


    private static URL buildGetUrl(String strUrl, String query) throws IOException {
        /* 398 */
        URL url = new URL(strUrl);
        /* 399 */
        if (StringUtils.isEmpty(query)) {
            /* 400 */
            return url;

        }

        /* 403 */
        if (StringUtils.isEmpty(url.getQuery())) {
            /* 404 */
            if (strUrl.endsWith("?"))
                /* 405 */
                strUrl = strUrl + query;

            else {
                /* 407 */
                strUrl = strUrl + "?" + query;

            }

        }
        /* 410 */
        else if (strUrl.endsWith("&"))
            /* 411 */
            strUrl = strUrl + query;

        else {
            /* 413 */
            strUrl = strUrl + "&" + query;

        }

        /* 417 */
        return new URL(strUrl);

    }


    public static String buildQuery(Map<String, String> params, String charset) throws IOException {
        /* 421 */
        if ((params == null) || (params.isEmpty())) {
            /* 422 */
            return null;

        }

        /* 425 */
        StringBuilder query = new StringBuilder();
        /* 426 */
        Set entries = params.entrySet();
        /* 427 */
        boolean hasParam = false;

        /* 429 */
        for (Entry entry : entries) {
            /* 430 */
            String name = (String) entry.getKey();
            /* 431 */
            String value = (String) entry.getValue();

            /* 433 */
            if (StringUtils.areNotEmpty(new String[]{name, value})) {
                /* 434 */
                if (hasParam)
                    /* 435 */
                    query.append("&");

                else {
                    /* 437 */
                    hasParam = true;

                }

                /* 440 */
                query.append(name).append("=").append(URLEncoder.encode(value, charset));

            }

        }

        /* 444 */
        return query.toString();

    }


    public static Map<String, String> splitUrlQuery(String query) {
        /* 453 */
        Map result = new HashMap();

        /* 455 */
        String[] pairs = query.split("&");
        /* 456 */
        if ((pairs != null) && (pairs.length > 0)) {
            /* 457 */
            for (String pair : pairs) {
                /* 458 */
                String[] param = pair.split("=", 2);
                /* 459 */
                if ((param != null) && (param.length == 2)) {
                    /* 460 */
                    result.put(param[0], param[1]);

                }

            }

        }

        /* 465 */
        return result;

    }


    public <T extends AlipayResponse> T execute(AlipayRequest<T> request) throws AlipayApiException {
        /* 113 */
        return execute(request, null);

    }


    public <T extends AlipayResponse> T execute(AlipayRequest<T> request, String accessToken)
            throws AlipayApiException {
        /* 122 */
        return execute(request, accessToken, null);

    }


    public <T extends AlipayResponse> T execute(AlipayRequest<T> request, String accessToken, String appAuthToken)
            throws AlipayApiException {
        /* 131 */
        return _execute(request, accessToken, appAuthToken);

    }


    private <T extends AlipayResponse> T _execute(AlipayRequest<T> request, String authToken, String appAuthToken)
            throws AlipayApiException {
        /* 137 */
        return doGet(request, appAuthToken);

    }


    public <T extends AlipayResponse> T doGet(AlipayRequest<T> request, String appAuthToken) throws AlipayApiException {
        /* 143 */
        if (StringUtils.isEmpty(this.charset)) {
            /* 144 */
            this.charset = "UTF-8";

        }

        /* 147 */
        RequestParametersHolder requestHolder = new RequestParametersHolder();
        /* 148 */
        AlipayHashMap appParams = new AlipayHashMap(request.getTextParams());

        /* 150 */
        if (!StringUtils.isEmpty(appAuthToken)) {
            /* 151 */
            appParams.put("app_auth_token", appAuthToken);

        }

        /* 154 */
        requestHolder.setApplicationParams(appParams);

        /* 156 */
        AlipayHashMap protocalMustParams = new AlipayHashMap();
        /* 157 */
        protocalMustParams.put("method", request.getApiMethodName());
        /* 158 */
        protocalMustParams.put("version", request.getApiVersion());
        /* 159 */
        protocalMustParams.put("app_id", this.appId);
        /* 160 */
        protocalMustParams.put("sign_type", this.sign_type);
        /* 161 */
        protocalMustParams.put("charset", this.charset);

        /* 163 */
        Long timestamp = Long.valueOf(System.currentTimeMillis());
        /* 164 */
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /* 165 */
        df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        /* 166 */
        protocalMustParams.put("timestamp", df.format(new Date(timestamp.longValue())));
        /* 167 */
        protocalMustParams.put("format", this.format);
        /* 168 */
        requestHolder.setProtocalMustParams(protocalMustParams);

        /* 170 */
        if ("RSA".equals(this.sign_type)) {
            /* 172 */
            String signContent = AlipaySignature.getSignatureContent(requestHolder);

            /* 174 */
            protocalMustParams.put("sign", AlipaySignature.rsaSign(signContent, this.privateKey, this.charset));

        }
        /* 177 */
        else if ("RSA2".equals(this.sign_type)) {
            /* 179 */
            String signContent = AlipaySignature.getSignatureContent(requestHolder);

            /* 181 */
            protocalMustParams.put("sign", AlipaySignature.rsa256Sign(signContent, this.privateKey, this.charset));

        } else {
            /* 185 */
            protocalMustParams.put("sign", "");

        }

        /* 188 */
        AlipayMobilePublicMultiMediaDownloadResponse rsp = null;

        try {
            /* 191 */
            if ((request instanceof AlipayMobilePublicMultiMediaDownloadRequest)) {
                /* 192 */
                OutputStream outputStream = ((AlipayMobilePublicMultiMediaDownloadRequest) request).getOutputStream();

                /* 194 */
                rsp = doGet(this.serverUrl, requestHolder, this.charset, this.connectTimeout, this.readTimeout, outputStream);

            }

        } catch (IOException e) {
            /* 198 */
            throw new AlipayApiException(e);

        }
        /* 200 */
        return rsp;

    }


    public <T extends AlipayResponse> T pageExecute(AlipayRequest<T> request) throws AlipayApiException {
        /* 469 */
        return null;

    }


    public <T extends AlipayResponse> T pageExecute(AlipayRequest<T> request, String method) throws AlipayApiException {
        /* 474 */
        return null;

    }


    private static class DefaultTrustManager implements X509TrustManager {

        public X509Certificate[] getAcceptedIssuers() {
            /*  67 */
            return null;

        }


        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }


        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.AlipayMobilePublicMultiMediaClient
 * JD-Core Version:    0.6.0
 */