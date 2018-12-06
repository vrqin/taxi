package com.spring.jersy.hibernate.publics.bean;

/**
 * 电召单返回结果
 * Created by Administrator on 2016/5/27.
 */
public class OrderResult {
    private int code;
    private String desc;
    private String orderId;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderResult{" + "code=" + code + ", desc='" + desc + '\'' + ", orderId='" + orderId + '\'' + '}';
    }
}
