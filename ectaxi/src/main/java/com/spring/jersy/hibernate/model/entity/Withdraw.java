package com.spring.jersy.hibernate.model.entity;

/**
 * Created by Administrator on 2016/9/11.
 */

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 提现详细列表信息表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_withdraw")
public class Withdraw implements Serializable {
    private String orderid;
    private String phone;//司机电话
    private String name;//司机姓名
    private Double amount;//提现金额
    private Date extracttime;//提现时间
    private Integer way;//提现方式
    private String cashaccount;//提现账户
    private Integer state;//状态
    private String dealpeople;//处理人
    private String transactionnum;//交易流水号
    private Date dealtime;//处理时间
    private String token;


    @Id
    @Column(name = "orderid", unique = true, nullable = false, length = 50)
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phone", length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "amount", length = 20)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "extracttime", length = 50)
    public Date getExtracttime() {
        return extracttime;
    }

    public void setExtracttime(Date extracttime) {
        this.extracttime = extracttime;
    }

    @Column(name = "way", length = 4)
    public Integer getWay() {
        return way;
    }

    public void setWay(Integer way) {
        this.way = way;
    }

    @Column(name = "cashaccount", length = 20)
    public String getCashaccount() {
        return cashaccount;
    }

    public void setCashaccount(String cashaccount) {
        this.cashaccount = cashaccount;
    }

    @Column(name = "state", length = 4, columnDefinition = "INT default 0")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Column(name = "dealpeople", length = 20)
    public String getDealpeople() {
        return dealpeople;
    }

    public void setDealpeople(String dealpeople) {
        this.dealpeople = dealpeople;
    }

    @Column(name = "transactionnum", length = 20)
    public String getTransactionnum() {
        return transactionnum;
    }

    public void setTransactionnum(String transactionnum) {
        this.transactionnum = transactionnum;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dealtime", length = 50)
    public Date getDealtime() {
        return dealtime;
    }

    public void setDealtime(Date dealtime) {
        this.dealtime = dealtime;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Withdraw{" + "orderid='" + orderid + '\'' + ", phone='" + phone + '\'' + ", name='" + name + '\'' + ", amount=" + amount + ", extracttime=" + extracttime + ", way=" + way + ", cashaccount='" + cashaccount + '\'' + ", state=" + state + ", dealpeople='" + dealpeople + '\'' + ", transactionnum='" + transactionnum + '\'' + ", dealtime=" + dealtime + ", token='" + token + '\'' + '}';
    }
}
