package com.speedtalk.smartkab.ws.domain;

public class CheckCoupon {
    private String account;
    private long couponid;
    private String type;

    public CheckCoupon() {
        super();
    }

    public CheckCoupon(String account, long couponid, String type) {
        super();
        this.account = account;
        this.couponid = couponid;
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public long getCouponid() {
        return couponid;
    }

    public void setCouponid(long couponid) {
        this.couponid = couponid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CheckCoupon [account=" + account + ", couponid=" + couponid + ", type=" + type + "]";
    }
}
