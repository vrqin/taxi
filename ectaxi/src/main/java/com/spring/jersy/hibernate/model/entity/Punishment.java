package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 惩罚记录
 */
@Entity
@Table(name = "tab_punishment_list")
public class Punishment implements Serializable {
    private static final long serialVersionUID = -131312312312321L;

    private int id;
    private Integer clientid;//所属公司编码
    private Integer cancelnum;//取消次数
    private String kabnum;//车牌号
    private String msid;//
    private Integer ishandle;//是否已处理 0:未处理，1：已处理
    private String token;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ishandle", length = 2)
    public Integer getIshandle() {
        return ishandle;
    }

    public void setIshandle(Integer ishandle) {
        this.ishandle = ishandle;
    }

    @Column(name = "clientid", length = 11)
    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    @Column(name = "msid", length = 22)
    public String getMsid() {
        return msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "cancelnum", length = 20, columnDefinition = "INT default 0")
    public Integer getCancelnum() {
        return cancelnum;
    }

    public void setCancelnum(Integer cancelnum) {
        this.cancelnum = cancelnum;
    }
}
