package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ContactPersonInfo extends AlipayObject {
    private static final long serialVersionUID = 4666757843279324947L;

    @ApiField("contact_email")
    private String contactEmail;

    @ApiField("contact_mobile")
    private String contactMobile;

    @ApiField("contact_name")
    private String contactName;

    public String getContactEmail() {
        /* 35 */
        return this.contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        /* 38 */
        this.contactEmail = contactEmail;
    }

    public String getContactMobile() {
        /* 42 */
        return this.contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        /* 45 */
        this.contactMobile = contactMobile;
    }

    public String getContactName() {
        /* 49 */
        return this.contactName;
    }

    public void setContactName(String contactName) {
        /* 52 */
        this.contactName = contactName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ContactPersonInfo
 * JD-Core Version:    0.6.0
 */