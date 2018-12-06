package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingDataCustomreportQueryModel extends AlipayObject {
    private static final long serialVersionUID = 2685869441228919176L;

    @ApiField("condition_key")
    private String conditionKey;

    @ApiListField("filter_tags")
    @ApiField("filter_tag")
    private List<FilterTag> filterTags;

    @ApiField("max_count")
    private String maxCount;

    public String getConditionKey() {
        /* 39 */
        return this.conditionKey;
    }

    public void setConditionKey(String conditionKey) {
        /* 42 */
        this.conditionKey = conditionKey;
    }

    public List<FilterTag> getFilterTags() {
        /* 46 */
        return this.filterTags;
    }

    public void setFilterTags(List<FilterTag> filterTags) {
        /* 49 */
        this.filterTags = filterTags;
    }

    public String getMaxCount() {
        /* 53 */
        return this.maxCount;
    }

    public void setMaxCount(String maxCount) {
        /* 56 */
        this.maxCount = maxCount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingDataCustomreportQueryModel
 * JD-Core Version:    0.6.0
 */