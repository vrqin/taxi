package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class QueryInstBillDetail extends AlipayObject {
    private static final long serialVersionUID = 8872854655236947447L;

    @ApiField("key")
    private String key;

    @ApiField("name")
    private String name;

    @ApiField("value")
    private String value;

    public String getKey() {
        /* 35 */
        return this.key;
    }

    public void setKey(String key) {
        /* 38 */
        this.key = key;
    }

    public String getName() {
        /* 42 */
        return this.name;
    }

    public void setName(String name) {
        /* 45 */
        this.name = name;
    }

    public String getValue() {
        /* 49 */
        return this.value;
    }

    public void setValue(String value) {
        /* 52 */
        this.value = value;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.QueryInstBillDetail
 * JD-Core Version:    0.6.0
 */