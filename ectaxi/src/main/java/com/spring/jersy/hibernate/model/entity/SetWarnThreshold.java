package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 65.	tab_set_warn_threshold设置预警阀值
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_set_warn_threshold")
public class SetWarnThreshold implements Serializable {
    private int id;
    private String versionname;//	varchar(20)			版本名称
    private String versionyears;//	varchar(20)			版本年度
    private String evaluationtime;//	datetime			考评时间
    private int type;//	int(2)			版本类型
    private int status;//	int(2)			阀值状态

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "versionname", length = 20)
    public String getVersionname() {
        return versionname;
    }

    public void setVersionname(String versionname) {
        this.versionname = versionname;
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

    @Column(name = "type", length = 20)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(name = "status", length = 20)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
