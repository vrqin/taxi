package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class CustomReportCondition extends AlipayObject {
    private static final long serialVersionUID = 8573838318275498178L;


    @ApiField("condition_key")
    private String conditionKey;


    @ApiListField("data_tags")

    @ApiField("data_tag")
    private List<DataTag> dataTags;


    @ApiListField("filter_tags")

    @ApiField("filter_tag")
    private List<FilterTag> filterTags;


    @ApiField("group_tags")
    private String groupTags;


    @ApiField("memo")
    private String memo;


    @ApiField("name")
    private String name;


    @ApiField("sort_tags")
    private String sortTags;


    public String getConditionKey() {
        /*  64 */
        return this.conditionKey;

    }


    public void setConditionKey(String conditionKey) {
        /*  67 */
        this.conditionKey = conditionKey;

    }


    public List<DataTag> getDataTags() {
        /*  71 */
        return this.dataTags;

    }


    public void setDataTags(List<DataTag> dataTags) {
        /*  74 */
        this.dataTags = dataTags;

    }


    public List<FilterTag> getFilterTags() {
        /*  78 */
        return this.filterTags;

    }


    public void setFilterTags(List<FilterTag> filterTags) {
        /*  81 */
        this.filterTags = filterTags;

    }


    public String getGroupTags() {
        /*  85 */
        return this.groupTags;

    }


    public void setGroupTags(String groupTags) {
        /*  88 */
        this.groupTags = groupTags;

    }


    public String getMemo() {
        /*  92 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /*  95 */
        this.memo = memo;

    }


    public String getName() {
        /*  99 */
        return this.name;

    }


    public void setName(String name) {
        /* 102 */
        this.name = name;

    }


    public String getSortTags() {
        /* 106 */
        return this.sortTags;

    }


    public void setSortTags(String sortTags) {
        /* 109 */
        this.sortTags = sortTags;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CustomReportCondition
 * JD-Core Version:    0.6.0
 */