package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 60.	tab_assess_manage考评管理
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_assess_manages")
public class AssessManage implements Serializable {
    private int id;
    private String evaluationlevel;//	int(4)			考评等级
    private int fractionone;//	int(8)			分值1
    private int fractiontwo;//	int(8)			分值2
    private int type;//	int(4)			类型//0大于 1介于 2小于
    private int levelexplanation;//	varchar			等级说明 0优秀 1良好 2中等 3不及格
    private Date createtime;//	datetime			创建时间
    private int versiontype;//	int(2)			版本类型：0：企业，1：驾驶员

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
    public String getEvaluationlevel() {
        return evaluationlevel;
    }

    public void setEvaluationlevel(String evaluationlevel) {
        this.evaluationlevel = evaluationlevel;
    }

    @Column(name = "fractionone", length = 20)
    public int getFractionone() {
        return fractionone;
    }

    public void setFractionone(int fractionone) {
        this.fractionone = fractionone;
    }

    @Column(name = "fractiontwo", length = 20)
    public int getFractiontwo() {
        return fractiontwo;
    }

    public void setFractiontwo(int fractiontwo) {
        this.fractiontwo = fractiontwo;
    }

    @Column(name = "type", length = 20)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(name = "levelexplanation", length = 20)
    public int getLevelexplanation() {
        return levelexplanation;
    }

    public void setLevelexplanation(int levelexplanation) {
        this.levelexplanation = levelexplanation;
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

    @Column(name = "versiontype", length = 20)
    public int getVersiontype() {
        return versiontype;
    }

    public void setVersiontype(int versiontype) {
        this.versiontype = versiontype;
    }
}
