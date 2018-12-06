package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCdpBrandstoryOffshelfModel extends AlipayObject {
    private static final long serialVersionUID = 3364324461968858219L;

    @ApiField("brand_story_id")
    private String brandStoryId;

    public String getBrandStoryId() {
        /* 23 */
        return this.brandStoryId;
    }

    public void setBrandStoryId(String brandStoryId) {
        /* 26 */
        this.brandStoryId = brandStoryId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpBrandstoryOffshelfModel
 * JD-Core Version:    0.6.0
 */