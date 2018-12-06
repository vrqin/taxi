package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignCrowdModifyModel extends AlipayObject {
    private static final long serialVersionUID = 5566835185427646627L;

    @ApiField("conditions")
    private String conditions;

    @ApiField("crowd_group_id")
    private String crowdGroupId;

    @ApiField("operator_id")
    private String operatorId;

    @ApiField("operator_type")
    private String operatorType;

    @ApiField("out_biz_no")
    private String outBizNo;

    public String getConditions() {
        /* 50 */
        return this.conditions;
    }

    public void setConditions(String conditions) {
        /* 53 */
        this.conditions = conditions;
    }

    public String getCrowdGroupId() {
        /* 57 */
        return this.crowdGroupId;
    }

    public void setCrowdGroupId(String crowdGroupId) {
        /* 60 */
        this.crowdGroupId = crowdGroupId;
    }

    public String getOperatorId() {
        /* 64 */
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        /* 67 */
        this.operatorId = operatorId;
    }

    public String getOperatorType() {
        /* 71 */
        return this.operatorType;
    }

    public void setOperatorType(String operatorType) {
        /* 74 */
        this.operatorType = operatorType;
    }

    public String getOutBizNo() {
        /* 78 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 81 */
        this.outBizNo = outBizNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCampaignCrowdModifyModel
 * JD-Core Version:    0.6.0
 */