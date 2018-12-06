package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarDataserviceViolationOwnershareModel extends AlipayObject {
    private static final long serialVersionUID = 6589585188655371411L;

    @ApiField("app_id")
    private String appId;

    @ApiField("vehicle_id")
    private String vehicleId;

    public String getAppId() {
        /* 29 */
        return this.appId;
    }

    public void setAppId(String appId) {
        /* 32 */
        this.appId = appId;
    }

    public String getVehicleId() {
        /* 36 */
        return this.vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        /* 39 */
        this.vehicleId = vehicleId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarDataserviceViolationOwnershareModel
 * JD-Core Version:    0.6.0
 */