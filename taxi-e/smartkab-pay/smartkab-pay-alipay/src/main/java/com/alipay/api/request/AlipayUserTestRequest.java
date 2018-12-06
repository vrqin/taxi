package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayUserTestResponse;

import java.util.List;
import java.util.Map;


public class AlipayUserTestRequest implements AlipayRequest<AlipayUserTestResponse> {
    private AlipayHashMap udfParams;
    /*  19 */   private String apiVersion = "1.0";
    private List<String> userinfo;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  37 */   private boolean needEncrypt = false;


    public List<String> getUserinfo() {
        /*  30 */
        return this.userinfo;

    }


    public void setUserinfo(List<String> userinfo) {
        /*  27 */
        this.userinfo = userinfo;

    }


    public String getNotifyUrl() {
        /*  40 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  44 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  48 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  52 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  56 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  60 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  68 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  64 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  76 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  72 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  84 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  80 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /*  88 */
        return "alipay.user.test";

    }


    public Map<String, String> getTextParams() {
        /*  92 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /*  93 */
        txtParams.put("userinfo", this.userinfo);
        /*  94 */
        if (this.udfParams != null) {
            /*  95 */
            txtParams.putAll(this.udfParams);

        }
        /*  97 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 101 */
        if (this.udfParams == null) {
            /* 102 */
            this.udfParams = new AlipayHashMap();

        }
        /* 104 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayUserTestResponse> getResponseClass() {
        /* 108 */
        return AlipayUserTestResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 114 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 120 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayUserTestRequest
 * JD-Core Version:    0.6.0
 */