package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.OpenActivity;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiQualityTestCloudacptActivityQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1731529831365592327L;

    @ApiListField("activity_list")
    @ApiField("open_activity")
    private List<OpenActivity> activityList;

    public List<OpenActivity> getActivityList() {
        /* 31 */
        return this.activityList;
    }

    public void setActivityList(List<OpenActivity> activityList) {
        /* 28 */
        this.activityList = activityList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiQualityTestCloudacptActivityQueryResponse
 * JD-Core Version:    0.6.0
 */