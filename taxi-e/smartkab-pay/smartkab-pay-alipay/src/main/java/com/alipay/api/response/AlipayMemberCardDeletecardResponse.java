package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMemberCardDeletecardResponse extends AlipayResponse {
    private static final long serialVersionUID = 3821697739785411925L;

    @ApiField("error_code")
    private String errorCode;

    @ApiField("error_msg")
    private String errorMsg;

    @ApiField("success")
    private String success;

    public String getErrorCode() {
        /* 41 */
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        /* 38 */
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        /* 48 */
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        /* 45 */
        this.errorMsg = errorMsg;
    }

    public String getSuccess() {
        /* 55 */
        return this.success;
    }

    public void setSuccess(String success) {
        /* 52 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMemberCardDeletecardResponse
 * JD-Core Version:    0.6.0
 */