package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * tab_driver_income_statis
 * 司机收入统计
 * "年度""司机名称""收入金额"
 * Created by Administrator on 2016/9/30.
 */
@Entity
@Table(name = "tab_driver_income_statis_day")
public class DriverIncomeStatisDay implements Serializable {
    //    private int id;
    private String date;//	varchar(20)			年度
    private double amount;//	double(20)			收入金额
    private String acount; //司机名称
    private String company;
    private int clientid;

    @Column(name = "date", length = 20)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Id
    @Column(name = "acount", unique = true, nullable = false, length = 20)
    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
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
