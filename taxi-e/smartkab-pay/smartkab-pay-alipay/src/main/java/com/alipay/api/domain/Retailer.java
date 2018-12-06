package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class Retailer extends AlipayObject {
    private static final long serialVersionUID = 2686332793829316957L;

    @ApiField("name")
    private String name;

    @ApiField("partner_id")
    private String partnerId;

    public String getName() {
        /* 29 */
        return this.name;
    }

    public void setName(String name) {
        /* 32 */
        this.name = name;
    }

    public String getPartnerId() {
        /* 36 */
        return this.partnerId;
    }

    public void setPartnerId(String partnerId) {
        /* 39 */
        this.partnerId = partnerId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Retailer
 * JD-Core Version:    0.6.0
 */