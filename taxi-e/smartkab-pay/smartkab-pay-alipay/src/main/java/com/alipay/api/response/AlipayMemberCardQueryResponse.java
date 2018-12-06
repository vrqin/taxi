package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMemberCardQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6148764267987824973L;

    @ApiField("card")
    private String card;

    @ApiField("error_code")
    private String errorCode;

    @ApiField("error_msg")
    private String errorMsg;

    @ApiField("success")
    private String success;

    public String getCard() {
        /* 56 */
        return this.card;
    }

    public void setCard(String card) {
        /* 53 */
        this.card = card;
    }

    public String getErrorCode() {
        /* 63 */
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        /* 60 */
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        /* 70 */
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        /* 67 */
        this.errorMsg = errorMsg;
    }

    public String getSuccess() {
        /* 77 */
        return this.success;
    }

    public void setSuccess(String success) {
        /* 74 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMemberCardQueryResponse
 * JD-Core Version:    0.6.0
 */