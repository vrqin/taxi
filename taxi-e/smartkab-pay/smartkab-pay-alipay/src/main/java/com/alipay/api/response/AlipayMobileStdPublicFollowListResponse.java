package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.Data;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobileStdPublicFollowListResponse extends AlipayResponse {
    private static final long serialVersionUID = 1286241954846829317L;

    @ApiField("count")
    private String count;

    @ApiField("data")
    private Data data;

    @ApiField("next_alipay_user_id")
    private String nextAlipayUserId;

    @ApiField("next_user_id")
    private String nextUserId;

    public String getCount() {
        /* 46 */
        return this.count;
    }

    public void setCount(String count) {
        /* 43 */
        this.count = count;
    }

    public Data getData() {
        /* 53 */
        return this.data;
    }

    public void setData(Data data) {
        /* 50 */
        this.data = data;
    }

    public String getNextAlipayUserId() {
        /* 60 */
        return this.nextAlipayUserId;
    }

    public void setNextAlipayUserId(String nextAlipayUserId) {
        /* 57 */
        this.nextAlipayUserId = nextAlipayUserId;
    }

    public String getNextUserId() {
        /* 67 */
        return this.nextUserId;
    }

    public void setNextUserId(String nextUserId) {
        /* 64 */
        this.nextUserId = nextUserId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobileStdPublicFollowListResponse
 * JD-Core Version:    0.6.0
 */