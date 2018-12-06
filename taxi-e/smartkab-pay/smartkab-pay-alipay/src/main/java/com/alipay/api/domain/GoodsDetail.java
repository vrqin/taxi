package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class GoodsDetail extends AlipayObject {
    private static final long serialVersionUID = 3766915983172987476L;


    @ApiField("alipay_goods_id")
    private String alipayGoodsId;


    @ApiField("body")
    private String body;


    @ApiField("goods_category")
    private String goodsCategory;


    @ApiField("goods_id")
    private String goodsId;


    @ApiField("goods_name")
    private String goodsName;


    @ApiField("price")
    private String price;


    @ApiField("quantity")
    private Long quantity;


    @ApiField("show_url")
    private String showUrl;


    public String getAlipayGoodsId() {
        /*  65 */
        return this.alipayGoodsId;

    }


    public void setAlipayGoodsId(String alipayGoodsId) {
        /*  68 */
        this.alipayGoodsId = alipayGoodsId;

    }


    public String getBody() {
        /*  72 */
        return this.body;

    }


    public void setBody(String body) {
        /*  75 */
        this.body = body;

    }


    public String getGoodsCategory() {
        /*  79 */
        return this.goodsCategory;

    }


    public void setGoodsCategory(String goodsCategory) {
        /*  82 */
        this.goodsCategory = goodsCategory;

    }


    public String getGoodsId() {
        /*  86 */
        return this.goodsId;

    }


    public void setGoodsId(String goodsId) {
        /*  89 */
        this.goodsId = goodsId;

    }


    public String getGoodsName() {
        /*  93 */
        return this.goodsName;

    }


    public void setGoodsName(String goodsName) {
        /*  96 */
        this.goodsName = goodsName;

    }


    public String getPrice() {
        /* 100 */
        return this.price;

    }


    public void setPrice(String price) {
        /* 103 */
        this.price = price;

    }


    public Long getQuantity() {
        /* 107 */
        return this.quantity;

    }


    public void setQuantity(Long quantity) {
        /* 110 */
        this.quantity = quantity;

    }


    public String getShowUrl() {
        /* 114 */
        return this.showUrl;

    }


    public void setShowUrl(String showUrl) {
        /* 117 */
        this.showUrl = showUrl;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.GoodsDetail
 * JD-Core Version:    0.6.0
 */