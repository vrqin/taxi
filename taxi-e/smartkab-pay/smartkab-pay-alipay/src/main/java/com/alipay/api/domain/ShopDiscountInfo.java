package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class ShopDiscountInfo extends AlipayObject {
    private static final long serialVersionUID = 3611144185923246562L;


    @ApiField("cover")
    private String cover;


    @ApiField("description")
    private String description;


    @ApiField("is_all")
    private String isAll;


    @ApiField("item_id")
    private String itemId;


    @ApiField("promotion_type")
    private String promotionType;


    @ApiField("purchase_mode")
    private String purchaseMode;


    @ApiField("sales_quantity")
    private String salesQuantity;


    @ApiField("subject")
    private String subject;


    public String getCover() {
        /*  68 */
        return this.cover;

    }


    public void setCover(String cover) {
        /*  71 */
        this.cover = cover;

    }


    public String getDescription() {
        /*  75 */
        return this.description;

    }


    public void setDescription(String description) {
        /*  78 */
        this.description = description;

    }


    public String getIsAll() {
        /*  82 */
        return this.isAll;

    }


    public void setIsAll(String isAll) {
        /*  85 */
        this.isAll = isAll;

    }


    public String getItemId() {
        /*  89 */
        return this.itemId;

    }


    public void setItemId(String itemId) {
        /*  92 */
        this.itemId = itemId;

    }


    public String getPromotionType() {
        /*  96 */
        return this.promotionType;

    }


    public void setPromotionType(String promotionType) {
        /*  99 */
        this.promotionType = promotionType;

    }


    public String getPurchaseMode() {
        /* 103 */
        return this.purchaseMode;

    }


    public void setPurchaseMode(String purchaseMode) {
        /* 106 */
        this.purchaseMode = purchaseMode;

    }


    public String getSalesQuantity() {
        /* 110 */
        return this.salesQuantity;

    }


    public void setSalesQuantity(String salesQuantity) {
        /* 113 */
        this.salesQuantity = salesQuantity;

    }


    public String getSubject() {
        /* 117 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /* 120 */
        this.subject = subject;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ShopDiscountInfo
 * JD-Core Version:    0.6.0
 */