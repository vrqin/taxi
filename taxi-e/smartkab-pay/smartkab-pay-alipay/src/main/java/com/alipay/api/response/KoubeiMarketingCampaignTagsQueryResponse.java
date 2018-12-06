package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignTagsQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6375775976339884632L;

    @ApiField("tags")
    private String tags;

    public String getTags() {
        /* 33 */
        return this.tags;
    }

    public void setTags(String tags) {
        /* 30 */
        this.tags = tags;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingCampaignTagsQueryResponse
 * JD-Core Version:    0.6.0
 */