package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class InsClaim extends AlipayObject {
    private static final long serialVersionUID = 5224447766195745471L;


    @ApiField("biz_data")
    private String bizData;


    @ApiField("claim_fee")
    private Long claimFee;


    @ApiField("claim_no")
    private String claimNo;


    @ApiField("claim_pay_time")
    private Date claimPayTime;


    @ApiListField("claim_progress")

    @ApiField("claim_progress")
    private List<ClaimProgress> claimProgress;


    @ApiField("claim_status")
    private String claimStatus;


    @ApiField("out_request_no")
    private String outRequestNo;


    public String getBizData() {
        /*  64 */
        return this.bizData;

    }


    public void setBizData(String bizData) {
        /*  67 */
        this.bizData = bizData;

    }


    public Long getClaimFee() {
        /*  71 */
        return this.claimFee;

    }


    public void setClaimFee(Long claimFee) {
        /*  74 */
        this.claimFee = claimFee;

    }


    public String getClaimNo() {
        /*  78 */
        return this.claimNo;

    }


    public void setClaimNo(String claimNo) {
        /*  81 */
        this.claimNo = claimNo;

    }


    public Date getClaimPayTime() {
        /*  85 */
        return this.claimPayTime;

    }


    public void setClaimPayTime(Date claimPayTime) {
        /*  88 */
        this.claimPayTime = claimPayTime;

    }


    public List<ClaimProgress> getClaimProgress() {
        /*  92 */
        return this.claimProgress;

    }


    public void setClaimProgress(List<ClaimProgress> claimProgress) {
        /*  95 */
        this.claimProgress = claimProgress;

    }


    public String getClaimStatus() {
        /*  99 */
        return this.claimStatus;

    }


    public void setClaimStatus(String claimStatus) {
        /* 102 */
        this.claimStatus = claimStatus;

    }


    public String getOutRequestNo() {
        /* 106 */
        return this.outRequestNo;

    }


    public void setOutRequestNo(String outRequestNo) {
        /* 109 */
        this.outRequestNo = outRequestNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.InsClaim
 * JD-Core Version:    0.6.0
 */