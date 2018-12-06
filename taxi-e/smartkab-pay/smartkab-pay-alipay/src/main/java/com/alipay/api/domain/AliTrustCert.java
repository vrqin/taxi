package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AliTrustCert extends AlipayObject {
    private static final long serialVersionUID = 6683439636513379774L;

    @ApiField("forward_url")
    private String forwardUrl;

    @ApiField("icon_url")
    private String iconUrl;

    @ApiField("is_certified")
    private String isCertified;

    @ApiField("level")
    private String level;

    @ApiField("message")
    private String message;

    public String getForwardUrl() {
        /* 47 */
        return this.forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        /* 50 */
        this.forwardUrl = forwardUrl;
    }

    public String getIconUrl() {
        /* 54 */
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        /* 57 */
        this.iconUrl = iconUrl;
    }

    public String getIsCertified() {
        /* 61 */
        return this.isCertified;
    }

    public void setIsCertified(String isCertified) {
        /* 64 */
        this.isCertified = isCertified;
    }

    public String getLevel() {
        /* 68 */
        return this.level;
    }

    public void setLevel(String level) {
        /* 71 */
        this.level = level;
    }

    public String getMessage() {
        /* 75 */
        return this.message;
    }

    public void setMessage(String message) {
        /* 78 */
        this.message = message;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AliTrustCert
 * JD-Core Version:    0.6.0
 */