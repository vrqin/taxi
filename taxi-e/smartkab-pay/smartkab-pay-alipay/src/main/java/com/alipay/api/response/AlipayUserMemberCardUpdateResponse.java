package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayUserMemberCardUpdateResponse extends AlipayResponse {
    private static final long serialVersionUID = 5522288742834349593L;

    @ApiField("card")
    private String card;

    @ApiField("result_code")
    private String resultCode;

    @ApiField("result_msg")
    private String resultMsg;

    public String getCard() {
        /* 39 */
        return this.card;
    }

    public void setCard(String card) {
        /* 36 */
        this.card = card;
    }

    public String getResultCode() {
        /* 46 */
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        /* 43 */
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        /* 53 */
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        /* 50 */
        this.resultMsg = resultMsg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayUserMemberCardUpdateResponse
 * JD-Core Version:    0.6.0
 */