package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by Administrator on 2016/3/14.
 */
@Entity
@Table(name = "tab_sys_setting")
public class SysSet implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer SSid;//功能id
    private String SSname;//功能名称
    private String SSdescribe;//描述

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "SSid")
    public Integer getSSid() {
        return SSid;
    }

    public void setSSid(Integer SSid) {
        this.SSid = SSid;
    }

    @Column(name = "SSname", length = 50)
    public String getSSname() {
        return SSname;
    }

    public void setSSname(String SSname) {
        this.SSname = SSname;
    }

    @Column(name = "SSdescribe", length = 50)
    public String getSSdescribe() {
        return SSdescribe;
    }

    public void setSSdescribe(String SSdescribe) {
        this.SSdescribe = SSdescribe;
    }


}
