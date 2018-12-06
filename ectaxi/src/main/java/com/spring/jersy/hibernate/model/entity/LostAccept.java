package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 失物受理信息表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_lostaccept")
public class LostAccept implements Serializable {
    private Integer id;
    private String name;
    private String phone;
    private Byte classify;
    private Date calltime;
    private Date geton;
    private Date getoff;
    private String kabnum;
    private Integer results;
    private Integer clientid;

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
    @Column(name = "calltime", length = 50)
    public Date getCalltime() {
        return calltime;
    }

    public void setCalltime(Date calltime) {
        this.calltime = calltime;
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

    @Column(name = "kabnum", length = 50)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "results", length = 50)
    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    @Column(name = "clientid", length = 20, columnDefinition = "INT default 0")
    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }
}
