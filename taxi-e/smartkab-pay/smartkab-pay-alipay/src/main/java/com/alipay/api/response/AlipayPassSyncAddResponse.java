package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPassSyncAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 5626794568772918446L;

    @ApiField("biz_result")
    private String bizResult;

    @ApiField("error_code")
    private String errorCode;

    @ApiField("success")
    private Boolean success;

    public String getBizResult() {
        /* 39 */
        return this.bizResult;
    }

    public void setBizResult(String bizResult) {
        /* 36 */
        this.bizResult = bizResult;
    }

    public String getErrorCode() {
        /* 46 */
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        /* 43 */
        this.errorCode = errorCode;
    }

    public Boolean getSuccess() {
        /* 53 */
        return this.success;
    }

    public void setSuccess(Boolean success) {
        /* 50 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayPassSyncAddResponse
 * JD-Core Version:    0.6.0
 */