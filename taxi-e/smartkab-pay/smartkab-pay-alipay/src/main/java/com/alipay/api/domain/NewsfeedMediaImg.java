package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class NewsfeedMediaImg extends AlipayObject {
    private static final long serialVersionUID = 5122919563165982571L;

    @ApiField("height")
    private String height;

    @ApiField("src")
    private String src;

    @ApiField("width")
    private String width;

    public String getHeight() {
        /* 35 */
        return this.height;
    }

    public void setHeight(String height) {
        /* 38 */
        this.height = height;
    }

    public String getSrc() {
        /* 42 */
        return this.src;
    }

    public void setSrc(String src) {
        /* 45 */
        this.src = src;
    }

    public String getWidth() {
        /* 49 */
        return this.width;
    }

    public void setWidth(String width) {
        /* 52 */
        this.width = width;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.NewsfeedMediaImg
 * JD-Core Version:    0.6.0
 */