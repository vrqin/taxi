package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class OldComplextMockModel extends AlipayObject {
    private static final long serialVersionUID = 5546691934333419338L;

    @ApiField("biz_num")
    private Long bizNum;

    @ApiField("biz_type")
    private String bizType;

    @ApiField("simple_mock_model")
    private SimpleMockModel simpleMockModel;

    public Long getBizNum() {
        /* 35 */
        return this.bizNum;
    }

    public void setBizNum(Long bizNum) {
        /* 38 */
        this.bizNum = bizNum;
    }

    public String getBizType() {
        /* 42 */
        return this.bizType;
    }

    public void setBizType(String bizType) {
        /* 45 */
        this.bizType = bizType;
    }

    public SimpleMockModel getSimpleMockModel() {
        /* 49 */
        return this.simpleMockModel;
    }

    public void setSimpleMockModel(SimpleMockModel simpleMockModel) {
        /* 52 */
        this.simpleMockModel = simpleMockModel;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OldComplextMockModel
 * JD-Core Version:    0.6.0
 */