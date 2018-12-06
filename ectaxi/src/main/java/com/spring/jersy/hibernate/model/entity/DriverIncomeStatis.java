package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 年
 * tab_driver_income_statis
 * 司机收入统计
 * "年度""司机名称""收入金额"
 * Created by Administrator on 2016/9/30.
 */
@Entity
@Table(name = "tab_driver_income_statis")
public class DriverIncomeStatis implements Serializable {
    //    private int id;
    private String annual;//	varchar(20)			年度
    private double amount;//	double(20)			收入金额
    private String acount; //司机名称
    private String company;
    private int clientid;

    @Id
    @Column(name = "acount", unique = true, nullable = false, length = 11)
    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    @Column(name = "annual", length = 20)
    public String getAnnual() {
        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
    }

    @Column(name = "amount", length = 20)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Transient
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    @Column(name = "clientid", length = 20)
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }


}
