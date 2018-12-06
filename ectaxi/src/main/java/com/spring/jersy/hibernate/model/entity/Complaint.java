package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 投诉管理信息表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_complaint")
public class Complaint implements Serializable {

    private Integer id;
    private String name;      //投诉描述
    private Date acceptime;       //投诉受理时间
    private Byte source;       // 投诉来源 0:电话 1:网络  来源考虑参考ordertype
    private String customername;        //客户名称
    private String phone;          //客户联系号码
    private String kabnum;           //被投诉车辆
    private Date endtime;          //处理结束时间
    private Byte results;           //处理结果 0：情况不属，不予处理 1：情况属实，已处理相关人员
    private Byte state;            //处理状态 0：受理 1：处理中 2：已处理完毕，并反馈给客户
    private String ordernum;          //订单ID
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


    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "acceptime", length = 50)
    public Date getAcceptime() {
        return acceptime;
    }

    public void setAcceptime(Date acceptime) {
        this.acceptime = acceptime;
    }

    @Column(name = "source", length = 4)
    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    @Column(name = "customername", length = 20)
    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    @Column(name = "phone", length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "endtime", length = 50)
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    @Column(name = "results", length = 4)
    public Byte getResults() {
        return results;
    }

    public void setResults(Byte results) {
        this.results = results;
    }

    @Column(name = "state", length = 4)
    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Column(name = "ordernum", length = 19)
    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    @Column(name = "clientid", length = 20, columnDefinition = "INT default 0")
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
}
