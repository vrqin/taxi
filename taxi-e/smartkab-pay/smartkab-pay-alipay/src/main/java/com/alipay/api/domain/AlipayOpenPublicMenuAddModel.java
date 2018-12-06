package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOpenPublicMenuAddModel extends AlipayObject {
    private static final long serialVersionUID = 5755363612172639356L;

    @ApiListField("button")
    @ApiField("button_object")
    private List<ButtonObject> button;

    public List<ButtonObject> getButton() {
        /* 27 */
        return this.button;
    }

    public void setButton(List<ButtonObject> button) {
        /* 30 */
        this.button = button;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicMenuAddModel
 * JD-Core Version:    0.6.0
 */