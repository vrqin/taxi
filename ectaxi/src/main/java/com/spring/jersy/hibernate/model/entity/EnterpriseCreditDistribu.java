package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 70.	tab_enterprise_credit_distribu企业信用分布
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_enterprise_credit_distribu")
public class EnterpriseCreditDistribu implements Serializable {
    private int id;
    private int evaluationlevel;//	int(4)			考评等级
    private int enterprisenum;//	int(11)			企业数量

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

    @Column(name = "enterprisenum", length = 20)
    public int getEnterprisenum() {
        return enterprisenum;
    }

    public void setEnterprisenum(int enterprisenum) {
        this.enterprisenum = enterprisenum;
    }
}
