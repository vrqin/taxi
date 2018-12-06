package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 紧急报警统计信息表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_emergency_alarm_statis")
public class EmergencyAlarmStatis implements Serializable {

    private Integer id;
    private String kabnum;//车牌号码
    private String driver;//驾驶员
    private String unit;//所属单位
    private String operatname;//操作名称
    private Integer operatfrequency;//操作次数
    private Date time;//时间


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "driver", length = 20)
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Column(name = "unit", length = 50)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Column(name = "operatname", length = 20)
    public String getOperatname() {
        return operatname;
    }

    public void setOperatname(String operatname) {
        this.operatname = operatname;
    }

    @Column(name = "operatfrequency", length = 20)
    public Integer getOperatfrequency() {
        return operatfrequency;
    }

    public void setOperatfrequency(Integer operatfrequency) {
        this.operatfrequency = operatfrequency;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time", length = 50)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
