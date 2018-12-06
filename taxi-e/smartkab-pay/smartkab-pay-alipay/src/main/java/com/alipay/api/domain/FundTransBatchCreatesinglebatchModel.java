package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class FundTransBatchCreatesinglebatchModel extends AlipayObject {
    private static final long serialVersionUID = 8781138716652169234L;


    @ApiField("batch_memo")
    private String batchMemo;


    @ApiField("biz_type")
    private String bizType;


    @ApiField("create_user_id")
    private String createUserId;


    @ApiField("ext_param")
    private String extParam;


    @ApiField("pay_amount_single")
    private String payAmountSingle;


    @ApiField("pay_amount_total")
    private String payAmountTotal;


    @ApiField("real_items_total")
    private String realItemsTotal;


    @ApiField("show_items_total")
    private String showItemsTotal;


    public String getBatchMemo() {
        /*  65 */
        return this.batchMemo;

    }


    public void setBatchMemo(String batchMemo) {
        /*  68 */
        this.batchMemo = batchMemo;

    }


    public String getBizType() {
        /*  72 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /*  75 */
        this.bizType = bizType;

    }


    public String getCreateUserId() {
        /*  79 */
        return this.createUserId;

    }


    public void setCreateUserId(String createUserId) {
        /*  82 */
        this.createUserId = createUserId;

    }


    public String getExtParam() {
        /*  86 */
        return this.extParam;

    }


    public void setExtParam(String extParam) {
        /*  89 */
        this.extParam = extParam;

    }


    public String getPayAmountSingle() {
        /*  93 */
        return this.payAmountSingle;

    }


    public void setPayAmountSingle(String payAmountSingle) {
        /*  96 */
        this.payAmountSingle = payAmountSingle;

    }


    public String getPayAmountTotal() {
        /* 100 */
        return this.payAmountTotal;

    }


    public void setPayAmountTotal(String payAmountTotal) {
        /* 103 */
        this.payAmountTotal = payAmountTotal;

    }


    public String getRealItemsTotal() {
        /* 107 */
        return this.realItemsTotal;

    }


    public void setRealItemsTotal(String realItemsTotal) {
        /* 110 */
        this.realItemsTotal = realItemsTotal;

    }


    public String getShowItemsTotal() {
        /* 114 */
        return this.showItemsTotal;

    }


    public void setShowItemsTotal(String showItemsTotal) {
        /* 117 */
        this.showItemsTotal = showItemsTotal;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.FundTransBatchCreatesinglebatchModel
 * JD-Core Version:    0.6.0
 */