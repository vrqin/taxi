package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 报警提醒设置信息表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_remindset")
public class RemindSet implements Serializable {

    private Integer id;

    private Byte extypes;
    private String remind;
    private Byte type;
    private Byte enable;
    private int clientid;
    private String company;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 20)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "extypes", length = 4)
    public Byte getExtypes() {
        return extypes;
    }

    public void setExtypes(Byte extypes) {
        this.extypes = extypes;
    }

    @Column(name = "remind", length = 20)
    public String getRemind() {
        return remind;
    }

    public void setRemind(String remind) {
        this.remind = remind;
    }

    @Column(name = "type", length = 4)
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Column(name = "enable", length = 4)
    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    @Column(name = "clientid", length = 20, columnDefinition = "INT default 0")
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
}
