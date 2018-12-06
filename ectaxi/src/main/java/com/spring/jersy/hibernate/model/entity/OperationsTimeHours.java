package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 121.tab_operations_time_hours运营次数-按时段-小时
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_operations_time_hours")
public class OperationsTimeHours implements Serializable {
    private int id;
    private Date hourse;//	varchar(11)			月份
    private String area;//	varchar(11)			区域
    private String companyname;//	varchar(11)			企业名称
    private int operationcarnum;//	int(11)			营运车辆数
    private int totaloperation;//	int(11)			总营运次数
    private int avedatebikeoperatnum;//	int(11)			日均单车营运次数

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hourse", length = 50)
    public Date getHourse() {
        return hourse;
    }

    public void setHourse(Date hourse) {
        this.hourse = hourse;
    }


    @Column(name = "area", length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "companyname", length = 20)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Column(name = "operationcarnum", length = 20)
    public int getOperationcarnum() {
        return operationcarnum;
    }

    public void setOperationcarnum(int operationcarnum) {
        this.operationcarnum = operationcarnum;
    }

    @Column(name = "totaloperation", length = 20)
    public int getTotaloperation() {
        return totaloperation;
    }

    public void setTotaloperation(int totaloperation) {
        this.totaloperation = totaloperation;
    }

    @Column(name = "avedatebikeoperatnum", length = 20)
    public int getAvedatebikeoperatnum() {
        return avedatebikeoperatnum;
    }

    public void setAvedatebikeoperatnum(int avedatebikeoperatnum) {
        this.avedatebikeoperatnum = avedatebikeoperatnum;
    }
}
