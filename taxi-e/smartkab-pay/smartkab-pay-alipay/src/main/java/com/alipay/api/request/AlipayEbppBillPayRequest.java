package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEbppBillPayResponse;

import java.util.Map;


public class AlipayEbppBillPayRequest implements AlipayRequest<AlipayEbppBillPayResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String alipayOrderNo;
    private String dispatchClusterTarget;
    private String extend;
    private String merchantOrderNo;
    private String orderType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  84 */   private boolean needEncrypt = false;


    public String getAlipayOrderNo() {
        /*  49 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /*  46 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public String getDispatchClusterTarget() {
        /*  56 */
        return this.dispatchClusterTarget;

    }


    public void setDispatchClusterTarget(String dispatchClusterTarget) {
        /*  53 */
        this.dispatchClusterTarget = dispatchClusterTarget;

    }


    public String getExtend() {
        /*  63 */
        return this.extend;

    }


    public void setExtend(String extend) {
        /*  60 */
        this.extend = extend;

    }


    public String getMerchantOrderNo() {
        /*  70 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /*  67 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public String getOrderType() {
        /*  77 */
        return this.orderType;

    }


    public void setOrderType(String orderType) {
        /*  74 */
        this.orderType = orderType;

    }


    public String getNotifyUrl() {
        /*  87 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  91 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  95 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  99 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 103 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 107 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 115 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 111 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 123 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 119 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 131 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 127 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 135 */
        return "alipay.ebpp.bill.pay";

    }


    public Map<String, String> getTextParams() {
        /* 139 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 140 */
        txtParams.put("alipay_order_no", this.alipayOrderNo);
        /* 141 */
        txtParams.put("dispatch_cluster_target", this.dispatchClusterTarget);
        /* 142 */
        txtParams.put("extend", this.extend);
        /* 143 */
        txtParams.put("merchant_order_no", this.merchantOrderNo);
        /* 144 */
        txtParams.put("order_type", this.orderType);
        /* 145 */
        if (this.udfParams != null) {
            /* 146 */
            txtParams.putAll(this.udfParams);

        }
        /* 148 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 152 */
        if (this.udfParams == null) {
            /* 153 */
            this.udfParams = new AlipayHashMap();

        }
        /* 155 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayEbppBillPayResponse> getResponseClass() {
        /* 159 */
        return AlipayEbppBillPayResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 165 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 171 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayEbppBillPayRequest
 * JD-Core Version:    0.6.0
 */