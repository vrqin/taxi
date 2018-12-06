package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class PreOrderResult extends AlipayObject {
    private static final long serialVersionUID = 4398937961411415329L;

    @ApiField("app_id")
    private String appId;

    @ApiField("out_trade_no")
    private String outTradeNo;

    @ApiField("result_code")
    private String resultCode;

    @ApiField("success")
    private Boolean success;

    public String getAppId() {
        /* 41 */
        return this.appId;
    }

    public void setAppId(String appId) {
        /* 44 */
        this.appId = appId;
    }

    public String getOutTradeNo() {
        /* 48 */
        return this.outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        /* 51 */
        this.outTradeNo = outTradeNo;
    }

    public String getResultCode() {
        /* 55 */
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        /* 58 */
        this.resultCode = resultCode;
    }

    public Boolean getSuccess() {
        /* 62 */
        return this.success;
    }

    public void setSuccess(Boolean success) {
        /* 65 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PreOrderResult
 * JD-Core Version:    0.6.0
 */