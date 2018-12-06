package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketShopQuerydetailModel extends AlipayObject {
    private static final long serialVersionUID = 6469565661721253181L;

    @ApiField("op_role")
    private String opRole;

    @ApiField("shop_id")
    private String shopId;

    public String getOpRole() {
        /* 29 */
        return this.opRole;
    }

    public void setOpRole(String opRole) {
        /* 32 */
        this.opRole = opRole;
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
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketShopQuerydetailModel
 * JD-Core Version:    0.6.0
 */