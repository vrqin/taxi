package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 63.	tab_driver_evaluation驾驶员考评
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_driver_evaluation")
public class DriverEvaluation implements Serializable {
    private int id;
    private String evaluation;//	varchar(20)			考评
    private String account;//	varchar(20)			驾驶员姓名
    private String seniority;//	varchar(20)			从业资格证号
    private String kabnum;//	varchar(20)			车牌号
    private String enterprisename;//	varchar(50)			企业名称
    private String evaluationversion;//	varchar(20)			考评版本
    private String evaluationyears;//	varchar(20)			考评年度
    private int evaluationtype;//	int(4)			考评状态
    private Date evaluationtime;//	datetime			考评时间
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

    @Column(name = "evaluation", length = 20)
    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    @Column(name = "account", length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "seniority", length = 20)
    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "enterprisename", length = 20)
    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    @Column(name = "evaluationversion", length = 20)
    public String getEvaluationversion() {
        return evaluationversion;
    }

    public void setEvaluationversion(String evaluationversion) {
        this.evaluationversion = evaluationversion;
    }

    @Column(name = "evaluationyears", length = 20)
    public String getEvaluationyears() {
        return evaluationyears;
    }

    public void setEvaluationyears(String evaluationyears) {
        this.evaluationyears = evaluationyears;
    }

    @Column(name = "evaluationtype", length = 20)
    public int getEvaluationtype() {
        return evaluationtype;
    }

    public void setEvaluationtype(int evaluationtype) {
        this.evaluationtype = evaluationtype;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
