package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class PrizeCustomMenu extends AlipayObject {
    private static final long serialVersionUID = 8118973262261726968L;

    @ApiField("text")
    private String text;

    @ApiField("title")
    private String title;

    public String getText() {
        /* 29 */
        return this.text;
    }

    public void setText(String text) {
        /* 32 */
        this.text = text;
    }

    public String getTitle() {
        /* 36 */
        return this.title;
    }

    public void setTitle(String title) {
        /* 39 */
        this.title = title;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PrizeCustomMenu
 * JD-Core Version:    0.6.0
 */