package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.TradeFundBill;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class AlipayTradeRefundResponse extends AlipayResponse {
    private static final long serialVersionUID = 4257912866564838218L;


    @ApiField("buyer_logon_id")
    private String buyerLogonId;


    @ApiField("buyer_user_id")
    private String buyerUserId;


    @ApiField("fund_change")
    private String fundChange;


    @ApiField("gmt_refund_pay")
    private Date gmtRefundPay;


    @ApiField("open_id")
    private String openId;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiListField("refund_detail_item_list")

    @ApiField("trade_fund_bill")
    private List<TradeFundBill> refundDetailItemList;


    @ApiField("refund_fee")
    private String refundFee;


    @ApiField("send_back_fee")
    private String sendBackFee;


    @ApiField("store_name")
    private String storeName;


    @ApiField("trade_no")
    private String tradeNo;


    public String getBuyerLogonId() {
        /*  92 */
        return this.buyerLogonId;

    }


    public void setBuyerLogonId(String buyerLogonId) {
        /*  89 */
        this.buyerLogonId = buyerLogonId;

    }


    public String getBuyerUserId() {
        /*  99 */
        return this.buyerUserId;

    }


    public void setBuyerUserId(String buyerUserId) {
        /*  96 */
        this.buyerUserId = buyerUserId;

    }


    public String getFundChange() {
        /* 106 */
        return this.fundChange;

    }


    public void setFundChange(String fundChange) {
        /* 103 */
        this.fundChange = fundChange;

    }


    public Date getGmtRefundPay() {
        /* 113 */
        return this.gmtRefundPay;

    }


    public void setGmtRefundPay(Date gmtRefundPay) {
        /* 110 */
        this.gmtRefundPay = gmtRefundPay;

    }


    public String getOpenId() {
        /* 120 */
        return this.openId;

    }


    public void setOpenId(String openId) {
        /* 117 */
        this.openId = openId;

    }


    public String getOutTradeNo() {
        /* 127 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 124 */
        this.outTradeNo = outTradeNo;

    }


    public List<TradeFundBill> getRefundDetailItemList() {
        /* 134 */
        return this.refundDetailItemList;

    }


    public void setRefundDetailItemList(List<TradeFundBill> refundDetailItemList) {
        /* 131 */
        this.refundDetailItemList = refundDetailItemList;

    }


    public String getRefundFee() {
        /* 141 */
        return this.refundFee;

    }


    public void setRefundFee(String refundFee) {
        /* 138 */
        this.refundFee = refundFee;

    }


    public String getSendBackFee() {
        /* 148 */
        return this.sendBackFee;

    }


    public void setSendBackFee(String sendBackFee) {
        /* 145 */
        this.sendBackFee = sendBackFee;

    }


    public String getStoreName() {
        /* 155 */
        return this.storeName;

    }


    public void setStoreName(String storeName) {
        /* 152 */
        this.storeName = storeName;

    }


    public String getTradeNo() {
        /* 162 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 159 */
        this.tradeNo = tradeNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTradeRefundResponse
 * JD-Core Version:    0.6.0
 */