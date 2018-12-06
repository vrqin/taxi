package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class OpenActivity extends AlipayObject {
    private static final long serialVersionUID = 2624334226378123424L;

    @ApiField("activity_end_date")
    private String activityEndDate;

    @ApiField("activity_id")
    private String activityId;

    @ApiField("activity_name")
    private String activityName;

    @ApiField("activity_start_date")
    private String activityStartDate;

    @ApiField("activity_status")
    private String activityStatus;

    @ApiField("store_id")
    private String storeId;

    public String getActivityEndDate() {
        /* 56 */
        return this.activityEndDate;
    }

    public void setActivityEndDate(String activityEndDate) {
        /* 59 */
        this.activityEndDate = activityEndDate;
    }

    public String getActivityId() {
        /* 63 */
        return this.activityId;
    }

    public void setActivityId(String activityId) {
        /* 66 */
        this.activityId = activityId;
    }

    public String getActivityName() {
        /* 70 */
        return this.activityName;
    }

    public void setActivityName(String activityName) {
        /* 73 */
        this.activityName = activityName;
    }

    public String getActivityStartDate() {
        /* 77 */
        return this.activityStartDate;
    }

    public void setActivityStartDate(String activityStartDate) {
        /* 80 */
        this.activityStartDate = activityStartDate;
    }

    public String getActivityStatus() {
        /* 84 */
        return this.activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        /* 87 */
        this.activityStatus = activityStatus;
    }

    public String getStoreId() {
        /* 91 */
        return this.storeId;
    }

    public void setStoreId(String storeId) {
        /* 94 */
        this.storeId = storeId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OpenActivity
 * JD-Core Version:    0.6.0
 */