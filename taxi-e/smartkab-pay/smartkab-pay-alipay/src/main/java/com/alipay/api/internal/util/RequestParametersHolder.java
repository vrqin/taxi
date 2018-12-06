package com.alipay.api.internal.util;

public class RequestParametersHolder {
    private AlipayHashMap protocalMustParams;
    private AlipayHashMap protocalOptParams;
    private AlipayHashMap applicationParams;

    public AlipayHashMap getProtocalMustParams() {
        /*  9 */
        return this.protocalMustParams;
    }

    public void setProtocalMustParams(AlipayHashMap protocalMustParams) {
        /* 12 */
        this.protocalMustParams = protocalMustParams;
    }

    public AlipayHashMap getProtocalOptParams() {
        /* 15 */
        return this.protocalOptParams;
    }

    public void setProtocalOptParams(AlipayHashMap protocalOptParams) {
        /* 18 */
        this.protocalOptParams = protocalOptParams;
    }

    public AlipayHashMap getApplicationParams() {
        /* 21 */
        return this.applicationParams;
    }

    public void setApplicationParams(AlipayHashMap applicationParams) {
        /* 24 */
        this.applicationParams = applicationParams;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.RequestParametersHolder
 * JD-Core Version:    0.6.0
 */