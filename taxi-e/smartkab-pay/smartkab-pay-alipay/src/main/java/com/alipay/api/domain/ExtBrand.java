package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ExtBrand extends AlipayObject {
    private static final long serialVersionUID = 2637849412641162749L;

    @ApiField("brand_code")
    private String brandCode;

    @ApiField("name")
    private String name;

    public String getBrandCode() {
        /* 29 */
        return this.brandCode;
    }

    public void setBrandCode(String brandCode) {
        /* 32 */
        this.brandCode = brandCode;
    }

    public String getName() {
        /* 36 */
        return this.name;
    }

    public void setName(String name) {
        /* 39 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ExtBrand
 * JD-Core Version:    0.6.0
 */