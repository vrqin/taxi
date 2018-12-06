package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOfflineTradeResult extends AlipayObject {
    private static final long serialVersionUID = 8536265341523513731L;


    @ApiField("error_code")
    private String errorCode;


    @ApiField("error_message")
    private String errorMessage;


    @ApiField("message")
    private String message;


    @ApiField("need_retry")
    private Boolean needRetry;


    @ApiField("next_try_time")
    private String nextTryTime;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiField("result")
    private String result;


    @ApiField("trade_no")
    private String tradeNo;


    public String getErrorCode() {
        /*  65 */
        return this.errorCode;

    }


    public void setErrorCode(String errorCode) {
        /*  68 */
        this.errorCode = errorCode;

    }


    public String getErrorMessage() {
        /*  72 */
        return this.errorMessage;

    }


    public void setErrorMessage(String errorMessage) {
        /*  75 */
        this.errorMessage = errorMessage;

    }


    public String getMessage() {
        /*  79 */
        return this.message;

    }


    public void setMessage(String message) {
        /*  82 */
        this.message = message;

    }


    public Boolean getNeedRetry() {
        /*  86 */
        return this.needRetry;

    }


    public void setNeedRetry(Boolean needRetry) {
        /*  89 */
        this.needRetry = needRetry;

    }


    public String getNextTryTime() {
        /*  93 */
        return this.nextTryTime;

    }


    public void setNextTryTime(String nextTryTime) {
        /*  96 */
        this.nextTryTime = nextTryTime;

    }


    public String getOutTradeNo() {
        /* 100 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /* 103 */
        this.outTradeNo = outTradeNo;

    }


    public String getResult() {
        /* 107 */
        return this.result;

    }


    public void setResult(String result) {
        /* 110 */
        this.result = result;

    }


    public String getTradeNo() {
        /* 114 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 117 */
        this.tradeNo = tradeNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineTradeResult
 * JD-Core Version:    0.6.0
 */