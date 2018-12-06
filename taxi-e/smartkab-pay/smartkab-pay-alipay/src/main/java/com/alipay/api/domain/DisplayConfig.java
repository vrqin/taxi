package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class DisplayConfig extends AlipayObject {
    private static final long serialVersionUID = 7213446648722839866L;

    @ApiField("slogan")
    private String slogan;

    @ApiField("slogan_img")
    private String sloganImg;

    public String getSlogan() {
        /* 31 */
        return this.slogan;
    }

    public void setSlogan(String slogan) {
        /* 34 */
        this.slogan = slogan;
    }

    public String getSloganImg() {
        /* 38 */
        return this.sloganImg;
    }

    public void setSloganImg(String sloganImg) {
        /* 41 */
        this.sloganImg = sloganImg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DisplayConfig
 * JD-Core Version:    0.6.0
 */