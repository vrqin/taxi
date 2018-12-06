package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class ValidDateInfo extends AlipayObject {
    private static final long serialVersionUID = 3882531698253913392L;

    @ApiField("end_time")
    private Date endTime;

    @ApiField("relative_time")
    private PeriodInfo relativeTime;

    @ApiField("start_time")
    private Date startTime;

    @ApiField("time_mode")
    private String timeMode;

    public Date getEndTime() {
        /* 43 */
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        /* 46 */
        this.endTime = endTime;
    }

    public PeriodInfo getRelativeTime() {
        /* 50 */
        return this.relativeTime;
    }

    public void setRelativeTime(PeriodInfo relativeTime) {
        /* 53 */
        this.relativeTime = relativeTime;
    }

    public Date getStartTime() {
        /* 57 */
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        /* 60 */
        this.startTime = startTime;
    }

    public String getTimeMode() {
        /* 64 */
        return this.timeMode;
    }

    public void setTimeMode(String timeMode) {
        /* 67 */
        this.timeMode = timeMode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ValidDateInfo
 * JD-Core Version:    0.6.0
 */