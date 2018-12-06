package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class BeaconTemplate extends AlipayObject {
    private static final long serialVersionUID = 1242562348413726945L;

    @ApiField("context")
    private String context;

    @ApiField("templateid")
    private String templateid;

    public String getContext() {
        /* 29 */
        return this.context;
    }

    public void setContext(String context) {
        /* 32 */
        this.context = context;
    }

    public String getTemplateid() {
        /* 36 */
        return this.templateid;
    }

    public void setTemplateid(String templateid) {
        /* 39 */
        this.templateid = templateid;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.BeaconTemplate
 * JD-Core Version:    0.6.0
 */