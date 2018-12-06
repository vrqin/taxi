package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.PublicBindAccount;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayMobileStdPublicAccountQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2777629312371275294L;

    @ApiListField("public_bind_accounts")
    @ApiField("public_bind_account")
    private List<PublicBindAccount> publicBindAccounts;

    public List<PublicBindAccount> getPublicBindAccounts() {
        /* 31 */
        return this.publicBindAccounts;
    }

    public void setPublicBindAccounts(List<PublicBindAccount> publicBindAccounts) {
        /* 28 */
        this.publicBindAccounts = publicBindAccounts;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobileStdPublicAccountQueryResponse
 * JD-Core Version:    0.6.0
 */