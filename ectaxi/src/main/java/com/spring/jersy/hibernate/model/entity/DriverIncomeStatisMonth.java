package com.spring.jersy.hibernate.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * tab_driver_income_statis
 * 司机收入统计
 * "年度""司机名称""收入金额"
 * Created by Administrator on 2016/9/30.
 */
@Entity
@Table(name = "tab_driver_income_statis_month")
public class DriverIncomeStatisMonth implements Serializable {

    private String month;//	varchar(20)			年度
    private double amount;//	double(20)			收入金额
    private String acount; //司机名称
    private String company;
    private int clientid;


    @Column(name = "month", length = 20)
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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

    @Column(name = "company", length = 20)
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
