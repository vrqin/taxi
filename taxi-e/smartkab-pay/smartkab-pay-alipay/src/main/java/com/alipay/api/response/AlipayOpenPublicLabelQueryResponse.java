package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.PublicLabel;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOpenPublicLabelQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3428287595711879663L;

    @ApiListField("label_list")
    @ApiField("public_label")
    private List<PublicLabel> labelList;

    public List<PublicLabel> getLabelList() {
        /* 31 */
        return this.labelList;
    }

    public void setLabelList(List<PublicLabel> labelList) {
        /* 28 */
        this.labelList = labelList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicLabelQueryResponse
 * JD-Core Version:    0.6.0
 */