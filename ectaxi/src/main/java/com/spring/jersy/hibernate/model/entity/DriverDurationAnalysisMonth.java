package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 157.tab_driver_duration_analysis_month驾驶员时长分析-月份
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_driver_duration_analysis_month")
public class DriverDurationAnalysisMonth implements Serializable {
    private int id;
    private String account;//	varchar(20)			驾驶员姓名
    private String month;//	varchar(11)			月份
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

    @Column(name = "account", length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "month", length = 20)
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
}
