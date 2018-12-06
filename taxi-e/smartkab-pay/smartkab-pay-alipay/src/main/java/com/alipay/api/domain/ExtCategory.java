package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ExtCategory extends AlipayObject {
    private static final long serialVersionUID = 7339227619553614834L;

    @ApiField("category_code")
    private String categoryCode;

    @ApiField("name")
    private String name;

    @ApiField("parent_id")
    private String parentId;

    public String getCategoryCode() {
        /* 35 */
        return this.categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        /* 38 */
        this.categoryCode = categoryCode;
    }

    public String getName() {
        /* 42 */
        return this.name;
    }

    public void setName(String name) {
        /* 45 */
        this.name = name;
    }

    public String getParentId() {
        /* 49 */
        return this.parentId;
    }

    public void setParentId(String parentId) {
        /* 52 */
        this.parentId = parentId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ExtCategory
 * JD-Core Version:    0.6.0
 */