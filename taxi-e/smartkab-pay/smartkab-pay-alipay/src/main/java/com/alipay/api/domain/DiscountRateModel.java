package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class DiscountRateModel extends AlipayObject {
    private static final long serialVersionUID = 3282823731921585338L;


    @ApiField("discount_dst_camp_prize_model")
    private DiscountDstCampPrizeModel discountDstCampPrizeModel;


    @ApiField("lower_trade_fee")
    private String lowerTradeFee;


    @ApiField("prize_type")
    private String prizeType;


    @ApiField("reduce_dst_camp_prize_model")
    private ReduceDstCampPrizeModel reduceDstCampPrizeModel;


    @ApiField("reduce_to_amt_dst_camp_prize_model")
    private ReduceToAmtDstCampPrizeModel reduceToAmtDstCampPrizeModel;


    @ApiField("single_dst_camp_prize_model")
    private SingleDstCampPrizeModel singleDstCampPrizeModel;


    @ApiField("upper_trade_fee")
    private String upperTradeFee;


    public DiscountDstCampPrizeModel getDiscountDstCampPrizeModel() {
        /*  64 */
        return this.discountDstCampPrizeModel;

    }


    public void setDiscountDstCampPrizeModel(DiscountDstCampPrizeModel discountDstCampPrizeModel) {
        /*  67 */
        this.discountDstCampPrizeModel = discountDstCampPrizeModel;

    }


    public String getLowerTradeFee() {
        /*  71 */
        return this.lowerTradeFee;

    }


    public void setLowerTradeFee(String lowerTradeFee) {
        /*  74 */
        this.lowerTradeFee = lowerTradeFee;

    }


    public String getPrizeType() {
        /*  78 */
        return this.prizeType;

    }


    public void setPrizeType(String prizeType) {
        /*  81 */
        this.prizeType = prizeType;

    }


    public ReduceDstCampPrizeModel getReduceDstCampPrizeModel() {
        /*  85 */
        return this.reduceDstCampPrizeModel;

    }


    public void setReduceDstCampPrizeModel(ReduceDstCampPrizeModel reduceDstCampPrizeModel) {
        /*  88 */
        this.reduceDstCampPrizeModel = reduceDstCampPrizeModel;

    }


    public ReduceToAmtDstCampPrizeModel getReduceToAmtDstCampPrizeModel() {
        /*  92 */
        return this.reduceToAmtDstCampPrizeModel;

    }


    public void setReduceToAmtDstCampPrizeModel(ReduceToAmtDstCampPrizeModel reduceToAmtDstCampPrizeModel) {
        /*  95 */
        this.reduceToAmtDstCampPrizeModel = reduceToAmtDstCampPrizeModel;

    }


    public SingleDstCampPrizeModel getSingleDstCampPrizeModel() {
        /*  99 */
        return this.singleDstCampPrizeModel;

    }


    public void setSingleDstCampPrizeModel(SingleDstCampPrizeModel singleDstCampPrizeModel) {
        /* 102 */
        this.singleDstCampPrizeModel = singleDstCampPrizeModel;

    }


    public String getUpperTradeFee() {
        /* 106 */
        return this.upperTradeFee;

    }


    public void setUpperTradeFee(String upperTradeFee) {
        /* 109 */
        this.upperTradeFee = upperTradeFee;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DiscountRateModel
 * JD-Core Version:    0.6.0
 */