package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicMessageTotalSendResponse extends AlipayResponse {
    private static final long serialVersionUID = 6287492462757138783L;

    @ApiField("message_id")
    private String messageId;

    public String getMessageId() {
        /* 27 */
        return this.messageId;
    }

    public void setMessageId(String messageId) {
        /* 24 */
        this.messageId = messageId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicMessageTotalSendResponse
 * JD-Core Version:    0.6.0
 */