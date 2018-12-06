package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayAcquirePrecreateResponse;

import java.util.Map;


public class AlipayAcquirePrecreateRequest implements AlipayRequest<AlipayAcquirePrecreateResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String body;
    private String channelParameters;
    private String currency;
    private String extendParams;
    private String goodsDetail;
    private String itBPay;
    private String operatorCode;
    private String operatorId;
    private String outTradeNo;
    private String price;
    private String quantity;
    private String royaltyParameters;
    private String royaltyType;
    private String sellerEmail;
    private String sellerId;
    private String showUrl;
    private String subject;
    private String totalFee;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 252 */   private boolean needEncrypt = false;


    public String getBody() {
        /* 126 */
        return this.body;

    }


    public void setBody(String body) {
        /* 123 */
        this.body = body;

    }


    public String getChannelParameters() {
        /* 133 */
        return this.channelParameters;

    }


    public void setChannelParameters(String channelParameters) {
        /* 130 */
        this.channelParameters = channelParameters;

    }


    public String getCurrency() {
        /* 140 */
        return this.currency;

    }


    public void setCurrency(String currency) {
        /* 137 */
        this.currency = currency;

    }


    public String getExtendParams() {
        /* 147 */
        return this.extendParams;

    }


    public void setExtendParams(String extendParams) {
        /* 144 */
        this.extendParams = extendParams;

    }


    public String getGoodsDetail() {
        /* 154 */
        return this.goodsDetail;

    }


    public void setGoodsDetail(String goodsDetail) {
        /* 151 */
        this.goodsDetail = goodsDetail;

    }


    public String getItBPay() {
        /* 161 */
        return this.itBPay;

    }


    public void setItBPay(String itBPay) {
        /* 158 */
        this.itBPay = itBPay;

    }


    public String getOperatorCode() {
        /* 168 */
        return this.operatorCode;

    }


    public void setOperatorCode(String operatorCode) {
        /* 165 */
        this.operatorCode = operatorCode;

    }


    public String getOperatorId() {
        /* 175 */
        return this.operatorId;

    }


    public void setOperatorId(String operatorId) {
        /* 172 */
        this.operatorId = operatorId;

    }


    public String getOutTradeNo() {
        /* 182 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 179 */
        this.outTradeNo = outTradeNo;

    }


    public String getPrice() {
        /* 189 */
        return this.price;

    }


    public void setPrice(String price) {
        /* 186 */
        this.price = price;

    }


    public String getQuantity() {
        /* 196 */
        return this.quantity;

    }


    public void setQuantity(String quantity) {
        /* 193 */
        this.quantity = quantity;

    }


    public String getRoyaltyParameters() {
        /* 203 */
        return this.royaltyParameters;

    }


    public void setRoyaltyParameters(String royaltyParameters) {
        /* 200 */
        this.royaltyParameters = royaltyParameters;

    }


    public String getRoyaltyType() {
        /* 210 */
        return this.royaltyType;

    }


    public void setRoyaltyType(String royaltyType) {
        /* 207 */
        this.royaltyType = royaltyType;

    }


    public String getSellerEmail() {
        /* 217 */
        return this.sellerEmail;

    }


    public void setSellerEmail(String sellerEmail) {
        /* 214 */
        this.sellerEmail = sellerEmail;

    }


    public String getSellerId() {
        /* 224 */
        return this.sellerId;

    }


    public void setSellerId(String sellerId) {
        /* 221 */
        this.sellerId = sellerId;

    }


    public String getShowUrl() {
        /* 231 */
        return this.showUrl;

    }


    public void setShowUrl(String showUrl) {
        /* 228 */
        this.showUrl = showUrl;

    }


    public String getSubject() {
        /* 238 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /* 235 */
        this.subject = subject;

    }


    public String getTotalFee() {
        /* 245 */
        return this.totalFee;

    }


    public void setTotalFee(String totalFee) {
        /* 242 */
        this.totalFee = totalFee;

    }


    public String getNotifyUrl() {
        /* 255 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 259 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 263 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 267 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 271 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 275 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 283 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 279 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 291 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 287 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 299 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 295 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 303 */
        return "alipay.acquire.precreate";

    }


    public Map<String, String> getTextParams() {
        /* 307 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 308 */
        txtParams.put("body", this.body);
        /* 309 */
        txtParams.put("channel_parameters", this.channelParameters);
        /* 310 */
        txtParams.put("currency", this.currency);
        /* 311 */
        txtParams.put("extend_params", this.extendParams);
        /* 312 */
        txtParams.put("goods_detail", this.goodsDetail);
        /* 313 */
        txtParams.put("it_b_pay", this.itBPay);
        /* 314 */
        txtParams.put("operator_code", this.operatorCode);
        /* 315 */
        txtParams.put("operator_id", this.operatorId);
        /* 316 */
        txtParams.put("out_trade_no", this.outTradeNo);
        /* 317 */
        txtParams.put("price", this.price);
        /* 318 */
        txtParams.put("quantity", this.quantity);
        /* 319 */
        txtParams.put("royalty_parameters", this.royaltyParameters);
        /* 320 */
        txtParams.put("royalty_type", this.royaltyType);
        /* 321 */
        txtParams.put("seller_email", this.sellerEmail);
        /* 322 */
        txtParams.put("seller_id", this.sellerId);
        /* 323 */
        txtParams.put("show_url", this.showUrl);
        /* 324 */
        txtParams.put("subject", this.subject);
        /* 325 */
        txtParams.put("total_fee", this.totalFee);
        /* 326 */
        if (this.udfParams != null) {
            /* 327 */
            txtParams.putAll(this.udfParams);

        }
        /* 329 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 333 */
        if (this.udfParams == null) {
            /* 334 */
            this.udfParams = new AlipayHashMap();

        }
        /* 336 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayAcquirePrecreateResponse> getResponseClass() {
        /* 340 */
        return AlipayAcquirePrecreateResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 346 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 352 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayAcquirePrecreateRequest
 * JD-Core Version:    0.6.0
 */