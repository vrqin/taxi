package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 司机注册审核
 * 司机申请信息与司机注册审核为同一表
 * Created by Administrator on 2016/9/29.
 */
@Entity
@Table(name = "tab_driver_reg")
public class DriverReg implements Serializable {
    private int id;
    private String name;    //varchar(20)			姓名
    private String phone;    //varchar(20)			手机号
    private String identity;//	varchar(20)			身份证号
    private String operationid;//	varchar(20)			运营证号
    private String kabnum;    //varchar(20)			车牌号
    private Date applytime;//	datetime			申请时间
    private Date audittime;    //datetime			审核时间
    private int applystatus;//	int(4)			申请状态

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phone", length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "identity", length = 20)
    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Column(name = "operationid", length = 20)
    public String getOperationid() {
        return operationid;
    }

    public void setOperationid(String operationid) {
        this.operationid = operationid;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "applytime", length = 50)
    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "audittime", length = 50)
    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    @Column(name = "applystatus", length = 4)
    public int getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(int applystatus) {
        this.applystatus = applystatus;
    }
}
