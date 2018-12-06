package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 59.	tab_version_manages版本管理
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_version_manages")
public class VersionManages implements Serializable {
    private int id;
    private String versionName;//	varchar(20)			版本名称
    private String indicatorspro;//	varchar(20)			指标项目
    private String versionyears;//	varchar(20)			版本年度
    private String evaluationtime;//	datetime			考评时间
    private String explanation;//	varchar(20)			说明
    private Date createtime;//	datetime			创建时间
    private int type;//	int(2)			版本类型：0：企业，1：驾驶员
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

    @Column(name = "versionName", length = 20)
    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    @Column(name = "indicatorspro", length = 20)
    public String getIndicatorspro() {
        return indicatorspro;
    }

    public void setIndicatorspro(String indicatorspro) {
        this.indicatorspro = indicatorspro;
    }

    @Column(name = "versionyears", length = 20)
    public String getVersionyears() {
        return versionyears;
    }

    public void setVersionyears(String versionyears) {
        this.versionyears = versionyears;
    }

    @Column(name = "evaluationtime", length = 50)
    public String getEvaluationtime() {
        return evaluationtime;
    }

    public void setEvaluationtime(String evaluationtime) {
        this.evaluationtime = evaluationtime;
    }

    @Column(name = "explanation", length = 20)
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createtime", length = 50)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Column(name = "type", length = 20)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
