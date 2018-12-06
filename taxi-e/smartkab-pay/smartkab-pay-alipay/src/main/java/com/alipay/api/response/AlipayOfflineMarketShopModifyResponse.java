package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketShopModifyResponse extends AlipayResponse {
    private static final long serialVersionUID = 7824753698962271674L;

    @ApiField("apply_id")
    private String applyId;

    @ApiField("audit_desc")
    private String auditDesc;

    @ApiField("audit_status")
    private String auditStatus;

    @ApiField("is_online")
    private String isOnline;

    @ApiField("is_show")
    private String isShow;

    public String getApplyId() {
        /* 52 */
        return this.applyId;
    }

    public void setApplyId(String applyId) {
        /* 49 */
        this.applyId = applyId;
    }

    public String getAuditDesc() {
        /* 59 */
        return this.auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        /* 56 */
        this.auditDesc = auditDesc;
    }

    public String getAuditStatus() {
        /* 66 */
        return this.auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        /* 63 */
        this.auditStatus = auditStatus;
    }

    public String getIsOnline() {
        /* 73 */
        return this.isOnline;
    }

    public void setIsOnline(String isOnline) {
        /* 70 */
        this.isOnline = isOnline;
    }

    public String getIsShow() {
        /* 80 */
        return this.isShow;
    }

    public void setIsShow(String isShow) {
        /* 77 */
        this.isShow = isShow;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketShopModifyResponse
 * JD-Core Version:    0.6.0
 */