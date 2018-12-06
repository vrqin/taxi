package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 160.tab_total_revenue_analysis_month总营收分析-月份
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_total_revenue_analysis_month")
public class TotalRevenueAnalysisMonth implements Serializable {
    private int id;
    private String month;//	varchar(11)
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

    @Column(name = "month", length = 20)
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
