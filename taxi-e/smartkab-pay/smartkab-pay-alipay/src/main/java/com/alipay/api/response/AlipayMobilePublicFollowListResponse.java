package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.Data;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicFollowListResponse extends AlipayResponse {
    private static final long serialVersionUID = 2381329825512324732L;

    @ApiField("code")
    private String code;

    @ApiField("count")
    private String count;

    @ApiField("data")
    private Data data;

    @ApiField("next_alipay_user_id")
    private String nextAlipayUserId;

    @ApiField("next_user_id")
    private String nextUserId;

    public String getCode() {
        /* 52 */
        return this.code;
    }

    public void setCode(String code) {
        /* 49 */
        this.code = code;
    }

    public String getCount() {
        /* 59 */
        return this.count;
    }

    public void setCount(String count) {
        /* 56 */
        this.count = count;
    }

    public Data getData() {
        /* 66 */
        return this.data;
    }

    public void setData(Data data) {
        /* 63 */
        this.data = data;
    }

    public String getNextAlipayUserId() {
        /* 73 */
        return this.nextAlipayUserId;
    }

    public void setNextAlipayUserId(String nextAlipayUserId) {
        /* 70 */
        this.nextAlipayUserId = nextAlipayUserId;
    }

    public String getNextUserId() {
        /* 80 */
        return this.nextUserId;
    }

    public void setNextUserId(String nextUserId) {
        /* 77 */
        this.nextUserId = nextUserId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicFollowListResponse
 * JD-Core Version:    0.6.0
 */