package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.XXXXsdasdasd;
import com.alipay.api.internal.mapping.ApiField;

public class ZhimaMerchantTestPracticeResponse extends AlipayResponse {
    private static final long serialVersionUID = 5622635623943563123L;

    @ApiField("dddd")
    private XXXXsdasdasd dddd;

    @ApiField("sss")
    private String sss;

    public XXXXsdasdasd getDddd() {
        /* 34 */
        return this.dddd;
    }

    public void setDddd(XXXXsdasdasd dddd) {
        /* 31 */
        this.dddd = dddd;
    }

    public String getSss() {
        /* 41 */
        return this.sss;
    }

    public void setSss(String sss) {
        /* 38 */
        this.sss = sss;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.ZhimaMerchantTestPracticeResponse
 * JD-Core Version:    0.6.0
 */