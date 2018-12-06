package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarOrderRefundResponse extends AlipayResponse {
    private static final long serialVersionUID = 6671332244425497396L;

    @ApiField("err_msg")
    private String errMsg;

    @ApiField("success")
    private String success;

    public String getErrMsg() {
        /* 33 */
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        /* 30 */
        this.errMsg = errMsg;
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
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarOrderRefundResponse
 * JD-Core Version:    0.6.0
 */