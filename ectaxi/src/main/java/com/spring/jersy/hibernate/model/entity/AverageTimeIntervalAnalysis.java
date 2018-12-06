package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 126.tab_average_time_interval_analysis平均时间间隔分析
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_average_time_interval_analysis")
public class AverageTimeIntervalAnalysis implements Serializable {
    private int id;
    private String area;//	varchar(20)			区域名称
    private double duration;//	double(20)		平均载客时间间隔（分钟）
    private String date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "area", length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "duration", length = 20)
    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Column(name = "date", length = 20)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
