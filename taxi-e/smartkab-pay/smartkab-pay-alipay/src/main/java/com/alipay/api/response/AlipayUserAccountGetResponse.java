package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayAccount;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayUserAccountGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 2284126731513962954L;

    @ApiField("alipay_account")
    private AlipayAccount alipayAccount;

    public AlipayAccount getAlipayAccount() {
        /* 28 */
        return this.alipayAccount;
    }

    public void setAlipayAccount(AlipayAccount alipayAccount) {
        /* 25 */
        this.alipayAccount = alipayAccount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayUserAccountGetResponse
 * JD-Core Version:    0.6.0
 */