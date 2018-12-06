package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySecurityRiskDeviceidQueryModel extends AlipayObject {
    private static final long serialVersionUID = 4222512526957492814L;

    @ApiField("app_key_client")
    private String appKeyClient;

    @ApiField("app_key_server")
    private String appKeyServer;

    @ApiField("app_name")
    private String appName;

    @ApiField("deviceid_token")
    private String deviceidToken;

    public String getAppKeyClient() {
        /* 41 */
        return this.appKeyClient;
    }

    public void setAppKeyClient(String appKeyClient) {
        /* 44 */
        this.appKeyClient = appKeyClient;
    }

    public String getAppKeyServer() {
        /* 48 */
        return this.appKeyServer;
    }

    public void setAppKeyServer(String appKeyServer) {
        /* 51 */
        this.appKeyServer = appKeyServer;
    }

    public String getAppName() {
        /* 55 */
        return this.appName;
    }

    public void setAppName(String appName) {
        /* 58 */
        this.appName = appName;
    }

    public String getDeviceidToken() {
        /* 62 */
        return this.deviceidToken;
    }

    public void setDeviceidToken(String deviceidToken) {
        /* 65 */
        this.deviceidToken = deviceidToken;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySecurityRiskDeviceidQueryModel
 * JD-Core Version:    0.6.0
 */