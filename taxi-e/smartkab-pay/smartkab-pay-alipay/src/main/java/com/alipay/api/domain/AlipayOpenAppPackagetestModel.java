package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenAppPackagetestModel extends AlipayObject {
    private static final long serialVersionUID = 5448841429511418912L;

    @ApiField("testparam")
    private String testparam;

    @ApiField("testtest")
    private String testtest;

    public String getTestparam() {
        /* 29 */
        return this.testparam;
    }

    public void setTestparam(String testparam) {
        /* 32 */
        this.testparam = testparam;
    }

    public String getTesttest() {
        /* 36 */
        return this.testtest;
    }

    public void setTesttest(String testtest) {
        /* 39 */
        this.testtest = testtest;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenAppPackagetestModel
 * JD-Core Version:    0.6.0
 */