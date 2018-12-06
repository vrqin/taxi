package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingAdvertisingOperateModel extends AlipayObject {
    private static final long serialVersionUID = 7818583649356438494L;

    @ApiField("ad_id")
    private String adId;

    @ApiField("operate_type")
    private String operateType;

    public String getAdId() {
        /* 29 */
        return this.adId;
    }

    public void setAdId(String adId) {
        /* 32 */
        this.adId = adId;
    }

    public String getOperateType() {
        /* 36 */
        return this.operateType;
    }

    public void setOperateType(String operateType) {
        /* 39 */
        this.operateType = operateType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingAdvertisingOperateModel
 * JD-Core Version:    0.6.0
 */