package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AccountFreeze extends AlipayObject {
    private static final long serialVersionUID = 4734349698775834839L;

    @ApiField("freeze_amount")
    private String freezeAmount;

    @ApiField("freeze_name")
    private String freezeName;

    @ApiField("freeze_type")
    private String freezeType;

    public String getFreezeAmount() {
        /* 35 */
        return this.freezeAmount;
    }

    public void setFreezeAmount(String freezeAmount) {
        /* 38 */
        this.freezeAmount = freezeAmount;
    }

    public String getFreezeName() {
        /* 42 */
        return this.freezeName;
    }

    public void setFreezeName(String freezeName) {
        /* 45 */
        this.freezeName = freezeName;
    }

    public String getFreezeType() {
        /* 49 */
        return this.freezeType;
    }

    public void setFreezeType(String freezeType) {
        /* 52 */
        this.freezeType = freezeType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AccountFreeze
 * JD-Core Version:    0.6.0
 */