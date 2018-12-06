package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayUserDetail;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayUserGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 8115514612719117383L;

    @ApiField("alipay_user_detail")
    private AlipayUserDetail alipayUserDetail;

    public AlipayUserDetail getAlipayUserDetail() {
        /* 28 */
        return this.alipayUserDetail;
    }

    public void setAlipayUserDetail(AlipayUserDetail alipayUserDetail) {
        /* 25 */
        this.alipayUserDetail = alipayUserDetail;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayUserGetResponse
 * JD-Core Version:    0.6.0
 */