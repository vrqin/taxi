package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ExRefRateInfoVO;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayAccountExrateRatequeryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3457337525536682132L;

    @ApiListField("rate_query_response_list")
    @ApiField("ex_ref_rate_info_v_o")
    private List<ExRefRateInfoVO> rateQueryResponseList;

    public List<ExRefRateInfoVO> getRateQueryResponseList() {
        /* 31 */
        return this.rateQueryResponseList;
    }

    public void setRateQueryResponseList(List<ExRefRateInfoVO> rateQueryResponseList) {
        /* 28 */
        this.rateQueryResponseList = rateQueryResponseList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayAccountExrateRatequeryResponse
 * JD-Core Version:    0.6.0
 */