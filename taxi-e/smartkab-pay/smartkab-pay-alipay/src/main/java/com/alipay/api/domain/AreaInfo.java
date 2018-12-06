package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AreaInfo extends AlipayObject {
    private static final long serialVersionUID = 6741375355118257583L;

    @ApiField("city")
    private String city;

    @ApiField("province")
    private String province;

    public String getCity() {
        /* 29 */
        return this.city;
    }

    public void setCity(String city) {
        /* 32 */
        this.city = city;
    }

    public String getProvince() {
        /* 36 */
        return this.province;
    }

    public void setProvince(String province) {
        /* 39 */
        this.province = province;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AreaInfo
 * JD-Core Version:    0.6.0
 */