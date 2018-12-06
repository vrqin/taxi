package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 168.tab_audit_task_management稽查任务管理
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_audit_task_management")
public class AuditTaskManagement implements Serializable {
    private int id;
    private String taskname;//	varchar(50)			任务名称
    private Date starttime;//	starttime			开始时间
    private Date endtime;//	endtime			结束时间
    private int taskstatus;//	int(4)			任务状态
    private int changestates;//	int(4)			更改状态
    private Double lg;
    private Double lat;
    private Double radius;
    private String token;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "taskname", length = 20)
    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "starttime", length = 50)
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "endtime", length = 50)
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    @Column(name = "taskstatus", length = 4)
    public int getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(int taskstatus) {
        this.taskstatus = taskstatus;
    }

    @Column(name = "changestates", length = 4)
    public int getChangestates() {
        return changestates;
    }

    public void setChangestates(int changestates) {
        this.changestates = changestates;
    }

    @Column(name = "lg", length = 20, scale = 6)
    public Double getLg() {
        return lg;
    }

    public void setLg(Double lg) {
        this.lg = lg;
    }

    @Column(name = "lat", length = 20, scale = 6)
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Column(name = "radius", length = 20, scale = 2)
    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
