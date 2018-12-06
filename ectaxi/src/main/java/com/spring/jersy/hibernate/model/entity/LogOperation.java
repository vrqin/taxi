package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志信息表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_log_operation")
public class LogOperation implements Serializable {
    private Integer id;
    //    private Integer operation;//操作模组
    //    private String operatobject;//操作对象
    //    private String operatdata;//操作资料表
    private String operator;//操作者
    private int type; //操作类型  增加、删除、修改、查询、导入、导出
    private String content;
    private Date operattime;//操作时间
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


    @Column(name = "operator", length = 20)
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Column(name = "type", length = 4)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "operattime", length = 50)
    public Date getOperattime() {
        return operattime;
    }

    public void setOperattime(Date operattime) {
        this.operattime = operattime;
    }

    @Column(name = "content", length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "clientid", length = 20, columnDefinition = "INT default 0")
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
}
