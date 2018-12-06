package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignCrowdCreateModel extends AlipayObject {
    private static final long serialVersionUID = 6572289293735655828L;

    @ApiField("conditions")
    private String conditions;

    @ApiField("name")
    private String name;

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

    public String getName() {
        /* 57 */
        return this.name;
    }

    public void setName(String name) {
        /* 60 */
        this.name = name;
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
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCampaignCrowdCreateModel
 * JD-Core Version:    0.6.0
 */