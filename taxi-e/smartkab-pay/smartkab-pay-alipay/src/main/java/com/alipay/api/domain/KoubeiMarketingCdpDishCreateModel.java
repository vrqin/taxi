package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingCdpDishCreateModel extends AlipayObject {
    private static final long serialVersionUID = 2141531767728781142L;

    @ApiField("desc")
    private String desc;

    @ApiField("dish_name")
    private String dishName;

    @ApiListField("pictures")
    @ApiField("picture")
    private List<Picture> pictures;

    @ApiField("price")
    private String price;

    @ApiListField("tags")
    @ApiField("dish_tag")
    private List<DishTag> tags;

    public String getDesc() {
        /* 52 */
        return this.desc;
    }

    public void setDesc(String desc) {
        /* 55 */
        this.desc = desc;
    }

    public String getDishName() {
        /* 59 */
        return this.dishName;
    }

    public void setDishName(String dishName) {
        /* 62 */
        this.dishName = dishName;
    }

    public List<Picture> getPictures() {
        /* 66 */
        return this.pictures;
    }

    public void setPictures(List<Picture> pictures) {
        /* 69 */
        this.pictures = pictures;
    }

    public String getPrice() {
        /* 73 */
        return this.price;
    }

    public void setPrice(String price) {
        /* 76 */
        this.price = price;
    }

    public List<DishTag> getTags() {
        /* 80 */
        return this.tags;
    }

    public void setTags(List<DishTag> tags) {
        /* 83 */
        this.tags = tags;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpDishCreateModel
 * JD-Core Version:    0.6.0
 */