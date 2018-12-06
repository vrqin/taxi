package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 消息通知
 * 系统发消息给指定司机
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_notifier_plus")
public class NotifierPlus implements Serializable {
    private Integer id;
    private String content; //通知内容
    private Date creattime; //创建时间
    private Date expired; //有效时间
    private String accountName; //发送者名称
    private Integer clientid;//所属公司id

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creattime", length = 50)
    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }


    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expired", length = 50)
    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    @Column(name = "content", length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "accountName", length = 20)
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(name = "clientid", length = 20, columnDefinition = "INT default 0")
    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }


}
