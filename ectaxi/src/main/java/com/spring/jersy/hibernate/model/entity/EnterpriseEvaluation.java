package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 61.	tab_enterprise_evaluation企业考评
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_enterprise_evaluation")
public class EnterpriseEvaluation implements Serializable {
    private int id;//
    private String evaluation;//	varchar(20)			考评
    private String enterprisename;//	varchar(50)			企业名称
    private String evaluationversion;//	varchar(20)			考评版本
    private String evaluationyear;//	varchar(20)			考评年度
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

    @Column(name = "evaluationyear", length = 20)
    public String getEvaluationyear() {
        return evaluationyear;
    }

    public void setEvaluationyear(String evaluationyear) {
        this.evaluationyear = evaluationyear;
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
