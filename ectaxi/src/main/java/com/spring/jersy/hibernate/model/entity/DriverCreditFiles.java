package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 73.	tab_driver_credit_files驾驶员信用档案
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_driver_credit_files")
public class DriverCreditFiles implements Serializable {
    private int id;
    private String account;//	varchar(20)			驾驶员姓名
    private String phone;//	varchar(20)			联系电话
    private String enterprisename;//	varchar(20)			企业名称
    private String evaluationyear;//varchar(20)			考评年度
    private String evaluationlevel;//	varchar(20)			考评版本
    private int evaluationscore;//	int(4)			考评等级
    private int achievement;//	int(11)			总得分
    private Date evaluationtime;//	datetime			考评时间

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

    @Column(name = "phone", length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "enterprisename", length = 20)
    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    @Column(name = "evaluationyear", length = 20)
    public String getEvaluationyear() {
        return evaluationyear;
    }

    public void setEvaluationyear(String evaluationyear) {
        this.evaluationyear = evaluationyear;
    }

    @Column(name = "evaluationlevel", length = 20)
    public String getEvaluationlevel() {
        return evaluationlevel;
    }

    public void setEvaluationlevel(String evaluationlevel) {
        this.evaluationlevel = evaluationlevel;
    }

    @Column(name = "evaluationscore", length = 4)
    public int getEvaluationscore() {
        return evaluationscore;
    }

    public void setEvaluationscore(int evaluationscore) {
        this.evaluationscore = evaluationscore;
    }

    @Column(name = "achievement", length = 20)
    public int getAchievement() {
        return achievement;
    }

    public void setAchievement(int achievement) {
        this.achievement = achievement;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "evaluationtime", length = 50)
    public Date getEvaluationtime() {
        return evaluationtime;
    }

    public void setEvaluationtime(Date evaluationtime) {
        this.evaluationtime = evaluationtime;
    }
}
