package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ContactFollower;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOpenPublicContactFollowBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 5329932437849651389L;

    @ApiListField("contact_follow_list")
    @ApiField("contact_follower")
    private List<ContactFollower> contactFollowList;

    public List<ContactFollower> getContactFollowList() {
        /* 31 */
        return this.contactFollowList;
    }

    public void setContactFollowList(List<ContactFollower> contactFollowList) {
        /* 28 */
        this.contactFollowList = contactFollowList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicContactFollowBatchqueryResponse
 * JD-Core Version:    0.6.0
 */