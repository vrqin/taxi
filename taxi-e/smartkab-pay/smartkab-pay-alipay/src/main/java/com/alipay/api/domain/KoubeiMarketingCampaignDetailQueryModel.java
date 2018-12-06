package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignDetailQueryModel extends AlipayObject {
    private static final long serialVersionUID = 3619436328273643961L;

    @ApiField("camp_id")
    private String campId;

    @ApiField("operator_id")
    private String operatorId;

    @ApiField("operator_type")
    private String operatorType;

    public String getCampId() {
        /* 35 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 38 */
        this.campId = campId;
    }

    public String getOperatorId() {
        /* 42 */
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        /* 45 */
        this.operatorId = operatorId;
    }

    public String getOperatorType() {
        /* 49 */
        return this.operatorType;
    }

    public void setOperatorType(String operatorType) {
        /* 52 */
        this.operatorType = operatorType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCampaignDetailQueryModel
 * JD-Core Version:    0.6.0
 */