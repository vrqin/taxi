package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 169.tab_audit_task_parameter稽查任务台账
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_audit_task_parameter")
public class AuditTaskParameter implements Serializable {
    private int id;
    private String auditarea;//	varchar(20)			稽查区域
    private Date starttime;//	datetime			开始时间
    private Date endtime;//datetime			结束时间
    private String tasker;//	varchar(20)			任务负责人
    private String auditnum;//	varchar(11)			稽查异常总数

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "auditarea", length = 20)
    public String getAuditarea() {
        return auditarea;
    }

    public void setAuditarea(String auditarea) {
        this.auditarea = auditarea;
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

    @Column(name = "tasker", length = 20)
    public String getTasker() {
        return tasker;
    }

    public void setTasker(String tasker) {
        this.tasker = tasker;
    }

    @Column(name = "auditnum", length = 20)
    public String getAuditnum() {
        return auditnum;
    }

    public void setAuditnum(String auditnum) {
        this.auditnum = auditnum;
    }
}
