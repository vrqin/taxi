package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class AdviceVO extends AlipayObject {
    private static final long serialVersionUID = 8869635293393341988L;


    @ApiField("client_advice_timestamp")
    private Date clientAdviceTimestamp;


    @ApiField("client_id")
    private String clientId;


    @ApiField("client_ref")
    private String clientRef;


    @ApiField("contra_amount")
    private String contraAmount;


    @ApiField("contra_ccy")
    private String contraCcy;


    @ApiField("end_to_end_id")
    private String endToEndId;


    @ApiField("msg_type")
    private String msgType;


    @ApiField("partial_trade")
    private String partialTrade;


    @ApiField("payment_provider")
    private String paymentProvider;


    @ApiField("payment_type")
    private String paymentType;


    @ApiField("profile_id")
    private String profileId;


    @ApiField("rate_ref")
    private String rateRef;


    @ApiField("rate_request_mode")
    private String rateRequestMode;


    @ApiField("rate_type")
    private String rateType;


    @ApiField("reference_field1")
    private String referenceField1;


    @ApiField("reference_field2")
    private String referenceField2;


    @ApiField("reference_field3")
    private String referenceField3;


    @ApiField("related_message_id")
    private String relatedMessageId;


    @ApiField("request_message_id")
    private String requestMessageId;


    @ApiField("requested_rate")
    private String requestedRate;


    @ApiField("settlement_amount")
    private String settlementAmount;


    @ApiField("settlement_ccy")
    private String settlementCcy;


    @ApiField("side")
    private String side;


    @ApiField("slip_point")
    private Long slipPoint;


    @ApiField("source_event_code")
    private String sourceEventCode;


    @ApiField("source_product_code")
    private String sourceProductCode;


    @ApiField("time_zone")
    private String timeZone;


    @ApiField("trade_timestamp")
    private Date tradeTimestamp;


    @ApiField("transaction_amount")
    private String transactionAmount;


    @ApiField("transaction_ccy")
    private String transactionCcy;


    @ApiField("transaction_ccy_type")
    private String transactionCcyType;


    @ApiField("transaction_type")
    private String transactionType;


    @ApiField("value_date")
    private String valueDate;


    public Date getClientAdviceTimestamp() {
        /* 230 */
        return this.clientAdviceTimestamp;

    }


    public void setClientAdviceTimestamp(Date clientAdviceTimestamp) {
        /* 233 */
        this.clientAdviceTimestamp = clientAdviceTimestamp;

    }


    public String getClientId() {
        /* 237 */
        return this.clientId;

    }


    public void setClientId(String clientId) {
        /* 240 */
        this.clientId = clientId;

    }


    public String getClientRef() {
        /* 244 */
        return this.clientRef;

    }


    public void setClientRef(String clientRef) {
        /* 247 */
        this.clientRef = clientRef;

    }


    public String getContraAmount() {
        /* 251 */
        return this.contraAmount;

    }


    public void setContraAmount(String contraAmount) {
        /* 254 */
        this.contraAmount = contraAmount;

    }


    public String getContraCcy() {
        /* 258 */
        return this.contraCcy;

    }


    public void setContraCcy(String contraCcy) {
        /* 261 */
        this.contraCcy = contraCcy;

    }


    public String getEndToEndId() {
        /* 265 */
        return this.endToEndId;

    }


    public void setEndToEndId(String endToEndId) {
        /* 268 */
        this.endToEndId = endToEndId;

    }


    public String getMsgType() {
        /* 272 */
        return this.msgType;

    }


    public void setMsgType(String msgType) {
        /* 275 */
        this.msgType = msgType;

    }


    public String getPartialTrade() {
        /* 279 */
        return this.partialTrade;

    }


    public void setPartialTrade(String partialTrade) {
        /* 282 */
        this.partialTrade = partialTrade;

    }


    public String getPaymentProvider() {
        /* 286 */
        return this.paymentProvider;

    }


    public void setPaymentProvider(String paymentProvider) {
        /* 289 */
        this.paymentProvider = paymentProvider;

    }


    public String getPaymentType() {
        /* 293 */
        return this.paymentType;

    }


    public void setPaymentType(String paymentType) {
        /* 296 */
        this.paymentType = paymentType;

    }


    public String getProfileId() {
        /* 300 */
        return this.profileId;

    }


    public void setProfileId(String profileId) {
        /* 303 */
        this.profileId = profileId;

    }


    public String getRateRef() {
        /* 307 */
        return this.rateRef;

    }


    public void setRateRef(String rateRef) {
        /* 310 */
        this.rateRef = rateRef;

    }


    public String getRateRequestMode() {
        /* 314 */
        return this.rateRequestMode;

    }


    public void setRateRequestMode(String rateRequestMode) {
        /* 317 */
        this.rateRequestMode = rateRequestMode;

    }


    public String getRateType() {
        /* 321 */
        return this.rateType;

    }


    public void setRateType(String rateType) {
        /* 324 */
        this.rateType = rateType;

    }


    public String getReferenceField1() {
        /* 328 */
        return this.referenceField1;

    }


    public void setReferenceField1(String referenceField1) {
        /* 331 */
        this.referenceField1 = referenceField1;

    }


    public String getReferenceField2() {
        /* 335 */
        return this.referenceField2;

    }


    public void setReferenceField2(String referenceField2) {
        /* 338 */
        this.referenceField2 = referenceField2;

    }


    public String getReferenceField3() {
        /* 342 */
        return this.referenceField3;

    }


    public void setReferenceField3(String referenceField3) {
        /* 345 */
        this.referenceField3 = referenceField3;

    }


    public String getRelatedMessageId() {
        /* 349 */
        return this.relatedMessageId;

    }


    public void setRelatedMessageId(String relatedMessageId) {
        /* 352 */
        this.relatedMessageId = relatedMessageId;

    }


    public String getRequestMessageId() {
        /* 356 */
        return this.requestMessageId;

    }


    public void setRequestMessageId(String requestMessageId) {
        /* 359 */
        this.requestMessageId = requestMessageId;

    }


    public String getRequestedRate() {
        /* 363 */
        return this.requestedRate;

    }


    public void setRequestedRate(String requestedRate) {
        /* 366 */
        this.requestedRate = requestedRate;

    }


    public String getSettlementAmount() {
        /* 370 */
        return this.settlementAmount;

    }


    public void setSettlementAmount(String settlementAmount) {
        /* 373 */
        this.settlementAmount = settlementAmount;

    }


    public String getSettlementCcy() {
        /* 377 */
        return this.settlementCcy;

    }


    public void setSettlementCcy(String settlementCcy) {
        /* 380 */
        this.settlementCcy = settlementCcy;

    }


    public String getSide() {
        /* 384 */
        return this.side;

    }


    public void setSide(String side) {
        /* 387 */
        this.side = side;

    }


    public Long getSlipPoint() {
        /* 391 */
        return this.slipPoint;

    }


    public void setSlipPoint(Long slipPoint) {
        /* 394 */
        this.slipPoint = slipPoint;

    }


    public String getSourceEventCode() {
        /* 398 */
        return this.sourceEventCode;

    }


    public void setSourceEventCode(String sourceEventCode) {
        /* 401 */
        this.sourceEventCode = sourceEventCode;

    }


    public String getSourceProductCode() {
        /* 405 */
        return this.sourceProductCode;

    }


    public void setSourceProductCode(String sourceProductCode) {
        /* 408 */
        this.sourceProductCode = sourceProductCode;

    }


    public String getTimeZone() {
        /* 412 */
        return this.timeZone;

    }


    public void setTimeZone(String timeZone) {
        /* 415 */
        this.timeZone = timeZone;

    }


    public Date getTradeTimestamp() {
        /* 419 */
        return this.tradeTimestamp;

    }


    public void setTradeTimestamp(Date tradeTimestamp) {
        /* 422 */
        this.tradeTimestamp = tradeTimestamp;

    }


    public String getTransactionAmount() {
        /* 426 */
        return this.transactionAmount;

    }


    public void setTransactionAmount(String transactionAmount) {
        /* 429 */
        this.transactionAmount = transactionAmount;

    }


    public String getTransactionCcy() {
        /* 433 */
        return this.transactionCcy;

    }


    public void setTransactionCcy(String transactionCcy) {
        /* 436 */
        this.transactionCcy = transactionCcy;

    }


    public String getTransactionCcyType() {
        /* 440 */
        return this.transactionCcyType;

    }


    public void setTransactionCcyType(String transactionCcyType) {
        /* 443 */
        this.transactionCcyType = transactionCcyType;

    }


    public String getTransactionType() {
        /* 447 */
        return this.transactionType;

    }


    public void setTransactionType(String transactionType) {
        /* 450 */
        this.transactionType = transactionType;

    }


    public String getValueDate() {
        /* 454 */
        return this.valueDate;

    }


    public void setValueDate(String valueDate) {
        /* 457 */
        this.valueDate = valueDate;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AdviceVO
 * JD-Core Version:    0.6.0
 */