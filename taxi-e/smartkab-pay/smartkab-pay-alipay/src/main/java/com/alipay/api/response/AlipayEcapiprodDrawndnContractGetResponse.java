package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcapiprodDrawndnContractGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 4193736646495711898L;

    @ApiField("contract_content")
    private String contractContent;

    @ApiField("contract_no")
    private String contractNo;

    @ApiField("request_id")
    private String requestId;

    public String getContractContent() {
        /* 39 */
        return this.contractContent;
    }

    public void setContractContent(String contractContent) {
        /* 36 */
        this.contractContent = contractContent;
    }

    public String getContractNo() {
        /* 46 */
        return this.contractNo;
    }

    public void setContractNo(String contractNo) {
        /* 43 */
        this.contractNo = contractNo;
    }

    public String getRequestId() {
        /* 53 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 50 */
        this.requestId = requestId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcapiprodDrawndnContractGetResponse
 * JD-Core Version:    0.6.0
 */