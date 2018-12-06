package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayMobilePublicContactFollowListResponse extends AlipayResponse {
    private static final long serialVersionUID = 3795479255545166977L;

    @ApiField("code")
    private String code;

    @ApiListField("contact_follow_list")
    @ApiField("string")
    private List<String> contactFollowList;

    public String getCode() {
        /* 36 */
        return this.code;
    }

    public void setCode(String code) {
        /* 33 */
        this.code = code;
    }

    public List<String> getContactFollowList() {
        /* 43 */
        return this.contactFollowList;
    }

    public void setContactFollowList(List<String> contactFollowList) {
        /* 40 */
        this.contactFollowList = contactFollowList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicContactFollowListResponse
 * JD-Core Version:    0.6.0
 */