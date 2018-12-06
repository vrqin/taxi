package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayExscUserFirstsignGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 5257515642786769795L;

    @ApiField("biz_type")
    private String bizType;

    @ApiField("success")
    private Boolean success;

    public String getBizType() {
        /* 35 */
        return this.bizType;
    }

    public void setBizType(String bizType) {
        /* 32 */
        this.bizType = bizType;
    }

    public Boolean getSuccess() {
        /* 42 */
        return this.success;
    }

    public void setSuccess(Boolean success) {
        /* 39 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayExscUserFirstsignGetResponse
 * JD-Core Version:    0.6.0
 */