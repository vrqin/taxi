package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEbppBillSearchResponse;

import java.util.Map;


public class AlipayEbppBillSearchRequest implements AlipayRequest<AlipayEbppBillSearchResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String billKey;
    private String chargeInst;
    private String chargeoffInst;
    private String companyId;
    private String extend;
    private String orderType;
    private String subOrderType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 109 */   private boolean needEncrypt = false;


    public String getBillKey() {
        /*  60 */
        return this.billKey;

    }


    public void setBillKey(String billKey) {
        /*  57 */
        this.billKey = billKey;

    }


    public String getChargeInst() {
        /*  67 */
        return this.chargeInst;

    }


    public void setChargeInst(String chargeInst) {
        /*  64 */
        this.chargeInst = chargeInst;

    }


    public String getChargeoffInst() {
        /*  74 */
        return this.chargeoffInst;

    }


    public void setChargeoffInst(String chargeoffInst) {
        /*  71 */
        this.chargeoffInst = chargeoffInst;

    }


    public String getCompanyId() {
        /*  81 */
        return this.companyId;

    }


    public void setCompanyId(String companyId) {
        /*  78 */
        this.companyId = companyId;

    }


    public String getExtend() {
        /*  88 */
        return this.extend;

    }


    public void setExtend(String extend) {
        /*  85 */
        this.extend = extend;

    }


    public String getOrderType() {
        /*  95 */
        return this.orderType;

    }


    public void setOrderType(String orderType) {
        /*  92 */
        this.orderType = orderType;

    }


    public String getSubOrderType() {
        /* 102 */
        return this.subOrderType;

    }


    public void setSubOrderType(String subOrderType) {
        /*  99 */
        this.subOrderType = subOrderType;

    }


    public String getNotifyUrl() {
        /* 112 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 116 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 120 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 124 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 128 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 132 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 140 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 136 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 148 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 144 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 156 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 152 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 160 */
        return "alipay.ebpp.bill.search";

    }


    public Map<String, String> getTextParams() {
        /* 164 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 165 */
        txtParams.put("bill_key", this.billKey);
        /* 166 */
        txtParams.put("charge_inst", this.chargeInst);
        /* 167 */
        txtParams.put("chargeoff_inst", this.chargeoffInst);
        /* 168 */
        txtParams.put("company_id", this.companyId);
        /* 169 */
        txtParams.put("extend", this.extend);
        /* 170 */
        txtParams.put("order_type", this.orderType);
        /* 171 */
        txtParams.put("sub_order_type", this.subOrderType);
        /* 172 */
        if (this.udfParams != null) {
            /* 173 */
            txtParams.putAll(this.udfParams);

        }
        /* 175 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 179 */
        if (this.udfParams == null) {
            /* 180 */
            this.udfParams = new AlipayHashMap();

        }
        /* 182 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayEbppBillSearchResponse> getResponseClass() {
        /* 186 */
        return AlipayEbppBillSearchResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 192 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 198 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayEbppBillSearchRequest
 * JD-Core Version:    0.6.0
 */