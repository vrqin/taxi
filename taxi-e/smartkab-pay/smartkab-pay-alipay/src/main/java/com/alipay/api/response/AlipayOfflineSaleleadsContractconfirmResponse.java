package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOfflineSaleleadsContractconfirmResponse extends AlipayResponse {
    private static final long serialVersionUID = 8224364588269971994L;


    @ApiField("ff_audit_status")
    private String ffAuditStatus;


    @ApiField("ff_audit_time")
    private String ffAuditTime;


    @ApiField("ff_online")
    private String ffOnline;


    @ApiField("is_open_shop")
    private String isOpenShop;


    @ApiField("is_sign")
    private String isSign;


    @ApiField("leads_id")
    private String leadsId;


    @ApiField("merchant_id")
    private String merchantId;


    public String getFfAuditStatus() {
        /*  63 */
        return this.ffAuditStatus;

    }


    public void setFfAuditStatus(String ffAuditStatus) {
        /*  60 */
        this.ffAuditStatus = ffAuditStatus;

    }


    public String getFfAuditTime() {
        /*  70 */
        return this.ffAuditTime;

    }


    public void setFfAuditTime(String ffAuditTime) {
        /*  67 */
        this.ffAuditTime = ffAuditTime;

    }


    public String getFfOnline() {
        /*  77 */
        return this.ffOnline;

    }


    public void setFfOnline(String ffOnline) {
        /*  74 */
        this.ffOnline = ffOnline;

    }


    public String getIsOpenShop() {
        /*  84 */
        return this.isOpenShop;

    }


    public void setIsOpenShop(String isOpenShop) {
        /*  81 */
        this.isOpenShop = isOpenShop;

    }


    public String getIsSign() {
        /*  91 */
        return this.isSign;

    }


    public void setIsSign(String isSign) {
        /*  88 */
        this.isSign = isSign;

    }


    public String getLeadsId() {
        /*  98 */
        return this.leadsId;

    }


    public void setLeadsId(String leadsId) {
        /*  95 */
        this.leadsId = leadsId;

    }


    public String getMerchantId() {
        /* 105 */
        return this.merchantId;

    }


    public void setMerchantId(String merchantId) {
        /* 102 */
        this.merchantId = merchantId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineSaleleadsContractconfirmResponse
 * JD-Core Version:    0.6.0
 */