package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class AlipayOfflineTrade extends AlipayObject {
    private static final long serialVersionUID = 4883421136571125644L;


    @ApiField("actual_order_time")
    private Date actualOrderTime;


    @ApiField("amount")
    private String amount;


    @ApiField("order_biz_context")
    private String orderBizContext;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiListField("records")

    @ApiField("string")
    private List<String> records;


    @ApiField("seller_login_name")
    private String sellerLoginName;


    @ApiField("subject")
    private String subject;


    @ApiField("user_id")
    private String userId;


    public Date getActualOrderTime() {
        /*  70 */
        return this.actualOrderTime;

    }


    public void setActualOrderTime(Date actualOrderTime) {
        /*  73 */
        this.actualOrderTime = actualOrderTime;

    }


    public String getAmount() {
        /*  77 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /*  80 */
        this.amount = amount;

    }


    public String getOrderBizContext() {
        /*  84 */
        return this.orderBizContext;

    }


    public void setOrderBizContext(String orderBizContext) {
        /*  87 */
        this.orderBizContext = orderBizContext;

    }


    public String getOutTradeNo() {
        /*  91 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /*  94 */
        this.outTradeNo = outTradeNo;

    }


    public List<String> getRecords() {
        /*  98 */
        return this.records;

    }


    public void setRecords(List<String> records) {
        /* 101 */
        this.records = records;

    }


    public String getSellerLoginName() {
        /* 105 */
        return this.sellerLoginName;

    }


    public void setSellerLoginName(String sellerLoginName) {
        /* 108 */
        this.sellerLoginName = sellerLoginName;

    }


    public String getSubject() {
        /* 112 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /* 115 */
        this.subject = subject;

    }


    public String getUserId() {
        /* 119 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 122 */
        this.userId = userId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineTrade
 * JD-Core Version:    0.6.0
 */