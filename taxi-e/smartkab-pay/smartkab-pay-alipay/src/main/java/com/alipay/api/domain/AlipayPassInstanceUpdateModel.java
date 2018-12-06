package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPassInstanceUpdateModel extends AlipayObject {
    private static final long serialVersionUID = 3498195972337329883L;

    @ApiField("channel_id")
    private String channelId;

    @ApiField("serial_number")
    private String serialNumber;

    @ApiField("status")
    private String status;

    @ApiField("tpl_params")
    private String tplParams;

    @ApiField("verify_code")
    private String verifyCode;

    @ApiField("verify_type")
    private String verifyType;

    public String getChannelId() {
        /* 53 */
        return this.channelId;
    }

    public void setChannelId(String channelId) {
        /* 56 */
        this.channelId = channelId;
    }

    public String getSerialNumber() {
        /* 60 */
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        /* 63 */
        this.serialNumber = serialNumber;
    }

    public String getStatus() {
        /* 67 */
        return this.status;
    }

    public void setStatus(String status) {
        /* 70 */
        this.status = status;
    }

    public String getTplParams() {
        /* 74 */
        return this.tplParams;
    }

    public void setTplParams(String tplParams) {
        /* 77 */
        this.tplParams = tplParams;
    }

    public String getVerifyCode() {
        /* 81 */
        return this.verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        /* 84 */
        this.verifyCode = verifyCode;
    }

    public String getVerifyType() {
        /* 88 */
        return this.verifyType;
    }

    public void setVerifyType(String verifyType) {
        /* 91 */
        this.verifyType = verifyType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayPassInstanceUpdateModel
 * JD-Core Version:    0.6.0
 */