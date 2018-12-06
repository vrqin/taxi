package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 驾驶员违规统计信息表
 * Created by Administrator on 2016/9/5.
 */

@Entity
@Table(name = "tab_driver_vio_statis")
public class DriverVioStatis implements Serializable {

    private Integer id;
    private String name; //驾驶员姓名
    private Integer complaints;//投诉次数
    private Double speedlimit;//超速
    private Integer fatigue;//疲劳驾驶
    private Integer timeoutpark;//超时停车
    private String arealine;//进出区域/路线
    private Integer total;//合计次数


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "complaints", length = 20)
    public Integer getComplaints() {
        return complaints;
    }

    public void setComplaints(Integer complaints) {
        this.complaints = complaints;
    }

    @Column(name = "speedlimit", length = 20)
    public Double getSpeedlimit() {
        return speedlimit;
    }

    public void setSpeedlimit(Double speedlimit) {
        this.speedlimit = speedlimit;
    }

    @Column(name = "fatigue", length = 20)
    public Integer getFatigue() {
        return fatigue;
    }

    public void setFatigue(Integer fatigue) {
        this.fatigue = fatigue;
    }


    @Column(name = "timeoutpark", length = 50)
    public Integer getTimeoutpark() {
        return timeoutpark;
    }

    public void setTimeoutpark(Integer timeoutpark) {
        this.timeoutpark = timeoutpark;
    }

    @Column(name = "arealine", length = 20)
    public String getArealine() {
        return arealine;
    }

    public void setArealine(String arealine) {
        this.arealine = arealine;
    }

    @Column(name = "total", length = 20)
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
