package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class NewsfeedLabelInfo extends AlipayObject {
    private static final long serialVersionUID = 6827781741228642644L;

    @ApiField("action")
    private String action;

    @ApiField("scheme")
    private String scheme;

    @ApiField("target")
    private String target;

    public String getAction() {
        /* 35 */
        return this.action;
    }

    public void setAction(String action) {
        /* 38 */
        this.action = action;
    }

    public String getScheme() {
        /* 42 */
        return this.scheme;
    }

    public void setScheme(String scheme) {
        /* 45 */
        this.scheme = scheme;
    }

    public String getTarget() {
        /* 49 */
        return this.target;
    }

    public void setTarget(String target) {
        /* 52 */
        this.target = target;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.NewsfeedLabelInfo
 * JD-Core Version:    0.6.0
 */