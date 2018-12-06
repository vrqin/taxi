package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class DataTag extends AlipayObject {
    private static final long serialVersionUID = 4532422462768231998L;

    @ApiField("aggregate")
    private String aggregate;

    @ApiField("alias")
    private String alias;

    @ApiField("code")
    private String code;

    public String getAggregate() {
        /* 35 */
        return this.aggregate;
    }

    public void setAggregate(String aggregate) {
        /* 38 */
        this.aggregate = aggregate;
    }

    public String getAlias() {
        /* 42 */
        return this.alias;
    }

    public void setAlias(String alias) {
        /* 45 */
        this.alias = alias;
    }

    public String getCode() {
        /* 49 */
        return this.code;
    }

    public void setCode(String code) {
        /* 52 */
        this.code = code;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DataTag
 * JD-Core Version:    0.6.0
 */