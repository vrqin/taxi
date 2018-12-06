package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobileStdPublicExpressUserQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 8599869862833787273L;

    @ApiField("cert_no")
    private String certNo;

    @ApiField("cert_type")
    private String certType;

    public String getCertNo() {
        /* 33 */
        return this.certNo;
    }

    public void setCertNo(String certNo) {
        /* 30 */
        this.certNo = certNo;
    }

    public String getCertType() {
        /* 40 */
        return this.certType;
    }

    public void setCertType(String certType) {
        /* 37 */
        this.certType = certType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobileStdPublicExpressUserQueryResponse
 * JD-Core Version:    0.6.0
 */