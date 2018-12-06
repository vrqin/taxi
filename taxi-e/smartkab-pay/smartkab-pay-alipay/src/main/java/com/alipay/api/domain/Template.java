package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class Template extends AlipayObject {
    private static final long serialVersionUID = 7753982668693829836L;

    @ApiField("context")
    private Context context;

    @ApiField("template_id")
    private String templateId;

    public Context getContext() {
        /* 29 */
        return this.context;
    }

    public void setContext(Context context) {
        /* 32 */
        this.context = context;
    }

    public String getTemplateId() {
        /* 36 */
        return this.templateId;
    }

    public void setTemplateId(String templateId) {
        /* 39 */
        this.templateId = templateId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Template
 * JD-Core Version:    0.6.0
 */