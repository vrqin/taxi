package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 66.	tab_enterprise_warning_monitore企业预警监控
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_enterprise_warning_monitore")
public class EnterpriseWarningMonitore implements Serializable {
    private int id;
    private int evaluationlevel;//	int(4)			考评等级
    private String achievementdet;//	varchar			等分详细
    private String enterprisename;//	varchar(50)			企业名称
    private int achievement;//	int(11)			总得分
    private String evaluationyears;//	varchar(20)			考评年度
    private String evaluationversion;//	varchar(20)			考评版本
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

    @Column(name = "evaluationlevel", length = 20)
    public int getEvaluationlevel() {
        return evaluationlevel;
    }

    public void setEvaluationlevel(int evaluationlevel) {
        this.evaluationlevel = evaluationlevel;
    }

    @Column(name = "achievementdet", length = 20)
    public String getAchievementdet() {
        return achievementdet;
    }

    public void setAchievementdet(String achievementdet) {
        this.achievementdet = achievementdet;
    }

    @Column(name = "enterprisename", length = 20)
    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    @Column(name = "achievement", length = 20)
    public int getAchievement() {
        return achievement;
    }

    public void setAchievement(int achievement) {
        this.achievement = achievement;
    }

    @Column(name = "evaluationyears", length = 20)
    public String getEvaluationyears() {
        return evaluationyears;
    }

    public void setEvaluationyears(String evaluationyears) {
        this.evaluationyears = evaluationyears;
    }

    @Column(name = "evaluationversion", length = 20)
    public String getEvaluationversion() {
        return evaluationversion;
    }

    public void setEvaluationversion(String evaluationversion) {
        this.evaluationversion = evaluationversion;
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
