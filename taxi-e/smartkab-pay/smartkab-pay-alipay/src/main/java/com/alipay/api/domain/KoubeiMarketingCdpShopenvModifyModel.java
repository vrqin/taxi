package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingCdpShopenvModifyModel extends AlipayObject {
    private static final long serialVersionUID = 4322159593977287794L;

    @ApiField("name")
    private String name;

    @ApiListField("shop_ids")
    @ApiField("string")
    private List<String> shopIds;

    @ApiField("shop_pic_id")
    private String shopPicId;

    public String getName() {
        /* 39 */
        return this.name;
    }

    public void setName(String name) {
        /* 42 */
        this.name = name;
    }

    public List<String> getShopIds() {
        /* 46 */
        return this.shopIds;
    }

    public void setShopIds(List<String> shopIds) {
        /* 49 */
        this.shopIds = shopIds;
    }

    public String getShopPicId() {
        /* 53 */
        return this.shopPicId;
    }

    public void setShopPicId(String shopPicId) {
        /* 56 */
        this.shopPicId = shopPicId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpShopenvModifyModel
 * JD-Core Version:    0.6.0
 */