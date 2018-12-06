package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataCustomtagDetailQueryModel extends AlipayObject {
    private static final long serialVersionUID = 1427985954655832242L;

    @ApiField("tag_code")
    private String tagCode;

    public String getTagCode() {
        /* 23 */
        return this.tagCode;
    }

    public void setTagCode(String tagCode) {
        /* 26 */
        this.tagCode = tagCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingDataCustomtagDetailQueryModel
 * JD-Core Version:    0.6.0
 */