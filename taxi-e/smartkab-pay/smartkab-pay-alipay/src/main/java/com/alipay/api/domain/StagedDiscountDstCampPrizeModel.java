package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class StagedDiscountDstCampPrizeModel extends AlipayObject {
    private static final long serialVersionUID = 2786586899252652215L;

    @ApiField("budget_id")
    private String budgetId;

    @ApiListField("discount_rate_model_list")
    @ApiField("discount_rate_model")
    private List<DiscountRateModel> discountRateModelList;

    @ApiField("id")
    private String id;

    @ApiField("max_discount_amt")
    private String maxDiscountAmt;

    public String getBudgetId() {
        /* 45 */
        return this.budgetId;
    }

    public void setBudgetId(String budgetId) {
        /* 48 */
        this.budgetId = budgetId;
    }

    public List<DiscountRateModel> getDiscountRateModelList() {
        /* 52 */
        return this.discountRateModelList;
    }

    public void setDiscountRateModelList(List<DiscountRateModel> discountRateModelList) {
        /* 55 */
        this.discountRateModelList = discountRateModelList;
    }

    public String getId() {
        /* 59 */
        return this.id;
    }

    public void setId(String id) {
        /* 62 */
        this.id = id;
    }

    public String getMaxDiscountAmt() {
        /* 66 */
        return this.maxDiscountAmt;
    }

    public void setMaxDiscountAmt(String maxDiscountAmt) {
        /* 69 */
        this.maxDiscountAmt = maxDiscountAmt;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.StagedDiscountDstCampPrizeModel
 * JD-Core Version:    0.6.0
 */