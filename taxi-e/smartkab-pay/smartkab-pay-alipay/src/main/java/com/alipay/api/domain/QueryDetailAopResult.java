package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class QueryDetailAopResult extends AlipayObject {
    private static final long serialVersionUID = 6462959274281783852L;


    @ApiField("batch_no")
    private String batchNo;


    @ApiField("detail_no")
    private String detailNo;


    @ApiField("ext_param")
    private String extParam;


    @ApiField("fail_message")
    private String failMessage;


    @ApiField("last_modified")
    private Date lastModified;


    @ApiField("order_no")
    private String orderNo;


    @ApiField("pay_amount")
    private String payAmount;


    @ApiField("payee_id")
    private String payeeId;


    @ApiField("payer_id")
    private String payerId;


    @ApiField("service_charge")
    private String serviceCharge;


    @ApiField("status")
    private String status;


    public String getBatchNo() {
        /*  85 */
        return this.batchNo;

    }


    public void setBatchNo(String batchNo) {
        /*  88 */
        this.batchNo = batchNo;

    }


    public String getDetailNo() {
        /*  92 */
        return this.detailNo;

    }


    public void setDetailNo(String detailNo) {
        /*  95 */
        this.detailNo = detailNo;

    }


    public String getExtParam() {
        /*  99 */
        return this.extParam;

    }


    public void setExtParam(String extParam) {
        /* 102 */
        this.extParam = extParam;

    }


    public String getFailMessage() {
        /* 106 */
        return this.failMessage;

    }


    public void setFailMessage(String failMessage) {
        /* 109 */
        this.failMessage = failMessage;

    }


    public Date getLastModified() {
        /* 113 */
        return this.lastModified;

    }


    public void setLastModified(Date lastModified) {
        /* 116 */
        this.lastModified = lastModified;

    }


    public String getOrderNo() {
        /* 120 */
        return this.orderNo;

    }


    public void setOrderNo(String orderNo) {
        /* 123 */
        this.orderNo = orderNo;

    }


    public String getPayAmount() {
        /* 127 */
        return this.payAmount;

    }


    public void setPayAmount(String payAmount) {
        /* 130 */
        this.payAmount = payAmount;

    }


    public String getPayeeId() {
        /* 134 */
        return this.payeeId;

    }


    public void setPayeeId(String payeeId) {
        /* 137 */
        this.payeeId = payeeId;

    }


    public String getPayerId() {
        /* 141 */
        return this.payerId;

    }


    public void setPayerId(String payerId) {
        /* 144 */
        this.payerId = payerId;

    }


    public String getServiceCharge() {
        /* 148 */
        return this.serviceCharge;

    }


    public void setServiceCharge(String serviceCharge) {
        /* 151 */
        this.serviceCharge = serviceCharge;

    }


    public String getStatus() {
        /* 155 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 158 */
        this.status = status;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.QueryDetailAopResult
 * JD-Core Version:    0.6.0
 */