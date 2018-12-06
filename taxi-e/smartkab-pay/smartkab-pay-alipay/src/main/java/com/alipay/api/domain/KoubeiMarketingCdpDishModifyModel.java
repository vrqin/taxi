package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingCdpDishModifyModel extends AlipayObject {
    private static final long serialVersionUID = 3738218553134847225L;

    @ApiField("desc")
    private String desc;

    @ApiField("dish_id")
    private String dishId;

    @ApiField("dish_name")
    private String dishName;

    @ApiField("price")
    private String price;

    @ApiListField("tags")
    @ApiField("dish_tag")
    private List<DishTag> tags;

    public String getDesc() {
        /* 51 */
        return this.desc;
    }

    public void setDesc(String desc) {
        /* 54 */
        this.desc = desc;
    }

    public String getDishId() {
        /* 58 */
        return this.dishId;
    }

    public void setDishId(String dishId) {
        /* 61 */
        this.dishId = dishId;
    }

    public String getDishName() {
        /* 65 */
        return this.dishName;
    }

    public void setDishName(String dishName) {
        /* 68 */
        this.dishName = dishName;
    }

    public String getPrice() {
        /* 72 */
        return this.price;
    }

    public void setPrice(String price) {
        /* 75 */
        this.price = price;
    }

    public List<DishTag> getTags() {
        /* 79 */
        return this.tags;
    }

    public void setTags(List<DishTag> tags) {
        /* 82 */
        this.tags = tags;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpDishModifyModel
 * JD-Core Version:    0.6.0
 */