package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.TradeFundBill;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class AlipayTradeQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1434567213266399468L;


    @ApiField("alipay_store_id")
    private String alipayStoreId;


    @ApiField("buyer_logon_id")
    private String buyerLogonId;


    @ApiField("buyer_pay_amount")
    private String buyerPayAmount;


    @ApiField("buyer_user_id")
    private String buyerUserId;


    @ApiField("discount_goods_detail")
    private String discountGoodsDetail;


    @ApiListField("fund_bill_list")

    @ApiField("trade_fund_bill")
    private List<TradeFundBill> fundBillList;


    @ApiField("industry_sepc_detail")
    private String industrySepcDetail;


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


    @ApiField("send_pay_date")
    private Date sendPayDate;


    @ApiField("store_id")
    private String storeId;


    @ApiField("store_name")
    private String storeName;


    @ApiField("terminal_id")
    private String terminalId;


    @ApiField("total_amount")
    private String totalAmount;


    @ApiField("trade_no")
    private String tradeNo;


    @ApiField("trade_status")
    private String tradeStatus;


    public String getAlipayStoreId() {
        /* 140 */
        return this.alipayStoreId;

    }


    public void setAlipayStoreId(String alipayStoreId) {
        /* 137 */
        this.alipayStoreId = alipayStoreId;

    }


    public String getBuyerLogonId() {
        /* 147 */
        return this.buyerLogonId;

    }


    public void setBuyerLogonId(String buyerLogonId) {
        /* 144 */
        this.buyerLogonId = buyerLogonId;

    }


    public String getBuyerPayAmount() {
        /* 154 */
        return this.buyerPayAmount;

    }


    public void setBuyerPayAmount(String buyerPayAmount) {
        /* 151 */
        this.buyerPayAmount = buyerPayAmount;

    }


    public String getBuyerUserId() {
        /* 161 */
        return this.buyerUserId;

    }


    public void setBuyerUserId(String buyerUserId) {
        /* 158 */
        this.buyerUserId = buyerUserId;

    }


    public String getDiscountGoodsDetail() {
        /* 168 */
        return this.discountGoodsDetail;

    }


    public void setDiscountGoodsDetail(String discountGoodsDetail) {
        /* 165 */
        this.discountGoodsDetail = discountGoodsDetail;

    }


    public List<TradeFundBill> getFundBillList() {
        /* 175 */
        return this.fundBillList;

    }


    public void setFundBillList(List<TradeFundBill> fundBillList) {
        /* 172 */
        this.fundBillList = fundBillList;

    }


    public String getIndustrySepcDetail() {
        /* 182 */
        return this.industrySepcDetail;

    }


    public void setIndustrySepcDetail(String industrySepcDetail) {
        /* 179 */
        this.industrySepcDetail = industrySepcDetail;

    }


    public String getInvoiceAmount() {
        /* 189 */
        return this.invoiceAmount;

    }


    public void setInvoiceAmount(String invoiceAmount) {
        /* 186 */
        this.invoiceAmount = invoiceAmount;

    }


    public String getOpenId() {
        /* 196 */
        return this.openId;

    }


    public void setOpenId(String openId) {
        /* 193 */
        this.openId = openId;

    }


    public String getOutTradeNo() {
        /* 203 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 200 */
        this.outTradeNo = outTradeNo;

    }


    public String getPointAmount() {
        /* 210 */
        return this.pointAmount;

    }


    public void setPointAmount(String pointAmount) {
        /* 207 */
        this.pointAmount = pointAmount;

    }


    public String getReceiptAmount() {
        /* 217 */
        return this.receiptAmount;

    }


    public void setReceiptAmount(String receiptAmount) {
        /* 214 */
        this.receiptAmount = receiptAmount;

    }


    public Date getSendPayDate() {
        /* 224 */
        return this.sendPayDate;

    }


    public void setSendPayDate(Date sendPayDate) {
        /* 221 */
        this.sendPayDate = sendPayDate;

    }


    public String getStoreId() {
        /* 231 */
        return this.storeId;

    }


    public void setStoreId(String storeId) {
        /* 228 */
        this.storeId = storeId;

    }


    public String getStoreName() {
        /* 238 */
        return this.storeName;

    }


    public void setStoreName(String storeName) {
        /* 235 */
        this.storeName = storeName;

    }


    public String getTerminalId() {
        /* 245 */
        return this.terminalId;

    }


    public void setTerminalId(String terminalId) {
        /* 242 */
        this.terminalId = terminalId;

    }


    public String getTotalAmount() {
        /* 252 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 249 */
        this.totalAmount = totalAmount;

    }


    public String getTradeNo() {
        /* 259 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 256 */
        this.tradeNo = tradeNo;

    }


    public String getTradeStatus() {
        /* 266 */
        return this.tradeStatus;

    }


    public void setTradeStatus(String tradeStatus) {
        /* 263 */
        this.tradeStatus = tradeStatus;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTradeQueryResponse
 * JD-Core Version:    0.6.0
 */