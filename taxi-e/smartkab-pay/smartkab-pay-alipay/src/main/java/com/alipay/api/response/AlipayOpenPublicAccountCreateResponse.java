package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicAccountCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 1565691715761925183L;

    @ApiField("agreement_id")
    private String agreementId;

    public String getAgreementId() {
        /* 27 */
        return this.agreementId;
    }

    public void setAgreementId(String agreementId) {
        /* 24 */
        this.agreementId = agreementId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicAccountCreateResponse
 * JD-Core Version:    0.6.0
 */