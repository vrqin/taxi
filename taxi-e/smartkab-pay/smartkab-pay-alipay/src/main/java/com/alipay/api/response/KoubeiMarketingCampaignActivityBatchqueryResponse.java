package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CampBaseDto;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingCampaignActivityBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6786177962474122651L;

    @ApiListField("camp_sets")
    @ApiField("camp_base_dto")
    private List<CampBaseDto> campSets;

    @ApiField("total_number")
    private String totalNumber;

    public List<CampBaseDto> getCampSets() {
        /* 37 */
        return this.campSets;
    }

    public void setCampSets(List<CampBaseDto> campSets) {
        /* 34 */
        this.campSets = campSets;
    }

    public String getTotalNumber() {
        /* 44 */
        return this.totalNumber;
    }

    public void setTotalNumber(String totalNumber) {
        /* 41 */
        this.totalNumber = totalNumber;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingCampaignActivityBatchqueryResponse
 * JD-Core Version:    0.6.0
 */