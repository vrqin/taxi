package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class KoubeiMemberDataExtitemCreateModel extends AlipayObject {
    private static final long serialVersionUID = 8445952577887415715L;


    @ApiField("brand_code")
    private String brandCode;


    @ApiField("category_code")
    private String categoryCode;


    @ApiField("count")
    private Long count;


    @ApiField("country")
    private String country;


    @ApiField("description")
    private String description;


    @ApiField("item_code")
    private String itemCode;


    @ApiField("picture")
    private String picture;


    @ApiField("price")
    private Long price;


    @ApiField("specification")
    private String specification;


    @ApiField("title")
    private String title;


    public String getBrandCode() {
        /*  77 */
        return this.brandCode;

    }


    public void setBrandCode(String brandCode) {
        /*  80 */
        this.brandCode = brandCode;

    }


    public String getCategoryCode() {
        /*  84 */
        return this.categoryCode;

    }


    public void setCategoryCode(String categoryCode) {
        /*  87 */
        this.categoryCode = categoryCode;

    }


    public Long getCount() {
        /*  91 */
        return this.count;

    }


    public void setCount(Long count) {
        /*  94 */
        this.count = count;

    }


    public String getCountry() {
        /*  98 */
        return this.country;

    }


    public void setCountry(String country) {
        /* 101 */
        this.country = country;

    }


    public String getDescription() {
        /* 105 */
        return this.description;

    }


    public void setDescription(String description) {
        /* 108 */
        this.description = description;

    }


    public String getItemCode() {
        /* 112 */
        return this.itemCode;

    }


    public void setItemCode(String itemCode) {
        /* 115 */
        this.itemCode = itemCode;

    }


    public String getPicture() {
        /* 119 */
        return this.picture;

    }


    public void setPicture(String picture) {
        /* 122 */
        this.picture = picture;

    }


    public Long getPrice() {
        /* 126 */
        return this.price;

    }


    public void setPrice(Long price) {
        /* 129 */
        this.price = price;

    }


    public String getSpecification() {
        /* 133 */
        return this.specification;

    }


    public void setSpecification(String specification) {
        /* 136 */
        this.specification = specification;

    }


    public String getTitle() {
        /* 140 */
        return this.title;

    }


    public void setTitle(String title) {
        /* 143 */
        this.title = title;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMemberDataExtitemCreateModel
 * JD-Core Version:    0.6.0
 */