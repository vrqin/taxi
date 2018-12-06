package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 129.tab_overall_satisfacte_analysis_month总体满意度分析-月份
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_overall_satisfacte_analysis_month")
public class OverallSatisfacteAnalysisMonth implements Serializable {
    private int id;
    private String month;//	varchar(20)			年度
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

    @Column(name = "month", length = 20)
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
