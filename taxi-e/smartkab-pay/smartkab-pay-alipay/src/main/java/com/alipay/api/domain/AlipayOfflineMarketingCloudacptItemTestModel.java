package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketingCloudacptItemTestModel extends AlipayObject {
    private static final long serialVersionUID = 4836951818184756736L;

    @ApiField("activity_id")
    private String activityId;

    @ApiField("batch_id")
    private String batchId;

    @ApiField("pid")
    private String pid;

    @ApiField("uid")
    private String uid;

    public String getActivityId() {
        /* 41 */
        return this.activityId;
    }

    public void setActivityId(String activityId) {
        /* 44 */
        this.activityId = activityId;
    }

    public String getBatchId() {
        /* 48 */
        return this.batchId;
    }

    public void setBatchId(String batchId) {
        /* 51 */
        this.batchId = batchId;
    }

    public String getPid() {
        /* 55 */
        return this.pid;
    }

    public void setPid(String pid) {
        /* 58 */
        this.pid = pid;
    }

    public String getUid() {
        /* 62 */
        return this.uid;
    }

    public void setUid(String uid) {
        /* 65 */
        this.uid = uid;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketingCloudacptItemTestModel
 * JD-Core Version:    0.6.0
 */