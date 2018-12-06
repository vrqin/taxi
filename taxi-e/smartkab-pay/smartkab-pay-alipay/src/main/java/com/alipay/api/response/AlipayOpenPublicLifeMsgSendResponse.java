package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicLifeMsgSendResponse extends AlipayResponse {
    private static final long serialVersionUID = 8585432232552884227L;

    @ApiField("alipay_msg_id")
    private String alipayMsgId;

    public String getAlipayMsgId() {
        /* 27 */
        return this.alipayMsgId;
    }

    public void setAlipayMsgId(String alipayMsgId) {
        /* 24 */
        this.alipayMsgId = alipayMsgId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicLifeMsgSendResponse
 * JD-Core Version:    0.6.0
 */