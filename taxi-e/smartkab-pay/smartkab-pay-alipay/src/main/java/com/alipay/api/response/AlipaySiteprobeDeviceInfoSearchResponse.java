package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySiteprobeDeviceInfoSearchResponse extends AlipayResponse {
    private static final long serialVersionUID = 2315747439687428685L;

    @ApiField("code")
    private String code;

    @ApiField("devices")
    private String devices;

    @ApiField("msg")
    private String msg;

    @ApiField("total")
    private Long total;

    public String getCode() {
        /* 55 */
        return this.code;
    }

    public void setCode(String code) {
        /* 52 */
        this.code = code;
    }

    public String getDevices() {
        /* 62 */
        return this.devices;
    }

    public void setDevices(String devices) {
        /* 59 */
        this.devices = devices;
    }

    public String getMsg() {
        /* 69 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 66 */
        this.msg = msg;
    }

    public Long getTotal() {
        /* 76 */
        return this.total;
    }

    public void setTotal(Long total) {
        /* 73 */
        this.total = total;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySiteprobeDeviceInfoSearchResponse
 * JD-Core Version:    0.6.0
 */