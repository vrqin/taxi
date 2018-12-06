package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayAcquireCloseResponse extends AlipayResponse {
    private static final long serialVersionUID = 8255583271288539964L;


    @ApiField("detail_error_code")
    private String detailErrorCode;


    @ApiField("detail_error_des")
    private String detailErrorDes;


    @ApiField("is_success")
    private String isSuccess;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiField("result_code")
    private String resultCode;


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


    public String getIsSuccess() {
        /*  79 */
        return this.isSuccess;

    }


    public void setIsSuccess(String isSuccess) {
        /*  76 */
        this.isSuccess = isSuccess;

    }


    public String getOutTradeNo() {
        /*  86 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /*  83 */
        this.outTradeNo = outTradeNo;

    }


    public String getResultCode() {
        /*  93 */
        return this.resultCode;

    }


    public void setResultCode(String resultCode) {
        /*  90 */
        this.resultCode = resultCode;

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
 * Qualified Name:     com.alipay.api.response.AlipayAcquireCloseResponse
 * JD-Core Version:    0.6.0
 */