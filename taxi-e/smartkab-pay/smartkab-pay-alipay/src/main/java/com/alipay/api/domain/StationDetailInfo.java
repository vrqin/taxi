package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class StationDetailInfo extends AlipayObject {
    private static final long serialVersionUID = 8488196361819942276L;

    @ApiField("code")
    private String code;

    @ApiField("ext_code")
    private String extCode;

    @ApiField("name")
    private String name;

    public String getCode() {
        /* 35 */
        return this.code;
    }

    public void setCode(String code) {
        /* 38 */
        this.code = code;
    }

    public String getExtCode() {
        /* 42 */
        return this.extCode;
    }

    public void setExtCode(String extCode) {
        /* 45 */
        this.extCode = extCode;
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
 * Qualified Name:     com.alipay.api.domain.StationDetailInfo
 * JD-Core Version:    0.6.0
 */