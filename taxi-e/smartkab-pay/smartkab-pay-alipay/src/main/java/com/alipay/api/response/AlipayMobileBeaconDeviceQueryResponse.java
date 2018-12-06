package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.BeaconDeviceInfo;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobileBeaconDeviceQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6256684922584913957L;

    @ApiField("beacon_device_info")
    private BeaconDeviceInfo beaconDeviceInfo;

    @ApiField("code")
    private String code;

    @ApiField("msg")
    private String msg;

    public BeaconDeviceInfo getBeaconDeviceInfo() {
        /* 40 */
        return this.beaconDeviceInfo;
    }

    public void setBeaconDeviceInfo(BeaconDeviceInfo beaconDeviceInfo) {
        /* 37 */
        this.beaconDeviceInfo = beaconDeviceInfo;
    }

    public String getCode() {
        /* 47 */
        return this.code;
    }

    public void setCode(String code) {
        /* 44 */
        this.code = code;
    }

    public String getMsg() {
        /* 54 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 51 */
        this.msg = msg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobileBeaconDeviceQueryResponse
 * JD-Core Version:    0.6.0
 */