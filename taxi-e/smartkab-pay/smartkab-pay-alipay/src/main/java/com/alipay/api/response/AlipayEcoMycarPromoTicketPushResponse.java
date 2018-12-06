package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarPromoTicketPushResponse extends AlipayResponse {
    private static final long serialVersionUID = 2511171176667646383L;

    @ApiField("sp_apply_no")
    private String spApplyNo;

    public String getSpApplyNo() {
        /* 27 */
        return this.spApplyNo;
    }

    public void setSpApplyNo(String spApplyNo) {
        /* 24 */
        this.spApplyNo = spApplyNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarPromoTicketPushResponse
 * JD-Core Version:    0.6.0
 */