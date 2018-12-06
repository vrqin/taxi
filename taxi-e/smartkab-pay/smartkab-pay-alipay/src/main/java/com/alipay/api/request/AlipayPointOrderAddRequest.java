package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayPointOrderAddResponse;

import java.util.Date;
import java.util.Map;


public class AlipayPointOrderAddRequest implements AlipayRequest<AlipayPointOrderAddResponse> {
    private AlipayHashMap udfParams;
    /*  19 */   private String apiVersion = "1.0";
    private String memo;
    private String merchantOrderNo;
    private Date orderTime;
    private Long pointCount;
    private String userSymbol;
    private String userSymbolType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  97 */   private boolean needEncrypt = false;


    public String getMemo() {
        /*  55 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /*  52 */
        this.memo = memo;

    }


    public String getMerchantOrderNo() {
        /*  62 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /*  59 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public Date getOrderTime() {
        /*  69 */
        return this.orderTime;

    }


    public void setOrderTime(Date orderTime) {
        /*  66 */
        this.orderTime = orderTime;

    }


    public Long getPointCount() {
        /*  76 */
        return this.pointCount;

    }


    public void setPointCount(Long pointCount) {
        /*  73 */
        this.pointCount = pointCount;

    }


    public String getUserSymbol() {
        /*  83 */
        return this.userSymbol;

    }


    public void setUserSymbol(String userSymbol) {
        /*  80 */
        this.userSymbol = userSymbol;

    }


    public String getUserSymbolType() {
        /*  90 */
        return this.userSymbolType;

    }


    public void setUserSymbolType(String userSymbolType) {
        /*  87 */
        this.userSymbolType = userSymbolType;

    }


    public String getNotifyUrl() {
        /* 100 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 104 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 108 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 112 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 116 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 120 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 128 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 124 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 136 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 132 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 144 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 140 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 148 */
        return "alipay.point.order.add";

    }


    public Map<String, String> getTextParams() {
        /* 152 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 153 */
        txtParams.put("memo", this.memo);
        /* 154 */
        txtParams.put("merchant_order_no", this.merchantOrderNo);
        /* 155 */
        txtParams.put("order_time", this.orderTime);
        /* 156 */
        txtParams.put("point_count", this.pointCount);
        /* 157 */
        txtParams.put("user_symbol", this.userSymbol);
        /* 158 */
        txtParams.put("user_symbol_type", this.userSymbolType);
        /* 159 */
        if (this.udfParams != null) {
            /* 160 */
            txtParams.putAll(this.udfParams);

        }
        /* 162 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 166 */
        if (this.udfParams == null) {
            /* 167 */
            this.udfParams = new AlipayHashMap();

        }
        /* 169 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayPointOrderAddResponse> getResponseClass() {
        /* 173 */
        return AlipayPointOrderAddResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 179 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 185 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayPointOrderAddRequest
 * JD-Core Version:    0.6.0
 */