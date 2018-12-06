package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.MpPrizeInfoModel;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayMarketingCampaignDrawcampQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1757286671229961848L;


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


    @ApiField("camp_id")
    private String campId;


    @ApiField("camp_name")
    private String campName;


    @ApiField("camp_start_time")
    private String campStartTime;


    @ApiField("camp_status")
    private String campStatus;


    @ApiField("cert_rule_id")
    private String certRuleId;


    @ApiField("certification_count")
    private String certificationCount;


    @ApiField("creator")
    private String creator;


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
        /* 139 */
        return this.accountCount;

    }


    public void setAccountCount(String accountCount) {
        /* 136 */
        this.accountCount = accountCount;

    }


    public String getAppidCount() {
        /* 146 */
        return this.appidCount;

    }


    public void setAppidCount(String appidCount) {
        /* 143 */
        this.appidCount = appidCount;

    }


    public String getAwardCount() {
        /* 153 */
        return this.awardCount;

    }


    public void setAwardCount(String awardCount) {
        /* 150 */
        this.awardCount = awardCount;

    }


    public String getAwardRate() {
        /* 160 */
        return this.awardRate;

    }


    public void setAwardRate(String awardRate) {
        /* 157 */
        this.awardRate = awardRate;

    }


    public String getCampCode() {
        /* 167 */
        return this.campCode;

    }


    public void setCampCode(String campCode) {
        /* 164 */
        this.campCode = campCode;

    }


    public String getCampEndTime() {
        /* 174 */
        return this.campEndTime;

    }


    public void setCampEndTime(String campEndTime) {
        /* 171 */
        this.campEndTime = campEndTime;

    }


    public String getCampId() {
        /* 181 */
        return this.campId;

    }


    public void setCampId(String campId) {
        /* 178 */
        this.campId = campId;

    }


    public String getCampName() {
        /* 188 */
        return this.campName;

    }


    public void setCampName(String campName) {
        /* 185 */
        this.campName = campName;

    }


    public String getCampStartTime() {
        /* 195 */
        return this.campStartTime;

    }


    public void setCampStartTime(String campStartTime) {
        /* 192 */
        this.campStartTime = campStartTime;

    }


    public String getCampStatus() {
        /* 202 */
        return this.campStatus;

    }


    public void setCampStatus(String campStatus) {
        /* 199 */
        this.campStatus = campStatus;

    }


    public String getCertRuleId() {
        /* 209 */
        return this.certRuleId;

    }


    public void setCertRuleId(String certRuleId) {
        /* 206 */
        this.certRuleId = certRuleId;

    }


    public String getCertificationCount() {
        /* 216 */
        return this.certificationCount;

    }


    public void setCertificationCount(String certificationCount) {
        /* 213 */
        this.certificationCount = certificationCount;

    }


    public String getCreator() {
        /* 223 */
        return this.creator;

    }


    public void setCreator(String creator) {
        /* 220 */
        this.creator = creator;

    }


    public String getMobileCount() {
        /* 230 */
        return this.mobileCount;

    }


    public void setMobileCount(String mobileCount) {
        /* 227 */
        this.mobileCount = mobileCount;

    }


    public List<MpPrizeInfoModel> getPrizeList() {
        /* 237 */
        return this.prizeList;

    }


    public void setPrizeList(List<MpPrizeInfoModel> prizeList) {
        /* 234 */
        this.prizeList = prizeList;

    }


    public String getPromoRuleId() {
        /* 244 */
        return this.promoRuleId;

    }


    public void setPromoRuleId(String promoRuleId) {
        /* 241 */
        this.promoRuleId = promoRuleId;

    }


    public String getTriggerType() {
        /* 251 */
        return this.triggerType;

    }


    public void setTriggerType(String triggerType) {
        /* 248 */
        this.triggerType = triggerType;

    }


    public String getTriggerUserRuleId() {
        /* 258 */
        return this.triggerUserRuleId;

    }


    public void setTriggerUserRuleId(String triggerUserRuleId) {
        /* 255 */
        this.triggerUserRuleId = triggerUserRuleId;

    }


    public String getUserRuleId() {
        /* 265 */
        return this.userRuleId;

    }


    public void setUserRuleId(String userRuleId) {
        /* 262 */
        this.userRuleId = userRuleId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignDrawcampQueryResponse
 * JD-Core Version:    0.6.0
 */