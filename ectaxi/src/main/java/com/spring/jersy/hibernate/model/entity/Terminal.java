package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 终端信息
 * Created by Administrator on 2016/9/29.
 */
@Entity
@Table(name = "tab_terminal")
public class Terminal implements Serializable {

    private int id;
    private String terminalid;//终端编号
    private String simcard;//SIM卡号
    private int type;//	设备类型
    private String company;//	所属公司
    private String unit;//	所属单位
    private int state;//	终端状态
    private Date installtime;//	安装日期
    private int validity;//	是否有效

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "terminalid", length = 20)
    public String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid;
    }

    @Column(name = "simcard", length = 20)
    public String getSimcard() {
        return simcard;
    }

    public void setSimcard(String simcard) {
        this.simcard = simcard;
    }

    @Column(name = "type", length = 4)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(name = "company", length = 50)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "unit", length = 50)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Column(name = "state", length = 2)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "installtime", length = 50)
    public Date getInstalltime() {
        return installtime;
    }

    public void setInstalltime(Date installtime) {
        this.installtime = installtime;
    }

    @Column(name = "validity", length = 2)
    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }
}
