package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenServicemarketOrderRejectModel extends AlipayObject {
    private static final long serialVersionUID = 4292743339199349827L;

    @ApiField("commodity_order_id")
    private String commodityOrderId;

    @ApiField("reject_reason")
    private String rejectReason;

    public String getCommodityOrderId() {
        /* 29 */
        return this.commodityOrderId;
    }

    public void setCommodityOrderId(String commodityOrderId) {
        /* 32 */
        this.commodityOrderId = commodityOrderId;
    }

    public String getRejectReason() {
        /* 36 */
        return this.rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        /* 39 */
        this.rejectReason = rejectReason;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenServicemarketOrderRejectModel
 * JD-Core Version:    0.6.0
 */