package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayCodeRecoResult;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayDataDataserviceCodeRecoResponse extends AlipayResponse {
    private static final long serialVersionUID = 1496793612675799298L;

    @ApiField("result")
    private AlipayCodeRecoResult result;

    public AlipayCodeRecoResult getResult() {
        /* 28 */
        return this.result;
    }

    public void setResult(AlipayCodeRecoResult result) {
        /* 25 */
        this.result = result;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayDataDataserviceCodeRecoResponse
 * JD-Core Version:    0.6.0
 */