package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class SingleFundDetailItemAOPModel extends AlipayObject {
    private static final long serialVersionUID = 1656446775832943659L;

    @ApiListField("batch_fund_item_model_list")
    @ApiField("batch_fund_item_a_o_p_model")
    private List<BatchFundItemAOPModel> batchFundItemModelList;

    @ApiField("consume_record")
    private ConsumeRecordAOPModel consumeRecord;

    public List<BatchFundItemAOPModel> getBatchFundItemModelList() {
        /* 33 */
        return this.batchFundItemModelList;
    }

    public void setBatchFundItemModelList(List<BatchFundItemAOPModel> batchFundItemModelList) {
        /* 36 */
        this.batchFundItemModelList = batchFundItemModelList;
    }

    public ConsumeRecordAOPModel getConsumeRecord() {
        /* 40 */
        return this.consumeRecord;
    }

    public void setConsumeRecord(ConsumeRecordAOPModel consumeRecord) {
        /* 43 */
        this.consumeRecord = consumeRecord;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.SingleFundDetailItemAOPModel
 * JD-Core Version:    0.6.0
 */