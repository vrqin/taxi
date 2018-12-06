package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOpenPublicFollowBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7121973531693445147L;

    @ApiField("count")
    private String count;

    @ApiField("next_user_id")
    private String nextUserId;

    @ApiListField("user_id_list")
    @ApiField("string")
    private List<String> userIdList;

    public String getCount() {
        /* 42 */
        return this.count;
    }

    public void setCount(String count) {
        /* 39 */
        this.count = count;
    }

    public String getNextUserId() {
        /* 49 */
        return this.nextUserId;
    }

    public void setNextUserId(String nextUserId) {
        /* 46 */
        this.nextUserId = nextUserId;
    }

    public List<String> getUserIdList() {
        /* 56 */
        return this.userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        /* 53 */
        this.userIdList = userIdList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicFollowBatchqueryResponse
 * JD-Core Version:    0.6.0
 */