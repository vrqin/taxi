package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicLifeMsgRecallModel extends AlipayObject {
    private static final long serialVersionUID = 6515897343477899511L;

    @ApiField("message_id")
    private String messageId;

    public String getMessageId() {
        /* 23 */
        return this.messageId;
    }

    public void setMessageId(String messageId) {
        /* 26 */
        this.messageId = messageId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicLifeMsgRecallModel
 * JD-Core Version:    0.6.0
 */