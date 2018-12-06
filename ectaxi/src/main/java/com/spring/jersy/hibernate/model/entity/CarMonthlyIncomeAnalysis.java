package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 94.tab_car_monthly_income_analysis车辆月收入分析
 * <p>
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_car_monthly_income_analysis")
public class CarMonthlyIncomeAnalysis implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年度
    private String company;
    private double avemonincome;//	double(11)			月均收入(元)
    private double allincome;//	double(11)			次均收入(元)
    private double kmoutput;//	double(11)			公里产值(元)
    private double bikehigincome;//	double(11)			单车最高月收入(元)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "annual", length = 20)
    public String getAnnual() {
        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
    }

    @Column(name = "avemonincome", length = 20)
    public double getAvemonincome() {
        return avemonincome;
    }

    public void setAvemonincome(double avemonincome) {
        this.avemonincome = avemonincome;
    }

    @Column(name = "allincome", length = 20)
    public double getAllincome() {
        return allincome;
    }

    public void setAllincome(double allincome) {
        this.allincome = allincome;
    }

    @Column(name = "kmoutput", length = 20)
    public double getKmoutput() {
        return kmoutput;
    }

    public void setKmoutput(double kmoutput) {
        this.kmoutput = kmoutput;
    }

    @Column(name = "bikehigincome", length = 20)
    public double getBikehigincome() {
        return bikehigincome;
    }

    public void setBikehigincome(double bikehigincome) {
        this.bikehigincome = bikehigincome;
    }

    @Column(name = "company", length = 20)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
