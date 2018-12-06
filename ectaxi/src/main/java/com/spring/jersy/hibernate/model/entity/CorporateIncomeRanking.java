package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 96.tab_corporate_income_ranking企业收入排行
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_corporate_income_ranking")
public class CorporateIncomeRanking implements Serializable {
    private int id;
    private String companyname;//	varchar(50)			公司名称
    private double grossincome;//	double(11)			总收入(元)
    private double avemonincome;//	double(11)			月均收入(元)
    private String month;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "companyname", length = 50)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Column(name = "grossincome", length = 20)
    public double getGrossincome() {
        return grossincome;
    }

    public void setGrossincome(double grossincome) {
        this.grossincome = grossincome;
    }

    @Column(name = "avemonincome", length = 20)
    public double getAvemonincome() {
        return avemonincome;
    }

    public void setAvemonincome(double avemonincome) {
        this.avemonincome = avemonincome;
    }

    @Column(name = "month", length = 20)
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
