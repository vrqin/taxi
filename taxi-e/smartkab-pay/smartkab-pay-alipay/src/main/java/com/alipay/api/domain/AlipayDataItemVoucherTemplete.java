package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayDataItemVoucherTemplete extends AlipayObject {
    private static final long serialVersionUID = 6133322398923564116L;


    @ApiField("delay_minute")
    private Long delayMinute;


    @ApiListField("desc_details")

    @ApiField("alipay_data_item_description")
    private List<AlipayDataItemDescription> descDetails;


    @ApiField("discount_rate")
    private String discountRate;


    @ApiField("external_goods_list")
    private AlipayDataItemGoodsList externalGoodsList;


    @ApiField("limit_period_info_list")
    private AlipayDataItemLimitPeriodInfo limitPeriodInfoList;


    @ApiField("original_amount")
    private String originalAmount;


    @ApiField("original_rate")
    private String originalRate;


    @ApiField("reduce_to_amount")
    private String reduceToAmount;


    @ApiField("rounding_rule")
    private String roundingRule;


    @ApiField("threshold_amount")
    private String thresholdAmount;


    @ApiField("threshold_quantity")
    private String thresholdQuantity;


    @ApiField("valid_period")
    private Long validPeriod;


    @ApiField("value_amount")
    private String valueAmount;


    @ApiField("voucher_desc")
    private String voucherDesc;


    @ApiField("voucher_type")
    private String voucherType;


    public Long getDelayMinute() {
        /* 113 */
        return this.delayMinute;

    }


    public void setDelayMinute(Long delayMinute) {
        /* 116 */
        this.delayMinute = delayMinute;

    }


    public List<AlipayDataItemDescription> getDescDetails() {
        /* 120 */
        return this.descDetails;

    }


    public void setDescDetails(List<AlipayDataItemDescription> descDetails) {
        /* 123 */
        this.descDetails = descDetails;

    }


    public String getDiscountRate() {
        /* 127 */
        return this.discountRate;

    }


    public void setDiscountRate(String discountRate) {
        /* 130 */
        this.discountRate = discountRate;

    }


    public AlipayDataItemGoodsList getExternalGoodsList() {
        /* 134 */
        return this.externalGoodsList;

    }


    public void setExternalGoodsList(AlipayDataItemGoodsList externalGoodsList) {
        /* 137 */
        this.externalGoodsList = externalGoodsList;

    }


    public AlipayDataItemLimitPeriodInfo getLimitPeriodInfoList() {
        /* 141 */
        return this.limitPeriodInfoList;

    }


    public void setLimitPeriodInfoList(AlipayDataItemLimitPeriodInfo limitPeriodInfoList) {
        /* 144 */
        this.limitPeriodInfoList = limitPeriodInfoList;

    }


    public String getOriginalAmount() {
        /* 148 */
        return this.originalAmount;

    }


    public void setOriginalAmount(String originalAmount) {
        /* 151 */
        this.originalAmount = originalAmount;

    }


    public String getOriginalRate() {
        /* 155 */
        return this.originalRate;

    }


    public void setOriginalRate(String originalRate) {
        /* 158 */
        this.originalRate = originalRate;

    }


    public String getReduceToAmount() {
        /* 162 */
        return this.reduceToAmount;

    }


    public void setReduceToAmount(String reduceToAmount) {
        /* 165 */
        this.reduceToAmount = reduceToAmount;

    }


    public String getRoundingRule() {
        /* 169 */
        return this.roundingRule;

    }


    public void setRoundingRule(String roundingRule) {
        /* 172 */
        this.roundingRule = roundingRule;

    }


    public String getThresholdAmount() {
        /* 176 */
        return this.thresholdAmount;

    }


    public void setThresholdAmount(String thresholdAmount) {
        /* 179 */
        this.thresholdAmount = thresholdAmount;

    }


    public String getThresholdQuantity() {
        /* 183 */
        return this.thresholdQuantity;

    }


    public void setThresholdQuantity(String thresholdQuantity) {
        /* 186 */
        this.thresholdQuantity = thresholdQuantity;

    }


    public Long getValidPeriod() {
        /* 190 */
        return this.validPeriod;

    }


    public void setValidPeriod(Long validPeriod) {
        /* 193 */
        this.validPeriod = validPeriod;

    }


    public String getValueAmount() {
        /* 197 */
        return this.valueAmount;

    }


    public void setValueAmount(String valueAmount) {
        /* 200 */
        this.valueAmount = valueAmount;

    }


    public String getVoucherDesc() {
        /* 204 */
        return this.voucherDesc;

    }


    public void setVoucherDesc(String voucherDesc) {
        /* 207 */
        this.voucherDesc = voucherDesc;

    }


    public String getVoucherType() {
        /* 211 */
        return this.voucherType;

    }


    public void setVoucherType(String voucherType) {
        /* 214 */
        this.voucherType = voucherType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayDataItemVoucherTemplete
 * JD-Core Version:    0.6.0
 */