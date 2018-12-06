package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicMessageSingleSendModel extends AlipayObject {
    private static final long serialVersionUID = 4184519412158945533L;

    @ApiField("template")
    private Template template;

    @ApiField("to_user_id")
    private String toUserId;

    public Template getTemplate() {
        /* 29 */
        return this.template;
    }

    public void setTemplate(Template template) {
        /* 32 */
        this.template = template;
    }

    public String getToUserId() {
        /* 36 */
        return this.toUserId;
    }

    public void setToUserId(String toUserId) {
        /* 39 */
        this.toUserId = toUserId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicMessageSingleSendModel
 * JD-Core Version:    0.6.0
 */