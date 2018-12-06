package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 52.	tab_operat_details运营数据明细
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_operat_details")
public class OperatDetails implements Serializable {
    private int id;
    private String account;//	varchar(20)			驾驶员姓名
    private String kabnum;//	varchar(20)			车牌号
    private Date ordertime;//	datetime			下单时间
    private Date getontime;//	datetime			上车时间
    private Date getofftime;//	datetime			下车时间
    private int enterprise;//	varchar(20)			企业id
    private double passmile;//	double(20)			载客里程
    private double emptymile;//	double(20)			空驶里程
    private double amount;//	double(20)			交易金额
    private int evaluation;//	varchar(20)			评价
    private String company; //企业名称

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "account", length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ordertime", length = 50)
    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "getontime", length = 50)
    public Date getGetontime() {
        return getontime;
    }

    public void setGetontime(Date getontime) {
        this.getontime = getontime;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "getofftime", length = 50)
    public Date getGetofftime() {
        return getofftime;
    }

    public void setGetofftime(Date getofftime) {
        this.getofftime = getofftime;
    }

    @Column(name = "enterprise", length = 20)
    public int getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(int enterprise) {
        this.enterprise = enterprise;
    }

    @Column(name = "passmile", length = 20)
    public double getPassmile() {
        return passmile;
    }

    public void setPassmile(double passmile) {
        this.passmile = passmile;
    }

    @Column(name = "emptymile", length = 20)
    public double getEmptymile() {
        return emptymile;
    }

    public void setEmptymile(double emptymile) {
        this.emptymile = emptymile;
    }

    @Column(name = "amount", length = 20)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "evaluation", length = 20)
    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    @Transient
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
