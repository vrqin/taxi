package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.StationDetailInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayCommerceCityfacilitatorStationQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3158552876717181643L;

    @ApiListField("support_starts")
    @ApiField("station_detail_info")
    private List<StationDetailInfo> supportStarts;

    public List<StationDetailInfo> getSupportStarts() {
        /* 31 */
        return this.supportStarts;
    }

    public void setSupportStarts(List<StationDetailInfo> supportStarts) {
        /* 28 */
        this.supportStarts = supportStarts;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayCommerceCityfacilitatorStationQueryResponse
 * JD-Core Version:    0.6.0
 */