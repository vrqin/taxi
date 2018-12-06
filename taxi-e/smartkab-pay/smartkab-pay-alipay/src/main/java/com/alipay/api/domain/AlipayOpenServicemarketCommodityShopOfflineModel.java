package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenServicemarketCommodityShopOfflineModel extends AlipayObject {
    private static final long serialVersionUID = 8472393545939517374L;

    @ApiField("commodity_id")
    private String commodityId;

    @ApiField("shop_id")
    private String shopId;

    public String getCommodityId() {
        /* 29 */
        return this.commodityId;
    }

    public void setCommodityId(String commodityId) {
        /* 32 */
        this.commodityId = commodityId;
    }

    public String getShopId() {
        /* 36 */
        return this.shopId;
    }

    public void setShopId(String shopId) {
        /* 39 */
        this.shopId = shopId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenServicemarketCommodityShopOfflineModel
 * JD-Core Version:    0.6.0
 */