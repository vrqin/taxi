package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class BatchFundItemAOPModel extends AlipayObject {
    private static final long serialVersionUID = 1635895879565928415L;


    @ApiField("batch_no")
    private Long batchNo;


    @ApiField("dback_refundtobank_processing_batch_amount")
    private String dbackRefundtobankProcessingBatchAmount;


    @ApiField("dback_refundtobank_success_batch_amount")
    private String dbackRefundtobankSuccessBatchAmount;


    @ApiListField("fund_item_list")

    @ApiField("fund_item_a_o_p_model")
    private List<FundItemAOPModel> fundItemList;


    @ApiField("gmt_biz_create_date")
    private Date gmtBizCreateDate;


    @ApiField("order_id")
    private String orderId;


    @ApiField("total_amount")
    private String totalAmount;


    @ApiField("total_amount_with_service_fee")
    private String totalAmountWithServiceFee;


    public Long getBatchNo() {
        /*  70 */
        return this.batchNo;

    }


    public void setBatchNo(Long batchNo) {
        /*  73 */
        this.batchNo = batchNo;

    }


    public String getDbackRefundtobankProcessingBatchAmount() {
        /*  77 */
        return this.dbackRefundtobankProcessingBatchAmount;

    }


    public void setDbackRefundtobankProcessingBatchAmount(String dbackRefundtobankProcessingBatchAmount) {
        /*  80 */
        this.dbackRefundtobankProcessingBatchAmount = dbackRefundtobankProcessingBatchAmount;

    }


    public String getDbackRefundtobankSuccessBatchAmount() {
        /*  84 */
        return this.dbackRefundtobankSuccessBatchAmount;

    }


    public void setDbackRefundtobankSuccessBatchAmount(String dbackRefundtobankSuccessBatchAmount) {
        /*  87 */
        this.dbackRefundtobankSuccessBatchAmount = dbackRefundtobankSuccessBatchAmount;

    }


    public List<FundItemAOPModel> getFundItemList() {
        /*  91 */
        return this.fundItemList;

    }


    public void setFundItemList(List<FundItemAOPModel> fundItemList) {
        /*  94 */
        this.fundItemList = fundItemList;

    }


    public Date getGmtBizCreateDate() {
        /*  98 */
        return this.gmtBizCreateDate;

    }


    public void setGmtBizCreateDate(Date gmtBizCreateDate) {
        /* 101 */
        this.gmtBizCreateDate = gmtBizCreateDate;

    }


    public String getOrderId() {
        /* 105 */
        return this.orderId;

    }


    public void setOrderId(String orderId) {
        /* 108 */
        this.orderId = orderId;

    }


    public String getTotalAmount() {
        /* 112 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 115 */
        this.totalAmount = totalAmount;

    }


    public String getTotalAmountWithServiceFee() {
        /* 119 */
        return this.totalAmountWithServiceFee;

    }


    public void setTotalAmountWithServiceFee(String totalAmountWithServiceFee) {
        /* 122 */
        this.totalAmountWithServiceFee = totalAmountWithServiceFee;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.BatchFundItemAOPModel
 * JD-Core Version:    0.6.0
 */