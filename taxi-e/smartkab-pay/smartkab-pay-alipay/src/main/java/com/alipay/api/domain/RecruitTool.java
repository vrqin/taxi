package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;

public class RecruitTool extends AlipayObject {
    private static final long serialVersionUID = 6143782714279454967L;

    @ApiField("end_time")
    private Date endTime;

    @ApiListField("pid_shops")
    @ApiField("pid_shop_info")
    private List<PidShopInfo> pidShops;

    @ApiField("start_time")
    private Date startTime;

    public Date getEndTime() {
        /* 40 */
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        /* 43 */
        this.endTime = endTime;
    }

    public List<PidShopInfo> getPidShops() {
        /* 47 */
        return this.pidShops;
    }

    public void setPidShops(List<PidShopInfo> pidShops) {
        /* 50 */
        this.pidShops = pidShops;
    }

    public Date getStartTime() {
        /* 54 */
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        /* 57 */
        this.startTime = startTime;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.RecruitTool
 * JD-Core Version:    0.6.0
 */