package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayAcquireCancelResponse extends AlipayResponse {
    private static final long serialVersionUID = 5526862756281767714L;


    @ApiField("detail_error_code")
    private String detailErrorCode;


    @ApiField("detail_error_des")
    private String detailErrorDes;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiField("result_code")
    private String resultCode;


    @ApiField("retry_flag")
    private String retryFlag;


    @ApiField("trade_no")
    private String tradeNo;


    public String getDetailErrorCode() {
        /*  65 */
        return this.detailErrorCode;

    }


    public void setDetailErrorCode(String detailErrorCode) {
        /*  62 */
        this.detailErrorCode = detailErrorCode;

    }


    public String getDetailErrorDes() {
        /*  72 */
        return this.detailErrorDes;

    }


    public void setDetailErrorDes(String detailErrorDes) {
        /*  69 */
        this.detailErrorDes = detailErrorDes;

    }


    public String getOutTradeNo() {
        /*  79 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /*  76 */
        this.outTradeNo = outTradeNo;

    }


    public String getResultCode() {
        /*  86 */
        return this.resultCode;

    }


    public void setResultCode(String resultCode) {
        /*  83 */
        this.resultCode = resultCode;

    }


    public String getRetryFlag() {
        /*  93 */
        return this.retryFlag;

    }


    public void setRetryFlag(String retryFlag) {
        /*  90 */
        this.retryFlag = retryFlag;

    }


    public String getTradeNo() {
        /* 100 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /*  97 */
        this.tradeNo = tradeNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayAcquireCancelResponse
 * JD-Core Version:    0.6.0
 */