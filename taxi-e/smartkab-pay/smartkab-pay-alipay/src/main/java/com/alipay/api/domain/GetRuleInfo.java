package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class GetRuleInfo extends AlipayObject {
    private static final long serialVersionUID = 7173893159192472962L;

    @ApiField("end_time")
    private Date endTime;

    @ApiField("get_count_limit")
    private PeriodInfo getCountLimit;

    @ApiField("start_time")
    private Date startTime;

    public Date getEndTime() {
        /* 37 */
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        /* 40 */
        this.endTime = endTime;
    }

    public PeriodInfo getGetCountLimit() {
        /* 44 */
        return this.getCountLimit;
    }

    public void setGetCountLimit(PeriodInfo getCountLimit) {
        /* 47 */
        this.getCountLimit = getCountLimit;
    }

    public Date getStartTime() {
        /* 51 */
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        /* 54 */
        this.startTime = startTime;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.GetRuleInfo
 * JD-Core Version:    0.6.0
 */