package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayMsaasSecuritySendcpainfoModel extends AlipayObject {
    private static final long serialVersionUID = 1236685386511267152L;


    @ApiField("app_id")
    private String appId;


    @ApiField("app_version")
    private String appVersion;


    @ApiField("bundle_id")
    private String bundleId;


    @ApiField("channel_id")
    private String channelId;


    @ApiField("debug")
    private String debug;


    @ApiField("extend")
    private String extend;


    @ApiField("idfa")
    private String idfa;


    @ApiField("ios_version")
    private String iosVersion;


    @ApiField("mac")
    private String mac;


    public String getAppId() {
        /*  71 */
        return this.appId;

    }


    public void setAppId(String appId) {
        /*  74 */
        this.appId = appId;

    }


    public String getAppVersion() {
        /*  78 */
        return this.appVersion;

    }


    public void setAppVersion(String appVersion) {
        /*  81 */
        this.appVersion = appVersion;

    }


    public String getBundleId() {
        /*  85 */
        return this.bundleId;

    }


    public void setBundleId(String bundleId) {
        /*  88 */
        this.bundleId = bundleId;

    }


    public String getChannelId() {
        /*  92 */
        return this.channelId;

    }


    public void setChannelId(String channelId) {
        /*  95 */
        this.channelId = channelId;

    }


    public String getDebug() {
        /*  99 */
        return this.debug;

    }


    public void setDebug(String debug) {
        /* 102 */
        this.debug = debug;

    }


    public String getExtend() {
        /* 106 */
        return this.extend;

    }


    public void setExtend(String extend) {
        /* 109 */
        this.extend = extend;

    }


    public String getIdfa() {
        /* 113 */
        return this.idfa;

    }


    public void setIdfa(String idfa) {
        /* 116 */
        this.idfa = idfa;

    }


    public String getIosVersion() {
        /* 120 */
        return this.iosVersion;

    }


    public void setIosVersion(String iosVersion) {
        /* 123 */
        this.iosVersion = iosVersion;

    }


    public String getMac() {
        /* 127 */
        return this.mac;

    }


    public void setMac(String mac) {
        /* 130 */
        this.mac = mac;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMsaasSecuritySendcpainfoModel
 * JD-Core Version:    0.6.0
 */