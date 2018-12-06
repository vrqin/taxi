package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarParkingEnterinfoSyncResponse extends AlipayResponse {
    private static final long serialVersionUID = 7337676823592426945L;

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
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarParkingEnterinfoSyncResponse
 * JD-Core Version:    0.6.0
 */