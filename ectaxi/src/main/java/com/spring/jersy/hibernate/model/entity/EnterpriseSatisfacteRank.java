package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 131.tab_enterprise_satisfacte_rank企业满意度排名
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_enterprise_satisfacte_rank")
public class EnterpriseSatisfacteRank implements Serializable {
    private int id;
    private String companyname;//	varchar(20)			企业名称
    private int rank;//	int(11)			排名
    private double satisfaction;//	double(20)			满意度（%）
    private String satistime;//时间

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "companyname", length = 20)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Column(name = "rank", length = 20)
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Column(name = "satisfaction", length = 20)
    public double getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(double satisfaction) {
        this.satisfaction = satisfaction;
    }


    @Column(name = "satistime", length = 50)
    public String getSatistime() {
        return satistime;
    }

    public void setSatistime(String satistime) {
        this.satistime = satistime;
    }


}
