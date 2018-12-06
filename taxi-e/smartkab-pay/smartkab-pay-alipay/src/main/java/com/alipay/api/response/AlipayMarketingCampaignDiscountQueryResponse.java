package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.*;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayMarketingCampaignDiscountQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6188629134554418549L;


    @ApiField("camp_code")
    private String campCode;


    @ApiField("camp_desc")
    private String campDesc;


    @ApiField("camp_id")
    private String campId;


    @ApiField("camp_name")
    private String campName;


    @ApiField("camp_slogan")
    private String campSlogan;


    @ApiField("camp_status")
    private String campStatus;


    @ApiField("discount_dst_camp_prize_model")
    private DiscountDstCampPrizeModel discountDstCampPrizeModel;


    @ApiField("dst_camp_rule_model")
    private DstCampRuleModel dstCampRuleModel;


    @ApiListField("dst_camp_sub_time_model_list")

    @ApiField("date_area_model")
    private List<DateAreaModel> dstCampSubTimeModelList;


    @ApiField("gmt_end")
    private String gmtEnd;


    @ApiField("gmt_start")
    private String gmtStart;


    @ApiField("prize_type")
    private String prizeType;


    @ApiField("random_discount_dst_camp_prize_model")
    private RandomDiscountDstCampPrizeModel randomDiscountDstCampPrizeModel;


    @ApiField("reduce_dst_camp_prize_model")
    private ReduceDstCampPrizeModel reduceDstCampPrizeModel;


    @ApiField("reduce_to_discount_dst_camp_prize_model")
    private ReduceToDiscountDstCampPrizeModel reduceToDiscountDstCampPrizeModel;


    @ApiField("reset_zero_dst_camp_prize_model")
    private ResetZeroDstCampPrizeModel resetZeroDstCampPrizeModel;


    @ApiField("single_dst_camp_prize_model")
    private SingleDstCampPrizeModel singleDstCampPrizeModel;


    @ApiField("staged_discount_dst_camp_prize_model")
    private StagedDiscountDstCampPrizeModel stagedDiscountDstCampPrizeModel;


    public String getCampCode() {
        /* 149 */
        return this.campCode;

    }


    public void setCampCode(String campCode) {
        /* 146 */
        this.campCode = campCode;

    }


    public String getCampDesc() {
        /* 156 */
        return this.campDesc;

    }


    public void setCampDesc(String campDesc) {
        /* 153 */
        this.campDesc = campDesc;

    }


    public String getCampId() {
        /* 163 */
        return this.campId;

    }


    public void setCampId(String campId) {
        /* 160 */
        this.campId = campId;

    }


    public String getCampName() {
        /* 170 */
        return this.campName;

    }


    public void setCampName(String campName) {
        /* 167 */
        this.campName = campName;

    }


    public String getCampSlogan() {
        /* 177 */
        return this.campSlogan;

    }


    public void setCampSlogan(String campSlogan) {
        /* 174 */
        this.campSlogan = campSlogan;

    }


    public String getCampStatus() {
        /* 184 */
        return this.campStatus;

    }


    public void setCampStatus(String campStatus) {
        /* 181 */
        this.campStatus = campStatus;

    }


    public DiscountDstCampPrizeModel getDiscountDstCampPrizeModel() {
        /* 191 */
        return this.discountDstCampPrizeModel;

    }


    public void setDiscountDstCampPrizeModel(DiscountDstCampPrizeModel discountDstCampPrizeModel) {
        /* 188 */
        this.discountDstCampPrizeModel = discountDstCampPrizeModel;

    }


    public DstCampRuleModel getDstCampRuleModel() {
        /* 198 */
        return this.dstCampRuleModel;

    }


    public void setDstCampRuleModel(DstCampRuleModel dstCampRuleModel) {
        /* 195 */
        this.dstCampRuleModel = dstCampRuleModel;

    }


    public List<DateAreaModel> getDstCampSubTimeModelList() {
        /* 205 */
        return this.dstCampSubTimeModelList;

    }


    public void setDstCampSubTimeModelList(List<DateAreaModel> dstCampSubTimeModelList) {
        /* 202 */
        this.dstCampSubTimeModelList = dstCampSubTimeModelList;

    }


    public String getGmtEnd() {
        /* 212 */
        return this.gmtEnd;

    }


    public void setGmtEnd(String gmtEnd) {
        /* 209 */
        this.gmtEnd = gmtEnd;

    }


    public String getGmtStart() {
        /* 219 */
        return this.gmtStart;

    }


    public void setGmtStart(String gmtStart) {
        /* 216 */
        this.gmtStart = gmtStart;

    }


    public String getPrizeType() {
        /* 226 */
        return this.prizeType;

    }


    public void setPrizeType(String prizeType) {
        /* 223 */
        this.prizeType = prizeType;

    }


    public RandomDiscountDstCampPrizeModel getRandomDiscountDstCampPrizeModel() {
        /* 233 */
        return this.randomDiscountDstCampPrizeModel;

    }


    public void setRandomDiscountDstCampPrizeModel(RandomDiscountDstCampPrizeModel randomDiscountDstCampPrizeModel) {
        /* 230 */
        this.randomDiscountDstCampPrizeModel = randomDiscountDstCampPrizeModel;

    }


    public ReduceDstCampPrizeModel getReduceDstCampPrizeModel() {
        /* 240 */
        return this.reduceDstCampPrizeModel;

    }


    public void setReduceDstCampPrizeModel(ReduceDstCampPrizeModel reduceDstCampPrizeModel) {
        /* 237 */
        this.reduceDstCampPrizeModel = reduceDstCampPrizeModel;

    }


    public ReduceToDiscountDstCampPrizeModel getReduceToDiscountDstCampPrizeModel() {
        /* 247 */
        return this.reduceToDiscountDstCampPrizeModel;

    }


    public void setReduceToDiscountDstCampPrizeModel(ReduceToDiscountDstCampPrizeModel reduceToDiscountDstCampPrizeModel) {
        /* 244 */
        this.reduceToDiscountDstCampPrizeModel = reduceToDiscountDstCampPrizeModel;

    }


    public ResetZeroDstCampPrizeModel getResetZeroDstCampPrizeModel() {
        /* 254 */
        return this.resetZeroDstCampPrizeModel;

    }


    public void setResetZeroDstCampPrizeModel(ResetZeroDstCampPrizeModel resetZeroDstCampPrizeModel) {
        /* 251 */
        this.resetZeroDstCampPrizeModel = resetZeroDstCampPrizeModel;

    }


    public SingleDstCampPrizeModel getSingleDstCampPrizeModel() {
        /* 261 */
        return this.singleDstCampPrizeModel;

    }


    public void setSingleDstCampPrizeModel(SingleDstCampPrizeModel singleDstCampPrizeModel) {
        /* 258 */
        this.singleDstCampPrizeModel = singleDstCampPrizeModel;

    }


    public StagedDiscountDstCampPrizeModel getStagedDiscountDstCampPrizeModel() {
        /* 268 */
        return this.stagedDiscountDstCampPrizeModel;

    }


    public void setStagedDiscountDstCampPrizeModel(StagedDiscountDstCampPrizeModel stagedDiscountDstCampPrizeModel) {
        /* 265 */
        this.stagedDiscountDstCampPrizeModel = stagedDiscountDstCampPrizeModel;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignDiscountQueryResponse
 * JD-Core Version:    0.6.0
 */