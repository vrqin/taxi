package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class PaymentAbilityQueryResponse extends AlipayObject {
    private static final long serialVersionUID = 5522197693676119817L;

    @ApiField("extra_infos")
    private String extraInfos;

    @ApiField("level")
    private String level;

    @ApiField("order_id")
    private String orderId;

    public String getExtraInfos() {
        /* 35 */
        return this.extraInfos;
    }

    public void setExtraInfos(String extraInfos) {
        /* 38 */
        this.extraInfos = extraInfos;
    }

    public String getLevel() {
        /* 42 */
        return this.level;
    }

    public void setLevel(String level) {
        /* 45 */
        this.level = level;
    }

    public String getOrderId() {
        /* 49 */
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        /* 52 */
        this.orderId = orderId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PaymentAbilityQueryResponse
 * JD-Core Version:    0.6.0
 */