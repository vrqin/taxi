package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenServicemarketCommodityAuditConfirmModel extends AlipayObject {
    private static final long serialVersionUID = 3611517117387968411L;

    @ApiField("commodity_id")
    private String commodityId;

    @ApiField("user_id")
    private String userId;

    public String getCommodityId() {
        /* 29 */
        return this.commodityId;
    }

    public void setCommodityId(String commodityId) {
        /* 32 */
        this.commodityId = commodityId;
    }

    public String getUserId() {
        /* 36 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 39 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenServicemarketCommodityAuditConfirmModel
 * JD-Core Version:    0.6.0
 */