package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicAccountDeleteModel extends AlipayObject {
    private static final long serialVersionUID = 3416824652787943344L;

    @ApiField("agreement_id")
    private String agreementId;

    @ApiField("bind_account_no")
    private String bindAccountNo;

    public String getAgreementId() {
        /* 29 */
        return this.agreementId;
    }

    public void setAgreementId(String agreementId) {
        /* 32 */
        this.agreementId = agreementId;
    }

    public String getBindAccountNo() {
        /* 36 */
        return this.bindAccountNo;
    }

    public void setBindAccountNo(String bindAccountNo) {
        /* 39 */
        this.bindAccountNo = bindAccountNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicAccountDeleteModel
 * JD-Core Version:    0.6.0
 */