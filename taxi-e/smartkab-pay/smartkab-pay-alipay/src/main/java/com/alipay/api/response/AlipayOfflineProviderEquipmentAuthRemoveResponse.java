package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineProviderEquipmentAuthRemoveResponse extends AlipayResponse {
    private static final long serialVersionUID = 2174411524271646924L;

    @ApiField("device_id")
    private String deviceId;

    @ApiField("merchant_pid")
    private String merchantPid;

    public String getDeviceId() {
        /* 33 */
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        /* 30 */
        this.deviceId = deviceId;
    }

    public String getMerchantPid() {
        /* 40 */
        return this.merchantPid;
    }

    public void setMerchantPid(String merchantPid) {
        /* 37 */
        this.merchantPid = merchantPid;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineProviderEquipmentAuthRemoveResponse
 * JD-Core Version:    0.6.0
 */