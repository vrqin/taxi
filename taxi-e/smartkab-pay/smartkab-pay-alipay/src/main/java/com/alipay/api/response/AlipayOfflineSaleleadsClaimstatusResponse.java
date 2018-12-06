package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineSaleleadsClaimstatusResponse extends AlipayResponse {
    private static final long serialVersionUID = 6857793591793643925L;

    @ApiField("res_msg")
    private String resMsg;

    public String getResMsg() {
        /* 27 */
        return this.resMsg;
    }

    public void setResMsg(String resMsg) {
        /* 24 */
        this.resMsg = resMsg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineSaleleadsClaimstatusResponse
 * JD-Core Version:    0.6.0
 */