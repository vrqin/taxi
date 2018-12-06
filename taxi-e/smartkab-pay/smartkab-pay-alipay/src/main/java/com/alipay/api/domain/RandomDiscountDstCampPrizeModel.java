package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class RandomDiscountDstCampPrizeModel extends AlipayObject {
    private static final long serialVersionUID = 2294494597523817961L;

    @ApiField("budget_id")
    private String budgetId;

    @ApiListField("discount_random_model_list")
    @ApiField("discount_random_model")
    private List<DiscountRandomModel> discountRandomModelList;

    @ApiField("id")
    private String id;

    @ApiField("max_random_discount_rate")
    private String maxRandomDiscountRate;

    public String getBudgetId() {
        /* 46 */
        return this.budgetId;
    }

    public void setBudgetId(String budgetId) {
        /* 49 */
        this.budgetId = budgetId;
    }

    public List<DiscountRandomModel> getDiscountRandomModelList() {
        /* 53 */
        return this.discountRandomModelList;
    }

    public void setDiscountRandomModelList(List<DiscountRandomModel> discountRandomModelList) {
        /* 56 */
        this.discountRandomModelList = discountRandomModelList;
    }

    public String getId() {
        /* 60 */
        return this.id;
    }

    public void setId(String id) {
        /* 63 */
        this.id = id;
    }

    public String getMaxRandomDiscountRate() {
        /* 67 */
        return this.maxRandomDiscountRate;
    }

    public void setMaxRandomDiscountRate(String maxRandomDiscountRate) {
        /* 70 */
        this.maxRandomDiscountRate = maxRandomDiscountRate;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.RandomDiscountDstCampPrizeModel
 * JD-Core Version:    0.6.0
 */