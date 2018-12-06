package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMicropayOrderFreezeResponse;

import java.util.Date;
import java.util.Map;


public class AlipayMicropayOrderFreezeRequest implements AlipayRequest<AlipayMicropayOrderFreezeResponse> {
    private AlipayHashMap udfParams;
    /*  19 */   private String apiVersion = "1.0";
    private String amount;
    private Date expireTime;
    private String memo;
    private String merchantOrderNo;
    private String payConfirm;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  85 */   private boolean needEncrypt = false;


    public String getAmount() {
        /*  50 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /*  47 */
        this.amount = amount;

    }


    public Date getExpireTime() {
        /*  57 */
        return this.expireTime;

    }


    public void setExpireTime(Date expireTime) {
        /*  54 */
        this.expireTime = expireTime;

    }


    public String getMemo() {
        /*  64 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /*  61 */
        this.memo = memo;

    }


    public String getMerchantOrderNo() {
        /*  71 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /*  68 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public String getPayConfirm() {
        /*  78 */
        return this.payConfirm;

    }


    public void setPayConfirm(String payConfirm) {
        /*  75 */
        this.payConfirm = payConfirm;

    }


    public String getNotifyUrl() {
        /*  88 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  92 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  96 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 100 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 104 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 108 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 116 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 112 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 124 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 120 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 132 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 128 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 136 */
        return "alipay.micropay.order.freeze";

    }


    public Map<String, String> getTextParams() {
        /* 140 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 141 */
        txtParams.put("amount", this.amount);
        /* 142 */
        txtParams.put("expire_time", this.expireTime);
        /* 143 */
        txtParams.put("memo", this.memo);
        /* 144 */
        txtParams.put("merchant_order_no", this.merchantOrderNo);
        /* 145 */
        txtParams.put("pay_confirm", this.payConfirm);
        /* 146 */
        if (this.udfParams != null) {
            /* 147 */
            txtParams.putAll(this.udfParams);

        }
        /* 149 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 153 */
        if (this.udfParams == null) {
            /* 154 */
            this.udfParams = new AlipayHashMap();

        }
        /* 156 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayMicropayOrderFreezeResponse> getResponseClass() {
        /* 160 */
        return AlipayMicropayOrderFreezeResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 166 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 172 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayMicropayOrderFreezeRequest
 * JD-Core Version:    0.6.0
 */