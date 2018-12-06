package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class CardDomainVO extends AlipayObject {
    private static final long serialVersionUID = 8584749894787454335L;

    @ApiField("description")
    private String description;

    @ApiField("domain_name")
    private String domainName;

    public String getDescription() {
        /* 29 */
        return this.description;
    }

    public void setDescription(String description) {
        /* 32 */
        this.description = description;
    }

    public String getDomainName() {
        /* 36 */
        return this.domainName;
    }

    public void setDomainName(String domainName) {
        /* 39 */
        this.domainName = domainName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CardDomainVO
 * JD-Core Version:    0.6.0
 */