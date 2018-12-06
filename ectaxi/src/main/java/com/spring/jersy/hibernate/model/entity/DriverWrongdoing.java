package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 77.	tab_driver_wrongdoing驾驶员不良行为
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_driver_wrongdoing")
public class DriverWrongdoing implements Serializable {
    private int id;
    private String projectname;//	varchar(20)			项目名称
    private int points;//	int(11)			扣分
    private int score;//	int(11)			总分
    private double deductionrate;//	double			扣分率

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "projectname", length = 20)
    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    @Column(name = "points", length = 20)
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Column(name = "score", length = 20)
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Column(name = "deductionrate", length = 20)
    public double getDeductionrate() {
        return deductionrate;
    }

    public void setDeductionrate(double deductionrate) {
        this.deductionrate = deductionrate;
    }
}
