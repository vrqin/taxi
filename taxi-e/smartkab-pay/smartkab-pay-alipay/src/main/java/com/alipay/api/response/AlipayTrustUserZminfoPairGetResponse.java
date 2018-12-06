package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class AlipayTrustUserZminfoPairGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 8873887317633582635L;

    @ApiField("apply_zm_info")
    private String applyZmInfo;

    @ApiField("expire_time")
    private Date expireTime;

    @ApiField("owner_zm_info")
    private String ownerZmInfo;

    public String getApplyZmInfo() {
        /* 40 */
        return this.applyZmInfo;
    }

    public void setApplyZmInfo(String applyZmInfo) {
        /* 37 */
        this.applyZmInfo = applyZmInfo;
    }

    public Date getExpireTime() {
        /* 47 */
        return this.expireTime;
    }

    public void setExpireTime(Date expireTime) {
        /* 44 */
        this.expireTime = expireTime;
    }

    public String getOwnerZmInfo() {
        /* 54 */
        return this.ownerZmInfo;
    }

    public void setOwnerZmInfo(String ownerZmInfo) {
        /* 51 */
        this.ownerZmInfo = ownerZmInfo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTrustUserZminfoPairGetResponse
 * JD-Core Version:    0.6.0
 */