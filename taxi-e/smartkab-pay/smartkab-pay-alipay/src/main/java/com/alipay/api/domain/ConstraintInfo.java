package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class ConstraintInfo extends AlipayObject {
    private static final long serialVersionUID = 5478529542679741998L;


    @ApiField("crowd_group_id")
    private String crowdGroupId;


    @ApiListField("item_ids")

    @ApiField("string")
    private List<String> itemIds;


    @ApiField("min_cost")
    private String minCost;


    @ApiListField("suit_shops")

    @ApiField("string")
    private List<String> suitShops;


    @ApiField("user_win_count")
    private String userWinCount;


    @ApiField("user_win_frequency")
    private String userWinFrequency;


    public String getCrowdGroupId() {
        /*  68 */
        return this.crowdGroupId;

    }


    public void setCrowdGroupId(String crowdGroupId) {
        /*  71 */
        this.crowdGroupId = crowdGroupId;

    }


    public List<String> getItemIds() {
        /*  75 */
        return this.itemIds;

    }


    public void setItemIds(List<String> itemIds) {
        /*  78 */
        this.itemIds = itemIds;

    }


    public String getMinCost() {
        /*  82 */
        return this.minCost;

    }


    public void setMinCost(String minCost) {
        /*  85 */
        this.minCost = minCost;

    }


    public List<String> getSuitShops() {
        /*  89 */
        return this.suitShops;

    }


    public void setSuitShops(List<String> suitShops) {
        /*  92 */
        this.suitShops = suitShops;

    }


    public String getUserWinCount() {
        /*  96 */
        return this.userWinCount;

    }


    public void setUserWinCount(String userWinCount) {
        /*  99 */
        this.userWinCount = userWinCount;

    }


    public String getUserWinFrequency() {
        /* 103 */
        return this.userWinFrequency;

    }


    public void setUserWinFrequency(String userWinFrequency) {
        /* 106 */
        this.userWinFrequency = userWinFrequency;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ConstraintInfo
 * JD-Core Version:    0.6.0
 */