package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.StdPublicBindAccount;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOpenPublicAccountQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 8449621465159733773L;

    @ApiListField("public_bind_accounts")
    @ApiField("std_public_bind_account")
    private List<StdPublicBindAccount> publicBindAccounts;

    public List<StdPublicBindAccount> getPublicBindAccounts() {
        /* 31 */
        return this.publicBindAccounts;
    }

    public void setPublicBindAccounts(List<StdPublicBindAccount> publicBindAccounts) {
        /* 28 */
        this.publicBindAccounts = publicBindAccounts;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicAccountQueryResponse
 * JD-Core Version:    0.6.0
 */