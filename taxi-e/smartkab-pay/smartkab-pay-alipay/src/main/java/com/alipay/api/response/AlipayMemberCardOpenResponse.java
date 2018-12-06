package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMemberCardOpenResponse extends AlipayResponse {
    private static final long serialVersionUID = 4584176521393181152L;

    @ApiField("card")
    private String card;

    @ApiField("error_code")
    private String errorCode;

    @ApiField("error_msg")
    private String errorMsg;

    @ApiField("success")
    private String success;

    public String getCard() {
        /* 51 */
        return this.card;
    }

    public void setCard(String card) {
        /* 48 */
        this.card = card;
    }

    public String getErrorCode() {
        /* 58 */
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        /* 55 */
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        /* 65 */
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        /* 62 */
        this.errorMsg = errorMsg;
    }

    public String getSuccess() {
        /* 72 */
        return this.success;
    }

    public void setSuccess(String success) {
        /* 69 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMemberCardOpenResponse
 * JD-Core Version:    0.6.0
 */