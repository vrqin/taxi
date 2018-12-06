package com.spring.jersy.hibernate.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * tab_staff
 * 员工信息表
 * Created by Administrator on 2016/9/30.
 */
@Entity
@Table(name = "tab_staff")
public class Staff implements Serializable {
    private String employeeid;//	varchar(20)			员工编号
    private String name;//varchar(20)			名称
    private String unit;//	varchar(20)			单位名称

    @Id
    @Column(name = "employeeid", unique = true, nullable = false, length = 21)
    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "unit", length = 50)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
