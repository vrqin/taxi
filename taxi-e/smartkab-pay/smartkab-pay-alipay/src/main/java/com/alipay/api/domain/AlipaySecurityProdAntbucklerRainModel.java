package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySecurityProdAntbucklerRainModel extends AlipayObject {
    private static final long serialVersionUID = 1137686155746338716L;

    @ApiField("account")
    private String account;

    @ApiField("account_type")
    private String accountType;

    @ApiField("version")
    private String version;

    public String getAccount() {
        /* 35 */
        return this.account;
    }

    public void setAccount(String account) {
        /* 38 */
        this.account = account;
    }

    public String getAccountType() {
        /* 42 */
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        /* 45 */
        this.accountType = accountType;
    }

    public String getVersion() {
        /* 49 */
        return this.version;
    }

    public void setVersion(String version) {
        /* 52 */
        this.version = version;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySecurityProdAntbucklerRainModel
 * JD-Core Version:    0.6.0
 */