package com.alipay.api;


import com.alipay.api.internal.parser.json.ObjectJsonParser;
import com.alipay.api.internal.parser.xml.ObjectXmlParser;
import com.alipay.api.internal.util.*;

import java.io.IOException;
import java.security.Security;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;


public class DefaultAlipayClient implements AlipayClient {

    static {
        /*  54 */
        Security.setProperty("jdk.certpath.disabledAlgorithms", "");

    }

    private String serverUrl;
    private String appId;
    private String privateKey;
    private String prodCode;
    /*  38 */   private String format = "json";
    /*  39 */   private String sign_type = "RSA";

    /*  41 */   private String encryptType = "AES";
    private String encryptKey;
    private String alipayPublicKey;
    private String charset;
    /*  49 */   private int connectTimeout = 3000;
    /*  50 */   private int readTimeout = 15000;


    public DefaultAlipayClient(String serverUrl, String appId, String privateKey) {
        /*  58 */
        this.serverUrl = serverUrl;
        /*  59 */
        this.appId = appId;
        /*  60 */
        this.privateKey = privateKey;
        /*  61 */
        this.alipayPublicKey = null;

    }


    public DefaultAlipayClient(String serverUrl, String appId, String privateKey, String format) {
        /*  65 */
        this(serverUrl, appId, privateKey);
        /*  66 */
        this.format = format;

    }


    public DefaultAlipayClient(String serverUrl, String appId, String privateKey, String format, String charset) {
        /*  71 */
        this(serverUrl, appId, privateKey);
        /*  72 */
        this.format = format;
        /*  73 */
        this.charset = charset;

    }


    public DefaultAlipayClient(String serverUrl, String appId, String privateKey, String format, String charset, String alipayPulicKey) {
        /*  78 */
        this(serverUrl, appId, privateKey);
        /*  79 */
        this.format = format;
        /*  80 */
        this.charset = charset;
        /*  81 */
        this.alipayPublicKey = alipayPulicKey;

    }


    public DefaultAlipayClient(String serverUrl, String appId, String privateKey, String format, String charset, String alipayPulicKey, String signType) {
        /*  87 */
        this(serverUrl, appId, privateKey, format, charset, alipayPulicKey);

        /*  89 */
        this.sign_type = signType;

    }


    public DefaultAlipayClient(String serverUrl, String appId, String privateKey, String format, String charset, String alipayPulicKey, String signType, String encryptKey, String encryptType) {
        /*  96 */
        this(serverUrl, appId, privateKey, format, charset, alipayPulicKey, signType);

        /*  98 */
        this.encryptType = encryptType;
        /*  99 */
        this.encryptKey = encryptKey;

    }


    public <T extends AlipayResponse> T execute(AlipayRequest<T> request) throws AlipayApiException {
        /* 103 */
        return execute(request, null);

    }


    public <T extends AlipayResponse> T execute(AlipayRequest<T> request, String accessToken)
            throws AlipayApiException {
        /* 109 */
        return execute(request, accessToken, null);

    }


    public <T extends AlipayResponse> T execute(AlipayRequest<T> request, String accessToken, String appAuthToken)
            throws AlipayApiException {
        /* 115 */
        AlipayParser parser = null;
        /* 116 */
        if ("xml".equals(this.format))
            /* 117 */
            parser = new ObjectXmlParser(request.getResponseClass());

        else {
            /* 119 */
            parser = new ObjectJsonParser(request.getResponseClass());

        }

        /* 122 */
        return _execute(request, parser, accessToken, appAuthToken);

    }


    public <T extends AlipayResponse> T pageExecute(AlipayRequest<T> request) throws AlipayApiException {
        /* 126 */
        return pageExecute(request, "POST");

    }


    public <T extends AlipayResponse> T pageExecute(AlipayRequest<T> request, String httpMethod)
            throws AlipayApiException {
        /* 131 */
        RequestParametersHolder requestHolder = getRequestHolderWithSign(request, null, null);

        /* 133 */
        if (AlipayLogger.isBizDebugEnabled().booleanValue()) {
            /* 134 */
            AlipayLogger.logBizDebug(getRedirectUrl(requestHolder));

        }
        /* 136 */
        AlipayResponse rsp = null;

        try {
            /* 138 */
            Class clazz = request.getResponseClass();
            /* 139 */
            rsp = (AlipayResponse) clazz.newInstance();

        } catch (InstantiationException e) {
            /* 141 */
            AlipayLogger.logBizError(e);

        } catch (IllegalAccessException e) {
            /* 143 */
            AlipayLogger.logBizError(e);

        }
        /* 145 */
        if ("GET".equalsIgnoreCase(httpMethod)) {
            /* 146 */
            rsp.setBody(getRedirectUrl(requestHolder));

        } else {
            /* 148 */
            String baseUrl = getRequestUrl(requestHolder);
            /* 149 */
            rsp.setBody(WebUtils.buildForm(baseUrl, requestHolder.getApplicationParams()));

        }
        /* 151 */
        return rsp;

    }


    private <T extends AlipayResponse> RequestParametersHolder getRequestHolderWithSign(AlipayRequest<?> request, String accessToken, String appAuthToken)
            throws AlipayApiException {
        /* 166 */
        RequestParametersHolder requestHolder = new RequestParametersHolder();
        /* 167 */
        AlipayHashMap appParams = new AlipayHashMap(request.getTextParams());

        /* 170 */
        if (request.isNeedEncrypt()) {
            /* 172 */
            if (StringUtils.isEmpty((String) appParams.get("biz_content"))) {
                /* 174 */
                throw new AlipayApiException("当前API不支持加密请求");

            }

            /* 178 */
            if (!StringUtils.areNotEmpty(new String[]{this.encryptKey, this.encryptType})) {
                /* 180 */
                throw new AlipayApiException("API请求要求加密，则必须设置密钥和密钥类型：encryptKey=" + this.encryptKey + ",encryptType=" + this.encryptType);

            }

            /* 184 */
            String encryptContent = AlipayEncrypt.encryptContent((String) appParams.get("biz_content"), this.encryptType, this.encryptKey, this.charset);

            /* 188 */
            appParams.put("biz_content", encryptContent);

        }

        /* 191 */
        if (!StringUtils.isEmpty(appAuthToken)) {
            /* 192 */
            appParams.put("app_auth_token", appAuthToken);

        }

        /* 195 */
        requestHolder.setApplicationParams(appParams);

        /* 197 */
        if (StringUtils.isEmpty(this.charset)) {
            /* 198 */
            this.charset = "UTF-8";

        }

        /* 201 */
        AlipayHashMap protocalMustParams = new AlipayHashMap();
        /* 202 */
        protocalMustParams.put("method", request.getApiMethodName());
        /* 203 */
        protocalMustParams.put("version", request.getApiVersion());
        /* 204 */
        protocalMustParams.put("app_id", this.appId);
        /* 205 */
        protocalMustParams.put("sign_type", this.sign_type);
        /* 206 */
        protocalMustParams.put("terminal_type", request.getTerminalType());
        /* 207 */
        protocalMustParams.put("terminal_info", request.getTerminalInfo());
        /* 208 */
        protocalMustParams.put("notify_url", request.getNotifyUrl());
        /* 209 */
        protocalMustParams.put("return_url", request.getReturnUrl());
        /* 210 */
        protocalMustParams.put("charset", this.charset);

        /* 212 */
        if (request.isNeedEncrypt()) {
            /* 213 */
            protocalMustParams.put("encrypt_type", this.encryptType);

        }

        /* 216 */
        Long timestamp = Long.valueOf(System.currentTimeMillis());
        /* 217 */
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /* 218 */
        df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        /* 219 */
        protocalMustParams.put("timestamp", df.format(new Date(timestamp.longValue())));
        /* 220 */
        requestHolder.setProtocalMustParams(protocalMustParams);

        /* 222 */
        AlipayHashMap protocalOptParams = new AlipayHashMap();
        /* 223 */
        protocalOptParams.put("format", this.format);
        /* 224 */
        protocalOptParams.put("auth_token", accessToken);
        /* 225 */
        protocalOptParams.put("alipay_sdk", "alipay-sdk-java-dynamicVersionNo");
        /* 226 */
        protocalOptParams.put("prod_code", request.getProdCode());
        /* 227 */
        requestHolder.setProtocalOptParams(protocalOptParams);

        /* 229 */
        if (!StringUtils.isEmpty(this.sign_type)) {
            /* 231 */
            String signContent = AlipaySignature.getSignatureContent(requestHolder);
            /* 232 */
            protocalMustParams.put("sign", AlipaySignature.rsaSign(signContent, this.privateKey, this.charset, this.sign_type));

        } else {
            /* 236 */
            protocalMustParams.put("sign", "");

        }
        /* 238 */
        return requestHolder;

    }


    private String getRequestUrl(RequestParametersHolder requestHolder) throws AlipayApiException {
        /* 249 */
        StringBuilder urlSb = new StringBuilder(this.serverUrl);

        try {
            /* 251 */
            String sysMustQuery = WebUtils.buildQuery(requestHolder.getProtocalMustParams(), this.charset);

            /* 253 */
            String sysOptQuery = WebUtils.buildQuery(requestHolder.getProtocalOptParams(), this.charset);

            /* 255 */
            urlSb.append("?");
            /* 256 */
            urlSb.append(sysMustQuery);
            /* 257 */
            if (((sysOptQuery != null ? 1 : 0) & (sysOptQuery.length() > 0 ? 1 : 0)) != 0) {
                /* 258 */
                urlSb.append("&");
                /* 259 */
                urlSb.append(sysOptQuery);

            }

        } catch (IOException e) {
            /* 262 */
            throw new AlipayApiException(e);

        }

        /* 265 */
        return urlSb.toString();

    }


    private String getRedirectUrl(RequestParametersHolder requestHolder) throws AlipayApiException {
        /* 276 */
        StringBuilder urlSb = new StringBuilder(this.serverUrl);

        try {
            /* 278 */
            Map sortedMap = AlipaySignature.getSortedMap(requestHolder);
            /* 279 */
            String sortedQuery = WebUtils.buildQuery(sortedMap, this.charset);
            /* 280 */
            String sign = (String) requestHolder.getProtocalMustParams().get("sign");
            /* 281 */
            urlSb.append("?");
            /* 282 */
            urlSb.append(sortedQuery);
            /* 283 */
            if (((sign != null ? 1 : 0) & (sign.length() > 0 ? 1 : 0)) != 0) {
                /* 284 */
                Map signMap = new HashMap();
                /* 285 */
                signMap.put("sign", sign);
                /* 286 */
                String signQuery = WebUtils.buildQuery(signMap, this.charset);
                /* 287 */
                urlSb.append("&");
                /* 288 */
                urlSb.append(signQuery);

            }

        } catch (IOException e) {
            /* 291 */
            throw new AlipayApiException(e);

        }

        /* 294 */
        return urlSb.toString();

    }


    private <T extends AlipayResponse> T _execute(AlipayRequest<T> request, AlipayParser<T> parser, String authToken, String appAuthToken)
            throws AlipayApiException {
        /* 301 */
        Map rt = doPost(request, authToken, appAuthToken);
        /* 302 */
        if (rt == null) {
            /* 303 */
            return null;

        }

        /* 306 */
        AlipayResponse tRsp = null;

        try {
            /* 311 */
            ResponseEncryptItem responseItem = encryptResponse(request, rt, parser);

            /* 314 */
            tRsp = parser.parse(responseItem.getRealContent());
            /* 315 */
            tRsp.setBody(responseItem.getRealContent());

            /* 318 */
            checkResponseSign(request, parser, responseItem.getRespContent(), tRsp.isSuccess());

        } catch (RuntimeException e) {
            /* 322 */
            AlipayLogger.logBizError((String) rt.get("rsp"));
            /* 323 */
            throw e;

        } catch (AlipayApiException e) {
            /* 326 */
            AlipayLogger.logBizError((String) rt.get("rsp"));
            /* 327 */
            throw new AlipayApiException(e);

        }

        /* 330 */
        tRsp.setParams((AlipayHashMap) rt.get("textParams"));
        /* 331 */
        if (!tRsp.isSuccess()) {
            /* 332 */
            AlipayLogger.logErrorScene(rt, tRsp, "");

        }
        /* 334 */
        return tRsp;

    }


    private <T extends AlipayResponse> Map<String, Object> doPost(AlipayRequest<T> request, String accessToken, String appAuthToken)
            throws AlipayApiException {
        /* 349 */
        Map result = new HashMap();
        /* 350 */
        RequestParametersHolder requestHolder = getRequestHolderWithSign(request, accessToken, appAuthToken);

        /* 353 */
        String url = getRequestUrl(requestHolder);

        /* 356 */
        if (AlipayLogger.isBizDebugEnabled().booleanValue()) {
            /* 357 */
            AlipayLogger.logBizDebug(getRedirectUrl(requestHolder));

        }

        /* 360 */
        String rsp = null;

        try {
            /* 362 */
            if ((request instanceof AlipayUploadRequest)) {
                /* 363 */
                AlipayUploadRequest uRequest = (AlipayUploadRequest) request;
                /* 364 */
                Map fileParams = AlipayUtils.cleanupMap(uRequest.getFileParams());
                /* 365 */
                rsp = WebUtils.doPost(url, requestHolder.getApplicationParams(), fileParams, this.charset, this.connectTimeout, this.readTimeout);

            } else {
                /* 368 */
                rsp = WebUtils.doPost(url, requestHolder.getApplicationParams(), this.charset, this.connectTimeout, this.readTimeout);

            }

        } catch (IOException e) {
            /* 372 */
            throw new AlipayApiException(e);

        }
        /* 374 */
        result.put("rsp", rsp);
        /* 375 */
        result.put("textParams", requestHolder.getApplicationParams());
        /* 376 */
        result.put("protocalMustParams", requestHolder.getProtocalMustParams());
        /* 377 */
        result.put("protocalOptParams", requestHolder.getProtocalOptParams());
        /* 378 */
        result.put("url", url);
        /* 379 */
        return result;

    }


    private <T extends AlipayResponse> void checkResponseSign(AlipayRequest<T> request, AlipayParser<T> parser, String responseBody, boolean responseIsSucess)
            throws AlipayApiException {
        /* 396 */
        if (!StringUtils.isEmpty(this.alipayPublicKey)) {
            /* 398 */
            SignItem signItem = parser.getSignItem(request, responseBody);

            /* 400 */
            if (signItem == null) {
                /* 402 */
                throw new AlipayApiException("sign check fail: Body is Empty!");

            }

            /* 405 */
            if ((responseIsSucess) || ((!responseIsSucess) && (!StringUtils.isEmpty(signItem.getSign())))) {
                /* 408 */
                boolean rsaCheckContent = AlipaySignature.rsaCheck(signItem.getSignSourceDate(), signItem.getSign(), this.alipayPublicKey, this.charset, this.sign_type);

                /* 411 */
                if (!rsaCheckContent) {
                    /* 414 */
                    if ((!StringUtils.isEmpty(signItem.getSignSourceDate())) && (signItem.getSignSourceDate()
                            .contains("\\/"))) {
                        /* 417 */
                        String srouceData = signItem.getSignSourceDate().replace("\\/", "/");

                        /* 419 */
                        boolean jsonCheck = AlipaySignature.rsaCheck(srouceData, signItem.getSign(), this.alipayPublicKey, this.charset, this.sign_type);

                        /* 422 */
                        if (!jsonCheck) {
                            /* 423 */
                            throw new AlipayApiException("sign check fail: check Sign and Data Fail！JSON also！");

                        }

                    } else {
                        /* 428 */
                        throw new AlipayApiException("sign check fail: check Sign and Data Fail!");

                    }

                }

            }

        }

    }


    private <T extends AlipayResponse> ResponseEncryptItem encryptResponse(AlipayRequest<T> request, Map<String, Object> rt, AlipayParser<T> parser)
            throws AlipayApiException {
        /* 449 */
        String responseBody = (String) rt.get("rsp");

        /* 451 */
        String realBody = null;

        /* 454 */
        if (request.isNeedEncrypt()) {
            /* 457 */
            realBody = parser.encryptSourceData(request, responseBody, this.format, this.encryptType, this.encryptKey, this.charset);

        } else {
            /* 462 */
            realBody = (String) rt.get("rsp");

        }

        /* 465 */
        return new ResponseEncryptItem(responseBody, realBody);

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.DefaultAlipayClient
 * JD-Core Version:    0.6.0
 */