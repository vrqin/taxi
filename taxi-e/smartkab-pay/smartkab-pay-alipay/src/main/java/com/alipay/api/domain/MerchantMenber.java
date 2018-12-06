package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class MerchantMenber extends AlipayObject {
    private static final long serialVersionUID = 4772182849983249259L;

    @ApiField("birth")
    private String birth;

    @ApiField("cell")
    private String cell;

    @ApiField("gende")
    private String gende;

    @ApiField("name")
    private String name;

    public String getBirth() {
        /* 41 */
        return this.birth;
    }

    public void setBirth(String birth) {
        /* 44 */
        this.birth = birth;
    }

    public String getCell() {
        /* 48 */
        return this.cell;
    }

    public void setCell(String cell) {
        /* 51 */
        this.cell = cell;
    }

    public String getGende() {
        /* 55 */
        return this.gende;
    }

    public void setGende(String gende) {
        /* 58 */
        this.gende = gende;
    }

    public String getName() {
        /* 62 */
        return this.name;
    }

    public void setName(String name) {
        /* 65 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.MerchantMenber
 * JD-Core Version:    0.6.0
 */