package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.OpenBatch;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiQualityTestCloudacptBatchQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1121484199823759554L;

    @ApiField("activity_id")
    private String activityId;

    @ApiListField("batch_list")
    @ApiField("open_batch")
    private List<OpenBatch> batchList;

    @ApiField("batch_num")
    private String batchNum;

    public String getActivityId() {
        /* 43 */
        return this.activityId;
    }

    public void setActivityId(String activityId) {
        /* 40 */
        this.activityId = activityId;
    }

    public List<OpenBatch> getBatchList() {
        /* 50 */
        return this.batchList;
    }

    public void setBatchList(List<OpenBatch> batchList) {
        /* 47 */
        this.batchList = batchList;
    }

    public String getBatchNum() {
        /* 57 */
        return this.batchNum;
    }

    public void setBatchNum(String batchNum) {
        /* 54 */
        this.batchNum = batchNum;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiQualityTestCloudacptBatchQueryResponse
 * JD-Core Version:    0.6.0
 */