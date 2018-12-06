package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 130.tab_overall_satisfacte_analysis_day总体满意度分析-日期
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_overall_satisfacte_analysis_day")
public class OverallSatisfacteAnalysisDay implements Serializable {
    private int id;
    private String date;//	varchar(20)			年度
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

    @Column(name = "date", length = 20)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
