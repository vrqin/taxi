package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPassInstanceAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 5411391764621223768L;

    @ApiField("result")
    private String result;

    @ApiField("success")
    private String success;

    public String getResult() {
        /* 33 */
        return this.result;
    }

    public void setResult(String result) {
        /* 30 */
        this.result = result;
    }

    public String getSuccess() {
        /* 40 */
        return this.success;
    }

    public void setSuccess(String success) {
        /* 37 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayPassInstanceAddResponse
 * JD-Core Version:    0.6.0
 */