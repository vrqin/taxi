package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayAcquireCreateandpayResponse extends AlipayResponse {
    private static final long serialVersionUID = 7218782372392739967L;


    @ApiField("buyer_logon_id")
    private String buyerLogonId;


    @ApiField("buyer_user_id")
    private String buyerUserId;


    @ApiField("detail_error_code")
    private String detailErrorCode;


    @ApiField("detail_error_des")
    private String detailErrorDes;


    @ApiField("extend_info")
    private String extendInfo;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiField("result_code")
    private String resultCode;


    @ApiField("trade_no")
    private String tradeNo;


    public String getBuyerLogonId() {
        /*  73 */
        return this.buyerLogonId;

    }


    public void setBuyerLogonId(String buyerLogonId) {
        /*  70 */
        this.buyerLogonId = buyerLogonId;

    }


    public String getBuyerUserId() {
        /*  80 */
        return this.buyerUserId;

    }


    public void setBuyerUserId(String buyerUserId) {
        /*  77 */
        this.buyerUserId = buyerUserId;

    }


    public String getDetailErrorCode() {
        /*  87 */
        return this.detailErrorCode;

    }


    public void setDetailErrorCode(String detailErrorCode) {
        /*  84 */
        this.detailErrorCode = detailErrorCode;

    }


    public String getDetailErrorDes() {
        /*  94 */
        return this.detailErrorDes;

    }


    public void setDetailErrorDes(String detailErrorDes) {
        /*  91 */
        this.detailErrorDes = detailErrorDes;

    }


    public String getExtendInfo() {
        /* 101 */
        return this.extendInfo;

    }


    public void setExtendInfo(String extendInfo) {
        /*  98 */
        this.extendInfo = extendInfo;

    }


    public String getOutTradeNo() {
        /* 108 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 105 */
        this.outTradeNo = outTradeNo;

    }


    public String getResultCode() {
        /* 115 */
        return this.resultCode;

    }


    public void setResultCode(String resultCode) {
        /* 112 */
        this.resultCode = resultCode;

    }


    public String getTradeNo() {
        /* 122 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 119 */
        this.tradeNo = tradeNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayAcquireCreateandpayResponse
 * JD-Core Version:    0.6.0
 */