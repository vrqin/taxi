package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingCdpShopenvCreateModel extends AlipayObject {
    private static final long serialVersionUID = 2537696541986775774L;

    @ApiField("name")
    private String name;

    @ApiListField("pictures")
    @ApiField("content_picture")
    private List<ContentPicture> pictures;

    @ApiListField("shop_ids")
    @ApiField("string")
    private List<String> shopIds;

    public String getName() {
        /* 40 */
        return this.name;
    }

    public void setName(String name) {
        /* 43 */
        this.name = name;
    }

    public List<ContentPicture> getPictures() {
        /* 47 */
        return this.pictures;
    }

    public void setPictures(List<ContentPicture> pictures) {
        /* 50 */
        this.pictures = pictures;
    }

    public List<String> getShopIds() {
        /* 54 */
        return this.shopIds;
    }

    public void setShopIds(List<String> shopIds) {
        /* 57 */
        this.shopIds = shopIds;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpShopenvCreateModel
 * JD-Core Version:    0.6.0
 */