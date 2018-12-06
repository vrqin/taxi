package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class RecruitInfo extends AlipayObject {
    private static final long serialVersionUID = 6273275146319468933L;

    @ApiField("end_time")
    private Date endTime;

    @ApiField("plan_id")
    private String planId;

    @ApiField("start_time")
    private Date startTime;

    @ApiField("status")
    private String status;

    public Date getEndTime() {
        /* 43 */
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        /* 46 */
        this.endTime = endTime;
    }

    public String getPlanId() {
        /* 50 */
        return this.planId;
    }

    public void setPlanId(String planId) {
        /* 53 */
        this.planId = planId;
    }

    public Date getStartTime() {
        /* 57 */
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        /* 60 */
        this.startTime = startTime;
    }

    public String getStatus() {
        /* 64 */
        return this.status;
    }

    public void setStatus(String status) {
        /* 67 */
        this.status = status;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.RecruitInfo
 * JD-Core Version:    0.6.0
 */