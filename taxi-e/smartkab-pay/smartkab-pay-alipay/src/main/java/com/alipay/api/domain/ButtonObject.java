package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class ButtonObject extends AlipayObject {
    private static final long serialVersionUID = 7593168836685225794L;

    @ApiField("action_param")
    private String actionParam;

    @ApiField("action_type")
    private String actionType;

    @ApiField("name")
    private String name;

    @ApiListField("sub_button")
    @ApiField("sub_button")
    private List<SubButton> subButton;

    public String getActionParam() {
        /* 51 */
        return this.actionParam;
    }

    public void setActionParam(String actionParam) {
        /* 54 */
        this.actionParam = actionParam;
    }

    public String getActionType() {
        /* 58 */
        return this.actionType;
    }

    public void setActionType(String actionType) {
        /* 61 */
        this.actionType = actionType;
    }

    public String getName() {
        /* 65 */
        return this.name;
    }

    public void setName(String name) {
        /* 68 */
        this.name = name;
    }

    public List<SubButton> getSubButton() {
        /* 72 */
        return this.subButton;
    }

    public void setSubButton(List<SubButton> subButton) {
        /* 75 */
        this.subButton = subButton;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ButtonObject
 * JD-Core Version:    0.6.0
 */