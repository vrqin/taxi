package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class FundDetailItemAOPModel extends AlipayObject {
    private static final long serialVersionUID = 4274223578526169124L;

    @ApiListField("single_fund_detail_item_aopmodel_list")
    @ApiField("single_fund_detail_item_a_o_p_model")
    private List<SingleFundDetailItemAOPModel> singleFundDetailItemAopmodelList;

    public List<SingleFundDetailItemAOPModel> getSingleFundDetailItemAopmodelList() {
        /* 27 */
        return this.singleFundDetailItemAopmodelList;
    }

    public void setSingleFundDetailItemAopmodelList(List<SingleFundDetailItemAOPModel> singleFundDetailItemAopmodelList) {
        /* 30 */
        this.singleFundDetailItemAopmodelList = singleFundDetailItemAopmodelList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.FundDetailItemAOPModel
 * JD-Core Version:    0.6.0
 */