package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.PublicBindAccount;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayMobilePublicAccountQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 8645933485573739116L;

    @ApiField("code")
    private String code;

    @ApiField("menu_key")
    private String menuKey;

    @ApiField("msg")
    private String msg;

    @ApiListField("public_bind_accounts")
    @ApiField("public_bind_account")
    private List<PublicBindAccount> publicBindAccounts;

    @ApiField("remark")
    private String remark;

    public String getCode() {
        /* 55 */
        return this.code;
    }

    public void setCode(String code) {
        /* 52 */
        this.code = code;
    }

    public String getMenuKey() {
        /* 62 */
        return this.menuKey;
    }

    public void setMenuKey(String menuKey) {
        /* 59 */
        this.menuKey = menuKey;
    }

    public String getMsg() {
        /* 69 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 66 */
        this.msg = msg;
    }

    public List<PublicBindAccount> getPublicBindAccounts() {
        /* 76 */
        return this.publicBindAccounts;
    }

    public void setPublicBindAccounts(List<PublicBindAccount> publicBindAccounts) {
        /* 73 */
        this.publicBindAccounts = publicBindAccounts;
    }

    public String getRemark() {
        /* 83 */
        return this.remark;
    }

    public void setRemark(String remark) {
        /* 80 */
        this.remark = remark;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicAccountQueryResponse
 * JD-Core Version:    0.6.0
 */