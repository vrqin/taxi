package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignActivityOfflineCreateModel extends AlipayObject {
    private static final long serialVersionUID = 5325384825237562454L;

    @ApiField("budget")
    private OpenPromoBudget budget;

    @ApiField("camp")
    private OpenPromoCamp camp;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiField("prize")
    private OpenPromoPrize prize;

    public OpenPromoBudget getBudget() {
        /* 41 */
        return this.budget;
    }

    public void setBudget(OpenPromoBudget budget) {
        /* 44 */
        this.budget = budget;
    }

    public OpenPromoCamp getCamp() {
        /* 48 */
        return this.camp;
    }

    public void setCamp(OpenPromoCamp camp) {
        /* 51 */
        this.camp = camp;
    }

    public String getOutBizNo() {
        /* 55 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 58 */
        this.outBizNo = outBizNo;
    }

    public OpenPromoPrize getPrize() {
        /* 62 */
        return this.prize;
    }

    public void setPrize(OpenPromoPrize prize) {
        /* 65 */
        this.prize = prize;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignActivityOfflineCreateModel
 * JD-Core Version:    0.6.0
 */