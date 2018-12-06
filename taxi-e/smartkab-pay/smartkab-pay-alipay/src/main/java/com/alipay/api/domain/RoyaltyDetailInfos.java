package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class RoyaltyDetailInfos extends AlipayObject {
    private static final long serialVersionUID = 1883567881468223841L;


    @ApiField("amount")
    private Long amount;


    @ApiField("amount_percentage")
    private String amountPercentage;


    @ApiField("batch_no")
    private String batchNo;


    @ApiField("desc")
    private String desc;


    @ApiField("out_relation_id")
    private String outRelationId;


    @ApiField("serial_no")
    private Long serialNo;


    @ApiField("trans_in")
    private String transIn;


    @ApiField("trans_in_type")
    private String transInType;


    @ApiField("trans_out")
    private String transOut;


    @ApiField("trans_out_type")
    private String transOutType;


    public Long getAmount() {
        /*  88 */
        return this.amount;

    }


    public void setAmount(Long amount) {
        /*  91 */
        this.amount = amount;

    }


    public String getAmountPercentage() {
        /*  95 */
        return this.amountPercentage;

    }


    public void setAmountPercentage(String amountPercentage) {
        /*  98 */
        this.amountPercentage = amountPercentage;

    }


    public String getBatchNo() {
        /* 102 */
        return this.batchNo;

    }


    public void setBatchNo(String batchNo) {
        /* 105 */
        this.batchNo = batchNo;

    }


    public String getDesc() {
        /* 109 */
        return this.desc;

    }


    public void setDesc(String desc) {
        /* 112 */
        this.desc = desc;

    }


    public String getOutRelationId() {
        /* 116 */
        return this.outRelationId;

    }


    public void setOutRelationId(String outRelationId) {
        /* 119 */
        this.outRelationId = outRelationId;

    }


    public Long getSerialNo() {
        /* 123 */
        return this.serialNo;

    }


    public void setSerialNo(Long serialNo) {
        /* 126 */
        this.serialNo = serialNo;

    }


    public String getTransIn() {
        /* 130 */
        return this.transIn;

    }


    public void setTransIn(String transIn) {
        /* 133 */
        this.transIn = transIn;

    }


    public String getTransInType() {
        /* 137 */
        return this.transInType;

    }


    public void setTransInType(String transInType) {
        /* 140 */
        this.transInType = transInType;

    }


    public String getTransOut() {
        /* 144 */
        return this.transOut;

    }


    public void setTransOut(String transOut) {
        /* 147 */
        this.transOut = transOut;

    }


    public String getTransOutType() {
        /* 151 */
        return this.transOutType;

    }


    public void setTransOutType(String transOutType) {
        /* 154 */
        this.transOutType = transOutType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.RoyaltyDetailInfos
 * JD-Core Version:    0.6.0
 */