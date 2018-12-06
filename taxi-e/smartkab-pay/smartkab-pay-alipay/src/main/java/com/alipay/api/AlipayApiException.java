package com.alipay.api;

public class AlipayApiException extends Exception {
    private static final long serialVersionUID = -238091758285157331L;
    private String errCode;
    private String errMsg;

    public AlipayApiException() {
    }

    public AlipayApiException(String message, Throwable cause) {
        /* 24 */
        super(message, cause);
    }

    public AlipayApiException(String message) {
        /* 28 */
        super(message);
    }

    public AlipayApiException(Throwable cause) {
        /* 32 */
        super(cause);
    }

    public AlipayApiException(String errCode, String errMsg) {
        /* 36 */
        super(errCode + ":" + errMsg);
        /* 37 */
        this.errCode = errCode;
        /* 38 */
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        /* 42 */
        return this.errCode;
    }

    public String getErrMsg() {
        /* 46 */
        return this.errMsg;
    }
}

