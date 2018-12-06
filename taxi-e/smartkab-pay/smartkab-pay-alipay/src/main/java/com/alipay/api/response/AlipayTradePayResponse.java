package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.TradeFundBill;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class AlipayTradePayResponse extends AlipayResponse {
    private static final long serialVersionUID = 8461752241171721888L;


    @ApiField("buyer_logon_id")
    private String buyerLogonId;


    @ApiField("buyer_pay_amount")
    private String buyerPayAmount;


    @ApiField("buyer_user_id")
    private String buyerUserId;


    @ApiField("card_balance")
    private String cardBalance;


    @ApiField("discount_goods_detail")
    private String discountGoodsDetail;


    @ApiListField("fund_bill_list")

    @ApiField("trade_fund_bill")
    private List<TradeFundBill> fundBillList;


    @ApiField("gmt_payment")
    private Date gmtPayment;


    @ApiField("invoice_amount")
    private String invoiceAmount;


    @ApiField("open_id")
    private String openId;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiField("point_amount")
    private String pointAmount;


    @ApiField("receipt_amount")
    private String receiptAmount;


    @ApiField("store_name")
    private String storeName;


    @ApiField("total_amount")
    private String totalAmount;


    @ApiField("trade_no")
    private String tradeNo;


    public String getBuyerLogonId() {
        /* 116 */
        return this.buyerLogonId;

    }


    public void setBuyerLogonId(String buyerLogonId) {
        /* 113 */
        this.buyerLogonId = buyerLogonId;

    }


    public String getBuyerPayAmount() {
        /* 123 */
        return this.buyerPayAmount;

    }


    public void setBuyerPayAmount(String buyerPayAmount) {
        /* 120 */
        this.buyerPayAmount = buyerPayAmount;

    }


    public String getBuyerUserId() {
        /* 130 */
        return this.buyerUserId;

    }


    public void setBuyerUserId(String buyerUserId) {
        /* 127 */
        this.buyerUserId = buyerUserId;

    }


    public String getCardBalance() {
        /* 137 */
        return this.cardBalance;

    }


    public void setCardBalance(String cardBalance) {
        /* 134 */
        this.cardBalance = cardBalance;

    }


    public String getDiscountGoodsDetail() {
        /* 144 */
        return this.discountGoodsDetail;

    }


    public void setDiscountGoodsDetail(String discountGoodsDetail) {
        /* 141 */
        this.discountGoodsDetail = discountGoodsDetail;

    }


    public List<TradeFundBill> getFundBillList() {
        /* 151 */
        return this.fundBillList;

    }


    public void setFundBillList(List<TradeFundBill> fundBillList) {
        /* 148 */
        this.fundBillList = fundBillList;

    }


    public Date getGmtPayment() {
        /* 158 */
        return this.gmtPayment;

    }


    public void setGmtPayment(Date gmtPayment) {
        /* 155 */
        this.gmtPayment = gmtPayment;

    }


    public String getInvoiceAmount() {
        /* 165 */
        return this.invoiceAmount;

    }


    public void setInvoiceAmount(String invoiceAmount) {
        /* 162 */
        this.invoiceAmount = invoiceAmount;

    }


    public String getOpenId() {
        /* 172 */
        return this.openId;

    }


    public void setOpenId(String openId) {
        /* 169 */
        this.openId = openId;

    }


    public String getOutTradeNo() {
        /* 179 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 176 */
        this.outTradeNo = outTradeNo;

    }


    public String getPointAmount() {
        /* 186 */
        return this.pointAmount;

    }


    public void setPointAmount(String pointAmount) {
        /* 183 */
        this.pointAmount = pointAmount;

    }


    public String getReceiptAmount() {
        /* 193 */
        return this.receiptAmount;

    }


    public void setReceiptAmount(String receiptAmount) {
        /* 190 */
        this.receiptAmount = receiptAmount;

    }


    public String getStoreName() {
        /* 200 */
        return this.storeName;

    }


    public void setStoreName(String storeName) {
        /* 197 */
        this.storeName = storeName;

    }


    public String getTotalAmount() {
        /* 207 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 204 */
        this.totalAmount = totalAmount;

    }


    public String getTradeNo() {
        /* 214 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 211 */
        this.tradeNo = tradeNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTradePayResponse
 * JD-Core Version:    0.6.0
 */