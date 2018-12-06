package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class OpenPromoPrize extends AlipayObject {
    private static final long serialVersionUID = 1224195656595257657L;


    @ApiField("prize_base_rule_amount")
    private String prizeBaseRuleAmount;


    @ApiListField("prize_custom_menu")

    @ApiField("prize_custom_menu")
    private List<PrizeCustomMenu> prizeCustomMenu;


    @ApiField("prize_desc")
    private String prizeDesc;


    @ApiField("prize_detail_img")
    private String prizeDetailImg;


    @ApiListField("prize_dimension_time")

    @ApiField("open_promo_prize_dimension")
    private List<OpenPromoPrizeDimension> prizeDimensionTime;


    @ApiField("prize_end_time")
    private String prizeEndTime;


    @ApiField("prize_logo")
    private String prizeLogo;


    @ApiField("prize_name")
    private String prizeName;


    @ApiField("prize_relative_time")
    private OpenPromoPrizeRelativeTime prizeRelativeTime;


    @ApiField("prize_start_time")
    private String prizeStartTime;


    @ApiField("prize_subtitle")
    private String prizeSubtitle;


    @ApiListField("prize_suitable_shops")

    @ApiField("string")
    private List<String> prizeSuitableShops;


    @ApiField("prize_template_end_time")
    private String prizeTemplateEndTime;


    @ApiField("prize_template_start_time")
    private String prizeTemplateStartTime;


    @ApiListField("prize_terms")

    @ApiField("string")
    private List<String> prizeTerms;


    @ApiField("prize_type")
    private String prizeType;


    @ApiField("prize_worth_amount")
    private String prizeWorthAmount;


    public String getPrizeBaseRuleAmount() {
        /* 126 */
        return this.prizeBaseRuleAmount;

    }


    public void setPrizeBaseRuleAmount(String prizeBaseRuleAmount) {
        /* 129 */
        this.prizeBaseRuleAmount = prizeBaseRuleAmount;

    }


    public List<PrizeCustomMenu> getPrizeCustomMenu() {
        /* 133 */
        return this.prizeCustomMenu;

    }


    public void setPrizeCustomMenu(List<PrizeCustomMenu> prizeCustomMenu) {
        /* 136 */
        this.prizeCustomMenu = prizeCustomMenu;

    }


    public String getPrizeDesc() {
        /* 140 */
        return this.prizeDesc;

    }


    public void setPrizeDesc(String prizeDesc) {
        /* 143 */
        this.prizeDesc = prizeDesc;

    }


    public String getPrizeDetailImg() {
        /* 147 */
        return this.prizeDetailImg;

    }


    public void setPrizeDetailImg(String prizeDetailImg) {
        /* 150 */
        this.prizeDetailImg = prizeDetailImg;

    }


    public List<OpenPromoPrizeDimension> getPrizeDimensionTime() {
        /* 154 */
        return this.prizeDimensionTime;

    }


    public void setPrizeDimensionTime(List<OpenPromoPrizeDimension> prizeDimensionTime) {
        /* 157 */
        this.prizeDimensionTime = prizeDimensionTime;

    }


    public String getPrizeEndTime() {
        /* 161 */
        return this.prizeEndTime;

    }


    public void setPrizeEndTime(String prizeEndTime) {
        /* 164 */
        this.prizeEndTime = prizeEndTime;

    }


    public String getPrizeLogo() {
        /* 168 */
        return this.prizeLogo;

    }


    public void setPrizeLogo(String prizeLogo) {
        /* 171 */
        this.prizeLogo = prizeLogo;

    }


    public String getPrizeName() {
        /* 175 */
        return this.prizeName;

    }


    public void setPrizeName(String prizeName) {
        /* 178 */
        this.prizeName = prizeName;

    }


    public OpenPromoPrizeRelativeTime getPrizeRelativeTime() {
        /* 182 */
        return this.prizeRelativeTime;

    }


    public void setPrizeRelativeTime(OpenPromoPrizeRelativeTime prizeRelativeTime) {
        /* 185 */
        this.prizeRelativeTime = prizeRelativeTime;

    }


    public String getPrizeStartTime() {
        /* 189 */
        return this.prizeStartTime;

    }


    public void setPrizeStartTime(String prizeStartTime) {
        /* 192 */
        this.prizeStartTime = prizeStartTime;

    }


    public String getPrizeSubtitle() {
        /* 196 */
        return this.prizeSubtitle;

    }


    public void setPrizeSubtitle(String prizeSubtitle) {
        /* 199 */
        this.prizeSubtitle = prizeSubtitle;

    }


    public List<String> getPrizeSuitableShops() {
        /* 203 */
        return this.prizeSuitableShops;

    }


    public void setPrizeSuitableShops(List<String> prizeSuitableShops) {
        /* 206 */
        this.prizeSuitableShops = prizeSuitableShops;

    }


    public String getPrizeTemplateEndTime() {
        /* 210 */
        return this.prizeTemplateEndTime;

    }


    public void setPrizeTemplateEndTime(String prizeTemplateEndTime) {
        /* 213 */
        this.prizeTemplateEndTime = prizeTemplateEndTime;

    }


    public String getPrizeTemplateStartTime() {
        /* 217 */
        return this.prizeTemplateStartTime;

    }


    public void setPrizeTemplateStartTime(String prizeTemplateStartTime) {
        /* 220 */
        this.prizeTemplateStartTime = prizeTemplateStartTime;

    }


    public List<String> getPrizeTerms() {
        /* 224 */
        return this.prizeTerms;

    }


    public void setPrizeTerms(List<String> prizeTerms) {
        /* 227 */
        this.prizeTerms = prizeTerms;

    }


    public String getPrizeType() {
        /* 231 */
        return this.prizeType;

    }


    public void setPrizeType(String prizeType) {
        /* 234 */
        this.prizeType = prizeType;

    }


    public String getPrizeWorthAmount() {
        /* 238 */
        return this.prizeWorthAmount;

    }


    public void setPrizeWorthAmount(String prizeWorthAmount) {
        /* 241 */
        this.prizeWorthAmount = prizeWorthAmount;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OpenPromoPrize
 * JD-Core Version:    0.6.0
 */