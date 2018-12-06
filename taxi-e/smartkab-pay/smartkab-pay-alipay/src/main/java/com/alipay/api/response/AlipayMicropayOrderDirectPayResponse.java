package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.SinglePayDetail;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMicropayOrderDirectPayResponse extends AlipayResponse {
    private static final long serialVersionUID = 5399287121352279245L;

    @ApiField("single_pay_detail")
    private SinglePayDetail singlePayDetail;

    public SinglePayDetail getSinglePayDetail() {
        /* 28 */
        return this.singlePayDetail;
    }

    public void setSinglePayDetail(SinglePayDetail singlePayDetail) {
        /* 25 */
        this.singlePayDetail = singlePayDetail;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMicropayOrderDirectPayResponse
 * JD-Core Version:    0.6.0
 */