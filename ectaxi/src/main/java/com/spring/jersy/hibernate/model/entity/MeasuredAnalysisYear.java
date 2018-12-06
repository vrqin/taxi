package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 141.tab_measured_analysis_year总体投诉率分析-年度
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_measured_analysis_year")
public class MeasuredAnalysisYear implements Serializable {
    private int id;
    private String annual;//	varchar(20)			年度
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

    @Column(name = "annual", length = 20)
    public String getAnnual() {
        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
    }

    @Column(name = "measured", length = 20)
    public double getMeasured() {
        return measured;
    }

    public void setMeasured(double measured) {
        this.measured = measured;
    }

    @Column(name = "companyname", length = 20)

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}
