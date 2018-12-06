package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayTradeCreateModel extends AlipayObject {
    private static final long serialVersionUID = 5693738637494389583L;


    @ApiField("alipay_store_id")
    private String alipayStoreId;


    @ApiField("body")
    private String body;


    @ApiField("buyer_id")
    private String buyerId;


    @ApiField("buyer_logon_id")
    private String buyerLogonId;


    @ApiField("discountable_amount")
    private String discountableAmount;


    @ApiField("extend_params")
    private ExtendParams extendParams;


    @ApiListField("goods_detail")

    @ApiField("goods_detail")
    private List<GoodsDetail> goodsDetail;


    @ApiField("operator_id")
    private String operatorId;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiField("royalty_info")
    private RoyaltyInfo royaltyInfo;


    @ApiField("seller_id")
    private String sellerId;


    @ApiField("store_id")
    private String storeId;


    @ApiField("sub_merchant")
    private SubMerchant subMerchant;


    @ApiField("subject")
    private String subject;


    @ApiField("terminal_id")
    private String terminalId;


    @ApiField("timeout_express")
    private String timeoutExpress;


    @ApiField("total_amount")
    private String totalAmount;


    @ApiField("undiscountable_amount")
    private String undiscountableAmount;


    public String getAlipayStoreId() {
        /* 136 */
        return this.alipayStoreId;

    }


    public void setAlipayStoreId(String alipayStoreId) {
        /* 139 */
        this.alipayStoreId = alipayStoreId;

    }


    public String getBody() {
        /* 143 */
        return this.body;

    }


    public void setBody(String body) {
        /* 146 */
        this.body = body;

    }


    public String getBuyerId() {
        /* 150 */
        return this.buyerId;

    }


    public void setBuyerId(String buyerId) {
        /* 153 */
        this.buyerId = buyerId;

    }


    public String getBuyerLogonId() {
        /* 157 */
        return this.buyerLogonId;

    }


    public void setBuyerLogonId(String buyerLogonId) {
        /* 160 */
        this.buyerLogonId = buyerLogonId;

    }


    public String getDiscountableAmount() {
        /* 164 */
        return this.discountableAmount;

    }


    public void setDiscountableAmount(String discountableAmount) {
        /* 167 */
        this.discountableAmount = discountableAmount;

    }


    public ExtendParams getExtendParams() {
        /* 171 */
        return this.extendParams;

    }


    public void setExtendParams(ExtendParams extendParams) {
        /* 174 */
        this.extendParams = extendParams;

    }


    public List<GoodsDetail> getGoodsDetail() {
        /* 178 */
        return this.goodsDetail;

    }


    public void setGoodsDetail(List<GoodsDetail> goodsDetail) {
        /* 181 */
        this.goodsDetail = goodsDetail;

    }


    public String getOperatorId() {
        /* 185 */
        return this.operatorId;

    }


    public void setOperatorId(String operatorId) {
        /* 188 */
        this.operatorId = operatorId;

    }


    public String getOutTradeNo() {
        /* 192 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 195 */
        this.outTradeNo = outTradeNo;

    }


    public RoyaltyInfo getRoyaltyInfo() {
        /* 199 */
        return this.royaltyInfo;

    }


    public void setRoyaltyInfo(RoyaltyInfo royaltyInfo) {
        /* 202 */
        this.royaltyInfo = royaltyInfo;

    }


    public String getSellerId() {
        /* 206 */
        return this.sellerId;

    }


    public void setSellerId(String sellerId) {
        /* 209 */
        this.sellerId = sellerId;

    }


    public String getStoreId() {
        /* 213 */
        return this.storeId;

    }


    public void setStoreId(String storeId) {
        /* 216 */
        this.storeId = storeId;

    }


    public SubMerchant getSubMerchant() {
        /* 220 */
        return this.subMerchant;

    }


    public void setSubMerchant(SubMerchant subMerchant) {
        /* 223 */
        this.subMerchant = subMerchant;

    }


    public String getSubject() {
        /* 227 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /* 230 */
        this.subject = subject;

    }


    public String getTerminalId() {
        /* 234 */
        return this.terminalId;

    }


    public void setTerminalId(String terminalId) {
        /* 237 */
        this.terminalId = terminalId;

    }


    public String getTimeoutExpress() {
        /* 241 */
        return this.timeoutExpress;

    }


    public void setTimeoutExpress(String timeoutExpress) {
        /* 244 */
        this.timeoutExpress = timeoutExpress;

    }


    public String getTotalAmount() {
        /* 248 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 251 */
        this.totalAmount = totalAmount;

    }


    public String getUndiscountableAmount() {
        /* 255 */
        return this.undiscountableAmount;

    }


    public void setUndiscountableAmount(String undiscountableAmount) {
        /* 258 */
        this.undiscountableAmount = undiscountableAmount;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradeCreateModel
 * JD-Core Version:    0.6.0
 */