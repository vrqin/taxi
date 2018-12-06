package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class DataEnumValue extends AlipayObject {
    private static final long serialVersionUID = 2147963847747479975L;

    @ApiListField("filter_tags")
    @ApiField("filter_tag")
    private List<FilterTag> filterTags;

    @ApiField("label")
    private String label;

    @ApiField("value")
    private String value;

    public List<FilterTag> getFilterTags() {
        /* 39 */
        return this.filterTags;
    }

    public void setFilterTags(List<FilterTag> filterTags) {
        /* 42 */
        this.filterTags = filterTags;
    }

    public String getLabel() {
        /* 46 */
        return this.label;
    }

    public void setLabel(String label) {
        /* 49 */
        this.label = label;
    }

    public String getValue() {
        /* 53 */
        return this.value;
    }

    public void setValue(String value) {
        /* 56 */
        this.value = value;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DataEnumValue
 * JD-Core Version:    0.6.0
 */