package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class MerchantInstConfig extends AlipayObject {
    private static final long serialVersionUID = 6725793876748764136L;

    @ApiField("en_name")
    private String enName;

    @ApiField("order_type")
    private String orderType;

    @ApiField("scene")
    private String scene;

    @ApiField("zh_name")
    private String zhName;

    public String getEnName() {
        /* 41 */
        return this.enName;
    }

    public void setEnName(String enName) {
        /* 44 */
        this.enName = enName;
    }

    public String getOrderType() {
        /* 48 */
        return this.orderType;
    }

    public void setOrderType(String orderType) {
        /* 51 */
        this.orderType = orderType;
    }

    public String getScene() {
        /* 55 */
        return this.scene;
    }

    public void setScene(String scene) {
        /* 58 */
        this.scene = scene;
    }

    public String getZhName() {
        /* 62 */
        return this.zhName;
    }

    public void setZhName(String zhName) {
        /* 65 */
        this.zhName = zhName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.MerchantInstConfig
 * JD-Core Version:    0.6.0
 */