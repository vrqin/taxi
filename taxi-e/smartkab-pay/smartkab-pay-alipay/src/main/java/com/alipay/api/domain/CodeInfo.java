package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class CodeInfo extends AlipayObject {
    private static final long serialVersionUID = 6296695767692997511L;

    @ApiField("goto_url")
    private String gotoUrl;

    @ApiField("scene")
    private Scene scene;

    public String getGotoUrl() {
        /* 29 */
        return this.gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        /* 32 */
        this.gotoUrl = gotoUrl;
    }

    public Scene getScene() {
        /* 36 */
        return this.scene;
    }

    public void setScene(Scene scene) {
        /* 39 */
        this.scene = scene;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CodeInfo
 * JD-Core Version:    0.6.0
 */