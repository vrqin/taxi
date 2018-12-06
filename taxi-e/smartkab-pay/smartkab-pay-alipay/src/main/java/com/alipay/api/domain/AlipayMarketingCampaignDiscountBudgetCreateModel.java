package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayMarketingCampaignDiscountBudgetCreateModel extends AlipayObject {
    private static final long serialVersionUID = 7616782598479441581L;


    @ApiField("biz_from")
    private String bizFrom;


    @ApiField("gmt_end")
    private String gmtEnd;


    @ApiField("name")
    private String name;


    @ApiField("out_biz_no")
    private String outBizNo;


    @ApiField("out_budget_no")
    private String outBudgetNo;


    @ApiField("publisher_logon_id")
    private String publisherLogonId;


    @ApiField("total_amount")
    private String totalAmount;


    public String getBizFrom() {
        /*  59 */
        return this.bizFrom;

    }


    public void setBizFrom(String bizFrom) {
        /*  62 */
        this.bizFrom = bizFrom;

    }


    public String getGmtEnd() {
        /*  66 */
        return this.gmtEnd;

    }


    public void setGmtEnd(String gmtEnd) {
        /*  69 */
        this.gmtEnd = gmtEnd;

    }


    public String getName() {
        /*  73 */
        return this.name;

    }


    public void setName(String name) {
        /*  76 */
        this.name = name;

    }


    public String getOutBizNo() {
        /*  80 */
        return this.outBizNo;

    }


    public void setOutBizNo(String outBizNo) {
        /*  83 */
        this.outBizNo = outBizNo;

    }


    public String getOutBudgetNo() {
        /*  87 */
        return this.outBudgetNo;

    }


    public void setOutBudgetNo(String outBudgetNo) {
        /*  90 */
        this.outBudgetNo = outBudgetNo;

    }


    public String getPublisherLogonId() {
        /*  94 */
        return this.publisherLogonId;

    }


    public void setPublisherLogonId(String publisherLogonId) {
        /*  97 */
        this.publisherLogonId = publisherLogonId;

    }


    public String getTotalAmount() {
        /* 101 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 104 */
        this.totalAmount = totalAmount;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignDiscountBudgetCreateModel
 * JD-Core Version:    0.6.0
 */