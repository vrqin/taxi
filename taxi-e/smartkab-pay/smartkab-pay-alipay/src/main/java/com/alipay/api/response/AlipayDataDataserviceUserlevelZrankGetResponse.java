package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayHighValueCustomerResult;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayDataDataserviceUserlevelZrankGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 8199512944897827349L;

    @ApiField("result")
    private AlipayHighValueCustomerResult result;

    public AlipayHighValueCustomerResult getResult() {
        /* 28 */
        return this.result;
    }

    public void setResult(AlipayHighValueCustomerResult result) {
        /* 25 */
        this.result = result;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayDataDataserviceUserlevelZrankGetResponse
 * JD-Core Version:    0.6.0
 */