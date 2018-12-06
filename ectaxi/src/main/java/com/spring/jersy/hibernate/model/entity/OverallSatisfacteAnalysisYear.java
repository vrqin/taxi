package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 128.tab_overall_satisfacte_analysis_year总体满意度分析-年度
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_overall_satisfacte_analysis_year")
public class OverallSatisfacteAnalysisYear implements Serializable {
    private int id;
    private String annual;//	varchar(20)			年度
    private String companyname;//	varchar(20)			企业
    private double satisfaction;//	double(20)			满意度（%）

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

    @Column(name = "satisfaction", length = 20)
    public double getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(double satisfaction) {
        this.satisfaction = satisfaction;
    }

    @Column(name = "companyname", length = 20)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}
