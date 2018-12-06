package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPassTplAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 3577154259582832912L;

    @ApiField("error_code")
    private String errorCode;

    @ApiField("result")
    private String result;

    @ApiField("success")
    private String success;

    public String getErrorCode() {
        /* 39 */
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        /* 36 */
        this.errorCode = errorCode;
    }

    public String getResult() {
        /* 46 */
        return this.result;
    }

    public void setResult(String result) {
        /* 43 */
        this.result = result;
    }

    public String getSuccess() {
        /* 53 */
        return this.success;
    }

    public void setSuccess(String success) {
        /* 50 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayPassTplAddResponse
 * JD-Core Version:    0.6.0
 */