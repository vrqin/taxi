package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayEcoMycarStoreProductNotifyModel extends AlipayObject {
    private static final long serialVersionUID = 1161498537768331369L;


    @ApiField("biz_status")
    private String bizStatus;


    @ApiField("biz_status_txt")
    private String bizStatusTxt;


    @ApiField("ext_param")
    private String extParam;


    @ApiField("out_order_no")
    private String outOrderNo;


    @ApiField("subject")
    private String subject;


    @ApiField("summary")
    private String summary;


    @ApiField("total_fee")
    private String totalFee;


    @ApiField("user_id")
    private String userId;


    public String getBizStatus() {
        /*  67 */
        return this.bizStatus;

    }


    public void setBizStatus(String bizStatus) {
        /*  70 */
        this.bizStatus = bizStatus;

    }


    public String getBizStatusTxt() {
        /*  74 */
        return this.bizStatusTxt;

    }


    public void setBizStatusTxt(String bizStatusTxt) {
        /*  77 */
        this.bizStatusTxt = bizStatusTxt;

    }


    public String getExtParam() {
        /*  81 */
        return this.extParam;

    }


    public void setExtParam(String extParam) {
        /*  84 */
        this.extParam = extParam;

    }


    public String getOutOrderNo() {
        /*  88 */
        return this.outOrderNo;

    }


    public void setOutOrderNo(String outOrderNo) {
        /*  91 */
        this.outOrderNo = outOrderNo;

    }


    public String getSubject() {
        /*  95 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /*  98 */
        this.subject = subject;

    }


    public String getSummary() {
        /* 102 */
        return this.summary;

    }


    public void setSummary(String summary) {
        /* 105 */
        this.summary = summary;

    }


    public String getTotalFee() {
        /* 109 */
        return this.totalFee;

    }


    public void setTotalFee(String totalFee) {
        /* 112 */
        this.totalFee = totalFee;

    }


    public String getUserId() {
        /* 116 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 119 */
        this.userId = userId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarStoreProductNotifyModel
 * JD-Core Version:    0.6.0
 */