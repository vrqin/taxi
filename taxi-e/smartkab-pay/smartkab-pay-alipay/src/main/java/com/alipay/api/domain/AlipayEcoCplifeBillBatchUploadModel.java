package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayEcoCplifeBillBatchUploadModel extends AlipayObject {
    private static final long serialVersionUID = 5763921663799321565L;

    @ApiField("batch_id")
    private String batchId;

    @ApiListField("bill_set")
    @ApiField("c_p_bill_set")
    private List<CPBillSet> billSet;

    @ApiField("community_id")
    private String communityId;

    public String getBatchId() {
        /* 40 */
        return this.batchId;
    }

    public void setBatchId(String batchId) {
        /* 43 */
        this.batchId = batchId;
    }

    public List<CPBillSet> getBillSet() {
        /* 47 */
        return this.billSet;
    }

    public void setBillSet(List<CPBillSet> billSet) {
        /* 50 */
        this.billSet = billSet;
    }

    public String getCommunityId() {
        /* 54 */
        return this.communityId;
    }

    public void setCommunityId(String communityId) {
        /* 57 */
        this.communityId = communityId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoCplifeBillBatchUploadModel
 * JD-Core Version:    0.6.0
 */