package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class AliTrustAlipayCert extends AlipayObject {
    private static final long serialVersionUID = 1779116997956537283L;

    @ApiField("birthday")
    private Date birthday;

    @ApiField("forward_url")
    private String forwardUrl;

    @ApiField("gender")
    private String gender;

    @ApiField("icon_url")
    private String iconUrl;

    @ApiField("is_certified")
    private String isCertified;

    @ApiField("name")
    private String name;

    public Date getBirthday() {
        /* 55 */
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        /* 58 */
        this.birthday = birthday;
    }

    public String getForwardUrl() {
        /* 62 */
        return this.forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        /* 65 */
        this.forwardUrl = forwardUrl;
    }

    public String getGender() {
        /* 69 */
        return this.gender;
    }

    public void setGender(String gender) {
        /* 72 */
        this.gender = gender;
    }

    public String getIconUrl() {
        /* 76 */
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        /* 79 */
        this.iconUrl = iconUrl;
    }

    public String getIsCertified() {
        /* 83 */
        return this.isCertified;
    }

    public void setIsCertified(String isCertified) {
        /* 86 */
        this.isCertified = isCertified;
    }

    public String getName() {
        /* 90 */
        return this.name;
    }

    public void setName(String name) {
        /* 93 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AliTrustAlipayCert
 * JD-Core Version:    0.6.0
 */