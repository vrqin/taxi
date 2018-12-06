package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class Paragraph extends AlipayObject {
    private static final long serialVersionUID = 4748576876231974587L;

    @ApiListField("pictures")
    @ApiField("picture")
    private List<Picture> pictures;

    @ApiField("text")
    private String text;

    public List<Picture> getPictures() {
        /* 33 */
        return this.pictures;
    }

    public void setPictures(List<Picture> pictures) {
        /* 36 */
        this.pictures = pictures;
    }

    public String getText() {
        /* 40 */
        return this.text;
    }

    public void setText(String text) {
        /* 43 */
        this.text = text;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Paragraph
 * JD-Core Version:    0.6.0
 */