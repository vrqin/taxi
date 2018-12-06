package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ComplextMockModel extends AlipayObject {
    private static final long serialVersionUID = 5688198379742465797L;

    @ApiField("biz_model")
    private SimpleMockModel bizModel;

    @ApiField("biz_num")
    private Long bizNum;

    @ApiField("biz_type")
    private String bizType;

    public SimpleMockModel getBizModel() {
        /* 35 */
        return this.bizModel;
    }

    public void setBizModel(SimpleMockModel bizModel) {
        /* 38 */
        this.bizModel = bizModel;
    }

    public Long getBizNum() {
        /* 42 */
        return this.bizNum;
    }

    public void setBizNum(Long bizNum) {
        /* 45 */
        this.bizNum = bizNum;
    }

    public String getBizType() {
        /* 49 */
        return this.bizType;
    }

    public void setBizType(String bizType) {
        /* 52 */
        this.bizType = bizType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ComplextMockModel
 * JD-Core Version:    0.6.0
 */