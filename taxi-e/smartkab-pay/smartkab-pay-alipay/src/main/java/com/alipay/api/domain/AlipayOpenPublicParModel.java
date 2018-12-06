package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicParModel extends AlipayObject {
    private static final long serialVersionUID = 5147752359586719645L;

    @ApiField("action_param")
    private String actionParam;

    @ApiField("action_type")
    private String actionType;

    @ApiField("agreement_id")
    private String agreementId;

    @ApiField("public_id")
    private String publicId;

    @ApiField("third_account_id")
    private String thirdAccountId;

    @ApiField("user_id")
    private String userId;

    public String getActionParam() {
        /* 53 */
        return this.actionParam;
    }

    public void setActionParam(String actionParam) {
        /* 56 */
        this.actionParam = actionParam;
    }

    public String getActionType() {
        /* 60 */
        return this.actionType;
    }

    public void setActionType(String actionType) {
        /* 63 */
        this.actionType = actionType;
    }

    public String getAgreementId() {
        /* 67 */
        return this.agreementId;
    }

    public void setAgreementId(String agreementId) {
        /* 70 */
        this.agreementId = agreementId;
    }

    public String getPublicId() {
        /* 74 */
        return this.publicId;
    }

    public void setPublicId(String publicId) {
        /* 77 */
        this.publicId = publicId;
    }

    public String getThirdAccountId() {
        /* 81 */
        return this.thirdAccountId;
    }

    public void setThirdAccountId(String thirdAccountId) {
        /* 84 */
        this.thirdAccountId = thirdAccountId;
    }

    public String getUserId() {
        /* 88 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 91 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicParModel
 * JD-Core Version:    0.6.0
 */