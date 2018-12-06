package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayFundTransBatchCreateorderModel extends AlipayObject {
    private static final long serialVersionUID = 8172581177282942462L;

    @ApiField("batch_no")
    private String batchNo;

    @ApiField("ext_param")
    private String extParam;

    @ApiField("pay_amount")
    private String payAmount;

    @ApiField("payee_id")
    private String payeeId;

    @ApiField("payer_id")
    private String payerId;

    @ApiField("token")
    private String token;

    public String getBatchNo() {
        /* 53 */
        return this.batchNo;
    }

    public void setBatchNo(String batchNo) {
        /* 56 */
        this.batchNo = batchNo;
    }

    public String getExtParam() {
        /* 60 */
        return this.extParam;
    }

    public void setExtParam(String extParam) {
        /* 63 */
        this.extParam = extParam;
    }

    public String getPayAmount() {
        /* 67 */
        return this.payAmount;
    }

    public void setPayAmount(String payAmount) {
        /* 70 */
        this.payAmount = payAmount;
    }

    public String getPayeeId() {
        /* 74 */
        return this.payeeId;
    }

    public void setPayeeId(String payeeId) {
        /* 77 */
        this.payeeId = payeeId;
    }

    public String getPayerId() {
        /* 81 */
        return this.payerId;
    }

    public void setPayerId(String payerId) {
        /* 84 */
        this.payerId = payerId;
    }

    public String getToken() {
        /* 88 */
        return this.token;
    }

    public void setToken(String token) {
        /* 91 */
        this.token = token;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayFundTransBatchCreateorderModel
 * JD-Core Version:    0.6.0
 */