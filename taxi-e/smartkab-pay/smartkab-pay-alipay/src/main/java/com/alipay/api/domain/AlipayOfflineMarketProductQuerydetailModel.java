package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketProductQuerydetailModel extends AlipayObject {
    private static final long serialVersionUID = 6396879495349141793L;

    @ApiField("item_id")
    private String itemId;

    @ApiField("op_role")
    private String opRole;

    @ApiField("shop_id")
    private String shopId;

    public String getItemId() {
        /* 35 */
        return this.itemId;
    }

    public void setItemId(String itemId) {
        /* 38 */
        this.itemId = itemId;
    }

    public String getOpRole() {
        /* 42 */
        return this.opRole;
    }

    public void setOpRole(String opRole) {
        /* 45 */
        this.opRole = opRole;
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
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketProductQuerydetailModel
 * JD-Core Version:    0.6.0
 */