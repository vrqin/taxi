package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class EquipmentAuthRemoveQueryBypageDTO extends AlipayObject {
    private static final long serialVersionUID = 2219571398197889284L;

    @ApiField("device_id")
    private String deviceId;

    @ApiField("unbind_time")
    private String unbindTime;

    public String getDeviceId() {
        /* 29 */
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        /* 32 */
        this.deviceId = deviceId;
    }

    public String getUnbindTime() {
        /* 36 */
        return this.unbindTime;
    }

    public void setUnbindTime(String unbindTime) {
        /* 39 */
        this.unbindTime = unbindTime;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.EquipmentAuthRemoveQueryBypageDTO
 * JD-Core Version:    0.6.0
 */