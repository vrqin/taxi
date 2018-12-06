package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketingVoucherCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 4174912239344913528L;

    @ApiField("activity_id")
    private String activityId;

    @ApiField("voucher_id")
    private String voucherId;

    public String getActivityId() {
        /* 33 */
        return this.activityId;
    }

    public void setActivityId(String activityId) {
        /* 30 */
        this.activityId = activityId;
    }

    public String getVoucherId() {
        /* 40 */
        return this.voucherId;
    }

    public void setVoucherId(String voucherId) {
        /* 37 */
        this.voucherId = voucherId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketingVoucherCreateResponse
 * JD-Core Version:    0.6.0
 */