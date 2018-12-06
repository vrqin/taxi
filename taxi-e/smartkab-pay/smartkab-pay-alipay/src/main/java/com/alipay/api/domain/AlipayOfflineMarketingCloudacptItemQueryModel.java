package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketingCloudacptItemQueryModel extends AlipayObject {
    private static final long serialVersionUID = 3423899133983934394L;

    @ApiField("activity_id")
    private String activityId;

    @ApiField("pid")
    private String pid;

    @ApiField("uid")
    private String uid;

    public String getActivityId() {
        /* 35 */
        return this.activityId;
    }

    public void setActivityId(String activityId) {
        /* 38 */
        this.activityId = activityId;
    }

    public String getPid() {
        /* 42 */
        return this.pid;
    }

    public void setPid(String pid) {
        /* 45 */
        this.pid = pid;
    }

    public String getUid() {
        /* 49 */
        return this.uid;
    }

    public void setUid(String uid) {
        /* 52 */
        this.uid = uid;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketingCloudacptItemQueryModel
 * JD-Core Version:    0.6.0
 */