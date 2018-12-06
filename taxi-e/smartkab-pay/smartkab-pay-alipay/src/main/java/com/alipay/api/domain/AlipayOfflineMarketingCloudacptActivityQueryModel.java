package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketingCloudacptActivityQueryModel extends AlipayObject {
    private static final long serialVersionUID = 3597788335975323929L;

    @ApiField("pid")
    private String pid;

    @ApiField("uid")
    private String uid;

    public String getPid() {
        /* 29 */
        return this.pid;
    }

    public void setPid(String pid) {
        /* 32 */
        this.pid = pid;
    }

    public String getUid() {
        /* 36 */
        return this.uid;
    }

    public void setUid(String uid) {
        /* 39 */
        this.uid = uid;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketingCloudacptActivityQueryModel
 * JD-Core Version:    0.6.0
 */