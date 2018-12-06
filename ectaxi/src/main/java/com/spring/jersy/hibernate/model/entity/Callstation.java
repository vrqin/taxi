package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 电召站管理信息表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_callstation")
public class Callstation implements Serializable {
    private Integer id;
    private String callstationId; //电召站编号
    private String name; //电召站简称
    private String phone; //电话号码
    private String position; //位置描述
    private String line;  //电召站附近路线
    private String geographical; //地理位置
    private Double lg;
    private Double lat;
    private String token;
    private int clientid;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 20)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "callstationId", length = 50)
    public String getCallstationId() {
        return callstationId;
    }

    public void setCallstationId(String callstationId) {
        this.callstationId = callstationId;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phone", length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "position", length = 50)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "line", length = 50)
    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Column(name = "geographical", length = 50)
    public String getGeographical() {
        return geographical;
    }

    public void setGeographical(String geographical) {
        this.geographical = geographical;
    }

    @Column(name = "lg", length = 50)
    public Double getLg() {
        return lg;
    }

    public void setLg(Double lg) {
        this.lg = lg;
    }

    @Column(name = "lat", length = 50)
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "clientid", length = 20, columnDefinition = "INT default 0")
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
}
