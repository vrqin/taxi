package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayOperatorMobileBindResponse;

import java.util.Map;


public class AlipayOperatorMobileBindRequest implements AlipayRequest<AlipayOperatorMobileBindResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String checkSigncard;
    private String fReturnUrl;
    private String hasSpi;
    private String operatorName;
    private String provinceName;
    private String sReturnUrl;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 100 */   private boolean needEncrypt = false;


    public String getCheckSigncard() {
        /*  58 */
        return this.checkSigncard;

    }


    public void setCheckSigncard(String checkSigncard) {
        /*  55 */
        this.checkSigncard = checkSigncard;

    }


    public String getfReturnUrl() {
        /*  65 */
        return this.fReturnUrl;

    }


    public void setfReturnUrl(String fReturnUrl) {
        /*  62 */
        this.fReturnUrl = fReturnUrl;

    }


    public String getHasSpi() {
        /*  72 */
        return this.hasSpi;

    }


    public void setHasSpi(String hasSpi) {
        /*  69 */
        this.hasSpi = hasSpi;

    }


    public String getOperatorName() {
        /*  79 */
        return this.operatorName;

    }


    public void setOperatorName(String operatorName) {
        /*  76 */
        this.operatorName = operatorName;

    }


    public String getProvinceName() {
        /*  86 */
        return this.provinceName;

    }


    public void setProvinceName(String provinceName) {
        /*  83 */
        this.provinceName = provinceName;

    }


    public String getsReturnUrl() {
        /*  93 */
        return this.sReturnUrl;

    }


    public void setsReturnUrl(String sReturnUrl) {
        /*  90 */
        this.sReturnUrl = sReturnUrl;

    }


    public String getNotifyUrl() {
        /* 103 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 107 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 111 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 115 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 119 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 123 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 131 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 127 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 139 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 135 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 147 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 143 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 151 */
        return "alipay.operator.mobile.bind";

    }


    public Map<String, String> getTextParams() {
        /* 155 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 156 */
        txtParams.put("check_signcard", this.checkSigncard);
        /* 157 */
        txtParams.put("f_return_url", this.fReturnUrl);
        /* 158 */
        txtParams.put("has_spi", this.hasSpi);
        /* 159 */
        txtParams.put("operator_name", this.operatorName);
        /* 160 */
        txtParams.put("province_name", this.provinceName);
        /* 161 */
        txtParams.put("s_return_url", this.sReturnUrl);
        /* 162 */
        if (this.udfParams != null) {
            /* 163 */
            txtParams.putAll(this.udfParams);

        }
        /* 165 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 169 */
        if (this.udfParams == null) {
            /* 170 */
            this.udfParams = new AlipayHashMap();

        }
        /* 172 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayOperatorMobileBindResponse> getResponseClass() {
        /* 176 */
        return AlipayOperatorMobileBindResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 182 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 188 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayOperatorMobileBindRequest
 * JD-Core Version:    0.6.0
 */