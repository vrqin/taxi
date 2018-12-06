package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.MaintainVehicleInfo;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarDataserviceMaintainvehicleShareResponse extends AlipayResponse {
    private static final long serialVersionUID = 1834599658837362433L;

    @ApiField("info")
    private MaintainVehicleInfo info;

    public MaintainVehicleInfo getInfo() {
        /* 28 */
        return this.info;
    }

    public void setInfo(MaintainVehicleInfo info) {
        /* 25 */
        this.info = info;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarDataserviceMaintainvehicleShareResponse
 * JD-Core Version:    0.6.0
 */