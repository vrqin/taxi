package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenAppCommodityOrderItemQueryModel extends AlipayObject {
    private static final long serialVersionUID = 7866434523857465698L;

    @ApiField("commodity_order_id")
    private String commodityOrderId;

    @ApiField("start_page")
    private String startPage;

    public String getCommodityOrderId() {
        /* 29 */
        return this.commodityOrderId;
    }

    public void setCommodityOrderId(String commodityOrderId) {
        /* 32 */
        this.commodityOrderId = commodityOrderId;
    }

    public String getStartPage() {
        /* 36 */
        return this.startPage;
    }

    public void setStartPage(String startPage) {
        /* 39 */
        this.startPage = startPage;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenAppCommodityOrderItemQueryModel
 * JD-Core Version:    0.6.0
 */