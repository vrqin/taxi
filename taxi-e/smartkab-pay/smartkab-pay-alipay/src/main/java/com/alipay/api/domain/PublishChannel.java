package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class PublishChannel extends AlipayObject {
    private static final long serialVersionUID = 2419617638325773666L;

    @ApiField("config")
    private String config;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("name")
    private String name;

    @ApiField("type")
    private String type;

    public String getConfig() {
        /* 46 */
        return this.config;
    }

    public void setConfig(String config) {
        /* 49 */
        this.config = config;
    }

    public String getExtInfo() {
        /* 53 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 56 */
        this.extInfo = extInfo;
    }

    public String getName() {
        /* 60 */
        return this.name;
    }

    public void setName(String name) {
        /* 63 */
        this.name = name;
    }

    public String getType() {
        /* 67 */
        return this.type;
    }

    public void setType(String type) {
        /* 70 */
        this.type = type;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PublishChannel
 * JD-Core Version:    0.6.0
 */