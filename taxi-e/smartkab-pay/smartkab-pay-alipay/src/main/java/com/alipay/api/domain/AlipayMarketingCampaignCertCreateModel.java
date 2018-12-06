package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignCertCreateModel extends AlipayObject {
    private static final long serialVersionUID = 2466292235241981967L;

    @ApiField("cert_name")
    private String certName;

    @ApiField("extend_info")
    private String extendInfo;

    @ApiField("memo")
    private String memo;

    @ApiField("valid_count")
    private String validCount;

    public String getCertName() {
        /* 41 */
        return this.certName;
    }

    public void setCertName(String certName) {
        /* 44 */
        this.certName = certName;
    }

    public String getExtendInfo() {
        /* 48 */
        return this.extendInfo;
    }

    public void setExtendInfo(String extendInfo) {
        /* 51 */
        this.extendInfo = extendInfo;
    }

    public String getMemo() {
        /* 55 */
        return this.memo;
    }

    public void setMemo(String memo) {
        /* 58 */
        this.memo = memo;
    }

    public String getValidCount() {
        /* 62 */
        return this.validCount;
    }

    public void setValidCount(String validCount) {
        /* 65 */
        this.validCount = validCount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignCertCreateModel
 * JD-Core Version:    0.6.0
 */