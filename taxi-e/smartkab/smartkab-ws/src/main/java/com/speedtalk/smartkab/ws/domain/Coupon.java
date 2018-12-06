package com.speedtalk.smartkab.ws.domain;

public class Coupon {
    private String code;
    private String desc;
    private String couponid;
    private String type;
    private String value;
    private String ischeck;
    private String expire;
    private String condition;
    private String deduction;
    private String starttime;

    public Coupon() {
        super();
    }

    public Coupon(String code, String desc, String couponid, String type, String value, String ischeck, String expire, String deduction, String condition, String starttime) {
        super();
        this.code = code;
        this.desc = desc;
        this.couponid = couponid;
        this.type = type;
        this.value = value;
        this.ischeck = ischeck;
        this.expire = expire;
        this.deduction = deduction;
        this.condition = condition;
        this.starttime = starttime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCouponid() {
        return couponid;
    }

    public void setCouponid(String couponid) {
        this.couponid = couponid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getDeduction() {
        return deduction;
    }

    public void setDeduction(String deduction) {
        this.deduction = deduction;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
}
