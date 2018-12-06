package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignCrowdCountModel extends AlipayObject {
    private static final long serialVersionUID = 7421972279957653691L;

    @ApiField("conditions")
    private String conditions;

    @ApiField("crowd_group_id")
    private String crowdGroupId;

    @ApiField("dimensions")
    private String dimensions;

    public String getConditions() {
        /* 39 */
        return this.conditions;
    }

    public void setConditions(String conditions) {
        /* 42 */
        this.conditions = conditions;
    }

    public String getCrowdGroupId() {
        /* 46 */
        return this.crowdGroupId;
    }

    public void setCrowdGroupId(String crowdGroupId) {
        /* 49 */
        this.crowdGroupId = crowdGroupId;
    }

    public String getDimensions() {
        /* 53 */
        return this.dimensions;
    }

    public void setDimensions(String dimensions) {
        /* 56 */
        this.dimensions = dimensions;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCampaignCrowdCountModel
 * JD-Core Version:    0.6.0
 */