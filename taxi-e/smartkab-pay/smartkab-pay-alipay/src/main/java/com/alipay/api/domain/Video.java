package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class Video extends AlipayObject {
    private static final long serialVersionUID = 1421539162554989259L;

    @ApiField("location")
    private String location;

    @ApiField("name")
    private String name;

    public String getLocation() {
        /* 29 */
        return this.location;
    }

    public void setLocation(String location) {
        /* 32 */
        this.location = location;
    }

    public String getName() {
        /* 36 */
        return this.name;
    }

    public void setName(String name) {
        /* 39 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Video
 * JD-Core Version:    0.6.0
 */