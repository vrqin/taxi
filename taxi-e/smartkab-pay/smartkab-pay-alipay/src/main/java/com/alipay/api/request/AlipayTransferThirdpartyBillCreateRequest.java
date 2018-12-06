package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayTransferThirdpartyBillCreateResponse;

import java.util.Map;


public class AlipayTransferThirdpartyBillCreateRequest implements AlipayRequest<AlipayTransferThirdpartyBillCreateResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String amount;
    private String currency;
    private String extParam;
    private String memo;
    private String partnerId;
    private String payeeAccount;
    private String payeeType;
    private String payerAccount;
    private String payerType;
    private String paymentId;
    private String paymentSource;
    private String title;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 175 */   private boolean needEncrypt = false;


    public String getAmount() {
        /*  91 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /*  88 */
        this.amount = amount;

    }


    public String getCurrency() {
        /*  98 */
        return this.currency;

    }


    public void setCurrency(String currency) {
        /*  95 */
        this.currency = currency;

    }


    public String getExtParam() {
        /* 105 */
        return this.extParam;

    }


    public void setExtParam(String extParam) {
        /* 102 */
        this.extParam = extParam;

    }


    public String getMemo() {
        /* 112 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 109 */
        this.memo = memo;

    }


    public String getPartnerId() {
        /* 119 */
        return this.partnerId;

    }


    public void setPartnerId(String partnerId) {
        /* 116 */
        this.partnerId = partnerId;

    }


    public String getPayeeAccount() {
        /* 126 */
        return this.payeeAccount;

    }


    public void setPayeeAccount(String payeeAccount) {
        /* 123 */
        this.payeeAccount = payeeAccount;

    }


    public String getPayeeType() {
        /* 133 */
        return this.payeeType;

    }


    public void setPayeeType(String payeeType) {
        /* 130 */
        this.payeeType = payeeType;

    }


    public String getPayerAccount() {
        /* 140 */
        return this.payerAccount;

    }


    public void setPayerAccount(String payerAccount) {
        /* 137 */
        this.payerAccount = payerAccount;

    }


    public String getPayerType() {
        /* 147 */
        return this.payerType;

    }


    public void setPayerType(String payerType) {
        /* 144 */
        this.payerType = payerType;

    }


    public String getPaymentId() {
        /* 154 */
        return this.paymentId;

    }


    public void setPaymentId(String paymentId) {
        /* 151 */
        this.paymentId = paymentId;

    }


    public String getPaymentSource() {
        /* 161 */
        return this.paymentSource;

    }


    public void setPaymentSource(String paymentSource) {
        /* 158 */
        this.paymentSource = paymentSource;

    }


    public String getTitle() {
        /* 168 */
        return this.title;

    }


    public void setTitle(String title) {
        /* 165 */
        this.title = title;

    }


    public String getNotifyUrl() {
        /* 178 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 182 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 186 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 190 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 194 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 198 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 206 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 202 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 214 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 210 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 222 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 218 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 226 */
        return "alipay.transfer.thirdparty.bill.create";

    }


    public Map<String, String> getTextParams() {
        /* 230 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 231 */
        txtParams.put("amount", this.amount);
        /* 232 */
        txtParams.put("currency", this.currency);
        /* 233 */
        txtParams.put("ext_param", this.extParam);
        /* 234 */
        txtParams.put("memo", this.memo);
        /* 235 */
        txtParams.put("partner_id", this.partnerId);
        /* 236 */
        txtParams.put("payee_account", this.payeeAccount);
        /* 237 */
        txtParams.put("payee_type", this.payeeType);
        /* 238 */
        txtParams.put("payer_account", this.payerAccount);
        /* 239 */
        txtParams.put("payer_type", this.payerType);
        /* 240 */
        txtParams.put("payment_id", this.paymentId);
        /* 241 */
        txtParams.put("payment_source", this.paymentSource);
        /* 242 */
        txtParams.put("title", this.title);
        /* 243 */
        if (this.udfParams != null) {
            /* 244 */
            txtParams.putAll(this.udfParams);

        }
        /* 246 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 250 */
        if (this.udfParams == null) {
            /* 251 */
            this.udfParams = new AlipayHashMap();

        }
        /* 253 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayTransferThirdpartyBillCreateResponse> getResponseClass() {
        /* 257 */
        return AlipayTransferThirdpartyBillCreateResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 263 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 269 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayTransferThirdpartyBillCreateRequest
 * JD-Core Version:    0.6.0
 */