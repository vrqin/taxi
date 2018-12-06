package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMemberConsumeNotifyResponse extends AlipayResponse {
    private static final long serialVersionUID = 7572669443248255712L;

    @ApiField("error_code")
    private String errorCode;

    @ApiField("error_msg")
    private String errorMsg;

    @ApiField("ext_card_no")
    private String extCardNo;

    @ApiField("success")
    private String success;

    public String getErrorCode() {
        /* 46 */
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        /* 43 */
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        /* 53 */
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        /* 50 */
        this.errorMsg = errorMsg;
    }

    public String getExtCardNo() {
        /* 60 */
        return this.extCardNo;
    }

    public void setExtCardNo(String extCardNo) {
        /* 57 */
        this.extCardNo = extCardNo;
    }

    public String getSuccess() {
        /* 67 */
        return this.success;
    }

    public void setSuccess(String success) {
        /* 64 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMemberConsumeNotifyResponse
 * JD-Core Version:    0.6.0
 */