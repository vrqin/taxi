package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky on 15-10-16
 * 类型表
 */
@Entity
@Table(name = "tab_typevalue")
public class TypeValue implements Serializable {
    private static final long serialVersionUID = -131312312312321L;
    private Integer typeid;         //id
    private Integer clientid;       //公司id,如果是0表示通用
    private Integer code;           //前两位代表分类；后三位代表具体值；
    private String value;           //类型值

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "typeid", unique = true, nullable = false, length = 11)
    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    @Column(name = "clientid", length = 11)
    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    @Column(name = "code", length = 50)
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Column(name = "value", length = 200)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
