package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class OuterShopDO extends AlipayObject {
    private static final long serialVersionUID = 1694743568133288796L;

    @ApiField("outer_id")
    private String outerId;

    @ApiField("shop_id")
    private String shopId;

    @ApiField("type")
    private String type;

    public String getOuterId() {
        /* 36 */
        return this.outerId;
    }

    public void setOuterId(String outerId) {
        /* 39 */
        this.outerId = outerId;
    }

    public String getShopId() {
        /* 43 */
        return this.shopId;
    }

    public void setShopId(String shopId) {
        /* 46 */
        this.shopId = shopId;
    }

    public String getType() {
        /* 50 */
        return this.type;
    }

    public void setType(String type) {
        /* 53 */
        this.type = type;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OuterShopDO
 * JD-Core Version:    0.6.0
 */