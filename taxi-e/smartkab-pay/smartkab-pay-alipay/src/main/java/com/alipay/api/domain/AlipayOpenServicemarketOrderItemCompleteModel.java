package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenServicemarketOrderItemCompleteModel extends AlipayObject {
    private static final long serialVersionUID = 6125932447437379111L;

    @ApiField("commodity_order_id")
    private String commodityOrderId;

    @ApiField("shop_id")
    private String shopId;

    public String getCommodityOrderId() {
        /* 29 */
        return this.commodityOrderId;
    }

    public void setCommodityOrderId(String commodityOrderId) {
        /* 32 */
        this.commodityOrderId = commodityOrderId;
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
 * Qualified Name:     com.alipay.api.domain.AlipayOpenServicemarketOrderItemCompleteModel
 * JD-Core Version:    0.6.0
 */