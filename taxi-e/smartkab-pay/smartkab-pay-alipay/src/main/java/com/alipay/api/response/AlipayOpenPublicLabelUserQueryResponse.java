package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicLabelUserQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 8143359948156783842L;

    @ApiField("label_ids")
    private String labelIds;

    public String getLabelIds() {
        /* 27 */
        return this.labelIds;
    }

    public void setLabelIds(String labelIds) {
        /* 24 */
        this.labelIds = labelIds;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicLabelUserQueryResponse
 * JD-Core Version:    0.6.0
 */