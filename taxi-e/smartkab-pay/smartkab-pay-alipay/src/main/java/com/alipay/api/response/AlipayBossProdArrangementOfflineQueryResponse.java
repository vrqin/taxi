package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayBossProdArrangementOfflineQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7721469247243951748L;

    @ApiField("sign_status")
    private String signStatus;

    public String getSignStatus() {
        /* 27 */
        return this.signStatus;
    }

    public void setSignStatus(String signStatus) {
        /* 24 */
        this.signStatus = signStatus;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayBossProdArrangementOfflineQueryResponse
 * JD-Core Version:    0.6.0
 */