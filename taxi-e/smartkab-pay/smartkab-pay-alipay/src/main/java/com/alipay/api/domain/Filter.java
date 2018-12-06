package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class Filter extends AlipayObject {
    private static final long serialVersionUID = 3759364316725958515L;

    @ApiField("context")
    private LabelContext context;

    @ApiField("template")
    private String template;

    public LabelContext getContext() {
        /* 31 */
        return this.context;
    }

    public void setContext(LabelContext context) {
        /* 34 */
        this.context = context;
    }

    public String getTemplate() {
        /* 38 */
        return this.template;
    }

    public void setTemplate(String template) {
        /* 41 */
        this.template = template;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Filter
 * JD-Core Version:    0.6.0
 */