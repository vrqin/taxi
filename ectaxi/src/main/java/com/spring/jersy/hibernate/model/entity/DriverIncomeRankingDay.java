package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 98.tab_driver_income_ranking驾驶员收入排行
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_driver_income_ranking_day")
public class DriverIncomeRankingDay implements Serializable {
    private int id;
    private String account;//	varchar(11)			驾驶员姓名
    private String kabnum;//	varchar(11)			车牌号码
    private String companyname;//	double(11)			公司名称
    private double grossincome;//	double(11)			总收入(元)
    private double dateavemonincome;//	double(11)			月均收入(元)
    private String date;

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

    @Column(name = "grossincome", length = 20)
    public double getGrossincome() {
        return grossincome;
    }

    public void setGrossincome(double grossincome) {
        this.grossincome = grossincome;
    }

    @Column(name = "dateavemonincome", length = 20)
    public double getDateavemonincome() {
        return dateavemonincome;
    }

    public void setDateavemonincome(double dateavemonincome) {
        this.dateavemonincome = dateavemonincome;
    }

    @Column(name = "companyname", length = 20)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Column(name = "date", length = 20)

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
