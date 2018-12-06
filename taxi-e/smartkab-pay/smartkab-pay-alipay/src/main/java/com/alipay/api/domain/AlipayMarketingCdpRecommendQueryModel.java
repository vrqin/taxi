package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCdpRecommendQueryModel extends AlipayObject {
    private static final long serialVersionUID = 2633558868999917765L;

    @ApiField("ad_code")
    private String adCode;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("logon_id")
    private String logonId;

    public String getAdCode() {
        /* 35 */
        return this.adCode;
    }

    public void setAdCode(String adCode) {
        /* 38 */
        this.adCode = adCode;
    }

    public String getExtInfo() {
        /* 42 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 45 */
        this.extInfo = extInfo;
    }

    public String getLogonId() {
        /* 49 */
        return this.logonId;
    }

    public void setLogonId(String logonId) {
        /* 52 */
        this.logonId = logonId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCdpRecommendQueryModel
 * JD-Core Version:    0.6.0
 */