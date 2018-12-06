package com.spring.jersy.hibernate.model.entity;


import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 失物入库信息表tab_lostlibrary
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_lostlibrary")
public class LostLibrary implements Serializable {
    private Integer id;
    private String name;    //客户姓名
    private String phone;   //电话号码
    private Byte classify;      //分类 1.钥匙2.手机3.电脑4.钱包5.背包6.其他
    private Date geton;        //客户上车时间
    private Date getoff;         //客户下车时间
    private String kabnum;    //所在车辆
    private Byte state;          //失物状态 0：未处理; 1：已退回客户
    private Date createtime;     //入库时间
    private int clientid;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Column(name = "classify", length = 4)
    public Byte getClassify() {
        return classify;
    }

    public void setClassify(Byte classify) {
        this.classify = classify;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "geton", length = 50)
    public Date getGeton() {
        return geton;
    }

    public void setGeton(Date geton) {
        this.geton = geton;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "getoff", length = 50)
    public Date getGetoff() {
        return getoff;
    }

    public void setGetoff(Date getoff) {
        this.getoff = getoff;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "state", length = 4)
    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createtime", length = 50)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Column(name = "clientid", length = 20, columnDefinition = "INT default 0")
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
}
