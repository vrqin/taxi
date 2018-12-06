package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 95.tab_peaktime_income_analysis高峰时段收入分析
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_peaktime_income_analysis_day")
public class PeaktimeIncomeAnalysisDay implements Serializable {
    private int id;
    private String date;//	varchar(11)			年度
    private String companyname;//	varchar(11)			班别
    private String classset;//	varchar(11)			班别
    private double allincome;//	double(11)			次均收入(元)
    private double avedayincome;//	double(11)			日均收入(元)
    private double bikehigincome;//	double(11)			单车最高日收入(元)
    private double kmoutput;//	double(11)			公里产值(元)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "date", length = 20)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "classset", length = 20)
    public String getClassset() {
        return classset;
    }

    public void setClassset(String classset) {
        this.classset = classset;
    }

    @Column(name = "allincome", length = 20)
    public double getAllincome() {
        return allincome;
    }

    public void setAllincome(double allincome) {
        this.allincome = allincome;
    }

    @Column(name = "avedayincome", length = 20)
    public double getAvedayincome() {
        return avedayincome;
    }

    public void setAvedayincome(double avedayincome) {
        this.avedayincome = avedayincome;
    }

    @Column(name = "bikehigincome", length = 20)
    public double getBikehigincome() {
        return bikehigincome;
    }

    public void setBikehigincome(double bikehigincome) {
        this.bikehigincome = bikehigincome;
    }

    @Column(name = "kmoutput", length = 20)
    public double getKmoutput() {
        return kmoutput;
    }

    public void setKmoutput(double kmoutput) {
        this.kmoutput = kmoutput;
    }

    @Column(name = "companyname", length = 20)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}
