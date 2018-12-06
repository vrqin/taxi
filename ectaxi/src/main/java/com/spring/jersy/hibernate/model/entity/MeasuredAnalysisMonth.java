package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 142.tab_measured_analysis_month总体投诉率分析-月份
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_measured_analysis_month")
public class MeasuredAnalysisMonth implements Serializable {
    private int id;
    private String month;//	varchar(20)			年度
    private double measured;//	double(11)			投诉率（%）
    private String companyname;

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

    @Column(name = "companyname", length = 20)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }


    @Column(name = "measured", length = 20)
    public double getMeasured() {
        return measured;
    }

    public void setMeasured(double measured) {
        this.measured = measured;
    }
}
