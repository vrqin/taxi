package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ExtendParams extends AlipayObject {
    private static final long serialVersionUID = 6235627729179957473L;

    @ApiField("hb_fq_num")
    private String hbFqNum;

    @ApiField("hb_fq_seller_percent")
    private String hbFqSellerPercent;

    @ApiField("sys_service_provider_id")
    private String sysServiceProviderId;

    public String getHbFqNum() {
        /* 36 */
        return this.hbFqNum;
    }

    public void setHbFqNum(String hbFqNum) {
        /* 39 */
        this.hbFqNum = hbFqNum;
    }

    public String getHbFqSellerPercent() {
        /* 43 */
        return this.hbFqSellerPercent;
    }

    public void setHbFqSellerPercent(String hbFqSellerPercent) {
        /* 46 */
        this.hbFqSellerPercent = hbFqSellerPercent;
    }

    public String getSysServiceProviderId() {
        /* 50 */
        return this.sysServiceProviderId;
    }

    public void setSysServiceProviderId(String sysServiceProviderId) {
        /* 53 */
        this.sysServiceProviderId = sysServiceProviderId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ExtendParams
 * JD-Core Version:    0.6.0
 */