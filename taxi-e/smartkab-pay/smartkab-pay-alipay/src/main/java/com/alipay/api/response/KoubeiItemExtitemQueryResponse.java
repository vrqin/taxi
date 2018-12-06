package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ExtItem;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiItemExtitemQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1558646419125154832L;

    @ApiField("extitem")
    private ExtItem extitem;

    public ExtItem getExtitem() {
        /* 28 */
        return this.extitem;
    }

    public void setExtitem(ExtItem extitem) {
        /* 25 */
        this.extitem = extitem;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiItemExtitemQueryResponse
 * JD-Core Version:    0.6.0
 */