package com.spring.jersy.hibernate.publics.bean;

/**
 * Created by Administrator on 2017/2/4.
 */
public class WalletBean {
    private String account;
    private Double money;//金额
    private Integer paytype;//支付方式：0：现金；1：支付宝；2：微信
    private Integer ordernum;//电召单数

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }
}
