package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayAcquirePrecreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 2324362127325524662L;


    @ApiField("detail_error_code")
    private String detailErrorCode;


    @ApiField("detail_error_des")
    private String detailErrorDes;


    @ApiField("error")
    private String error;


    @ApiField("is_success")
    private String isSuccess;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiField("pic_url")
    private String picUrl;


    @ApiField("qr_code")
    private String qrCode;


    @ApiField("result_code")
    private String resultCode;


    @ApiField("trade_no")
    private String tradeNo;


    @ApiField("voucher_type")
    private String voucherType;


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


    public String getError() {
        /* 106 */
        return this.error;

    }


    public void setError(String error) {
        /* 103 */
        this.error = error;

    }


    public String getIsSuccess() {
        /* 113 */
        return this.isSuccess;

    }


    public void setIsSuccess(String isSuccess) {
        /* 110 */
        this.isSuccess = isSuccess;

    }


    public String getOutTradeNo() {
        /* 120 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 117 */
        this.outTradeNo = outTradeNo;

    }


    public String getPicUrl() {
        /* 127 */
        return this.picUrl;

    }


    public void setPicUrl(String picUrl) {
        /* 124 */
        this.picUrl = picUrl;

    }


    public String getQrCode() {
        /* 134 */
        return this.qrCode;

    }


    public void setQrCode(String qrCode) {
        /* 131 */
        this.qrCode = qrCode;

    }


    public String getResultCode() {
        /* 141 */
        return this.resultCode;

    }


    public void setResultCode(String resultCode) {
        /* 138 */
        this.resultCode = resultCode;

    }


    public String getTradeNo() {
        /* 148 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 145 */
        this.tradeNo = tradeNo;

    }


    public String getVoucherType() {
        /* 155 */
        return this.voucherType;

    }


    public void setVoucherType(String voucherType) {
        /* 152 */
        this.voucherType = voucherType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayAcquirePrecreateResponse
 * JD-Core Version:    0.6.0
 */