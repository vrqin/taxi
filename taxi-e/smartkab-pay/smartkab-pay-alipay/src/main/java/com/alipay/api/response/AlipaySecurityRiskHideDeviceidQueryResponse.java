package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySecurityRiskHideDeviceidQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1579531893768924478L;

    @ApiField("deviceid")
    private String deviceid;

    public String getDeviceid() {
        /* 27 */
        return this.deviceid;
    }

    public void setDeviceid(String deviceid) {
        /* 24 */
        this.deviceid = deviceid;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySecurityRiskHideDeviceidQueryResponse
 * JD-Core Version:    0.6.0
 */