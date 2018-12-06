package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCodeRecoResult extends AlipayObject {
    private static final long serialVersionUID = 4885416427893511742L;

    @ApiField("content")
    private String content;

    public String getContent() {
        /* 23 */
        return this.content;
    }

    public void setContent(String content) {
        /* 26 */
        this.content = content;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCodeRecoResult
 * JD-Core Version:    0.6.0
 */