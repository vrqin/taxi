package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AliTrustRiskUser extends AlipayObject {
    private static final long serialVersionUID = 1689547351548498993L;

    @ApiField("date")
    private String date;

    @ApiField("reason")
    private String reason;

    @ApiField("risk")
    private Boolean risk;

    @ApiField("source")
    private String source;

    public String getDate() {
        /* 41 */
        return this.date;
    }

    public void setDate(String date) {
        /* 44 */
        this.date = date;
    }

    public String getReason() {
        /* 48 */
        return this.reason;
    }

    public void setReason(String reason) {
        /* 51 */
        this.reason = reason;
    }

    public Boolean getRisk() {
        /* 55 */
        return this.risk;
    }

    public void setRisk(Boolean risk) {
        /* 58 */
        this.risk = risk;
    }

    public String getSource() {
        /* 62 */
        return this.source;
    }

    public void setSource(String source) {
        /* 65 */
        this.source = source;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AliTrustRiskUser
 * JD-Core Version:    0.6.0
 */