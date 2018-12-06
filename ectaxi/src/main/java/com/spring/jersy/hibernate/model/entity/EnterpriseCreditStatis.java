package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 71.	tab_enterprise_credit_statis企业信用统计
 * <p>
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_enterprise_credit_statis")
public class EnterpriseCreditStatis implements Serializable {
    private int id;
    private String evaluationyear;//	varchar(20)			考评年度
    private int evaluationscore;//	int(11)			考评分数
    private int evaluationlevel;//	int(4)			考评等级

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "evaluationyear", length = 20)
    public String getEvaluationyear() {
        return evaluationyear;
    }

    public void setEvaluationyear(String evaluationyear) {
        this.evaluationyear = evaluationyear;
    }

    @Column(name = "evaluationscore", length = 20)
    public int getEvaluationscore() {
        return evaluationscore;
    }

    public void setEvaluationscore(int evaluationscore) {
        this.evaluationscore = evaluationscore;
    }

    @Column(name = "evaluationlevel", length = 4)
    public int getEvaluationlevel() {
        return evaluationlevel;
    }

    public void setEvaluationlevel(int evaluationlevel) {
        this.evaluationlevel = evaluationlevel;
    }
}
