package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcardEduPublicBindResponse extends AlipayResponse {
    private static final long serialVersionUID = 4859876826759669944L;

    @ApiField("agent_code")
    private String agentCode;

    @ApiField("card_no")
    private String cardNo;

    @ApiField("return_code")
    private String returnCode;

    public String getAgentCode() {
        /* 39 */
        return this.agentCode;
    }

    public void setAgentCode(String agentCode) {
        /* 36 */
        this.agentCode = agentCode;
    }

    public String getCardNo() {
        /* 46 */
        return this.cardNo;
    }

    public void setCardNo(String cardNo) {
        /* 43 */
        this.cardNo = cardNo;
    }

    public String getReturnCode() {
        /* 53 */
        return this.returnCode;
    }

    public void setReturnCode(String returnCode) {
        /* 50 */
        this.returnCode = returnCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcardEduPublicBindResponse
 * JD-Core Version:    0.6.0
 */