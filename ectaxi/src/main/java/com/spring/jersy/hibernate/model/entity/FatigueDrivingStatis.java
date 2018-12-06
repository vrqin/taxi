package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 疲劳驾驶统计
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_fatigue_driving_statis")
public class FatigueDrivingStatis implements Serializable {
    private Integer id;
    private String kabnum;//车牌号码
    private String driver;//驾驶员
    private String unit;//所属单位
    private Integer cumulative;//累计次数
    private double duration;//时间

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "driver", length = 20)
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Column(name = "unit", length = 50)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Column(name = "cumulative", length = 20)
    public Integer getCumulative() {
        return cumulative;
    }

    public void setCumulative(Integer cumulative) {
        this.cumulative = cumulative;
    }

    @Column(name = "duration", length = 50)
    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
