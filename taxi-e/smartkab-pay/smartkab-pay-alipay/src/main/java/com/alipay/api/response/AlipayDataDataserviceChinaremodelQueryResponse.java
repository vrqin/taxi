package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayChinareModelResult;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayDataDataserviceChinaremodelQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1719271811945291918L;

    @ApiField("result")
    private AlipayChinareModelResult result;

    public AlipayChinareModelResult getResult() {
        /* 28 */
        return this.result;
    }

    public void setResult(AlipayChinareModelResult result) {
        /* 25 */
        this.result = result;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayDataDataserviceChinaremodelQueryResponse
 * JD-Core Version:    0.6.0
 */