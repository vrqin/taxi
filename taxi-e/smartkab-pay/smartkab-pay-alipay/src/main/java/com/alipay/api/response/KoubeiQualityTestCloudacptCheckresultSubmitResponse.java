package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiQualityTestCloudacptCheckresultSubmitResponse extends AlipayResponse {
    private static final long serialVersionUID = 1196842777654724147L;

    @ApiField("activity_id")
    private String activityId;

    @ApiField("batch_id")
    private String batchId;

    public String getActivityId() {
        /* 33 */
        return this.activityId;
    }

    public void setActivityId(String activityId) {
        /* 30 */
        this.activityId = activityId;
    }

    public String getBatchId() {
        /* 40 */
        return this.batchId;
    }

    public void setBatchId(String batchId) {
        /* 37 */
        this.batchId = batchId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiQualityTestCloudacptCheckresultSubmitResponse
 * JD-Core Version:    0.6.0
 */