package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class FilterTag extends AlipayObject {
    private static final long serialVersionUID = 2288668655679378593L;

    @ApiField("code")
    private String code;

    @ApiField("filter_items")
    private String filterItems;

    public String getCode() {
        /* 29 */
        return this.code;
    }

    public void setCode(String code) {
        /* 32 */
        this.code = code;
    }

    public String getFilterItems() {
        /* 36 */
        return this.filterItems;
    }

    public void setFilterItems(String filterItems) {
        /* 39 */
        this.filterItems = filterItems;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.FilterTag
 * JD-Core Version:    0.6.0
 */