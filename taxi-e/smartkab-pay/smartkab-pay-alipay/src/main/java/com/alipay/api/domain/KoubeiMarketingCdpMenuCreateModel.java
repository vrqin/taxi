package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingCdpMenuCreateModel extends AlipayObject {
    private static final long serialVersionUID = 6196588975137745267L;

    @ApiField("cover")
    private Picture cover;

    @ApiListField("dishes")
    @ApiField("string")
    private List<String> dishes;

    @ApiListField("shop_ids")
    @ApiField("string")
    private List<String> shopIds;

    @ApiField("title")
    private String title;

    public Picture getCover() {
        /* 46 */
        return this.cover;
    }

    public void setCover(Picture cover) {
        /* 49 */
        this.cover = cover;
    }

    public List<String> getDishes() {
        /* 53 */
        return this.dishes;
    }

    public void setDishes(List<String> dishes) {
        /* 56 */
        this.dishes = dishes;
    }

    public List<String> getShopIds() {
        /* 60 */
        return this.shopIds;
    }

    public void setShopIds(List<String> shopIds) {
        /* 63 */
        this.shopIds = shopIds;
    }

    public String getTitle() {
        /* 67 */
        return this.title;
    }

    public void setTitle(String title) {
        /* 70 */
        this.title = title;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpMenuCreateModel
 * JD-Core Version:    0.6.0
 */