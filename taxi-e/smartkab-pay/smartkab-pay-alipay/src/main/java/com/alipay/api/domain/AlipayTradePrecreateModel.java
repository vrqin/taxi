package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayTradePrecreateModel extends AlipayObject {
    private static final long serialVersionUID = 5841511977332922725L;


    @ApiField("alipay_store_id")
    private String alipayStoreId;


    @ApiField("body")
    private String body;


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
        /* 124 */
        return this.alipayStoreId;

    }


    public void setAlipayStoreId(String alipayStoreId) {
        /* 127 */
        this.alipayStoreId = alipayStoreId;

    }


    public String getBody() {
        /* 131 */
        return this.body;

    }


    public void setBody(String body) {
        /* 134 */
        this.body = body;

    }


    public String getBuyerLogonId() {
        /* 138 */
        return this.buyerLogonId;

    }


    public void setBuyerLogonId(String buyerLogonId) {
        /* 141 */
        this.buyerLogonId = buyerLogonId;

    }


    public String getDiscountableAmount() {
        /* 145 */
        return this.discountableAmount;

    }


    public void setDiscountableAmount(String discountableAmount) {
        /* 148 */
        this.discountableAmount = discountableAmount;

    }


    public ExtendParams getExtendParams() {
        /* 152 */
        return this.extendParams;

    }


    public void setExtendParams(ExtendParams extendParams) {
        /* 155 */
        this.extendParams = extendParams;

    }


    public List<GoodsDetail> getGoodsDetail() {
        /* 159 */
        return this.goodsDetail;

    }


    public void setGoodsDetail(List<GoodsDetail> goodsDetail) {
        /* 162 */
        this.goodsDetail = goodsDetail;

    }


    public String getOperatorId() {
        /* 166 */
        return this.operatorId;

    }


    public void setOperatorId(String operatorId) {
        /* 169 */
        this.operatorId = operatorId;

    }


    public String getOutTradeNo() {
        /* 173 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 176 */
        this.outTradeNo = outTradeNo;

    }


    public RoyaltyInfo getRoyaltyInfo() {
        /* 180 */
        return this.royaltyInfo;

    }


    public void setRoyaltyInfo(RoyaltyInfo royaltyInfo) {
        /* 183 */
        this.royaltyInfo = royaltyInfo;

    }


    public String getSellerId() {
        /* 187 */
        return this.sellerId;

    }


    public void setSellerId(String sellerId) {
        /* 190 */
        this.sellerId = sellerId;

    }


    public String getStoreId() {
        /* 194 */
        return this.storeId;

    }


    public void setStoreId(String storeId) {
        /* 197 */
        this.storeId = storeId;

    }


    public SubMerchant getSubMerchant() {
        /* 201 */
        return this.subMerchant;

    }


    public void setSubMerchant(SubMerchant subMerchant) {
        /* 204 */
        this.subMerchant = subMerchant;

    }


    public String getSubject() {
        /* 208 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /* 211 */
        this.subject = subject;

    }


    public String getTerminalId() {
        /* 215 */
        return this.terminalId;

    }


    public void setTerminalId(String terminalId) {
        /* 218 */
        this.terminalId = terminalId;

    }


    public String getTimeoutExpress() {
        /* 222 */
        return this.timeoutExpress;

    }


    public void setTimeoutExpress(String timeoutExpress) {
        /* 225 */
        this.timeoutExpress = timeoutExpress;

    }


    public String getTotalAmount() {
        /* 229 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 232 */
        this.totalAmount = totalAmount;

    }


    public String getUndiscountableAmount() {
        /* 236 */
        return this.undiscountableAmount;

    }


    public void setUndiscountableAmount(String undiscountableAmount) {
        /* 239 */
        this.undiscountableAmount = undiscountableAmount;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradePrecreateModel
 * JD-Core Version:    0.6.0
 */