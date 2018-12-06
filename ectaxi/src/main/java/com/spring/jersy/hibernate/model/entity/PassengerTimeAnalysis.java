package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 124.tab_passenger_time_analysis载客时长分析
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_passenger_time_analysis")
public class PassengerTimeAnalysis implements Serializable {
    private int id;
    private String date;
    private String area;//	varchar(20)			区域名称
    private double duration;//	double(20)			平均每次载客时长（分钟）

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
