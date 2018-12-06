package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 91.tab_driver_information_analysis_age驾驶员信息分析---年龄段
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_driver_information_analysis_age")
public class DriverInformationAnalysisAge implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年份
    private int age24;//	int(11)			18~24岁
    private int age29;//	int(11)			25~29岁
    private int age34;//	int(11)			30~34岁
    private int age39;//	int(11)			35~39岁
    private int age44;//	int(11)			40~44岁
    private int age49;//	int(11)			45~49岁
    private int age54;//	int(11)			50~54岁
    private int age59;//	int(11)			55~59岁
    private int age60;//	int(11)			60岁以上
    private int unknown;//	int(11)			未知
    private int total;//	int(11)			合计

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "annual", length = 20)
    public String getAnnual() {
        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
    }

    @Column(name = "age24", length = 20)
    public int getAge24() {
        return age24;
    }

    public void setAge24(int age24) {
        this.age24 = age24;
    }

    @Column(name = "age29", length = 20)
    public int getAge29() {
        return age29;
    }

    public void setAge29(int age29) {
        this.age29 = age29;
    }

    @Column(name = "age34", length = 20)
    public int getAge34() {
        return age34;
    }

    public void setAge34(int age34) {
        this.age34 = age34;
    }

    @Column(name = "age39", length = 20)
    public int getAge39() {
        return age39;
    }

    public void setAge39(int age39) {
        this.age39 = age39;
    }

    @Column(name = "age44", length = 20)
    public int getAge44() {
        return age44;
    }

    public void setAge44(int age44) {
        this.age44 = age44;
    }

    @Column(name = "age49", length = 20)
    public int getAge49() {
        return age49;
    }

    public void setAge49(int age49) {
        this.age49 = age49;
    }

    @Column(name = "age54", length = 20)
    public int getAge54() {
        return age54;
    }

    public void setAge54(int age54) {
        this.age54 = age54;
    }

    @Column(name = "age59", length = 20)
    public int getAge59() {
        return age59;
    }

    public void setAge59(int age59) {
        this.age59 = age59;
    }

    @Column(name = "age60", length = 20)
    public int getAge60() {
        return age60;
    }

    public void setAge60(int age60) {
        this.age60 = age60;
    }

    @Column(name = "unknown", length = 20)
    public int getUnknown() {
        return unknown;
    }

    public void setUnknown(int unknown) {
        this.unknown = unknown;
    }

    @Column(name = "total", length = 20)
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
