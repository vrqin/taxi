package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayDataItemDescription extends AlipayObject {
    private static final long serialVersionUID = 4763685542357966792L;

    @ApiListField("details")
    @ApiField("string")
    private List<String> details;

    @ApiListField("images")
    @ApiField("string")
    private List<String> images;

    @ApiField("title")
    private String title;

    @ApiField("url")
    private String url;

    public List<String> getDetails() {
        /* 46 */
        return this.details;
    }

    public void setDetails(List<String> details) {
        /* 49 */
        this.details = details;
    }

    public List<String> getImages() {
        /* 53 */
        return this.images;
    }

    public void setImages(List<String> images) {
        /* 56 */
        this.images = images;
    }

    public String getTitle() {
        /* 60 */
        return this.title;
    }

    public void setTitle(String title) {
        /* 63 */
        this.title = title;
    }

    public String getUrl() {
        /* 67 */
        return this.url;
    }

    public void setUrl(String url) {
        /* 70 */
        this.url = url;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayDataItemDescription
 * JD-Core Version:    0.6.0
 */