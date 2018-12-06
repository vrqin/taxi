package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceCityfacilitatorScardcenterFunctionQueryModel extends AlipayObject {
    private static final long serialVersionUID = 8358264618572251538L;

    @ApiField("city_code")
    private String cityCode;

    @ApiField("device_code")
    private String deviceCode;

    public String getCityCode() {
        /* 29 */
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        /* 32 */
        this.cityCode = cityCode;
    }

    public String getDeviceCode() {
        /* 36 */
        return this.deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        /* 39 */
        this.deviceCode = deviceCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceCityfacilitatorScardcenterFunctionQueryModel
 * JD-Core Version:    0.6.0
 */