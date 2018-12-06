package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayMarketingCampaignPromocoreCreateModel extends AlipayObject {
    private static final long serialVersionUID = 3898627473463345749L;


    @ApiField("account_count")
    private String accountCount;


    @ApiField("appid_count")
    private String appidCount;


    @ApiField("award_count")
    private String awardCount;


    @ApiField("award_rate")
    private String awardRate;


    @ApiField("camp_code")
    private String campCode;


    @ApiField("camp_end_time")
    private String campEndTime;


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


    @ApiField("trigger_type")
    private String triggerType;


    @ApiField("trigger_user_rule_id")
    private String triggerUserRuleId;


    @ApiField("user_rule_id")
    private String userRuleId;


    public String getAccountCount() {
        /* 117 */
        return this.accountCount;

    }


    public void setAccountCount(String accountCount) {
        /* 120 */
        this.accountCount = accountCount;

    }


    public String getAppidCount() {
        /* 124 */
        return this.appidCount;

    }


    public void setAppidCount(String appidCount) {
        /* 127 */
        this.appidCount = appidCount;

    }


    public String getAwardCount() {
        /* 131 */
        return this.awardCount;

    }


    public void setAwardCount(String awardCount) {
        /* 134 */
        this.awardCount = awardCount;

    }


    public String getAwardRate() {
        /* 138 */
        return this.awardRate;

    }


    public void setAwardRate(String awardRate) {
        /* 141 */
        this.awardRate = awardRate;

    }


    public String getCampCode() {
        /* 145 */
        return this.campCode;

    }


    public void setCampCode(String campCode) {
        /* 148 */
        this.campCode = campCode;

    }


    public String getCampEndTime() {
        /* 152 */
        return this.campEndTime;

    }


    public void setCampEndTime(String campEndTime) {
        /* 155 */
        this.campEndTime = campEndTime;

    }


    public String getCampName() {
        /* 159 */
        return this.campName;

    }


    public void setCampName(String campName) {
        /* 162 */
        this.campName = campName;

    }


    public String getCampStartTime() {
        /* 166 */
        return this.campStartTime;

    }


    public void setCampStartTime(String campStartTime) {
        /* 169 */
        this.campStartTime = campStartTime;

    }


    public String getCertRuleId() {
        /* 173 */
        return this.certRuleId;

    }


    public void setCertRuleId(String certRuleId) {
        /* 176 */
        this.certRuleId = certRuleId;

    }


    public String getCertificationCount() {
        /* 180 */
        return this.certificationCount;

    }


    public void setCertificationCount(String certificationCount) {
        /* 183 */
        this.certificationCount = certificationCount;

    }


    public String getMobileCount() {
        /* 187 */
        return this.mobileCount;

    }


    public void setMobileCount(String mobileCount) {
        /* 190 */
        this.mobileCount = mobileCount;

    }


    public List<MpPrizeInfoModel> getPrizeList() {
        /* 194 */
        return this.prizeList;

    }


    public void setPrizeList(List<MpPrizeInfoModel> prizeList) {
        /* 197 */
        this.prizeList = prizeList;

    }


    public String getPromoRuleId() {
        /* 201 */
        return this.promoRuleId;

    }


    public void setPromoRuleId(String promoRuleId) {
        /* 204 */
        this.promoRuleId = promoRuleId;

    }


    public String getTriggerType() {
        /* 208 */
        return this.triggerType;

    }


    public void setTriggerType(String triggerType) {
        /* 211 */
        this.triggerType = triggerType;

    }


    public String getTriggerUserRuleId() {
        /* 215 */
        return this.triggerUserRuleId;

    }


    public void setTriggerUserRuleId(String triggerUserRuleId) {
        /* 218 */
        this.triggerUserRuleId = triggerUserRuleId;

    }


    public String getUserRuleId() {
        /* 222 */
        return this.userRuleId;

    }


    public void setUserRuleId(String userRuleId) {
        /* 225 */
        this.userRuleId = userRuleId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignPromocoreCreateModel
 * JD-Core Version:    0.6.0
 */