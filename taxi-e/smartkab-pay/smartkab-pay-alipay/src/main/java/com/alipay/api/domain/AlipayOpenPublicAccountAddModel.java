package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicAccountAddModel extends AlipayObject {
    private static final long serialVersionUID = 3117677984357745763L;

    @ApiField("agreement_id")
    private String agreementId;

    @ApiField("bind_account_no")
    private String bindAccountNo;

    @ApiField("display_name")
    private String displayName;

    @ApiField("from_user_id")
    private String fromUserId;

    @ApiField("real_name")
    private String realName;

    @ApiField("remark")
    private String remark;

    public String getAgreementId() {
        /* 53 */
        return this.agreementId;
    }

    public void setAgreementId(String agreementId) {
        /* 56 */
        this.agreementId = agreementId;
    }

    public String getBindAccountNo() {
        /* 60 */
        return this.bindAccountNo;
    }

    public void setBindAccountNo(String bindAccountNo) {
        /* 63 */
        this.bindAccountNo = bindAccountNo;
    }

    public String getDisplayName() {
        /* 67 */
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        /* 70 */
        this.displayName = displayName;
    }

    public String getFromUserId() {
        /* 74 */
        return this.fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        /* 77 */
        this.fromUserId = fromUserId;
    }

    public String getRealName() {
        /* 81 */
        return this.realName;
    }

    public void setRealName(String realName) {
        /* 84 */
        this.realName = realName;
    }

    public String getRemark() {
        /* 88 */
        return this.remark;
    }

    public void setRemark(String remark) {
        /* 91 */
        this.remark = remark;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicAccountAddModel
 * JD-Core Version:    0.6.0
 */