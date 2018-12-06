package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketShopdiscountQueryModel extends AlipayObject {
    private static final long serialVersionUID = 1757337333198754435L;

    @ApiField("shop_id")
    private String shopId;

    public String getShopId() {
        /* 23 */
        return this.shopId;
    }

    public void setShopId(String shopId) {
        /* 26 */
        this.shopId = shopId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketShopdiscountQueryModel
 * JD-Core Version:    0.6.0
 */