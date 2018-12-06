package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 权限列表
 * 系统类型权限
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_privilege")
public class Privilege implements Serializable {
    private Integer id;
    private String privilegename;
    private String remark;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "privilegename", nullable = false, length = 50)
    public String getPrivilegename() {
        return privilegename;
    }

    public void setPrivilegename(String privilegename) {
        this.privilegename = privilegename;
    }

    @Column(name = "remark", nullable = false, length = 50)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Privilege{" + "id=" + id + ", privilegename='" + privilegename + '\'' + ", remark='" + remark + '\'' + '}';
    }
}
