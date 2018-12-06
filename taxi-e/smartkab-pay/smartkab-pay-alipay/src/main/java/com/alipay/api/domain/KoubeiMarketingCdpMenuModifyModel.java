package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingCdpMenuModifyModel extends AlipayObject {
    private static final long serialVersionUID = 8341187523521593136L;

    @ApiField("cover")
    private Picture cover;

    @ApiListField("dishes")
    @ApiField("string")
    private List<String> dishes;

    @ApiField("menu_id")
    private String menuId;

    @ApiListField("shop_ids")
    @ApiField("string")
    private List<String> shopIds;

    @ApiField("title")
    private String title;

    public Picture getCover() {
        /* 52 */
        return this.cover;
    }

    public void setCover(Picture cover) {
        /* 55 */
        this.cover = cover;
    }

    public List<String> getDishes() {
        /* 59 */
        return this.dishes;
    }

    public void setDishes(List<String> dishes) {
        /* 62 */
        this.dishes = dishes;
    }

    public String getMenuId() {
        /* 66 */
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        /* 69 */
        this.menuId = menuId;
    }

    public List<String> getShopIds() {
        /* 73 */
        return this.shopIds;
    }

    public void setShopIds(List<String> shopIds) {
        /* 76 */
        this.shopIds = shopIds;
    }

    public String getTitle() {
        /* 80 */
        return this.title;
    }

    public void setTitle(String title) {
        /* 83 */
        this.title = title;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpMenuModifyModel
 * JD-Core Version:    0.6.0
 */