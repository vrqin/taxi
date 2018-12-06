package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class OrderDetail extends AlipayObject {
    private static final long serialVersionUID = 7773366245612678381L;


    @ApiField("app_id")
    private String appId;


    @ApiField("body")
    private String body;


    @ApiListField("goods_detail")

    @ApiField("goods_detail")
    private List<GoodsDetail> goodsDetail;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiField("passback_params")
    private String passbackParams;


    @ApiField("product_code")
    private String productCode;


    @ApiField("seller_id")
    private String sellerId;


    @ApiField("seller_logon_id")
    private String sellerLogonId;


    @ApiField("show_url")
    private String showUrl;


    @ApiField("subject")
    private String subject;


    @ApiField("total_amount")
    private String totalAmount;


    public String getAppId() {
        /*  89 */
        return this.appId;

    }


    public void setAppId(String appId) {
        /*  92 */
        this.appId = appId;

    }


    public String getBody() {
        /*  96 */
        return this.body;

    }


    public void setBody(String body) {
        /*  99 */
        this.body = body;

    }


    public List<GoodsDetail> getGoodsDetail() {
        /* 103 */
        return this.goodsDetail;

    }


    public void setGoodsDetail(List<GoodsDetail> goodsDetail) {
        /* 106 */
        this.goodsDetail = goodsDetail;

    }


    public String getOutTradeNo() {
        /* 110 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 113 */
        this.outTradeNo = outTradeNo;

    }


    public String getPassbackParams() {
        /* 117 */
        return this.passbackParams;

    }


    public void setPassbackParams(String passbackParams) {
        /* 120 */
        this.passbackParams = passbackParams;

    }


    public String getProductCode() {
        /* 124 */
        return this.productCode;

    }


    public void setProductCode(String productCode) {
        /* 127 */
        this.productCode = productCode;

    }


    public String getSellerId() {
        /* 131 */
        return this.sellerId;

    }


    public void setSellerId(String sellerId) {
        /* 134 */
        this.sellerId = sellerId;

    }


    public String getSellerLogonId() {
        /* 138 */
        return this.sellerLogonId;

    }


    public void setSellerLogonId(String sellerLogonId) {
        /* 141 */
        this.sellerLogonId = sellerLogonId;

    }


    public String getShowUrl() {
        /* 145 */
        return this.showUrl;

    }


    public void setShowUrl(String showUrl) {
        /* 148 */
        this.showUrl = showUrl;

    }


    public String getSubject() {
        /* 152 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /* 155 */
        this.subject = subject;

    }


    public String getTotalAmount() {
        /* 159 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 162 */
        this.totalAmount = totalAmount;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OrderDetail
 * JD-Core Version:    0.6.0
 */