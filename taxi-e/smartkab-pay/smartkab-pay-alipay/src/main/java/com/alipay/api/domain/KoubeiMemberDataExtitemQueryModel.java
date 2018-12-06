package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMemberDataExtitemQueryModel extends AlipayObject {
    private static final long serialVersionUID = 7429968236162886855L;

    @ApiField("item_code")
    private String itemCode;

    public String getItemCode() {
        /* 23 */
        return this.itemCode;
    }

    public void setItemCode(String itemCode) {
        /* 26 */
        this.itemCode = itemCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMemberDataExtitemQueryModel
 * JD-Core Version:    0.6.0
 */