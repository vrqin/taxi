package com.speedtalk.smartkab.pay.ws.domain;

public class WeChatH5PayInfo extends Response {
    private String appid;
    private String timestamp;
    private String noncestr;
    private String packagestr;
    private String signtype;
    private String sign;

    public WeChatH5PayInfo() {
        super();
    }

    public WeChatH5PayInfo(String code, String desc) {
        setCode(code);
        setDesc(desc);
    }

    public WeChatH5PayInfo(String appid, String timestamp, String noncestr, String packagestr, String signtype, String sign) {
        super();
        this.appid = appid;
        this.timestamp = timestamp;
        this.noncestr = noncestr;
        this.packagestr = packagestr;
        this.signtype = signtype;
        this.sign = sign;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getPackagestr() {
        return packagestr;
    }

    public void setPackagestr(String packagestr) {
        this.packagestr = packagestr;
    }

    public String getSigntype() {
        return signtype;
    }

    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "WeChatH5PayInfo [appid=" + appid + ", timestamp=" + timestamp + ", noncestr=" + noncestr + ", packagestr=" + packagestr + ", signtype=" + signtype + ", sign=" + sign + ", getCode()=" + getCode() + ", getDesc()=" + getDesc() + "]";
    }
}
