package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOfflineMarketShopCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 8528675777866822445L;


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


    @ApiField("result_code")
    private String resultCode;


    @ApiField("shop_id")
    private String shopId;


    public String getApplyId() {
        /*  68 */
        return this.applyId;

    }


    public void setApplyId(String applyId) {
        /*  65 */
        this.applyId = applyId;

    }


    public String getAuditDesc() {
        /*  75 */
        return this.auditDesc;

    }


    public void setAuditDesc(String auditDesc) {
        /*  72 */
        this.auditDesc = auditDesc;

    }


    public String getAuditStatus() {
        /*  82 */
        return this.auditStatus;

    }


    public void setAuditStatus(String auditStatus) {
        /*  79 */
        this.auditStatus = auditStatus;

    }


    public String getIsOnline() {
        /*  89 */
        return this.isOnline;

    }


    public void setIsOnline(String isOnline) {
        /*  86 */
        this.isOnline = isOnline;

    }


    public String getIsShow() {
        /*  96 */
        return this.isShow;

    }


    public void setIsShow(String isShow) {
        /*  93 */
        this.isShow = isShow;

    }


    public String getResultCode() {
        /* 103 */
        return this.resultCode;

    }


    public void setResultCode(String resultCode) {
        /* 100 */
        this.resultCode = resultCode;

    }


    public String getShopId() {
        /* 110 */
        return this.shopId;

    }


    public void setShopId(String shopId) {
        /* 107 */
        this.shopId = shopId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketShopCreateResponse
 * JD-Core Version:    0.6.0
 */