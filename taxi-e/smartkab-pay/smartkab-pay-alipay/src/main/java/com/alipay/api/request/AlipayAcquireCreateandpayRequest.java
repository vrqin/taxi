package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayAcquireCreateandpayResponse;

import java.util.Map;


public class AlipayAcquireCreateandpayRequest implements AlipayRequest<AlipayAcquireCreateandpayResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String alipayCaRequest;
    private String body;
    private String buyerEmail;
    private String buyerId;
    private String channelParameters;
    private String currency;
    private String dynamicId;
    private String dynamicIdType;
    private String extendParams;
    private String formatType;
    private String goodsDetail;
    private String itBPay;
    private String mcardParameters;
    private String operatorId;
    private String operatorType;
    private String outTradeNo;
    private String price;
    private String quantity;
    private String refIds;
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
    /* 368 */   private boolean needEncrypt = false;


    public String getAlipayCaRequest() {
        /* 186 */
        return this.alipayCaRequest;

    }


    public void setAlipayCaRequest(String alipayCaRequest) {
        /* 183 */
        this.alipayCaRequest = alipayCaRequest;

    }


    public String getBody() {
        /* 193 */
        return this.body;

    }


    public void setBody(String body) {
        /* 190 */
        this.body = body;

    }


    public String getBuyerEmail() {
        /* 200 */
        return this.buyerEmail;

    }


    public void setBuyerEmail(String buyerEmail) {
        /* 197 */
        this.buyerEmail = buyerEmail;

    }


    public String getBuyerId() {
        /* 207 */
        return this.buyerId;

    }


    public void setBuyerId(String buyerId) {
        /* 204 */
        this.buyerId = buyerId;

    }


    public String getChannelParameters() {
        /* 214 */
        return this.channelParameters;

    }


    public void setChannelParameters(String channelParameters) {
        /* 211 */
        this.channelParameters = channelParameters;

    }


    public String getCurrency() {
        /* 221 */
        return this.currency;

    }


    public void setCurrency(String currency) {
        /* 218 */
        this.currency = currency;

    }


    public String getDynamicId() {
        /* 228 */
        return this.dynamicId;

    }


    public void setDynamicId(String dynamicId) {
        /* 225 */
        this.dynamicId = dynamicId;

    }


    public String getDynamicIdType() {
        /* 235 */
        return this.dynamicIdType;

    }


    public void setDynamicIdType(String dynamicIdType) {
        /* 232 */
        this.dynamicIdType = dynamicIdType;

    }


    public String getExtendParams() {
        /* 242 */
        return this.extendParams;

    }


    public void setExtendParams(String extendParams) {
        /* 239 */
        this.extendParams = extendParams;

    }


    public String getFormatType() {
        /* 249 */
        return this.formatType;

    }


    public void setFormatType(String formatType) {
        /* 246 */
        this.formatType = formatType;

    }


    public String getGoodsDetail() {
        /* 256 */
        return this.goodsDetail;

    }


    public void setGoodsDetail(String goodsDetail) {
        /* 253 */
        this.goodsDetail = goodsDetail;

    }


    public String getItBPay() {
        /* 263 */
        return this.itBPay;

    }


    public void setItBPay(String itBPay) {
        /* 260 */
        this.itBPay = itBPay;

    }


    public String getMcardParameters() {
        /* 270 */
        return this.mcardParameters;

    }


    public void setMcardParameters(String mcardParameters) {
        /* 267 */
        this.mcardParameters = mcardParameters;

    }


    public String getOperatorId() {
        /* 277 */
        return this.operatorId;

    }


    public void setOperatorId(String operatorId) {
        /* 274 */
        this.operatorId = operatorId;

    }


    public String getOperatorType() {
        /* 284 */
        return this.operatorType;

    }


    public void setOperatorType(String operatorType) {
        /* 281 */
        this.operatorType = operatorType;

    }


    public String getOutTradeNo() {
        /* 291 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 288 */
        this.outTradeNo = outTradeNo;

    }


    public String getPrice() {
        /* 298 */
        return this.price;

    }


    public void setPrice(String price) {
        /* 295 */
        this.price = price;

    }


    public String getQuantity() {
        /* 305 */
        return this.quantity;

    }


    public void setQuantity(String quantity) {
        /* 302 */
        this.quantity = quantity;

    }


    public String getRefIds() {
        /* 312 */
        return this.refIds;

    }


    public void setRefIds(String refIds) {
        /* 309 */
        this.refIds = refIds;

    }


    public String getRoyaltyParameters() {
        /* 319 */
        return this.royaltyParameters;

    }


    public void setRoyaltyParameters(String royaltyParameters) {
        /* 316 */
        this.royaltyParameters = royaltyParameters;

    }


    public String getRoyaltyType() {
        /* 326 */
        return this.royaltyType;

    }


    public void setRoyaltyType(String royaltyType) {
        /* 323 */
        this.royaltyType = royaltyType;

    }


    public String getSellerEmail() {
        /* 333 */
        return this.sellerEmail;

    }


    public void setSellerEmail(String sellerEmail) {
        /* 330 */
        this.sellerEmail = sellerEmail;

    }


    public String getSellerId() {
        /* 340 */
        return this.sellerId;

    }


    public void setSellerId(String sellerId) {
        /* 337 */
        this.sellerId = sellerId;

    }


    public String getShowUrl() {
        /* 347 */
        return this.showUrl;

    }


    public void setShowUrl(String showUrl) {
        /* 344 */
        this.showUrl = showUrl;

    }


    public String getSubject() {
        /* 354 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /* 351 */
        this.subject = subject;

    }


    public String getTotalFee() {
        /* 361 */
        return this.totalFee;

    }


    public void setTotalFee(String totalFee) {
        /* 358 */
        this.totalFee = totalFee;

    }


    public String getNotifyUrl() {
        /* 371 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 375 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 379 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 383 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 387 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 391 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 399 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 395 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 407 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 403 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 415 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 411 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 419 */
        return "alipay.acquire.createandpay";

    }


    public Map<String, String> getTextParams() {
        /* 423 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 424 */
        txtParams.put("alipay_ca_request", this.alipayCaRequest);
        /* 425 */
        txtParams.put("body", this.body);
        /* 426 */
        txtParams.put("buyer_email", this.buyerEmail);
        /* 427 */
        txtParams.put("buyer_id", this.buyerId);
        /* 428 */
        txtParams.put("channel_parameters", this.channelParameters);
        /* 429 */
        txtParams.put("currency", this.currency);
        /* 430 */
        txtParams.put("dynamic_id", this.dynamicId);
        /* 431 */
        txtParams.put("dynamic_id_type", this.dynamicIdType);
        /* 432 */
        txtParams.put("extend_params", this.extendParams);
        /* 433 */
        txtParams.put("format_type", this.formatType);
        /* 434 */
        txtParams.put("goods_detail", this.goodsDetail);
        /* 435 */
        txtParams.put("it_b_pay", this.itBPay);
        /* 436 */
        txtParams.put("mcard_parameters", this.mcardParameters);
        /* 437 */
        txtParams.put("operator_id", this.operatorId);
        /* 438 */
        txtParams.put("operator_type", this.operatorType);
        /* 439 */
        txtParams.put("out_trade_no", this.outTradeNo);
        /* 440 */
        txtParams.put("price", this.price);
        /* 441 */
        txtParams.put("quantity", this.quantity);
        /* 442 */
        txtParams.put("ref_ids", this.refIds);
        /* 443 */
        txtParams.put("royalty_parameters", this.royaltyParameters);
        /* 444 */
        txtParams.put("royalty_type", this.royaltyType);
        /* 445 */
        txtParams.put("seller_email", this.sellerEmail);
        /* 446 */
        txtParams.put("seller_id", this.sellerId);
        /* 447 */
        txtParams.put("show_url", this.showUrl);
        /* 448 */
        txtParams.put("subject", this.subject);
        /* 449 */
        txtParams.put("total_fee", this.totalFee);
        /* 450 */
        if (this.udfParams != null) {
            /* 451 */
            txtParams.putAll(this.udfParams);

        }
        /* 453 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 457 */
        if (this.udfParams == null) {
            /* 458 */
            this.udfParams = new AlipayHashMap();

        }
        /* 460 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayAcquireCreateandpayResponse> getResponseClass() {
        /* 464 */
        return AlipayAcquireCreateandpayResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 470 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 476 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayAcquireCreateandpayRequest
 * JD-Core Version:    0.6.0
 */