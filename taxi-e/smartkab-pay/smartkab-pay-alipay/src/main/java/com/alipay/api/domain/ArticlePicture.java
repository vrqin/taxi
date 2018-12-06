package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ArticlePicture extends AlipayObject {
    private static final long serialVersionUID = 7875251315684811849L;

    @ApiField("desc")
    private String desc;

    @ApiField("location")
    private String location;

    @ApiField("name")
    private String name;

    @ApiField("type")
    private String type;

    public String getDesc() {
        /* 41 */
        return this.desc;
    }

    public void setDesc(String desc) {
        /* 44 */
        this.desc = desc;
    }

    public String getLocation() {
        /* 48 */
        return this.location;
    }

    public void setLocation(String location) {
        /* 51 */
        this.location = location;
    }

    public String getName() {
        /* 55 */
        return this.name;
    }

    public void setName(String name) {
        /* 58 */
        this.name = name;
    }

    public String getType() {
        /* 62 */
        return this.type;
    }

    public void setType(String type) {
        /* 65 */
        this.type = type;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ArticlePicture
 * JD-Core Version:    0.6.0
 */