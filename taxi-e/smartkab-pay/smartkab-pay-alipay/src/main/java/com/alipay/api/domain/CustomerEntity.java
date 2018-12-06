package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class CustomerEntity extends AlipayObject {
    private static final long serialVersionUID = 3387386264518574752L;

    @ApiField("code")
    private String code;

    @ApiField("desc")
    private String desc;

    @ApiField("id")
    private String id;

    @ApiField("name")
    private String name;

    @ApiListField("tags")
    @ApiField("customer_tag")
    private List<CustomerTag> tags;

    public String getCode() {
        /* 51 */
        return this.code;
    }

    public void setCode(String code) {
        /* 54 */
        this.code = code;
    }

    public String getDesc() {
        /* 58 */
        return this.desc;
    }

    public void setDesc(String desc) {
        /* 61 */
        this.desc = desc;
    }

    public String getId() {
        /* 65 */
        return this.id;
    }

    public void setId(String id) {
        /* 68 */
        this.id = id;
    }

    public String getName() {
        /* 72 */
        return this.name;
    }

    public void setName(String name) {
        /* 75 */
        this.name = name;
    }

    public List<CustomerTag> getTags() {
        /* 79 */
        return this.tags;
    }

    public void setTags(List<CustomerTag> tags) {
        /* 82 */
        this.tags = tags;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CustomerEntity
 * JD-Core Version:    0.6.0
 */