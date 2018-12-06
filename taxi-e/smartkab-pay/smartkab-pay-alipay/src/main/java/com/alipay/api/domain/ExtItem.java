package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class ExtItem extends AlipayObject {
    private static final long serialVersionUID = 1753675398335837682L;


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


    @ApiField("id")
    private Long id;


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
        /*  83 */
        return this.brandCode;

    }


    public void setBrandCode(String brandCode) {
        /*  86 */
        this.brandCode = brandCode;

    }


    public String getCategoryCode() {
        /*  90 */
        return this.categoryCode;

    }


    public void setCategoryCode(String categoryCode) {
        /*  93 */
        this.categoryCode = categoryCode;

    }


    public Long getCount() {
        /*  97 */
        return this.count;

    }


    public void setCount(Long count) {
        /* 100 */
        this.count = count;

    }


    public String getCountry() {
        /* 104 */
        return this.country;

    }


    public void setCountry(String country) {
        /* 107 */
        this.country = country;

    }


    public String getDescription() {
        /* 111 */
        return this.description;

    }


    public void setDescription(String description) {
        /* 114 */
        this.description = description;

    }


    public Long getId() {
        /* 118 */
        return this.id;

    }


    public void setId(Long id) {
        /* 121 */
        this.id = id;

    }


    public String getItemCode() {
        /* 125 */
        return this.itemCode;

    }


    public void setItemCode(String itemCode) {
        /* 128 */
        this.itemCode = itemCode;

    }


    public String getPicture() {
        /* 132 */
        return this.picture;

    }


    public void setPicture(String picture) {
        /* 135 */
        this.picture = picture;

    }


    public Long getPrice() {
        /* 139 */
        return this.price;

    }


    public void setPrice(Long price) {
        /* 142 */
        this.price = price;

    }


    public String getSpecification() {
        /* 146 */
        return this.specification;

    }


    public void setSpecification(String specification) {
        /* 149 */
        this.specification = specification;

    }


    public String getTitle() {
        /* 153 */
        return this.title;

    }


    public void setTitle(String title) {
        /* 156 */
        this.title = title;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ExtItem
 * JD-Core Version:    0.6.0
 */