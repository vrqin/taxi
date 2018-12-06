package com.speedtalk.smartkab.ws.db;


/**
 * TabStatusremark entity. @author MyEclipse Persistence Tools
 */

public class TabStatusremark implements java.io.Serializable {


    // Fields    

    private Integer status;
    private String remark;


    // Constructors

    /**
     * default constructor
     */
    public TabStatusremark() {
    }

    /**
     * minimal constructor
     */
    public TabStatusremark(Integer status) {
        this.status = status;
    }

    /**
     * full constructor
     */
    public TabStatusremark(Integer status, String remark) {
        this.status = status;
        this.remark = remark;
    }


    // Property accessors

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}