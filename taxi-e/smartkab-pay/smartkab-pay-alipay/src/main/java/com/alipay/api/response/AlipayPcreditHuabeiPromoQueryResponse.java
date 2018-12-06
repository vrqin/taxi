package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPcreditHuabeiPromoQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7588672568121435535L;

    @ApiField("facescore")
    private String facescore;

    public String getFacescore() {
        /* 27 */
        return this.facescore;
    }

    public void setFacescore(String facescore) {
        /* 24 */
        this.facescore = facescore;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayPcreditHuabeiPromoQueryResponse
 * JD-Core Version:    0.6.0
 */