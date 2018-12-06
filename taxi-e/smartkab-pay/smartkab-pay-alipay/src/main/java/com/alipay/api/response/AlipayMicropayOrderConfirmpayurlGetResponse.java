package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.SinglePayDetail;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMicropayOrderConfirmpayurlGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 8729562571728689124L;

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
 * Qualified Name:     com.alipay.api.response.AlipayMicropayOrderConfirmpayurlGetResponse
 * JD-Core Version:    0.6.0
 */