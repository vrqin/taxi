package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 150.tab_total_duration_analysis_year总时长分析-年度
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_total_duration_analysis_year")
public class TotalDurationAnalysisYear implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年度
    private String company;//
    private int dayshift;//	int(11)			白班（小时）
    private int lateshift;//	int(11)			晚班（小时）
    private int summary;//	int(11)			汇总（小时）

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

    @Column(name = "dayshift", length = 20)
    public int getDayshift() {
        return dayshift;
    }

    public void setDayshift(int dayshift) {
        this.dayshift = dayshift;
    }

    @Column(name = "lateshift", length = 20)
    public int getLateshift() {
        return lateshift;
    }

    public void setLateshift(int lateshift) {
        this.lateshift = lateshift;
    }

    @Column(name = "summary", length = 20)
    public int getSummary() {
        return summary;
    }

    public void setSummary(int summary) {
        this.summary = summary;
    }

    @Column(name = "company", length = 20)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
