package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataCustomtagSaveResponse extends AlipayResponse {
    private static final long serialVersionUID = 8441125142153254778L;

    @ApiField("tag_code")
    private String tagCode;

    public String getTagCode() {
        /* 27 */
        return this.tagCode;
    }

    public void setTagCode(String tagCode) {
        /* 24 */
        this.tagCode = tagCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingDataCustomtagSaveResponse
 * JD-Core Version:    0.6.0
 */