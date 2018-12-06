package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOfflineMarketingCloudacptCheckresultSubmitModel extends AlipayObject {
    private static final long serialVersionUID = 5524397351418555534L;


    @ApiField("activity_id")
    private String activityId;


    @ApiField("auth_code")
    private String authCode;


    @ApiField("batch_id")
    private String batchId;


    @ApiField("end_time")
    private String endTime;


    @ApiField("pid")
    private String pid;


    @ApiField("start_time")
    private String startTime;


    @ApiField("uid")
    private String uid;


    public String getActivityId() {
        /*  59 */
        return this.activityId;

    }


    public void setActivityId(String activityId) {
        /*  62 */
        this.activityId = activityId;

    }


    public String getAuthCode() {
        /*  66 */
        return this.authCode;

    }


    public void setAuthCode(String authCode) {
        /*  69 */
        this.authCode = authCode;

    }


    public String getBatchId() {
        /*  73 */
        return this.batchId;

    }


    public void setBatchId(String batchId) {
        /*  76 */
        this.batchId = batchId;

    }


    public String getEndTime() {
        /*  80 */
        return this.endTime;

    }


    public void setEndTime(String endTime) {
        /*  83 */
        this.endTime = endTime;

    }


    public String getPid() {
        /*  87 */
        return this.pid;

    }


    public void setPid(String pid) {
        /*  90 */
        this.pid = pid;

    }


    public String getStartTime() {
        /*  94 */
        return this.startTime;

    }


    public void setStartTime(String startTime) {
        /*  97 */
        this.startTime = startTime;

    }


    public String getUid() {
        /* 101 */
        return this.uid;

    }


    public void setUid(String uid) {
        /* 104 */
        this.uid = uid;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketingCloudacptCheckresultSubmitModel
 * JD-Core Version:    0.6.0
 */