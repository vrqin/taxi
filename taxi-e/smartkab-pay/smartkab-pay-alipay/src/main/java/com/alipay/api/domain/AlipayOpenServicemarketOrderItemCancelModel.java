package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenServicemarketOrderItemCancelModel extends AlipayObject {
    private static final long serialVersionUID = 8353831144572212175L;

    @ApiField("cancel_reason")
    private String cancelReason;

    @ApiField("commodity_order_id")
    private String commodityOrderId;

    @ApiField("shop_id")
    private String shopId;

    public String getCancelReason() {
        /* 35 */
        return this.cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        /* 38 */
        this.cancelReason = cancelReason;
    }

    public String getCommodityOrderId() {
        /* 42 */
        return this.commodityOrderId;
    }

    public void setCommodityOrderId(String commodityOrderId) {
        /* 45 */
        this.commodityOrderId = commodityOrderId;
    }

    public String getShopId() {
        /* 49 */
        return this.shopId;
    }

    public void setShopId(String shopId) {
        /* 52 */
        this.shopId = shopId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenServicemarketOrderItemCancelModel
 * JD-Core Version:    0.6.0
 */