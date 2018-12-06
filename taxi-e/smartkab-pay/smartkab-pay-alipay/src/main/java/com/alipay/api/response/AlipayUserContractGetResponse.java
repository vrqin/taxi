package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayContract;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayUserContractGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 6646295729732491441L;

    @ApiField("alipay_contract")
    private AlipayContract alipayContract;

    public AlipayContract getAlipayContract() {
        /* 28 */
        return this.alipayContract;
    }

    public void setAlipayContract(AlipayContract alipayContract) {
        /* 25 */
        this.alipayContract = alipayContract;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayUserContractGetResponse
 * JD-Core Version:    0.6.0
 */