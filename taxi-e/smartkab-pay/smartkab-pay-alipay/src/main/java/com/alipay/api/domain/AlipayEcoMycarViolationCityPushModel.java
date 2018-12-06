package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarViolationCityPushModel extends AlipayObject {
    private static final long serialVersionUID = 1564765652958797631L;

    @ApiField("city_code")
    private String cityCode;

    @ApiField("push_type")
    private String pushType;

    @ApiField("service_status")
    private String serviceStatus;

    public String getCityCode() {
        /* 35 */
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        /* 38 */
        this.cityCode = cityCode;
    }

    public String getPushType() {
        /* 42 */
        return this.pushType;
    }

    public void setPushType(String pushType) {
        /* 45 */
        this.pushType = pushType;
    }

    public String getServiceStatus() {
        /* 49 */
        return this.serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        /* 52 */
        this.serviceStatus = serviceStatus;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarViolationCityPushModel
 * JD-Core Version:    0.6.0
 */