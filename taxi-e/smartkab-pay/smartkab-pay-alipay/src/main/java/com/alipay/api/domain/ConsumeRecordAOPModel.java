package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class ConsumeRecordAOPModel extends AlipayObject {
    private static final long serialVersionUID = 6316695515371841789L;


    @ApiField("access_channel")
    private String accessChannel;


    @ApiField("additional_status")
    private String additionalStatus;


    @ApiListField("biz_actions")

    @ApiField("string")
    private List<String> bizActions;


    @ApiField("biz_extra_no")
    private String bizExtraNo;


    @ApiField("biz_in_no")
    private String bizInNo;


    @ApiField("biz_memo")
    private String bizMemo;


    @ApiField("biz_orig")
    private String bizOrig;


    @ApiField("biz_out_no")
    private String bizOutNo;


    @ApiField("biz_state")
    private String bizState;


    @ApiField("biz_sub_type")
    private String bizSubType;


    @ApiField("biz_type")
    private String bizType;


    @ApiField("category_id")
    private String categoryId;


    @ApiField("consume_fee")
    private String consumeFee;


    @ApiField("consume_refund_status")
    private String consumeRefundStatus;


    @ApiField("consume_site")
    private String consumeSite;


    @ApiField("consume_status")
    private String consumeStatus;


    @ApiField("consume_title")
    private String consumeTitle;


    @ApiField("consume_type")
    private String consumeType;


    @ApiField("currency")
    private String currency;


    @ApiField("delete_over_time")
    private Date deleteOverTime;


    @ApiField("delete_time")
    private Date deleteTime;


    @ApiField("delete_type")
    private String deleteType;


    @ApiField("depositback_status")
    private String depositbackStatus;


    @ApiField("flag_locked")
    private String flagLocked;


    @ApiField("flag_refund")
    private String flagRefund;


    @ApiField("gmt_biz_create")
    private Date gmtBizCreate;


    @ApiField("gmt_biz_modified")
    private Date gmtBizModified;


    @ApiField("gmt_create")
    private Date gmtCreate;


    @ApiField("gmt_modified")
    private Date gmtModified;


    @ApiField("gmt_receive_pay")
    private Date gmtReceivePay;


    @ApiField("gmt_send_pay")
    private Date gmtSendPay;


    @ApiField("has_fund_item")
    private Boolean hasFundItem;


    @ApiField("has_new_fund_item")
    private Boolean hasNewFundItem;


    @ApiField("in_out")
    private String inOut;


    @ApiField("opposite_card_no")
    private String oppositeCardNo;


    @ApiField("opposite_login_id")
    private String oppositeLoginId;


    @ApiField("opposite_name")
    private String oppositeName;


    @ApiField("opposite_nick_name")
    private String oppositeNickName;


    @ApiField("orig_consume_title")
    private String origConsumeTitle;


    @ApiField("owner_card_no")
    private String ownerCardNo;


    @ApiField("owner_customer_id")
    private String ownerCustomerId;


    @ApiField("owner_login_id")
    private String ownerLoginId;


    @ApiField("owner_name")
    private String ownerName;


    @ApiField("owner_nick")
    private String ownerNick;


    @ApiField("partner_id")
    private String partnerId;


    @ApiField("pay_channel")
    private String payChannel;


    @ApiField("peerpayer_real_name")
    private String peerpayerRealName;


    @ApiField("product")
    private String product;


    @ApiField("refund_fee")
    private String refundFee;


    @ApiField("service_fee")
    private String serviceFee;


    @ApiField("total_refund_fee")
    private String totalRefundFee;


    @ApiField("trade_from")
    private String tradeFrom;


    public String getAccessChannel() {
        /* 334 */
        return this.accessChannel;

    }


    public void setAccessChannel(String accessChannel) {
        /* 337 */
        this.accessChannel = accessChannel;

    }


    public String getAdditionalStatus() {
        /* 341 */
        return this.additionalStatus;

    }


    public void setAdditionalStatus(String additionalStatus) {
        /* 344 */
        this.additionalStatus = additionalStatus;

    }


    public List<String> getBizActions() {
        /* 348 */
        return this.bizActions;

    }


    public void setBizActions(List<String> bizActions) {
        /* 351 */
        this.bizActions = bizActions;

    }


    public String getBizExtraNo() {
        /* 355 */
        return this.bizExtraNo;

    }


    public void setBizExtraNo(String bizExtraNo) {
        /* 358 */
        this.bizExtraNo = bizExtraNo;

    }


    public String getBizInNo() {
        /* 362 */
        return this.bizInNo;

    }


    public void setBizInNo(String bizInNo) {
        /* 365 */
        this.bizInNo = bizInNo;

    }


    public String getBizMemo() {
        /* 369 */
        return this.bizMemo;

    }


    public void setBizMemo(String bizMemo) {
        /* 372 */
        this.bizMemo = bizMemo;

    }


    public String getBizOrig() {
        /* 376 */
        return this.bizOrig;

    }


    public void setBizOrig(String bizOrig) {
        /* 379 */
        this.bizOrig = bizOrig;

    }


    public String getBizOutNo() {
        /* 383 */
        return this.bizOutNo;

    }


    public void setBizOutNo(String bizOutNo) {
        /* 386 */
        this.bizOutNo = bizOutNo;

    }


    public String getBizState() {
        /* 390 */
        return this.bizState;

    }


    public void setBizState(String bizState) {
        /* 393 */
        this.bizState = bizState;

    }


    public String getBizSubType() {
        /* 397 */
        return this.bizSubType;

    }


    public void setBizSubType(String bizSubType) {
        /* 400 */
        this.bizSubType = bizSubType;

    }


    public String getBizType() {
        /* 404 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /* 407 */
        this.bizType = bizType;

    }


    public String getCategoryId() {
        /* 411 */
        return this.categoryId;

    }


    public void setCategoryId(String categoryId) {
        /* 414 */
        this.categoryId = categoryId;

    }


    public String getConsumeFee() {
        /* 418 */
        return this.consumeFee;

    }


    public void setConsumeFee(String consumeFee) {
        /* 421 */
        this.consumeFee = consumeFee;

    }


    public String getConsumeRefundStatus() {
        /* 425 */
        return this.consumeRefundStatus;

    }


    public void setConsumeRefundStatus(String consumeRefundStatus) {
        /* 428 */
        this.consumeRefundStatus = consumeRefundStatus;

    }


    public String getConsumeSite() {
        /* 432 */
        return this.consumeSite;

    }


    public void setConsumeSite(String consumeSite) {
        /* 435 */
        this.consumeSite = consumeSite;

    }


    public String getConsumeStatus() {
        /* 439 */
        return this.consumeStatus;

    }


    public void setConsumeStatus(String consumeStatus) {
        /* 442 */
        this.consumeStatus = consumeStatus;

    }


    public String getConsumeTitle() {
        /* 446 */
        return this.consumeTitle;

    }


    public void setConsumeTitle(String consumeTitle) {
        /* 449 */
        this.consumeTitle = consumeTitle;

    }


    public String getConsumeType() {
        /* 453 */
        return this.consumeType;

    }


    public void setConsumeType(String consumeType) {
        /* 456 */
        this.consumeType = consumeType;

    }


    public String getCurrency() {
        /* 460 */
        return this.currency;

    }


    public void setCurrency(String currency) {
        /* 463 */
        this.currency = currency;

    }


    public Date getDeleteOverTime() {
        /* 467 */
        return this.deleteOverTime;

    }


    public void setDeleteOverTime(Date deleteOverTime) {
        /* 470 */
        this.deleteOverTime = deleteOverTime;

    }


    public Date getDeleteTime() {
        /* 474 */
        return this.deleteTime;

    }


    public void setDeleteTime(Date deleteTime) {
        /* 477 */
        this.deleteTime = deleteTime;

    }


    public String getDeleteType() {
        /* 481 */
        return this.deleteType;

    }


    public void setDeleteType(String deleteType) {
        /* 484 */
        this.deleteType = deleteType;

    }


    public String getDepositbackStatus() {
        /* 488 */
        return this.depositbackStatus;

    }


    public void setDepositbackStatus(String depositbackStatus) {
        /* 491 */
        this.depositbackStatus = depositbackStatus;

    }


    public String getFlagLocked() {
        /* 495 */
        return this.flagLocked;

    }


    public void setFlagLocked(String flagLocked) {
        /* 498 */
        this.flagLocked = flagLocked;

    }


    public String getFlagRefund() {
        /* 502 */
        return this.flagRefund;

    }


    public void setFlagRefund(String flagRefund) {
        /* 505 */
        this.flagRefund = flagRefund;

    }


    public Date getGmtBizCreate() {
        /* 509 */
        return this.gmtBizCreate;

    }


    public void setGmtBizCreate(Date gmtBizCreate) {
        /* 512 */
        this.gmtBizCreate = gmtBizCreate;

    }


    public Date getGmtBizModified() {
        /* 516 */
        return this.gmtBizModified;

    }


    public void setGmtBizModified(Date gmtBizModified) {
        /* 519 */
        this.gmtBizModified = gmtBizModified;

    }


    public Date getGmtCreate() {
        /* 523 */
        return this.gmtCreate;

    }


    public void setGmtCreate(Date gmtCreate) {
        /* 526 */
        this.gmtCreate = gmtCreate;

    }


    public Date getGmtModified() {
        /* 530 */
        return this.gmtModified;

    }


    public void setGmtModified(Date gmtModified) {
        /* 533 */
        this.gmtModified = gmtModified;

    }


    public Date getGmtReceivePay() {
        /* 537 */
        return this.gmtReceivePay;

    }


    public void setGmtReceivePay(Date gmtReceivePay) {
        /* 540 */
        this.gmtReceivePay = gmtReceivePay;

    }


    public Date getGmtSendPay() {
        /* 544 */
        return this.gmtSendPay;

    }


    public void setGmtSendPay(Date gmtSendPay) {
        /* 547 */
        this.gmtSendPay = gmtSendPay;

    }


    public Boolean getHasFundItem() {
        /* 551 */
        return this.hasFundItem;

    }


    public void setHasFundItem(Boolean hasFundItem) {
        /* 554 */
        this.hasFundItem = hasFundItem;

    }


    public Boolean getHasNewFundItem() {
        /* 558 */
        return this.hasNewFundItem;

    }


    public void setHasNewFundItem(Boolean hasNewFundItem) {
        /* 561 */
        this.hasNewFundItem = hasNewFundItem;

    }


    public String getInOut() {
        /* 565 */
        return this.inOut;

    }


    public void setInOut(String inOut) {
        /* 568 */
        this.inOut = inOut;

    }


    public String getOppositeCardNo() {
        /* 572 */
        return this.oppositeCardNo;

    }


    public void setOppositeCardNo(String oppositeCardNo) {
        /* 575 */
        this.oppositeCardNo = oppositeCardNo;

    }


    public String getOppositeLoginId() {
        /* 579 */
        return this.oppositeLoginId;

    }


    public void setOppositeLoginId(String oppositeLoginId) {
        /* 582 */
        this.oppositeLoginId = oppositeLoginId;

    }


    public String getOppositeName() {
        /* 586 */
        return this.oppositeName;

    }


    public void setOppositeName(String oppositeName) {
        /* 589 */
        this.oppositeName = oppositeName;

    }


    public String getOppositeNickName() {
        /* 593 */
        return this.oppositeNickName;

    }


    public void setOppositeNickName(String oppositeNickName) {
        /* 596 */
        this.oppositeNickName = oppositeNickName;

    }


    public String getOrigConsumeTitle() {
        /* 600 */
        return this.origConsumeTitle;

    }


    public void setOrigConsumeTitle(String origConsumeTitle) {
        /* 603 */
        this.origConsumeTitle = origConsumeTitle;

    }


    public String getOwnerCardNo() {
        /* 607 */
        return this.ownerCardNo;

    }


    public void setOwnerCardNo(String ownerCardNo) {
        /* 610 */
        this.ownerCardNo = ownerCardNo;

    }


    public String getOwnerCustomerId() {
        /* 614 */
        return this.ownerCustomerId;

    }


    public void setOwnerCustomerId(String ownerCustomerId) {
        /* 617 */
        this.ownerCustomerId = ownerCustomerId;

    }


    public String getOwnerLoginId() {
        /* 621 */
        return this.ownerLoginId;

    }


    public void setOwnerLoginId(String ownerLoginId) {
        /* 624 */
        this.ownerLoginId = ownerLoginId;

    }


    public String getOwnerName() {
        /* 628 */
        return this.ownerName;

    }


    public void setOwnerName(String ownerName) {
        /* 631 */
        this.ownerName = ownerName;

    }


    public String getOwnerNick() {
        /* 635 */
        return this.ownerNick;

    }


    public void setOwnerNick(String ownerNick) {
        /* 638 */
        this.ownerNick = ownerNick;

    }


    public String getPartnerId() {
        /* 642 */
        return this.partnerId;

    }


    public void setPartnerId(String partnerId) {
        /* 645 */
        this.partnerId = partnerId;

    }


    public String getPayChannel() {
        /* 649 */
        return this.payChannel;

    }


    public void setPayChannel(String payChannel) {
        /* 652 */
        this.payChannel = payChannel;

    }


    public String getPeerpayerRealName() {
        /* 656 */
        return this.peerpayerRealName;

    }


    public void setPeerpayerRealName(String peerpayerRealName) {
        /* 659 */
        this.peerpayerRealName = peerpayerRealName;

    }


    public String getProduct() {
        /* 663 */
        return this.product;

    }


    public void setProduct(String product) {
        /* 666 */
        this.product = product;

    }


    public String getRefundFee() {
        /* 670 */
        return this.refundFee;

    }


    public void setRefundFee(String refundFee) {
        /* 673 */
        this.refundFee = refundFee;

    }


    public String getServiceFee() {
        /* 677 */
        return this.serviceFee;

    }


    public void setServiceFee(String serviceFee) {
        /* 680 */
        this.serviceFee = serviceFee;

    }


    public String getTotalRefundFee() {
        /* 684 */
        return this.totalRefundFee;

    }


    public void setTotalRefundFee(String totalRefundFee) {
        /* 687 */
        this.totalRefundFee = totalRefundFee;

    }


    public String getTradeFrom() {
        /* 691 */
        return this.tradeFrom;

    }


    public void setTradeFrom(String tradeFrom) {
        /* 694 */
        this.tradeFrom = tradeFrom;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ConsumeRecordAOPModel
 * JD-Core Version:    0.6.0
 */