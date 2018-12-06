package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicAccountResetResponse extends AlipayResponse {
    private static final long serialVersionUID = 4261289475184825697L;

    @ApiField("agreement_id")
    private String agreementId;

    @ApiField("code")
    private String code;

    @ApiField("msg")
    private String msg;

    public String getAgreementId() {
        /* 39 */
        return this.agreementId;
    }

    public void setAgreementId(String agreementId) {
        /* 36 */
        this.agreementId = agreementId;
    }

    public String getCode() {
        /* 46 */
        return this.code;
    }

    public void setCode(String code) {
        /* 43 */
        this.code = code;
    }

    public String getMsg() {
        /* 53 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 50 */
        this.msg = msg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicAccountResetResponse
 * JD-Core Version:    0.6.0
 */