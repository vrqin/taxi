package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayAcquireRefundResponse extends AlipayResponse {
    private static final long serialVersionUID = 7148919143316838344L;


    @ApiField("buyer_logon_id")
    private String buyerLogonId;


    @ApiField("buyer_user_id")
    private String buyerUserId;


    @ApiField("detail_error_code")
    private String detailErrorCode;


    @ApiField("detail_error_des")
    private String detailErrorDes;


    @ApiField("fund_change")
    private String fundChange;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiField("result_code")
    private String resultCode;


    @ApiField("trade_no")
    private String tradeNo;


    public String getBuyerLogonId() {
        /*  78 */
        return this.buyerLogonId;

    }


    public void setBuyerLogonId(String buyerLogonId) {
        /*  75 */
        this.buyerLogonId = buyerLogonId;

    }


    public String getBuyerUserId() {
        /*  85 */
        return this.buyerUserId;

    }


    public void setBuyerUserId(String buyerUserId) {
        /*  82 */
        this.buyerUserId = buyerUserId;

    }


    public String getDetailErrorCode() {
        /*  92 */
        return this.detailErrorCode;

    }


    public void setDetailErrorCode(String detailErrorCode) {
        /*  89 */
        this.detailErrorCode = detailErrorCode;

    }


    public String getDetailErrorDes() {
        /*  99 */
        return this.detailErrorDes;

    }


    public void setDetailErrorDes(String detailErrorDes) {
        /*  96 */
        this.detailErrorDes = detailErrorDes;

    }


    public String getFundChange() {
        /* 106 */
        return this.fundChange;

    }


    public void setFundChange(String fundChange) {
        /* 103 */
        this.fundChange = fundChange;

    }


    public String getOutTradeNo() {
        /* 113 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 110 */
        this.outTradeNo = outTradeNo;

    }


    public String getResultCode() {
        /* 120 */
        return this.resultCode;

    }


    public void setResultCode(String resultCode) {
        /* 117 */
        this.resultCode = resultCode;

    }


    public String getTradeNo() {
        /* 127 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 124 */
        this.tradeNo = tradeNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayAcquireRefundResponse
 * JD-Core Version:    0.6.0
 */