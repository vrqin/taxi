package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ContentPicture extends AlipayObject {
    private static final long serialVersionUID = 2593728143785971484L;

    @ApiField("location")
    private String location;

    @ApiField("name")
    private String name;

    @ApiField("type")
    private String type;

    public String getLocation() {
        /* 35 */
        return this.location;
    }

    public void setLocation(String location) {
        /* 38 */
        this.location = location;
    }

    public String getName() {
        /* 42 */
        return this.name;
    }

    public void setName(String name) {
        /* 45 */
        this.name = name;
    }

    public String getType() {
        /* 49 */
        return this.type;
    }

    public void setType(String type) {
        /* 52 */
        this.type = type;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ContentPicture
 * JD-Core Version:    0.6.0
 */