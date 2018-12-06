package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class Voucher extends AlipayObject {
    private static final long serialVersionUID = 4891277295376318792L;


    @ApiField("brand_name")
    private String brandName;


    @ApiListField("clause_terms")

    @ApiField("clause_term")
    private List<ClauseTerm> clauseTerms;


    @ApiField("delay_info")
    private DelayInfo delayInfo;


    @ApiField("desc")
    private String desc;


    @ApiField("display_config")
    private DisplayConfig displayConfig;


    @ApiField("donate_flag")
    private String donateFlag;


    @ApiField("effect_type")
    private String effectType;


    @ApiField("end_time")
    private Date endTime;


    @ApiField("ext_info")
    private String extInfo;


    @ApiField("item_info")
    private ItemInfo itemInfo;


    @ApiField("logo")
    private String logo;


    @ApiField("max_amount")
    private String maxAmount;


    @ApiField("name")
    private String name;


    @ApiField("rate")
    private String rate;


    @ApiField("relative_time")
    private String relativeTime;


    @ApiField("start_time")
    private Date startTime;


    @ApiField("type")
    private String type;


    @ApiListField("use_instructions")

    @ApiField("string")
    private List<String> useInstructions;


    @ApiField("use_rule")
    private UseRule useRule;


    @ApiField("validate_type")
    private String validateType;


    @ApiField("verify_mode")
    private String verifyMode;


    @ApiField("voucher_img")
    private String voucherImg;


    @ApiField("worth_value")
    private String worthValue;


    public String getBrandName() {
        /* 191 */
        return this.brandName;

    }


    public void setBrandName(String brandName) {
        /* 194 */
        this.brandName = brandName;

    }


    public List<ClauseTerm> getClauseTerms() {
        /* 198 */
        return this.clauseTerms;

    }


    public void setClauseTerms(List<ClauseTerm> clauseTerms) {
        /* 201 */
        this.clauseTerms = clauseTerms;

    }


    public DelayInfo getDelayInfo() {
        /* 205 */
        return this.delayInfo;

    }


    public void setDelayInfo(DelayInfo delayInfo) {
        /* 208 */
        this.delayInfo = delayInfo;

    }


    public String getDesc() {
        /* 212 */
        return this.desc;

    }


    public void setDesc(String desc) {
        /* 215 */
        this.desc = desc;

    }


    public DisplayConfig getDisplayConfig() {
        /* 219 */
        return this.displayConfig;

    }


    public void setDisplayConfig(DisplayConfig displayConfig) {
        /* 222 */
        this.displayConfig = displayConfig;

    }


    public String getDonateFlag() {
        /* 226 */
        return this.donateFlag;

    }


    public void setDonateFlag(String donateFlag) {
        /* 229 */
        this.donateFlag = donateFlag;

    }


    public String getEffectType() {
        /* 233 */
        return this.effectType;

    }


    public void setEffectType(String effectType) {
        /* 236 */
        this.effectType = effectType;

    }


    public Date getEndTime() {
        /* 240 */
        return this.endTime;

    }


    public void setEndTime(Date endTime) {
        /* 243 */
        this.endTime = endTime;

    }


    public String getExtInfo() {
        /* 247 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /* 250 */
        this.extInfo = extInfo;

    }


    public ItemInfo getItemInfo() {
        /* 254 */
        return this.itemInfo;

    }


    public void setItemInfo(ItemInfo itemInfo) {
        /* 257 */
        this.itemInfo = itemInfo;

    }


    public String getLogo() {
        /* 261 */
        return this.logo;

    }


    public void setLogo(String logo) {
        /* 264 */
        this.logo = logo;

    }


    public String getMaxAmount() {
        /* 268 */
        return this.maxAmount;

    }


    public void setMaxAmount(String maxAmount) {
        /* 271 */
        this.maxAmount = maxAmount;

    }


    public String getName() {
        /* 275 */
        return this.name;

    }


    public void setName(String name) {
        /* 278 */
        this.name = name;

    }


    public String getRate() {
        /* 282 */
        return this.rate;

    }


    public void setRate(String rate) {
        /* 285 */
        this.rate = rate;

    }


    public String getRelativeTime() {
        /* 289 */
        return this.relativeTime;

    }


    public void setRelativeTime(String relativeTime) {
        /* 292 */
        this.relativeTime = relativeTime;

    }


    public Date getStartTime() {
        /* 296 */
        return this.startTime;

    }


    public void setStartTime(Date startTime) {
        /* 299 */
        this.startTime = startTime;

    }


    public String getType() {
        /* 303 */
        return this.type;

    }


    public void setType(String type) {
        /* 306 */
        this.type = type;

    }


    public List<String> getUseInstructions() {
        /* 310 */
        return this.useInstructions;

    }


    public void setUseInstructions(List<String> useInstructions) {
        /* 313 */
        this.useInstructions = useInstructions;

    }


    public UseRule getUseRule() {
        /* 317 */
        return this.useRule;

    }


    public void setUseRule(UseRule useRule) {
        /* 320 */
        this.useRule = useRule;

    }


    public String getValidateType() {
        /* 324 */
        return this.validateType;

    }


    public void setValidateType(String validateType) {
        /* 327 */
        this.validateType = validateType;

    }


    public String getVerifyMode() {
        /* 331 */
        return this.verifyMode;

    }


    public void setVerifyMode(String verifyMode) {
        /* 334 */
        this.verifyMode = verifyMode;

    }


    public String getVoucherImg() {
        /* 338 */
        return this.voucherImg;

    }


    public void setVoucherImg(String voucherImg) {
        /* 341 */
        this.voucherImg = voucherImg;

    }


    public String getWorthValue() {
        /* 345 */
        return this.worthValue;

    }


    public void setWorthValue(String worthValue) {
        /* 348 */
        this.worthValue = worthValue;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Voucher
 * JD-Core Version:    0.6.0
 */