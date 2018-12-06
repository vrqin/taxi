package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class SubButton extends AlipayObject {
    private static final long serialVersionUID = 5831114189253954277L;

    @ApiField("action_param")
    private String actionParam;

    @ApiField("action_type")
    private String actionType;

    @ApiField("name")
    private String name;

    public String getActionParam() {
        /* 35 */
        return this.actionParam;
    }

    public void setActionParam(String actionParam) {
        /* 38 */
        this.actionParam = actionParam;
    }

    public String getActionType() {
        /* 42 */
        return this.actionType;
    }

    public void setActionType(String actionType) {
        /* 45 */
        this.actionType = actionType;
    }

    public String getName() {
        /* 49 */
        return this.name;
    }

    public void setName(String name) {
        /* 52 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.SubButton
 * JD-Core Version:    0.6.0
 */