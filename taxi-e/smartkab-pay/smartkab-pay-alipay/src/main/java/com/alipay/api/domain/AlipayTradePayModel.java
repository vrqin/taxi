package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayTradePayModel extends AlipayObject {
    private static final long serialVersionUID = 3548793414336174144L;


    @ApiField("alipay_store_id")
    private String alipayStoreId;


    @ApiField("auth_code")
    private String authCode;


    @ApiField("body")
    private String body;


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


    @ApiField("scene")
    private String scene;


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
        /* 135 */
        return this.alipayStoreId;

    }


    public void setAlipayStoreId(String alipayStoreId) {
        /* 138 */
        this.alipayStoreId = alipayStoreId;

    }


    public String getAuthCode() {
        /* 142 */
        return this.authCode;

    }


    public void setAuthCode(String authCode) {
        /* 145 */
        this.authCode = authCode;

    }


    public String getBody() {
        /* 149 */
        return this.body;

    }


    public void setBody(String body) {
        /* 152 */
        this.body = body;

    }


    public String getDiscountableAmount() {
        /* 156 */
        return this.discountableAmount;

    }


    public void setDiscountableAmount(String discountableAmount) {
        /* 159 */
        this.discountableAmount = discountableAmount;

    }


    public ExtendParams getExtendParams() {
        /* 163 */
        return this.extendParams;

    }


    public void setExtendParams(ExtendParams extendParams) {
        /* 166 */
        this.extendParams = extendParams;

    }


    public List<GoodsDetail> getGoodsDetail() {
        /* 170 */
        return this.goodsDetail;

    }


    public void setGoodsDetail(List<GoodsDetail> goodsDetail) {
        /* 173 */
        this.goodsDetail = goodsDetail;

    }


    public String getOperatorId() {
        /* 177 */
        return this.operatorId;

    }


    public void setOperatorId(String operatorId) {
        /* 180 */
        this.operatorId = operatorId;

    }


    public String getOutTradeNo() {
        /* 184 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 187 */
        this.outTradeNo = outTradeNo;

    }


    public RoyaltyInfo getRoyaltyInfo() {
        /* 191 */
        return this.royaltyInfo;

    }


    public void setRoyaltyInfo(RoyaltyInfo royaltyInfo) {
        /* 194 */
        this.royaltyInfo = royaltyInfo;

    }


    public String getScene() {
        /* 198 */
        return this.scene;

    }


    public void setScene(String scene) {
        /* 201 */
        this.scene = scene;

    }


    public String getSellerId() {
        /* 205 */
        return this.sellerId;

    }


    public void setSellerId(String sellerId) {
        /* 208 */
        this.sellerId = sellerId;

    }


    public String getStoreId() {
        /* 212 */
        return this.storeId;

    }


    public void setStoreId(String storeId) {
        /* 215 */
        this.storeId = storeId;

    }


    public SubMerchant getSubMerchant() {
        /* 219 */
        return this.subMerchant;

    }


    public void setSubMerchant(SubMerchant subMerchant) {
        /* 222 */
        this.subMerchant = subMerchant;

    }


    public String getSubject() {
        /* 226 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /* 229 */
        this.subject = subject;

    }


    public String getTerminalId() {
        /* 233 */
        return this.terminalId;

    }


    public void setTerminalId(String terminalId) {
        /* 236 */
        this.terminalId = terminalId;

    }


    public String getTimeoutExpress() {
        /* 240 */
        return this.timeoutExpress;

    }


    public void setTimeoutExpress(String timeoutExpress) {
        /* 243 */
        this.timeoutExpress = timeoutExpress;

    }


    public String getTotalAmount() {
        /* 247 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 250 */
        this.totalAmount = totalAmount;

    }


    public String getUndiscountableAmount() {
        /* 254 */
        return this.undiscountableAmount;

    }


    public void setUndiscountableAmount(String undiscountableAmount) {
        /* 257 */
        this.undiscountableAmount = undiscountableAmount;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradePayModel
 * JD-Core Version:    0.6.0
 */