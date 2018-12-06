package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 异常日志信息表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_log_abnormal")
public class LogAbnormal implements Serializable {
    private Integer id;
    //    private Integer operation; //操作模组
    private String operator;//操作者
    private Date operattime;//操作时间
    private String returninfo;//返回信息
    private int clientid;
    //    private String excaddress;//异常地址

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //    @Column(name = "operation",length = 20)
    //    public Integer getOperation() {
    //        return operation;
    //    }
    //
    //    public void setOperation(Integer operation) {
    //        this.operation = operation;
    //    }

    @Column(name = "operator", length = 20)
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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

    @Column(name = "returninfo", length = 255)
    public String getReturninfo() {
        return returninfo;
    }

    public void setReturninfo(String returninfo) {
        this.returninfo = returninfo;
    }

    @Column(name = "clientid", length = 20, columnDefinition = "INT default 0")
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    //    @Column(name = "excaddress")
    //    public String getExcaddress() {
    //        return excaddress;
    //    }
    //
    //    public void setExcaddress(String excaddress) {
    //        this.excaddress = excaddress;
    //    }
}
