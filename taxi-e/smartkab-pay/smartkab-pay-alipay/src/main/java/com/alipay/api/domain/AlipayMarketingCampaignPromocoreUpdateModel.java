package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayMarketingCampaignPromocoreUpdateModel extends AlipayObject {
    private static final long serialVersionUID = 5175387886216793475L;


    @ApiField("account_count")
    private String accountCount;


    @ApiField("appid_count")
    private String appidCount;


    @ApiField("award_rate")
    private String awardRate;


    @ApiField("camp_end_time")
    private String campEndTime;


    @ApiField("camp_id")
    private String campId;


    @ApiField("camp_name")
    private String campName;


    @ApiField("camp_start_time")
    private String campStartTime;


    @ApiField("cert_rule_id")
    private String certRuleId;


    @ApiField("certification_count")
    private String certificationCount;


    @ApiField("mobile_count")
    private String mobileCount;


    @ApiListField("prize_list")

    @ApiField("mp_prize_info_model")
    private List<MpPrizeInfoModel> prizeList;


    @ApiField("promo_rule_id")
    private String promoRuleId;


    @ApiField("user_rule_id")
    private String userRuleId;


    public String getAccountCount() {
        /*  99 */
        return this.accountCount;

    }


    public void setAccountCount(String accountCount) {
        /* 102 */
        this.accountCount = accountCount;

    }


    public String getAppidCount() {
        /* 106 */
        return this.appidCount;

    }


    public void setAppidCount(String appidCount) {
        /* 109 */
        this.appidCount = appidCount;

    }


    public String getAwardRate() {
        /* 113 */
        return this.awardRate;

    }


    public void setAwardRate(String awardRate) {
        /* 116 */
        this.awardRate = awardRate;

    }


    public String getCampEndTime() {
        /* 120 */
        return this.campEndTime;

    }


    public void setCampEndTime(String campEndTime) {
        /* 123 */
        this.campEndTime = campEndTime;

    }


    public String getCampId() {
        /* 127 */
        return this.campId;

    }


    public void setCampId(String campId) {
        /* 130 */
        this.campId = campId;

    }


    public String getCampName() {
        /* 134 */
        return this.campName;

    }


    public void setCampName(String campName) {
        /* 137 */
        this.campName = campName;

    }


    public String getCampStartTime() {
        /* 141 */
        return this.campStartTime;

    }


    public void setCampStartTime(String campStartTime) {
        /* 144 */
        this.campStartTime = campStartTime;

    }


    public String getCertRuleId() {
        /* 148 */
        return this.certRuleId;

    }


    public void setCertRuleId(String certRuleId) {
        /* 151 */
        this.certRuleId = certRuleId;

    }


    public String getCertificationCount() {
        /* 155 */
        return this.certificationCount;

    }


    public void setCertificationCount(String certificationCount) {
        /* 158 */
        this.certificationCount = certificationCount;

    }


    public String getMobileCount() {
        /* 162 */
        return this.mobileCount;

    }


    public void setMobileCount(String mobileCount) {
        /* 165 */
        this.mobileCount = mobileCount;

    }


    public List<MpPrizeInfoModel> getPrizeList() {
        /* 169 */
        return this.prizeList;

    }


    public void setPrizeList(List<MpPrizeInfoModel> prizeList) {
        /* 172 */
        this.prizeList = prizeList;

    }


    public String getPromoRuleId() {
        /* 176 */
        return this.promoRuleId;

    }


    public void setPromoRuleId(String promoRuleId) {
        /* 179 */
        this.promoRuleId = promoRuleId;

    }


    public String getUserRuleId() {
        /* 183 */
        return this.userRuleId;

    }


    public void setUserRuleId(String userRuleId) {
        /* 186 */
        this.userRuleId = userRuleId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignPromocoreUpdateModel
 * JD-Core Version:    0.6.0
 */