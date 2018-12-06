package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 常用约车点信息表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_commonpoint")
public class CommonPoint implements Serializable {

    private Integer id;
    private String position; //位置描述
    private Byte type;//类型：0：景点;1：宾馆；2其他
    private String phone;//电话号码
    private String geographical;//地理位置
    private Double lg;
    private Double lat;
    private String token;
    private Integer clientid;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 20)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "position", length = 50)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "type")
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Column(name = "phone", length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "geographical")
    public String getGeographical() {
        return geographical;
    }

    public void setGeographical(String geographical) {
        this.geographical = geographical;
    }

    @Column(name = "lg")
    public Double getLg() {
        return lg;
    }

    public void setLg(Double lg) {
        this.lg = lg;
    }

    @Column(name = "lat")
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Column(name = "clientid", length = 20, columnDefinition = "INT default 0")
    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
