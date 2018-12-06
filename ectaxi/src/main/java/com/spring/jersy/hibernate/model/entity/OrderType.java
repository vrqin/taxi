package com.spring.jersy.hibernate.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/18.
 */
@Entity
@Table(name = "tab_order_type")
public class OrderType implements Serializable {
    private static final long serialVersionUID = -131312312312321L;
    private Integer typeid;         //id
    private String remark;

    public OrderType() {
    }

    public OrderType(Integer typeid) {
        this.typeid = typeid;
    }

    public OrderType(Integer typeid, String remark) {
        this.typeid = typeid;
        this.remark = remark;
    }

    @Id
    @Column(name = "typeid", unique = true, nullable = false, length = 4)
    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    @Column(name = "remark", length = 20)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
