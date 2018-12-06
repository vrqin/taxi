package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicTemplateMessageGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 6768714872537227154L;

    @ApiField("msg_template_id")
    private String msgTemplateId;

    @ApiField("template")
    private String template;

    public String getMsgTemplateId() {
        /* 33 */
        return this.msgTemplateId;
    }

    public void setMsgTemplateId(String msgTemplateId) {
        /* 30 */
        this.msgTemplateId = msgTemplateId;
    }

    public String getTemplate() {
        /* 40 */
        return this.template;
    }

    public void setTemplate(String template) {
        /* 37 */
        this.template = template;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicTemplateMessageGetResponse
 * JD-Core Version:    0.6.0
 */