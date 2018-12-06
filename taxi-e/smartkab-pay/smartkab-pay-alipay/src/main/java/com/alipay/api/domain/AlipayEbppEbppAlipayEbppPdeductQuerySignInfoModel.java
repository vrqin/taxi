package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEbppEbppAlipayEbppPdeductQuerySignInfoModel extends AlipayObject {
    private static final long serialVersionUID = 7358882747987597699L;

    @ApiField("agreement_id")
    private String agreementId;

    @ApiField("user_id")
    private String userId;

    public String getAgreementId() {
        /* 29 */
        return this.agreementId;
    }

    public void setAgreementId(String agreementId) {
        /* 32 */
        this.agreementId = agreementId;
    }

    public String getUserId() {
        /* 36 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 39 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEbppEbppAlipayEbppPdeductQuerySignInfoModel
 * JD-Core Version:    0.6.0
 */