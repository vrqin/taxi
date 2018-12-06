package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class ItemInfo extends AlipayObject {
    private static final long serialVersionUID = 2189891874497444973L;


    @ApiListField("item_ids")

    @ApiField("string")
    private List<String> itemIds;


    @ApiListField("item_imgs")

    @ApiField("string")
    private List<String> itemImgs;


    @ApiField("item_link")
    private String itemLink;


    @ApiField("item_name")
    private String itemName;


    @ApiField("item_text")
    private String itemText;


    @ApiField("max_discount_num")
    private String maxDiscountNum;


    @ApiField("min_consume_num")
    private String minConsumeNum;


    @ApiField("original_price")
    private String originalPrice;


    public List<String> getItemIds() {
        /*  74 */
        return this.itemIds;

    }


    public void setItemIds(List<String> itemIds) {
        /*  77 */
        this.itemIds = itemIds;

    }


    public List<String> getItemImgs() {
        /*  81 */
        return this.itemImgs;

    }


    public void setItemImgs(List<String> itemImgs) {
        /*  84 */
        this.itemImgs = itemImgs;

    }


    public String getItemLink() {
        /*  88 */
        return this.itemLink;

    }


    public void setItemLink(String itemLink) {
        /*  91 */
        this.itemLink = itemLink;

    }


    public String getItemName() {
        /*  95 */
        return this.itemName;

    }


    public void setItemName(String itemName) {
        /*  98 */
        this.itemName = itemName;

    }


    public String getItemText() {
        /* 102 */
        return this.itemText;

    }


    public void setItemText(String itemText) {
        /* 105 */
        this.itemText = itemText;

    }


    public String getMaxDiscountNum() {
        /* 109 */
        return this.maxDiscountNum;

    }


    public void setMaxDiscountNum(String maxDiscountNum) {
        /* 112 */
        this.maxDiscountNum = maxDiscountNum;

    }


    public String getMinConsumeNum() {
        /* 116 */
        return this.minConsumeNum;

    }


    public void setMinConsumeNum(String minConsumeNum) {
        /* 119 */
        this.minConsumeNum = minConsumeNum;

    }


    public String getOriginalPrice() {
        /* 123 */
        return this.originalPrice;

    }


    public void setOriginalPrice(String originalPrice) {
        /* 126 */
        this.originalPrice = originalPrice;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ItemInfo
 * JD-Core Version:    0.6.0
 */