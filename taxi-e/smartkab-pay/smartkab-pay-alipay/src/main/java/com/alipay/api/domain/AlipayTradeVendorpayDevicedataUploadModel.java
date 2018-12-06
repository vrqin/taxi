package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayTradeVendorpayDevicedataUploadModel extends AlipayObject {
    private static final long serialVersionUID = 4175598221924493583L;


    @ApiField("app_package_name")
    private String appPackageName;


    @ApiField("ext_info")
    private String extInfo;


    @ApiField("imei")
    private String imei;


    @ApiField("imsi")
    private String imsi;


    @ApiField("mac")
    private String mac;


    @ApiField("machine_type")
    private String machineType;


    @ApiField("phone_sys_version")
    private String phoneSysVersion;


    @ApiField("public_key")
    private String publicKey;


    @ApiField("tidsource")
    private String tidsource;


    @ApiField("uuid")
    private String uuid;


    @ApiField("vendor")
    private String vendor;


    public String getAppPackageName() {
        /*  83 */
        return this.appPackageName;

    }


    public void setAppPackageName(String appPackageName) {
        /*  86 */
        this.appPackageName = appPackageName;

    }


    public String getExtInfo() {
        /*  90 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /*  93 */
        this.extInfo = extInfo;

    }


    public String getImei() {
        /*  97 */
        return this.imei;

    }


    public void setImei(String imei) {
        /* 100 */
        this.imei = imei;

    }


    public String getImsi() {
        /* 104 */
        return this.imsi;

    }


    public void setImsi(String imsi) {
        /* 107 */
        this.imsi = imsi;

    }


    public String getMac() {
        /* 111 */
        return this.mac;

    }


    public void setMac(String mac) {
        /* 114 */
        this.mac = mac;

    }


    public String getMachineType() {
        /* 118 */
        return this.machineType;

    }


    public void setMachineType(String machineType) {
        /* 121 */
        this.machineType = machineType;

    }


    public String getPhoneSysVersion() {
        /* 125 */
        return this.phoneSysVersion;

    }


    public void setPhoneSysVersion(String phoneSysVersion) {
        /* 128 */
        this.phoneSysVersion = phoneSysVersion;

    }


    public String getPublicKey() {
        /* 132 */
        return this.publicKey;

    }


    public void setPublicKey(String publicKey) {
        /* 135 */
        this.publicKey = publicKey;

    }


    public String getTidsource() {
        /* 139 */
        return this.tidsource;

    }


    public void setTidsource(String tidsource) {
        /* 142 */
        this.tidsource = tidsource;

    }


    public String getUuid() {
        /* 146 */
        return this.uuid;

    }


    public void setUuid(String uuid) {
        /* 149 */
        this.uuid = uuid;

    }


    public String getVendor() {
        /* 153 */
        return this.vendor;

    }


    public void setVendor(String vendor) {
        /* 156 */
        this.vendor = vendor;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradeVendorpayDevicedataUploadModel
 * JD-Core Version:    0.6.0
 */