package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipaySiteprobeDeviceInfoGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 5253673123932475976L;


    @ApiField("auth_id")
    private String authId;


    @ApiField("auth_type")
    private String authType;


    @ApiField("bssid")
    private String bssid;


    @ApiField("code")
    private String code;


    @ApiField("latitude")
    private String latitude;


    @ApiField("longitude")
    private String longitude;


    @ApiField("msg")
    private String msg;


    @ApiField("password")
    private String password;


    @ApiField("shop_id")
    private String shopId;


    @ApiField("ssid")
    private String ssid;


    @ApiField("status")
    private String status;


    public String getAuthId() {
        /*  87 */
        return this.authId;

    }


    public void setAuthId(String authId) {
        /*  84 */
        this.authId = authId;

    }


    public String getAuthType() {
        /*  94 */
        return this.authType;

    }


    public void setAuthType(String authType) {
        /*  91 */
        this.authType = authType;

    }


    public String getBssid() {
        /* 101 */
        return this.bssid;

    }


    public void setBssid(String bssid) {
        /*  98 */
        this.bssid = bssid;

    }


    public String getCode() {
        /* 108 */
        return this.code;

    }


    public void setCode(String code) {
        /* 105 */
        this.code = code;

    }


    public String getLatitude() {
        /* 115 */
        return this.latitude;

    }


    public void setLatitude(String latitude) {
        /* 112 */
        this.latitude = latitude;

    }


    public String getLongitude() {
        /* 122 */
        return this.longitude;

    }


    public void setLongitude(String longitude) {
        /* 119 */
        this.longitude = longitude;

    }


    public String getMsg() {
        /* 129 */
        return this.msg;

    }


    public void setMsg(String msg) {
        /* 126 */
        this.msg = msg;

    }


    public String getPassword() {
        /* 136 */
        return this.password;

    }


    public void setPassword(String password) {
        /* 133 */
        this.password = password;

    }


    public String getShopId() {
        /* 143 */
        return this.shopId;

    }


    public void setShopId(String shopId) {
        /* 140 */
        this.shopId = shopId;

    }


    public String getSsid() {
        /* 150 */
        return this.ssid;

    }


    public void setSsid(String ssid) {
        /* 147 */
        this.ssid = ssid;

    }


    public String getStatus() {
        /* 157 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 154 */
        this.status = status;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySiteprobeDeviceInfoGetResponse
 * JD-Core Version:    0.6.0
 */