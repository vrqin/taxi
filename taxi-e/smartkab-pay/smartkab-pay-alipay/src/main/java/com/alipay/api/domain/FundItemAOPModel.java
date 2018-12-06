package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class FundItemAOPModel extends AlipayObject {
    private static final long serialVersionUID = 8254819475259624274L;


    @ApiField("acctrans_out_biz_no")
    private String acctransOutBizNo;


    @ApiField("amount")
    private String amount;


    @ApiField("assert_type_code")
    private String assertTypeCode;


    @ApiField("bank_card_pay_type")
    private String bankCardPayType;


    @ApiField("bank_card_type")
    private String bankCardType;


    @ApiField("biz_id")
    private String bizId;


    @ApiField("biz_in_no")
    private String bizInNo;


    @ApiField("biz_out_no")
    private String bizOutNo;


    @ApiField("biz_type")
    private String bizType;


    @ApiField("currency")
    private String currency;


    @ApiField("dback_amount")
    private String dbackAmount;


    @ApiField("dback_gmt_create")
    private Date dbackGmtCreate;


    @ApiField("dback_gmt_est_bk_ack")
    private Date dbackGmtEstBkAck;


    @ApiField("dback_gmt_est_bk_into")
    private Date dbackGmtEstBkInto;


    @ApiField("dback_inst_account_name")
    private String dbackInstAccountName;


    @ApiField("dback_inst_account_no")
    private String dbackInstAccountNo;


    @ApiField("dback_inst_id")
    private String dbackInstId;


    @ApiField("dback_inst_name")
    private String dbackInstName;


    @ApiField("fid")
    private String fid;


    @ApiField("fund_access_type")
    private Long fundAccessType;


    @ApiField("fund_account_no")
    private String fundAccountNo;


    @ApiField("fund_biz_type")
    private Long fundBizType;


    @ApiField("fund_create_time")
    private Date fundCreateTime;


    @ApiField("fund_finish_time")
    private Date fundFinishTime;


    @ApiField("fund_in_out")
    private Long fundInOut;


    @ApiField("fund_inst_id")
    private String fundInstId;


    @ApiField("fund_modify_time")
    private Date fundModifyTime;


    @ApiField("fund_status")
    private String fundStatus;


    @ApiField("fund_tool_belong_to_crowner")
    private Boolean fundToolBelongToCrowner;


    @ApiField("fund_tool_owner_card_no")
    private String fundToolOwnerCardNo;


    @ApiField("fund_tool_type_for_crowner")
    private String fundToolTypeForCrowner;


    @ApiField("fund_tool_type_for_system")
    private String fundToolTypeForSystem;


    @ApiField("fund_tool_type_name")
    private String fundToolTypeName;


    @ApiField("gmt_biz_create")
    private Date gmtBizCreate;


    @ApiField("opposite_biz_card_alias")
    private String oppositeBizCardAlias;


    @ApiField("opposite_biz_card_no")
    private String oppositeBizCardNo;


    @ApiField("opposite_fund_card_no")
    private String oppositeFundCardNo;


    @ApiField("out_request_no")
    private String outRequestNo;


    @ApiField("owner_card_no")
    private String ownerCardNo;


    @ApiField("refund_bank_status")
    private String refundBankStatus;


    @ApiField("sub_prepaid_card_type")
    private String subPrepaidCardType;


    @ApiField("uid")
    private String uid;


    public String getAcctransOutBizNo() {
        /* 271 */
        return this.acctransOutBizNo;

    }


    public void setAcctransOutBizNo(String acctransOutBizNo) {
        /* 274 */
        this.acctransOutBizNo = acctransOutBizNo;

    }


    public String getAmount() {
        /* 278 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /* 281 */
        this.amount = amount;

    }


    public String getAssertTypeCode() {
        /* 285 */
        return this.assertTypeCode;

    }


    public void setAssertTypeCode(String assertTypeCode) {
        /* 288 */
        this.assertTypeCode = assertTypeCode;

    }


    public String getBankCardPayType() {
        /* 292 */
        return this.bankCardPayType;

    }


    public void setBankCardPayType(String bankCardPayType) {
        /* 295 */
        this.bankCardPayType = bankCardPayType;

    }


    public String getBankCardType() {
        /* 299 */
        return this.bankCardType;

    }


    public void setBankCardType(String bankCardType) {
        /* 302 */
        this.bankCardType = bankCardType;

    }


    public String getBizId() {
        /* 306 */
        return this.bizId;

    }


    public void setBizId(String bizId) {
        /* 309 */
        this.bizId = bizId;

    }


    public String getBizInNo() {
        /* 313 */
        return this.bizInNo;

    }


    public void setBizInNo(String bizInNo) {
        /* 316 */
        this.bizInNo = bizInNo;

    }


    public String getBizOutNo() {
        /* 320 */
        return this.bizOutNo;

    }


    public void setBizOutNo(String bizOutNo) {
        /* 323 */
        this.bizOutNo = bizOutNo;

    }


    public String getBizType() {
        /* 327 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /* 330 */
        this.bizType = bizType;

    }


    public String getCurrency() {
        /* 334 */
        return this.currency;

    }


    public void setCurrency(String currency) {
        /* 337 */
        this.currency = currency;

    }


    public String getDbackAmount() {
        /* 341 */
        return this.dbackAmount;

    }


    public void setDbackAmount(String dbackAmount) {
        /* 344 */
        this.dbackAmount = dbackAmount;

    }


    public Date getDbackGmtCreate() {
        /* 348 */
        return this.dbackGmtCreate;

    }


    public void setDbackGmtCreate(Date dbackGmtCreate) {
        /* 351 */
        this.dbackGmtCreate = dbackGmtCreate;

    }


    public Date getDbackGmtEstBkAck() {
        /* 355 */
        return this.dbackGmtEstBkAck;

    }


    public void setDbackGmtEstBkAck(Date dbackGmtEstBkAck) {
        /* 358 */
        this.dbackGmtEstBkAck = dbackGmtEstBkAck;

    }


    public Date getDbackGmtEstBkInto() {
        /* 362 */
        return this.dbackGmtEstBkInto;

    }


    public void setDbackGmtEstBkInto(Date dbackGmtEstBkInto) {
        /* 365 */
        this.dbackGmtEstBkInto = dbackGmtEstBkInto;

    }


    public String getDbackInstAccountName() {
        /* 369 */
        return this.dbackInstAccountName;

    }


    public void setDbackInstAccountName(String dbackInstAccountName) {
        /* 372 */
        this.dbackInstAccountName = dbackInstAccountName;

    }


    public String getDbackInstAccountNo() {
        /* 376 */
        return this.dbackInstAccountNo;

    }


    public void setDbackInstAccountNo(String dbackInstAccountNo) {
        /* 379 */
        this.dbackInstAccountNo = dbackInstAccountNo;

    }


    public String getDbackInstId() {
        /* 383 */
        return this.dbackInstId;

    }


    public void setDbackInstId(String dbackInstId) {
        /* 386 */
        this.dbackInstId = dbackInstId;

    }


    public String getDbackInstName() {
        /* 390 */
        return this.dbackInstName;

    }


    public void setDbackInstName(String dbackInstName) {
        /* 393 */
        this.dbackInstName = dbackInstName;

    }


    public String getFid() {
        /* 397 */
        return this.fid;

    }


    public void setFid(String fid) {
        /* 400 */
        this.fid = fid;

    }


    public Long getFundAccessType() {
        /* 404 */
        return this.fundAccessType;

    }


    public void setFundAccessType(Long fundAccessType) {
        /* 407 */
        this.fundAccessType = fundAccessType;

    }


    public String getFundAccountNo() {
        /* 411 */
        return this.fundAccountNo;

    }


    public void setFundAccountNo(String fundAccountNo) {
        /* 414 */
        this.fundAccountNo = fundAccountNo;

    }


    public Long getFundBizType() {
        /* 418 */
        return this.fundBizType;

    }


    public void setFundBizType(Long fundBizType) {
        /* 421 */
        this.fundBizType = fundBizType;

    }


    public Date getFundCreateTime() {
        /* 425 */
        return this.fundCreateTime;

    }


    public void setFundCreateTime(Date fundCreateTime) {
        /* 428 */
        this.fundCreateTime = fundCreateTime;

    }


    public Date getFundFinishTime() {
        /* 432 */
        return this.fundFinishTime;

    }


    public void setFundFinishTime(Date fundFinishTime) {
        /* 435 */
        this.fundFinishTime = fundFinishTime;

    }


    public Long getFundInOut() {
        /* 439 */
        return this.fundInOut;

    }


    public void setFundInOut(Long fundInOut) {
        /* 442 */
        this.fundInOut = fundInOut;

    }


    public String getFundInstId() {
        /* 446 */
        return this.fundInstId;

    }


    public void setFundInstId(String fundInstId) {
        /* 449 */
        this.fundInstId = fundInstId;

    }


    public Date getFundModifyTime() {
        /* 453 */
        return this.fundModifyTime;

    }


    public void setFundModifyTime(Date fundModifyTime) {
        /* 456 */
        this.fundModifyTime = fundModifyTime;

    }


    public String getFundStatus() {
        /* 460 */
        return this.fundStatus;

    }


    public void setFundStatus(String fundStatus) {
        /* 463 */
        this.fundStatus = fundStatus;

    }


    public Boolean getFundToolBelongToCrowner() {
        /* 467 */
        return this.fundToolBelongToCrowner;

    }


    public void setFundToolBelongToCrowner(Boolean fundToolBelongToCrowner) {
        /* 470 */
        this.fundToolBelongToCrowner = fundToolBelongToCrowner;

    }


    public String getFundToolOwnerCardNo() {
        /* 474 */
        return this.fundToolOwnerCardNo;

    }


    public void setFundToolOwnerCardNo(String fundToolOwnerCardNo) {
        /* 477 */
        this.fundToolOwnerCardNo = fundToolOwnerCardNo;

    }


    public String getFundToolTypeForCrowner() {
        /* 481 */
        return this.fundToolTypeForCrowner;

    }


    public void setFundToolTypeForCrowner(String fundToolTypeForCrowner) {
        /* 484 */
        this.fundToolTypeForCrowner = fundToolTypeForCrowner;

    }


    public String getFundToolTypeForSystem() {
        /* 488 */
        return this.fundToolTypeForSystem;

    }


    public void setFundToolTypeForSystem(String fundToolTypeForSystem) {
        /* 491 */
        this.fundToolTypeForSystem = fundToolTypeForSystem;

    }


    public String getFundToolTypeName() {
        /* 495 */
        return this.fundToolTypeName;

    }


    public void setFundToolTypeName(String fundToolTypeName) {
        /* 498 */
        this.fundToolTypeName = fundToolTypeName;

    }


    public Date getGmtBizCreate() {
        /* 502 */
        return this.gmtBizCreate;

    }


    public void setGmtBizCreate(Date gmtBizCreate) {
        /* 505 */
        this.gmtBizCreate = gmtBizCreate;

    }


    public String getOppositeBizCardAlias() {
        /* 509 */
        return this.oppositeBizCardAlias;

    }


    public void setOppositeBizCardAlias(String oppositeBizCardAlias) {
        /* 512 */
        this.oppositeBizCardAlias = oppositeBizCardAlias;

    }


    public String getOppositeBizCardNo() {
        /* 516 */
        return this.oppositeBizCardNo;

    }


    public void setOppositeBizCardNo(String oppositeBizCardNo) {
        /* 519 */
        this.oppositeBizCardNo = oppositeBizCardNo;

    }


    public String getOppositeFundCardNo() {
        /* 523 */
        return this.oppositeFundCardNo;

    }


    public void setOppositeFundCardNo(String oppositeFundCardNo) {
        /* 526 */
        this.oppositeFundCardNo = oppositeFundCardNo;

    }


    public String getOutRequestNo() {
        /* 530 */
        return this.outRequestNo;

    }


    public void setOutRequestNo(String outRequestNo) {
        /* 533 */
        this.outRequestNo = outRequestNo;

    }


    public String getOwnerCardNo() {
        /* 537 */
        return this.ownerCardNo;

    }


    public void setOwnerCardNo(String ownerCardNo) {
        /* 540 */
        this.ownerCardNo = ownerCardNo;

    }


    public String getRefundBankStatus() {
        /* 544 */
        return this.refundBankStatus;

    }


    public void setRefundBankStatus(String refundBankStatus) {
        /* 547 */
        this.refundBankStatus = refundBankStatus;

    }


    public String getSubPrepaidCardType() {
        /* 551 */
        return this.subPrepaidCardType;

    }


    public void setSubPrepaidCardType(String subPrepaidCardType) {
        /* 554 */
        this.subPrepaidCardType = subPrepaidCardType;

    }


    public String getUid() {
        /* 558 */
        return this.uid;

    }


    public void setUid(String uid) {
        /* 561 */
        this.uid = uid;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.FundItemAOPModel
 * JD-Core Version:    0.6.0
 */