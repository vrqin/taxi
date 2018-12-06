package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenServicemarketOrderAcceptModel extends AlipayObject {
    private static final long serialVersionUID = 6389955391176898391L;

    @ApiField("commodity_order_id")
    private String commodityOrderId;

    public String getCommodityOrderId() {
        /* 23 */
        return this.commodityOrderId;
    }

    public void setCommodityOrderId(String commodityOrderId) {
        /* 26 */
        this.commodityOrderId = commodityOrderId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenServicemarketOrderAcceptModel
 * JD-Core Version:    0.6.0
 */