package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipaySecurityProdAlipaySecurityProdTestModel extends AlipayObject {
    private static final long serialVersionUID = 7822367569597175241L;

    @ApiListField("cds")
    @ApiField("string")
    private List<String> cds;

    @ApiField("ddd")
    private String ddd;

    public List<String> getCds() {
        /* 33 */
        return this.cds;
    }

    public void setCds(List<String> cds) {
        /* 36 */
        this.cds = cds;
    }

    public String getDdd() {
        /* 40 */
        return this.ddd;
    }

    public void setDdd(String ddd) {
        /* 43 */
        this.ddd = ddd;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySecurityProdAlipaySecurityProdTestModel
 * JD-Core Version:    0.6.0
 */