package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarParkingExitinfoSyncResponse extends AlipayResponse {
    private static final long serialVersionUID = 8376932466359676616L;

    @ApiField("status")
    private String status;

    public String getStatus() {
        /* 27 */
        return this.status;
    }

    public void setStatus(String status) {
        /* 24 */
        this.status = status;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarParkingExitinfoSyncResponse
 * JD-Core Version:    0.6.0
 */