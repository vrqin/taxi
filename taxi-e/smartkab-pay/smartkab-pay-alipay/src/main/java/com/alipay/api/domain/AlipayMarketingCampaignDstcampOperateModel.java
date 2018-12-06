package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayMarketingCampaignDstcampOperateModel extends AlipayObject {
    private static final long serialVersionUID = 3479343852264154133L;


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


    @ApiField("operate_type")
    private String operateType;


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
        /* 137 */
        return this.campCode;

    }


    public void setCampCode(String campCode) {
        /* 140 */
        this.campCode = campCode;

    }


    public String getCampDesc() {
        /* 144 */
        return this.campDesc;

    }


    public void setCampDesc(String campDesc) {
        /* 147 */
        this.campDesc = campDesc;

    }


    public String getCampId() {
        /* 151 */
        return this.campId;

    }


    public void setCampId(String campId) {
        /* 154 */
        this.campId = campId;

    }


    public String getCampName() {
        /* 158 */
        return this.campName;

    }


    public void setCampName(String campName) {
        /* 161 */
        this.campName = campName;

    }


    public String getCampSlogan() {
        /* 165 */
        return this.campSlogan;

    }


    public void setCampSlogan(String campSlogan) {
        /* 168 */
        this.campSlogan = campSlogan;

    }


    public DiscountDstCampPrizeModel getDiscountDstCampPrizeModel() {
        /* 172 */
        return this.discountDstCampPrizeModel;

    }


    public void setDiscountDstCampPrizeModel(DiscountDstCampPrizeModel discountDstCampPrizeModel) {
        /* 175 */
        this.discountDstCampPrizeModel = discountDstCampPrizeModel;

    }


    public DstCampRuleModel getDstCampRuleModel() {
        /* 179 */
        return this.dstCampRuleModel;

    }


    public void setDstCampRuleModel(DstCampRuleModel dstCampRuleModel) {
        /* 182 */
        this.dstCampRuleModel = dstCampRuleModel;

    }


    public List<DateAreaModel> getDstCampSubTimeModelList() {
        /* 186 */
        return this.dstCampSubTimeModelList;

    }


    public void setDstCampSubTimeModelList(List<DateAreaModel> dstCampSubTimeModelList) {
        /* 189 */
        this.dstCampSubTimeModelList = dstCampSubTimeModelList;

    }


    public String getGmtEnd() {
        /* 193 */
        return this.gmtEnd;

    }


    public void setGmtEnd(String gmtEnd) {
        /* 196 */
        this.gmtEnd = gmtEnd;

    }


    public String getGmtStart() {
        /* 200 */
        return this.gmtStart;

    }


    public void setGmtStart(String gmtStart) {
        /* 203 */
        this.gmtStart = gmtStart;

    }


    public String getOperateType() {
        /* 207 */
        return this.operateType;

    }


    public void setOperateType(String operateType) {
        /* 210 */
        this.operateType = operateType;

    }


    public String getPrizeType() {
        /* 214 */
        return this.prizeType;

    }


    public void setPrizeType(String prizeType) {
        /* 217 */
        this.prizeType = prizeType;

    }


    public RandomDiscountDstCampPrizeModel getRandomDiscountDstCampPrizeModel() {
        /* 221 */
        return this.randomDiscountDstCampPrizeModel;

    }


    public void setRandomDiscountDstCampPrizeModel(RandomDiscountDstCampPrizeModel randomDiscountDstCampPrizeModel) {
        /* 224 */
        this.randomDiscountDstCampPrizeModel = randomDiscountDstCampPrizeModel;

    }


    public ReduceDstCampPrizeModel getReduceDstCampPrizeModel() {
        /* 228 */
        return this.reduceDstCampPrizeModel;

    }


    public void setReduceDstCampPrizeModel(ReduceDstCampPrizeModel reduceDstCampPrizeModel) {
        /* 231 */
        this.reduceDstCampPrizeModel = reduceDstCampPrizeModel;

    }


    public ReduceToDiscountDstCampPrizeModel getReduceToDiscountDstCampPrizeModel() {
        /* 235 */
        return this.reduceToDiscountDstCampPrizeModel;

    }


    public void setReduceToDiscountDstCampPrizeModel(ReduceToDiscountDstCampPrizeModel reduceToDiscountDstCampPrizeModel) {
        /* 238 */
        this.reduceToDiscountDstCampPrizeModel = reduceToDiscountDstCampPrizeModel;

    }


    public ResetZeroDstCampPrizeModel getResetZeroDstCampPrizeModel() {
        /* 242 */
        return this.resetZeroDstCampPrizeModel;

    }


    public void setResetZeroDstCampPrizeModel(ResetZeroDstCampPrizeModel resetZeroDstCampPrizeModel) {
        /* 245 */
        this.resetZeroDstCampPrizeModel = resetZeroDstCampPrizeModel;

    }


    public SingleDstCampPrizeModel getSingleDstCampPrizeModel() {
        /* 249 */
        return this.singleDstCampPrizeModel;

    }


    public void setSingleDstCampPrizeModel(SingleDstCampPrizeModel singleDstCampPrizeModel) {
        /* 252 */
        this.singleDstCampPrizeModel = singleDstCampPrizeModel;

    }


    public StagedDiscountDstCampPrizeModel getStagedDiscountDstCampPrizeModel() {
        /* 256 */
        return this.stagedDiscountDstCampPrizeModel;

    }


    public void setStagedDiscountDstCampPrizeModel(StagedDiscountDstCampPrizeModel stagedDiscountDstCampPrizeModel) {
        /* 259 */
        this.stagedDiscountDstCampPrizeModel = stagedDiscountDstCampPrizeModel;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignDstcampOperateModel
 * JD-Core Version:    0.6.0
 */