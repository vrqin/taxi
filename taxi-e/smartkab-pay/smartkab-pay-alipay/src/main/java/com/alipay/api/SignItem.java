package com.alipay.api;

import java.io.Serializable;

public class SignItem implements Serializable {
    private static final long serialVersionUID = 6531196726066096786L;
    private String signSourceDate;
    private String sign;

    public String getSignSourceDate() {
        /* 35 */
        return this.signSourceDate;
    }

    public void setSignSourceDate(String signSourceDate) {
        /* 44 */
        this.signSourceDate = signSourceDate;
    }

    public String getSign() {
        /* 53 */
        return this.sign;
    }

    public void setSign(String sign) {
        /* 62 */
        this.sign = sign;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.SignItem
 * JD-Core Version:    0.6.0
 */