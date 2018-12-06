package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicTemplateMessageGetModel extends AlipayObject {
    private static final long serialVersionUID = 6269447184216598178L;

    @ApiField("template_id")
    private String templateId;

    public String getTemplateId() {
        /* 23 */
        return this.templateId;
    }

    public void setTemplateId(String templateId) {
        /* 26 */
        this.templateId = templateId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicTemplateMessageGetModel
 * JD-Core Version:    0.6.0
 */