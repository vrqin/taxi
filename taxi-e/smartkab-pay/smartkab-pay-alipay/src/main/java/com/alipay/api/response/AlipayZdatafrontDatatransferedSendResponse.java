package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayZdatafrontDatatransferedSendResponse extends AlipayResponse {
    private static final long serialVersionUID = 5627833717658187416L;

    @ApiField("success")
    private String success;

    public String getSuccess() {
        /* 27 */
        return this.success;
    }

    public void setSuccess(String success) {
        /* 24 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayZdatafrontDatatransferedSendResponse
 * JD-Core Version:    0.6.0
 */