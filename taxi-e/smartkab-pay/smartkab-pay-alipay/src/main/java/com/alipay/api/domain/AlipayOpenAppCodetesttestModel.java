package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenAppCodetesttestModel extends AlipayObject {
    private static final long serialVersionUID = 3726575123342985845L;

    @ApiField("testparam")
    private String testparam;

    @ApiField("testtestparam")
    private String testtestparam;

    public String getTestparam() {
        /* 29 */
        return this.testparam;
    }

    public void setTestparam(String testparam) {
        /* 32 */
        this.testparam = testparam;
    }

    public String getTesttestparam() {
        /* 36 */
        return this.testtestparam;
    }

    public void setTesttestparam(String testtestparam) {
        /* 39 */
        this.testtestparam = testtestparam;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenAppCodetesttestModel
 * JD-Core Version:    0.6.0
 */