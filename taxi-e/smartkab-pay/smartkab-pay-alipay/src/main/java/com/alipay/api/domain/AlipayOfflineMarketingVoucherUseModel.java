package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketingVoucherUseModel extends AlipayObject {
    private static final long serialVersionUID = 4558119994889361351L;

    @ApiField("extend_params")
    private String extendParams;

    @ApiField("external_id")
    private String externalId;

    @ApiField("external_trade_info")
    private VoucherUserExternalTradeInfo externalTradeInfo;

    @ApiField("external_voucher_code")
    private String externalVoucherCode;

    public String getExtendParams() {
        /* 41 */
        return this.extendParams;
    }

    public void setExtendParams(String extendParams) {
        /* 44 */
        this.extendParams = extendParams;
    }

    public String getExternalId() {
        /* 48 */
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        /* 51 */
        this.externalId = externalId;
    }

    public VoucherUserExternalTradeInfo getExternalTradeInfo() {
        /* 55 */
        return this.externalTradeInfo;
    }

    public void setExternalTradeInfo(VoucherUserExternalTradeInfo externalTradeInfo) {
        /* 58 */
        this.externalTradeInfo = externalTradeInfo;
    }

    public String getExternalVoucherCode() {
        /* 62 */
        return this.externalVoucherCode;
    }

    public void setExternalVoucherCode(String externalVoucherCode) {
        /* 65 */
        this.externalVoucherCode = externalVoucherCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketingVoucherUseModel
 * JD-Core Version:    0.6.0
 */