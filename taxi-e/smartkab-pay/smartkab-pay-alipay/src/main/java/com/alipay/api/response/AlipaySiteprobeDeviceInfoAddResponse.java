package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySiteprobeDeviceInfoAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 7856166611979213285L;

    @ApiField("code")
    private String code;

    @ApiField("device_id")
    private String deviceId;

    @ApiField("msg")
    private String msg;

    public String getCode() {
        /* 39 */
        return this.code;
    }

    public void setCode(String code) {
        /* 36 */
        this.code = code;
    }

    public String getDeviceId() {
        /* 46 */
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        /* 43 */
        this.deviceId = deviceId;
    }

    public String getMsg() {
        /* 53 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 50 */
        this.msg = msg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySiteprobeDeviceInfoAddResponse
 * JD-Core Version:    0.6.0
 */