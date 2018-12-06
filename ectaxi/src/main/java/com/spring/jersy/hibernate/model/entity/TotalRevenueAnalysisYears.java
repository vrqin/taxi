package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 159.tab_total_revenue_analysis_years总营收分析-年度
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_total_revenue_analysis_years")
public class TotalRevenueAnalysisYears implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年度
    private double dayshifthourse;//	double(11)			白班（小时）
    private double dayshiftmoney;//	double(11)			白班（元）
    private double lateshifthourse;//	double(11)			晚班（小时）
    private double lateshiftmoney;//	double(11)			晚班（元）
    private double summary;//	double(11)			汇总（元）

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

    @Column(name = "dayshifthourse", length = 20)
    public double getDayshifthourse() {
        return dayshifthourse;
    }

    public void setDayshifthourse(double dayshifthourse) {
        this.dayshifthourse = dayshifthourse;
    }

    @Column(name = "dayshiftmoney", length = 20)
    public double getDayshiftmoney() {
        return dayshiftmoney;
    }

    public void setDayshiftmoney(double dayshiftmoney) {
        this.dayshiftmoney = dayshiftmoney;
    }

    @Column(name = "lateshifthourse", length = 20)
    public double getLateshifthourse() {
        return lateshifthourse;
    }

    public void setLateshifthourse(double lateshifthourse) {
        this.lateshifthourse = lateshifthourse;
    }

    @Column(name = "lateshiftmoney", length = 20)
    public double getLateshiftmoney() {
        return lateshiftmoney;
    }

    public void setLateshiftmoney(double lateshiftmoney) {
        this.lateshiftmoney = lateshiftmoney;
    }

    @Column(name = "summary", length = 20)
    public double getSummary() {
        return summary;
    }

    public void setSummary(double summary) {
        this.summary = summary;
    }
}
