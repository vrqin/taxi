package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class PublicBindAccount extends AlipayObject {
    private static final long serialVersionUID = 7268763495473195325L;

    @ApiField("agreement_id")
    private String agreementId;

    @ApiField("app_id")
    private String appId;

    @ApiField("bind_account_no")
    private String bindAccountNo;

    @ApiField("display_name")
    private String displayName;

    @ApiField("from_user_id")
    private String fromUserId;

    @ApiField("real_name")
    private String realName;

    public String getAgreementId() {
        /* 53 */
        return this.agreementId;
    }

    public void setAgreementId(String agreementId) {
        /* 56 */
        this.agreementId = agreementId;
    }

    public String getAppId() {
        /* 60 */
        return this.appId;
    }

    public void setAppId(String appId) {
        /* 63 */
        this.appId = appId;
    }

    public String getBindAccountNo() {
        /* 67 */
        return this.bindAccountNo;
    }

    public void setBindAccountNo(String bindAccountNo) {
        /* 70 */
        this.bindAccountNo = bindAccountNo;
    }

    public String getDisplayName() {
        /* 74 */
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        /* 77 */
        this.displayName = displayName;
    }

    public String getFromUserId() {
        /* 81 */
        return this.fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        /* 84 */
        this.fromUserId = fromUserId;
    }

    public String getRealName() {
        /* 88 */
        return this.realName;
    }

    public void setRealName(String realName) {
        /* 91 */
        this.realName = realName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PublicBindAccount
 * JD-Core Version:    0.6.0
 */