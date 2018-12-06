package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class PublicLabel extends AlipayObject {
    private static final long serialVersionUID = 1718758569152859443L;

    @ApiField("count")
    private Long count;

    @ApiField("id")
    private String id;

    @ApiField("name")
    private String name;

    public Long getCount() {
        /* 35 */
        return this.count;
    }

    public void setCount(Long count) {
        /* 38 */
        this.count = count;
    }

    public String getId() {
        /* 42 */
        return this.id;
    }

    public void setId(String id) {
        /* 45 */
        this.id = id;
    }

    public String getName() {
        /* 49 */
        return this.name;
    }

    public void setName(String name) {
        /* 52 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PublicLabel
 * JD-Core Version:    0.6.0
 */