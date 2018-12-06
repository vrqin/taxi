package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMemberCouponQuerylistResponse;

import java.util.Map;


public class AlipayMemberCouponQuerylistRequest implements AlipayRequest<AlipayMemberCouponQuerylistResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String merchantInfo;
    private String pageNo;
    private String pageSize;
    private String status;
    private String userInfo;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 100 */   private boolean needEncrypt = false;


    public String getMerchantInfo() {
        /*  65 */
        return this.merchantInfo;

    }


    public void setMerchantInfo(String merchantInfo) {
        /*  62 */
        this.merchantInfo = merchantInfo;

    }


    public String getPageNo() {
        /*  72 */
        return this.pageNo;

    }


    public void setPageNo(String pageNo) {
        /*  69 */
        this.pageNo = pageNo;

    }


    public String getPageSize() {
        /*  79 */
        return this.pageSize;

    }


    public void setPageSize(String pageSize) {
        /*  76 */
        this.pageSize = pageSize;

    }


    public String getStatus() {
        /*  86 */
        return this.status;

    }


    public void setStatus(String status) {
        /*  83 */
        this.status = status;

    }


    public String getUserInfo() {
        /*  93 */
        return this.userInfo;

    }


    public void setUserInfo(String userInfo) {
        /*  90 */
        this.userInfo = userInfo;

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
        return "alipay.member.coupon.querylist";

    }


    public Map<String, String> getTextParams() {
        /* 155 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 156 */
        txtParams.put("merchant_info", this.merchantInfo);
        /* 157 */
        txtParams.put("page_no", this.pageNo);
        /* 158 */
        txtParams.put("page_size", this.pageSize);
        /* 159 */
        txtParams.put("status", this.status);
        /* 160 */
        txtParams.put("user_info", this.userInfo);
        /* 161 */
        if (this.udfParams != null) {
            /* 162 */
            txtParams.putAll(this.udfParams);

        }
        /* 164 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 168 */
        if (this.udfParams == null) {
            /* 169 */
            this.udfParams = new AlipayHashMap();

        }
        /* 171 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayMemberCouponQuerylistResponse> getResponseClass() {
        /* 175 */
        return AlipayMemberCouponQuerylistResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 181 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 187 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayMemberCouponQuerylistRequest
 * JD-Core Version:    0.6.0
 */