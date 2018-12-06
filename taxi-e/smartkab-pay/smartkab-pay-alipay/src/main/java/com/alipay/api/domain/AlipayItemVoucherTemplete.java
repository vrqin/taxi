package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayItemVoucherTemplete extends AlipayObject {
    private static final long serialVersionUID = 1545117415468422781L;


    @ApiField("delay_minute")
    private Long delayMinute;


    @ApiListField("desc_details")

    @ApiField("alipay_item_description")
    private List<AlipayItemDescription> descDetails;


    @ApiField("discount_rate")
    private Long discountRate;


    @ApiField("external_goods_list")
    private AlipayItemGoodsList externalGoodsList;


    @ApiListField("limit_period_info_list")

    @ApiField("alipay_item_limit_period_info")
    private List<AlipayItemLimitPeriodInfo> limitPeriodInfoList;


    @ApiField("original_amount")
    private Long originalAmount;


    @ApiField("original_rate")
    private Long originalRate;


    @ApiField("reduce_to_amount")
    private Long reduceToAmount;


    @ApiField("rounding_rule")
    private String roundingRule;


    @ApiField("threshold_amount")
    private Long thresholdAmount;


    @ApiField("threshold_quantity")
    private Long thresholdQuantity;


    @ApiField("valid_period")
    private Long validPeriod;


    @ApiField("value_amount")
    private Long valueAmount;


    @ApiField("voucher_desc")
    private String voucherDesc;


    @ApiField("voucher_type")
    private String voucherType;


    public Long getDelayMinute() {
        /* 123 */
        return this.delayMinute;

    }


    public void setDelayMinute(Long delayMinute) {
        /* 126 */
        this.delayMinute = delayMinute;

    }


    public List<AlipayItemDescription> getDescDetails() {
        /* 130 */
        return this.descDetails;

    }


    public void setDescDetails(List<AlipayItemDescription> descDetails) {
        /* 133 */
        this.descDetails = descDetails;

    }


    public Long getDiscountRate() {
        /* 137 */
        return this.discountRate;

    }


    public void setDiscountRate(Long discountRate) {
        /* 140 */
        this.discountRate = discountRate;

    }


    public AlipayItemGoodsList getExternalGoodsList() {
        /* 144 */
        return this.externalGoodsList;

    }


    public void setExternalGoodsList(AlipayItemGoodsList externalGoodsList) {
        /* 147 */
        this.externalGoodsList = externalGoodsList;

    }


    public List<AlipayItemLimitPeriodInfo> getLimitPeriodInfoList() {
        /* 151 */
        return this.limitPeriodInfoList;

    }


    public void setLimitPeriodInfoList(List<AlipayItemLimitPeriodInfo> limitPeriodInfoList) {
        /* 154 */
        this.limitPeriodInfoList = limitPeriodInfoList;

    }


    public Long getOriginalAmount() {
        /* 158 */
        return this.originalAmount;

    }


    public void setOriginalAmount(Long originalAmount) {
        /* 161 */
        this.originalAmount = originalAmount;

    }


    public Long getOriginalRate() {
        /* 165 */
        return this.originalRate;

    }


    public void setOriginalRate(Long originalRate) {
        /* 168 */
        this.originalRate = originalRate;

    }


    public Long getReduceToAmount() {
        /* 172 */
        return this.reduceToAmount;

    }


    public void setReduceToAmount(Long reduceToAmount) {
        /* 175 */
        this.reduceToAmount = reduceToAmount;

    }


    public String getRoundingRule() {
        /* 179 */
        return this.roundingRule;

    }


    public void setRoundingRule(String roundingRule) {
        /* 182 */
        this.roundingRule = roundingRule;

    }


    public Long getThresholdAmount() {
        /* 186 */
        return this.thresholdAmount;

    }


    public void setThresholdAmount(Long thresholdAmount) {
        /* 189 */
        this.thresholdAmount = thresholdAmount;

    }


    public Long getThresholdQuantity() {
        /* 193 */
        return this.thresholdQuantity;

    }


    public void setThresholdQuantity(Long thresholdQuantity) {
        /* 196 */
        this.thresholdQuantity = thresholdQuantity;

    }


    public Long getValidPeriod() {
        /* 200 */
        return this.validPeriod;

    }


    public void setValidPeriod(Long validPeriod) {
        /* 203 */
        this.validPeriod = validPeriod;

    }


    public Long getValueAmount() {
        /* 207 */
        return this.valueAmount;

    }


    public void setValueAmount(Long valueAmount) {
        /* 210 */
        this.valueAmount = valueAmount;

    }


    public String getVoucherDesc() {
        /* 214 */
        return this.voucherDesc;

    }


    public void setVoucherDesc(String voucherDesc) {
        /* 217 */
        this.voucherDesc = voucherDesc;

    }


    public String getVoucherType() {
        /* 221 */
        return this.voucherType;

    }


    public void setVoucherType(String voucherType) {
        /* 224 */
        this.voucherType = voucherType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayItemVoucherTemplete
 * JD-Core Version:    0.6.0
 */