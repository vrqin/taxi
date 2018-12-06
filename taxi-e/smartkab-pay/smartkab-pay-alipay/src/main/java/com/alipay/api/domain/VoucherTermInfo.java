package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class VoucherTermInfo extends AlipayObject {
    private static final long serialVersionUID = 4742668423789516619L;

    @ApiListField("descriptions")
    @ApiField("string")
    private List<String> descriptions;

    @ApiField("title")
    private String title;

    public List<String> getDescriptions() {
        /* 33 */
        return this.descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        /* 36 */
        this.descriptions = descriptions;
    }

    public String getTitle() {
        /* 40 */
        return this.title;
    }

    public void setTitle(String title) {
        /* 43 */
        this.title = title;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.VoucherTermInfo
 * JD-Core Version:    0.6.0
 */